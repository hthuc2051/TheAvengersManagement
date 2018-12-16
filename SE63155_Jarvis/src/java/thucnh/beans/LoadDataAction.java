/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucnh.beans;

import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;
import thucnh.dtos.ArmorDTO;
import thucnh.dtos.ArmorUseDTO;
import thucnh.dtos.MaterialDTO;
import thucnh.dtos.MissionDTO;
import thucnh.dtos.UserDTO;
import thucnh.dtos.WeaponDTO;
import thucnh.models.ArmorDAO;
import thucnh.models.ArmorUseDAO;
import thucnh.models.MaterialDAO;
import thucnh.models.MissionDAO;
import thucnh.models.UserDAO;
import thucnh.models.WeaponDAO;

/**
 *
 * @author USER
 */
public class LoadDataAction {

    private static final String ADMIN = "admin";
    private static final String USER = "user";
    private static final String ARMORUSER = "armorUser";
    private static final String ERROR = "error";

    private String key, alert;
    private List<UserDTO> usersData;
    private List<ArmorDTO> armorsData;
    private List<ArmorDTO> newsArmors;
    private List<MissionDTO> missionsData;
    private List<ArmorUseDTO> armorRequestData;
    private List<ArmorUseDTO> armorUseHistory;
    private List<MaterialDTO> materialsData;
    private List<String> materialsUsedID;
    private List<WeaponDTO> weaponsData;

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public LoadDataAction() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<UserDTO> getUsersData() {
        return usersData;
    }

    public void setUsersData(List<UserDTO> usersData) {
        this.usersData = usersData;
    }

    public List<ArmorDTO> getArmorsData() {
        return armorsData;
    }

    public void setArmorsData(List<ArmorDTO> armorsData) {
        this.armorsData = armorsData;
    }

    public List<ArmorDTO> getNewsArmors() {
        return newsArmors;
    }

    public void setNewsArmors(List<ArmorDTO> newsArmors) {
        this.newsArmors = newsArmors;
    }

    public List<MissionDTO> getMissionsData() {
        return missionsData;
    }

    public void setMissionsData(List<MissionDTO> missionsData) {
        this.missionsData = missionsData;
    }

    public List<ArmorUseDTO> getArmorRequestData() {
        return armorRequestData;
    }

    public void setArmorRequestData(List<ArmorUseDTO> armorRequestData) {
        this.armorRequestData = armorRequestData;
    }

    public List<ArmorUseDTO> getArmorUseHistory() {
        return armorUseHistory;
    }

    public void setArmorUseHistory(List<ArmorUseDTO> armorUseHistory) {
        this.armorUseHistory = armorUseHistory;
    }

    public List<MaterialDTO> getMaterialsData() {
        return materialsData;
    }

    public void setMaterialsData(List<MaterialDTO> materialsData) {
        this.materialsData = materialsData;
    }

    public List<String> getMaterialsUsedID() {
        return materialsUsedID;
    }

    public void setMaterialsUsedID(List<String> materialsUsedID) {
        this.materialsUsedID = materialsUsedID;
    }

    public List<WeaponDTO> getWeaponsData() {
        return weaponsData;
    }

    public void setWeaponsData(List<WeaponDTO> weaponsData) {
        this.weaponsData = weaponsData;
    }

    public String execute() throws Exception {
        String url = ERROR;
        Map session = ActionContext.getContext().getSession();
        if (key != null) {
            if (key.equals("armorUser")) {
                ArmorDAO dao = new ArmorDAO();
                armorsData = dao.getAllArmorForArmorPage();
                newsArmors = dao.getNewsArmor();
                session.put("NewsArmor", newsArmors);
                url = ARMORUSER;
            } else {
                url = ADMIN;
                if (key.equals("user")) {
                    UserDAO dao = new UserDAO();
                    String username = (String) session.get("Username");
                    usersData = dao.getAllUser(username.trim());
                } else if (key.equals("armor")) {
                    ArmorDAO dao = new ArmorDAO();
                    armorsData = dao.getAllArmor();
                } else if (key.equals("mission")) {
                    MissionDAO dao = new MissionDAO();
                    missionsData = dao.getAllMission();
                } else if (key.equals("requestArmor")) {
                    ArmorUseDAO dao = new ArmorUseDAO();
                    armorRequestData = dao.getAllArmorRequested();
                } else if (key.equals("requestArmorHistory")) {
                    ArmorUseDAO dao = new ArmorUseDAO();
                    armorUseHistory = dao.getAllRequestHistory();
                } else if (key.equals("material")) {
                    MaterialDAO dao = new MaterialDAO();
                    materialsData = dao.getAllMaterials();
                    materialsUsedID = dao.getMaterialsUsedID();
                } else if (key.equals("weapon")) {
                    WeaponDAO dao = new WeaponDAO();
                    weaponsData = dao.getAllWeapons();
                } else if (key.equals("user_ArmorUse") || key.equals("user_Mission")) {
                    url = USER;
                }
            }
        }

        return url;
    }

}
