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
public class InsertArmorSupportedAction {

    private static final String ERROR = "error";
    private static final String ADMIN = "admin";
    private String alert;
    private String key;
    private String weaponName;
    private String materialName;
    private String description;
    private int power;

    public InsertArmorSupportedAction() {
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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String execute() throws Exception {
        String url = ERROR;
        Map session = ActionContext.getContext().getSession();
        if (key != null) {
            if (key.equals("material")) {
                MaterialDAO dao = new MaterialDAO();
                MaterialDTO dto = new MaterialDTO(materialName, description);
                if (dao.insert(dto)) {
                    alert = "Insert materials successfully !";
                    //refresh session
                    List<MaterialDTO> allMaterials = dao.getAllMaterials();
                    session.put("AllMaterials", allMaterials);
                    url = ADMIN;
                } else {
                    alert = "Insert materials failed !";
                }

            } else if (key.equals("weapon")) {
                WeaponDAO dao = new WeaponDAO();
                WeaponDTO dto = new WeaponDTO(weaponName, description, power);
                if (dao.insert(dto)) {
                    alert = "Insert weapons successfully !";
                    //refresh session
                    List<WeaponDTO> allWeapons = dao.getAllWeapons();
                    session.put("AllWeapons", allWeapons);
                    url = ADMIN;
                } else {
                    alert = "Insert weapons failed !";
                }
            }
        }
        return url;
    }

}
