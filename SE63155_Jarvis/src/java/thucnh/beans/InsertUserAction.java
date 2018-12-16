/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucnh.beans;

import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;
import thucnh.dtos.UserDTO;
import thucnh.models.UserDAO;

/**
 *
 * @author USER
 */
public class InsertUserAction {

    private static final String ERROR = "error";
    private static final String DUPPLICATED = "duplicate";
    private static final String SUCCESS = "admin";
    private String username, password, firstName, lastName, email, role;
    private static final String DEFAULTIMG = "default-img.jpg";
    private String alert;

    public InsertUserAction() {
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String execute() {
        String url = ERROR;
        try {
            Map session = ActionContext.getContext().getSession();
            UserDTO userDTO = new UserDTO(username, password, lastName, firstName, email, role, DEFAULTIMG);
            UserDAO dao = new UserDAO();
            if (dao.checkDupplicateUsername(username)) {
                alert = "Dupplicate code";
                url = DUPPLICATED;
            } else {
                boolean check = dao.insert(userDTO);
                if (check) {
                    url = SUCCESS;
                    List<UserDTO> allUsers = dao.getAllUserForSession();
                    session.put("AllUsers", allUsers);
                    alert = "Insert user successfully";
                } else {
                    alert = "Insert user failed";
                }
            }

        } catch (Exception e) {

        }
        return url;
    }

}
