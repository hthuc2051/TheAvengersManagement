/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucnh.beans;

import java.util.ArrayList;
import java.util.List;
import thucnh.dtos.MissionDTO;
import thucnh.models.MissionDAO;
import thucnh.models.UserDAO;

/**
 *
 * @author USER
 */
public class InsertMissionAction {

    private static final String ERROR = "error";
    private static final String DUPPLICATED = "duplicate";
    private static final String ADMIN = "admin";
    private String alert;
    private String code, title, location, description, startDate, endDate;
    private static final String DEFAULTSTATUS = "Not finished";

    List<String> users;

    public InsertMissionAction() {
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public String execute() throws Exception {
        String url = ERROR;
        MissionDAO missionDAO = new MissionDAO();
        UserDAO userDAO = new UserDAO();
        List<Integer> listID = new ArrayList<>();
        if (users != null) {
            if (!users.isEmpty()) {
                for (String username : users) {
                    int id = userDAO.getUserIDByUsername(username);
                    listID.add(id);
                }
            }
        }
        if (missionDAO.checkDupplicateCode(code)) {
            url = DUPPLICATED;
            alert = "Dupplicated code !";
        } else {
            MissionDTO missionDTO = new MissionDTO(code, title, location, DEFAULTSTATUS, startDate, endDate, description);
            boolean check = missionDAO.insert(missionDTO);
            if (check) {
                url = ADMIN;
                alert = "Insert mission successfully";
                int missionID = missionDAO.getMissionIDByMissionCode(code);
                if (users != null) {
                    if (!users.isEmpty()) {
                        boolean insertUserMission = missionDAO.insertUserMission(missionID, listID);
                        if (insertUserMission) {
                            alert = "Insert mission successfully";
                        } else {
                            alert = "Insert mission failed";
                            missionDAO.delete(code);
                        }
                    }
                }
            } else {
                url = ADMIN;
                alert = "Insert mission failed";
            }
        }

        return url;
    }

}
