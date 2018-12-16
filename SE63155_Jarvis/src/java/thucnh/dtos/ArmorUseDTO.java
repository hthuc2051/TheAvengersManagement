/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucnh.dtos;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class ArmorUseDTO implements Serializable {

    private int idRequest, armorID, userID;
    private String armorName, username, weaponRequest, startDate, endDate, status;

    public ArmorUseDTO() {

    }

    public ArmorUseDTO(int idRequest, int armorID, String armorName, String startDate, String endDate,String status) {
        this.idRequest = idRequest;
        this.armorID = armorID;
        this.armorName = armorName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    
    public ArmorUseDTO(String weaponRequest, String startDate, int armorID, int userID) {
        this.weaponRequest = weaponRequest;
        this.startDate = startDate;
        this.armorID = armorID;
        this.userID = userID;
    }

    
    public ArmorUseDTO(String armorName, String username, String weaponRequest, int idRequest, int armorID) {
        this.armorName = armorName;
        this.username = username;
        this.weaponRequest = weaponRequest;
        this.idRequest = idRequest;
        this.armorID = armorID;
    }

    public ArmorUseDTO(String armorName, String username, String startDate, String endDate, String status) {
        this.armorName = armorName;
        this.username = username;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public ArmorUseDTO(String weaponRequest, int armorID) {
        this.weaponRequest = weaponRequest;
        this.armorID = armorID;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWeaponRequest() {
        return weaponRequest;
    }

    public void setWeaponRequest(String weaponRequest) {
        this.weaponRequest = weaponRequest;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

}
