/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucnh.beans;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import thucnh.dtos.UserDTO;
import thucnh.models.UserDAO;

/**
 *
 * @author USER
 */
public class UpdateUserAction extends ActionSupport{

    private static final String ADMIN = "admin";
    private static final String USER = "user";
    private static final String ERROR = "error";
    private static final String FOLDER = "web\\uploads\\";
    
    private String alert;
    private String key;
    private String searchValue;
    private String username, password, firstName, lastName, role, email;

    private File myFile;
    private String myFileContentType;
    private String myFileFileName;

    public UpdateUserAction() {
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public File getMyFile() {
        return myFile;
    }

    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }

    public String getMyFileContentType() {
        return myFileContentType;
    }

    public void setMyFileContentType(String myFileContentType) {
        this.myFileContentType = myFileContentType;
    }

    public String getMyFileFileName() {
        return myFileFileName;
    }

    public void setMyFileFileName(String myFileFileName) {
        this.myFileFileName = myFileFileName;
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        String url = ERROR;
        UserDAO dao = new UserDAO();
        if (key != null) {
            if (key.equals("userUpdate")) {
                UserDTO dto = new UserDTO(username, password, lastName, firstName);
                dto.setEmail(email);
                if (password.length() == 0) {
                    password = dao.getUserPasswordByUsername(username);
                    dto.setPassword(password);
                } else {
                    dto.setPassword(password);
                }
                boolean check = dao.updateByUser(dto);
                if (check) {
                    alert = "Update your profile successfully";
                    if (myFile != null) {
                        if (!uploadFile()) {
                            session.put("STATUS", "Update your image failed");
                        }
                    }
                } else {
                    alert = "Update your profile failed";
                }
                url = USER;
            } else if (key.equals("adminUpdate")) {
                UserDTO dto = new UserDTO(username, lastName, firstName, email, role);
                if (password.length() == 0) {
                    password = dao.getUserPasswordByUsername(username);
                    dto.setPassword(password);
                } else {
                    dto.setPassword(password);
                }
                boolean check = dao.updateByAdmin(dto);
                if (check) {
                    alert = "Update user successfully";
                    if (myFile != null) {
                        if (!uploadFile()) {
                            alert = "Update user image failed";
                        }
                    }

                } else {
                    alert = "Update user failed";
                }
                url = ADMIN;
            }
            String oldUsername = (String) session.get("Username");
            if (username.equals(oldUsername)) {
                url = USER;
                alert = "Update your profile successfully";
                session.put("Username", username);
                session.put("Password", password);
            }
            List<UserDTO> allUsers = dao.getAllUserForSession();
            session.put("AllUsers", allUsers);
        }

        return url;
    }

    public boolean uploadFile() throws Exception {
        boolean check = false;
        ServletRequest request = ServletActionContext.getRequest();
        UserDAO dao = new UserDAO();
        String fileName = "";
        String applicationPath = request.getServletContext().getRealPath("/");
        String[] temp = applicationPath.split("build");
        String folPath = temp[0] + FOLDER;
        File fileUpload = new File(folPath);
        if (!fileUpload.exists()) {
            fileUpload.mkdirs();
        }
        String dateForImage = new SimpleDateFormat("ddMMyyyHHmmss").format(Calendar.getInstance().getTime());
        fileName = dateForImage + myFileFileName;
        File file = new File(folPath, fileName);
        FileUtils.copyFile(myFile, file);
        check = dao.updateImage(fileName, username);
        return check;
    }

}
