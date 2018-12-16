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
public class WeaponDTO implements Serializable{
    private String name,description;
    private int power,id;
    public WeaponDTO() {
    }

    public WeaponDTO(String name, String description, int power, int id) {
        this.name = name;
        this.description = description;
        this.power = power;
        this.id = id;
    }

  

    
    
    public WeaponDTO(String name, String description, int power) {
        this.name = name;
        this.description = description;
        this.power = power;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    
}
