/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucnh.beans;

import java.util.List;
import thucnh.dtos.ArmorDTO;
import thucnh.dtos.MaterialDTO;
import thucnh.models.ArmorDAO;

/**
 *
 * @author USER
 */
public class InsertArmorAction {

    private static final String ERROR = "error";
    private static final String DUPPLICATED = "duplicate";
    private static final String ADMIN = "admin";
    private static final String DEFAULTIMG = "deault-armorIMG.jpg";
    private String alert;
    private String code, name, materials, description;
    private List<String> weapons;

    public InsertArmorAction() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public List<String> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<String> weapons) {
        this.weapons = weapons;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String execute() throws Exception {
        String url = ERROR;
        ArmorDAO armorDAO = new ArmorDAO();
        MaterialDTO materialDTO = new MaterialDTO(Integer.parseInt(materials));
        ArmorDTO dto = new ArmorDTO(code, name, description, true, materialDTO);
        dto.setImage(DEFAULTIMG);
        if (armorDAO.checkDupplicateCode(code)) {
            alert = "Dupplicated code !";
            url = DUPPLICATED;
        } else {
            boolean checkInsert = armorDAO.insert(dto);
            if (checkInsert) {
                url = ADMIN;
                alert = "Insert armor successfully";
                if (weapons != null) {
                    if (!weapons.isEmpty()) {
                        int armorID = armorDAO.getArmorIDByArmorCode(code);
                        boolean checkInsertArmorWeapon = armorDAO.insertArmorWeapon(weapons, armorID);
                        if (checkInsertArmorWeapon) {
                            alert = "Insert armor successfully";
                        } else {
                            alert = "Insert armor failed";
                            armorDAO.delete(code);
                        }
                    } else {
                        alert = "Insert armor successfully";
                    }
                }

            } else {
                alert = "Insert armor failed";
            }
        }

        return url;
    }

}
