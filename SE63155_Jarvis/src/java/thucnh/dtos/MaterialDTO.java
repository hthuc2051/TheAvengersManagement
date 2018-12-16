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
public class MaterialDTO implements Serializable{
    private String name,description;
    private int id;
    public MaterialDTO() {
    }

    public MaterialDTO(int id) {
        this.id = id;
    }

    
    public MaterialDTO(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public MaterialDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
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

    
    
}
