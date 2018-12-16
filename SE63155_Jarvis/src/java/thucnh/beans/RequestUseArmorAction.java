/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucnh.beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import thucnh.dtos.ArmorUseDTO;
import thucnh.models.ArmorDAO;
import thucnh.models.ArmorUseDAO;
import thucnh.models.UserDAO;

/**
 *
 * @author USER
 */
public class RequestUseArmorAction {

    private static final String ARMORUSER = "armorUser";
    private static final String ERROR = "error";
    private String alert;
    private String username;
    private int armorID;
    private List<String> weapons;

    public RequestUseArmorAction() {
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

    public int getArmorID() {
        return armorID;
    }

    public void setArmorID(int armorID) {
        this.armorID = armorID;
    }

    public List<String> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<String> weapons) {
        this.weapons = weapons;
    }

    public String execute() throws Exception {
        String url = ERROR;
        UserDAO userDAO = new UserDAO();
        ArmorUseDAO armorUseDAO = new ArmorUseDAO();
        int userID = userDAO.getUserIDByUsername(username);
        String weaponRequest = "";
        if (weapons != null) {
            for (String weapon : weapons) {
                weaponRequest += weapon + "-";
            }
        }
        if (!armorUseDAO.checkRequestArmorExisted(armorID)) {
            if (username.trim().equalsIgnoreCase("ironman")) {
                url = ARMORUSER;
                ArmorDAO armorDAO = new ArmorDAO();
                String startDate = new SimpleDateFormat("yyy-MM-dd").format(Calendar.getInstance().getTime());
                ArmorUseDTO dto = new ArmorUseDTO(weaponRequest, startDate, armorID, userID);
                dto.setStatus("Allowed");
                boolean check = armorUseDAO.ironmanUse(dto);
                if (check) {
                    alert = "The armor will be sent now sir !";
                    List<Integer> requestWatingID = armorUseDAO.getAllRequestWaitingIDOfArmor(armorID);
                    if (requestWatingID != null) {
                        for (Integer id : requestWatingID) {
                            armorUseDAO.updateStatus(id, "Refused");
                        }
                    }
                    if (weapons != null) {
                        armorDAO.deleteArmorWeapon(armorID);
                        boolean checkArmorWeapon = armorDAO.insertArmorWeapon(weapons, armorID);
                        if (checkArmorWeapon) {
                            boolean updateAvailable = armorDAO.updateAvailable(armorID, false);
                            if (!updateAvailable) {
                                alert = "The armor can't be sent sir !";
                            }
                        } else {
                            alert = "The armor can't be sent !";
                        }
                    } else {
                        boolean updateAvailable = armorDAO.updateAvailable(armorID, false);
                        if (!updateAvailable) {
                            alert = "The armor can't be sent sir !";
                        }
                    }
                }

            } else {
                url = ARMORUSER;
                boolean check = armorUseDAO.insertRequestUse(userID, armorID, "Waiting", weaponRequest);
                if (check) {
                    alert = "Request successfully ! Please wait for the permission of Jarvis !";

                } else {
                    alert = "Request occurs error ! Please try again !";
                }
            }
        }

        return url;
    }

}
