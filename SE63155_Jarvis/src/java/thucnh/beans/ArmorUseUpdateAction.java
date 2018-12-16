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
import thucnh.models.ArmorDAO;
import thucnh.models.ArmorUseDAO;

public class ArmorUseUpdateAction {

    private static final String ADMIN = "admin";
    private static final String USER = "user";
    private static final String ERROR = "error";
    private String alert;

    private String key, weaponRequest;
    private int idRequest, armorID;

    public ArmorUseUpdateAction() {
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

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public int getArmorID() {
        return armorID;
    }

    public void setArmorID(int armorID) {
        this.armorID = armorID;
    }

    public String getWeaponRequest() {
        return weaponRequest;
    }

    public void setWeaponRequest(String weaponRequest) {
        this.weaponRequest = weaponRequest;
    }

    public String execute() throws Exception {
        String url = ERROR;
        ArmorUseDAO armorUseDAO = new ArmorUseDAO();
        ArmorDAO armorDAO = new ArmorDAO();
        String curDate = new SimpleDateFormat("yyy-MM-dd").format(Calendar.getInstance().getTime());
        if (key != null) {
            if (key.equals("refuse")) {
                alert = "The request use armor is refused !";
                if (!armorUseDAO.refuse(idRequest)) {
                    alert = "Action occurs error ! Please try later !";
                }
                url = ADMIN;
            } else if (key.equals("allow")) {
                boolean allowed = armorUseDAO.allowed(curDate, idRequest);
                if (allowed) {
                    alert = "The armor will be sent now !";
                    if (weaponRequest.length() != 0) {
                        alert = "The armor will be sent now !";
                        String[] temp = weaponRequest.split("-");
                        List<String> weapons = new ArrayList<>();
                        for (int i = 0; i < temp.length; i++) {
                            weapons.add(temp[i]);
                        }
                        armorDAO.deleteArmorWeapon(armorID);
                        boolean check = armorDAO.insertArmorWeapon(weapons, armorID);
                        if (check) {
                            boolean updateAvailable = armorDAO.updateAvailable(armorID, false);
                            if (updateAvailable) {
                                List<Integer> requestWatingID = armorUseDAO.getAllRequestWaitingIDOfArmor(armorID);
                                if (requestWatingID != null) {
                                    for (Integer id : requestWatingID) {
                                        armorUseDAO.updateStatus(id, "Refused");
                                    }
                                }
                                alert = "The armor will be sent !";
                            } else {
                                alert = "The armor can't be sent !";
                                armorUseDAO.updateStatus(idRequest, "Occurs Error");
                            }
                        } else {
                            alert = "The armor can't be sent !";
                        }
                    }
                }
                url = ADMIN;
            } else if (key.equals("sendBack")) {
                boolean check = armorDAO.updateAvailable(armorID, true);
                if (check) {
                    alert = "The armor will be sent back now !";
                    if (!armorUseDAO.setEndDate(curDate, idRequest)) {
                        alert = "The process occurs error ! Please try later";
                    }
                }
                url = USER;
            } else {
                alert = "Action occurs error ! Please try again !";
            }
        } else {
            alert = "Action is not supported";
        }
        return url;
    }

}
