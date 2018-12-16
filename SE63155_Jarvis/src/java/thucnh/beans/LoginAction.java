/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucnh.beans;

import com.opensymphony.xwork2.ActionContext;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import thucnh.dtos.ArmorUseDTO;
import thucnh.dtos.MissionDTO;
import thucnh.dtos.UserDTO;
import thucnh.models.ArmorUseDAO;
import thucnh.models.MissionDAO;
import thucnh.models.UserDAO;

/**
 *
 * @author USER
 */
public class LoginAction {

    private static final String ADMIN = "admin";
    private static final String USER = "user";
    private static final String INVALID = "invalid";
    private static final String ERROR = "error";

    private String alert;
    private String username, password;
    private UserDTO userDTO;
    List<ArmorUseDTO> armorRequestData;

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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<ArmorUseDTO> getArmorRequestData() {
        return armorRequestData;
    }

    public void setArmorRequestData(List<ArmorUseDTO> armorRequestData) {
        this.armorRequestData = armorRequestData;
    }

    public LoginAction() {
    }

    public String execute() {
        Map session = ActionContext.getContext().getSession();
        String url = ERROR;
        try {
            UserDAO userDAO = new UserDAO();
            MissionDAO missionDAO = new MissionDAO();
            ArmorUseDAO armorUseDAO = new ArmorUseDAO();
            if (session.get("Username") != null || session.get("Password") != null) {
                username = (String) session.get("Username");
                password = (String) session.get("Password");
            }

            String role = userDAO.checkLogin(username, password);
            if (role.equals("failed")) {
                alert = "Invalid username or password";
                url = INVALID;
            } else {
                session.put("Username", username.trim());
                session.put("Password", password.trim());
                checkFinishedMission();
                if (role.equals("admin")) {
                    url = ADMIN;
                } else if (role.equals("user")) {
                    url = USER;
                    armorRequestData = armorUseDAO.getListArmorUseByUsername(username);
                    userDTO = userDAO.getUserByUsername(username);
                    List<MissionDTO> listMission = missionDAO.getMissionsByUsername(username);
                    if (listMission != null) {
                        for (MissionDTO dto : listMission) {
                            List<UserDTO> partners = missionDAO.getUsersDoMissionByMissionCode(dto.getCode());
                            dto.setListUsers(partners);
                        }
                        userDTO.setListMission(listMission);
                    }
                } else {
                    alert = "Your role is not existed!";
                    url = ERROR;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    public void checkFinishedMission() throws SQLException, ClassNotFoundException {
        MissionDAO missionDAO = new MissionDAO();
        List<MissionDTO> listMission = missionDAO.getAllNotFinishedMission();
        String temp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        Date curDate = Date.valueOf(temp);
        if (listMission != null) {
            for (MissionDTO dto : listMission) {
                Date endDate = Date.valueOf(dto.getEndDate());
                if (curDate.compareTo(endDate) > 0) {
                    dto.setStatus("Failed");
                    missionDAO.updateStatusMission(dto);
                }
            }
        }

    }
}
