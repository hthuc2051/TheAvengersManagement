/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucnh.beans;

import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;
import thucnh.dtos.MaterialDTO;
import thucnh.dtos.WeaponDTO;
import thucnh.models.MaterialDAO;
import thucnh.models.WeaponDAO;

/**
 *
 * @author USER
 */
public class UpdateArmorSupportedAction {


    private static final String ADMIN = "admin";
    private String alert, key;
    private String weaponName, materialName, description;
    private int materialID, weaponID, power;

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

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
    }

    public int getWeaponID() {
        return weaponID;
    }

    public void setWeaponID(int weaponID) {
        this.weaponID = weaponID;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public UpdateArmorSupportedAction() {
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        if (key != null) {
            if (key.equals("material")) {
                if (materialName != null) {
                    if (materialName.length() > 0) {
                        MaterialDAO dao = new MaterialDAO();
                        MaterialDTO dto = new MaterialDTO(materialName, description, materialID);
                        if (dao.update(dto)) {
                            alert = "Update materials successfully !";

                            //refresh session
                            List<MaterialDTO> allMaterials = dao.getAllMaterials();
                            session.put("AllMaterials", allMaterials);
                        } else {
                            alert = "Update materials failed !";
                        }
                    } else {
                        alert = "Update materials failed ! [Material's name is blank!]";
                    }
                }
            } else if (key.equals("weapon")) {
                WeaponDAO dao = new WeaponDAO();
                WeaponDTO dto = new WeaponDTO(weaponName, description, power, weaponID);
                if (weaponName != null) {
                    if (weaponName.length() > 0) {
                        if (dao.update(dto)) {
                            alert = "Update weapons successfully !";
                            
                            //refresh session
                            List<WeaponDTO> allWeapons = dao.getAllWeapons();
                            session.put("AllWeapons", allWeapons);
                        } else {
                            alert = "Update weapons failed !";
                        }
                    } else {
                        alert = "Update weapons failed ! [Weapon's name is blank!] ";
                    }
                }

            }
        }
        return ADMIN;
    }

}
