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
public class ArmorDTO implements Serializable {

    private int id;
    private String code, name, description, image;
    boolean available;
    MaterialDTO materials;
    List<WeaponDTO> weapons;

    public ArmorDTO() {
    }

    public ArmorDTO(int id, String code, String name, String description, boolean available, MaterialDTO materials) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.available = available;
        this.materials = materials;
    }

    public ArmorDTO(String code, String name, String description, boolean available, MaterialDTO materials) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.available = available;
        this.materials = materials;
    }

    //for search in ArmorPage
    public ArmorDTO(String code, String name) {
        this.code = code;
        this.name = name;
    }

    //for ArmorPage
    public ArmorDTO(String code, String name, String image) {
        this.code = code;
        this.name = name;
        this.image = image;
    }

    public ArmorDTO(String code, String name, String description, boolean available) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.available = available;
    }

    public ArmorDTO(int id, String code, String name, String description, String image, boolean available) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.image = image;
        this.available = available;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public MaterialDTO getMaterials() {
        return materials;
    }

    public void setMaterials(MaterialDTO materials) {
        this.materials = materials;
    }

    public List<WeaponDTO> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<WeaponDTO> weapons) {
        this.weapons = weapons;
    }

}
