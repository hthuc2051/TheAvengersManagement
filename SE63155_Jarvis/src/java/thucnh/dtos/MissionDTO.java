/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucnh.dtos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author USER
 */
public class MissionDTO implements Serializable {

    private int id;
    private String code, title, location, status, startDate, endDate, description;
    private List<UserDTO> listUsers;

    public MissionDTO() {
    }

    public MissionDTO(int id, String code, String title, String location, String status, String startDate, String endDate, String description) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.location = location;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    
    //for submit mission
    public MissionDTO(String code, String status, String endDate) {
        this.code = code;
        this.status = status;
        this.endDate = endDate;
    }
    // for loadtable

    public MissionDTO(String code, String title, String location, String status) {
        this.code = code;
        this.title = title;
        this.location = location;
        this.status = status;
    }
  

    //main constructor | Update
    public MissionDTO(String code, String title, String location, String status, String startDate, String endDate, String description, List<UserDTO> listUsers) {
        this.code = code;
        this.title = title;
        this.location = location;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.listUsers = listUsers;
    }

    public MissionDTO(String code, String title, String location, String status, String endDate) {
        this.code = code;
        this.title = title;
        this.location = location;
        this.status = status;
        this.endDate = endDate;
    }
    
    
    //for add new Mission
    public MissionDTO(String code,String title, String location, String status, String startDate, String endDate, String description) {
        this.code = code;
        this.title = title;
        this.location = location;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    
    public MissionDTO(List<UserDTO> listUsers) {
        this.listUsers = listUsers;
    }

    public int getId() {
        return id;
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

    public List<UserDTO> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<UserDTO> listUsers) {
        this.listUsers = listUsers;
    }

}
