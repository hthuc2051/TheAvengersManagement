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
public class UserDTO implements Serializable {

    private int id;
    private String username, password, lastName, firstName, email, role, image;
    private List<MissionDTO> listMission;

    public UserDTO() {
    }
    
    
    
//  for getUsersDoMissionByMissionCode
    public UserDTO(String username, String lastName, String firstName) {
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
    }
//    for view / insert
    public UserDTO(String username, String lastName, String firstName, String email, String role, String image) {
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.role = role;
        this.image = image;
    }

//    for getAllToDisPlay
    public UserDTO(String username, String lastName, String firstName, String email, String role) {
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.role = role;
    }

    // for user update 
    public UserDTO(String username, String password, String lastName, String firstName) {
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
    }
    
    
//  for admin update 
    public UserDTO(String username, String password, String lastName, String firstName, String email, String role, String image) {
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.role = role;
        this.image = image;
    }
    
    
    
    public int getId() {
        return id;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<MissionDTO> getListMission() {
        return listMission;
    }

    public void setListMission(List<MissionDTO> listMission) {
        this.listMission = listMission;
    }

}
