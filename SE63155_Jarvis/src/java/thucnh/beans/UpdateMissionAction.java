/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucnh.beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import thucnh.dtos.MissionDTO;

import thucnh.models.MissionDAO;
import thucnh.models.UserDAO;

/**
 *
 * @author USER
 */
public class UpdateMissionAction {

    private static final String ADMIN = "admin";
    private static final String USER = "user";
    private static final String ERROR = "error";
    private String alert;

    private String missionCode, missionTitle, location, status, startDate, endDate, description;
    private List<String> usernames;

    private String key, doneMissionCode;

    public UpdateMissionAction() {
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getMissionCode() {
        return missionCode;
    }

    public void setMissionCode(String missionCode) {
        this.missionCode = missionCode;
    }

    public String getMissionTitle() {
        return missionTitle;
    }

    public void setMissionTitle(String missionTitle) {
        this.missionTitle = missionTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }

    //for user submit
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDoneMissionCode() {
        return doneMissionCode;
    }

    public void setDoneMissionCode(String doneMissionCode) {
        this.doneMissionCode = doneMissionCode;
    }

    public String execute() throws Exception {
        UserDAO userDAO = new UserDAO();
        String url = ERROR;
        MissionDAO missionDAO = new MissionDAO();
        if (key.equals("submit")) {
            String curDate = new SimpleDateFormat("yyy-MM-dd").format(Calendar.getInstance().getTime());
            MissionDTO dto = new MissionDTO(doneMissionCode, "Finished", curDate);
            boolean check = missionDAO.updateStatusMission(dto);
            if (check) {
                alert = "Submit mission successfully";
            } else {
                alert = "Submit mission failed";
            }
            url = USER;
        } else if (key.equals("adminUpdate")) {
            List<Integer> listID = new ArrayList<>();
            if (usernames != null) {
                if (!usernames.isEmpty()) {
                    for (String username : usernames) {
                        int userID = userDAO.getUserIDByUsername(username);
                        listID.add(userID);
                    }
                }
            }
            int missionID = missionDAO.getMissionIDByMissionCode(missionCode);
            MissionDTO dto = new MissionDTO(missionCode, missionTitle, location, status, startDate, endDate, description);
            boolean checkUpdate = missionDAO.update(dto);
            if (checkUpdate) {
                alert = "Update mission successfully";
                missionDAO.delelteUserMissionByMissionID(missionID);
                if (!listID.isEmpty()) {
                    boolean checkInsertUserMission = missionDAO.insertUserMission(missionID, listID);
                    if (!checkInsertUserMission) {
                        alert = "Update mission failed";
                    }
                } else {
                    alert = "Update mission successfully";
                }

            } else {
                alert = "Update mission failed";
            }
            url = ADMIN;
        }
        return url;
    }
}
