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
import thucnh.dtos.UserDTO;
import thucnh.dtos.WeaponDTO;

import thucnh.models.ArmorDAO;
import thucnh.models.MaterialDAO;
import thucnh.models.MissionDAO;
import thucnh.models.UserDAO;
import thucnh.models.WeaponDAO;

/**
 *
 * @author USER
 */
public class DeleteAction {

    private static final String SUCCESS = "admin";
    private static final String ERROR = "error";

    private String key, alert;
    private String username;
    private String armorCode;
    private String missionCode;
    private String materialID;
    private String weaponID;
    private String searchValue;

    public DeleteAction() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getArmorCode() {
        return armorCode;
    }

    public void setArmorCode(String armorCode) {
        this.armorCode = armorCode;
    }

    public String getMissionCode() {
        return missionCode;
    }

    public void setMissionCode(String missionCode) {
        this.missionCode = missionCode;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getMaterialID() {
        return materialID;
    }

    public void setMaterialID(String materialID) {
        this.materialID = materialID;
    }

    public String getWeaponID() {
        return weaponID;
    }

    public void setWeaponID(String weaponID) {
        this.weaponID = weaponID;
    }

    public String execute() throws Exception {
        String url = ERROR;
        Map session = ActionContext.getContext().getSession();
        if (key != null) {
            if (key.equals("user")) {
                UserDAO userDAO = new UserDAO();
                MissionDAO missionDAO = new MissionDAO();
                int userID = userDAO.getUserIDByUsername(username);
                missionDAO.delelteUserDoMissionByUserID(userID);
                boolean check = userDAO.delete(username);
                if (check) {
                    alert = "Delete user successfully";
                    //refresh session
                    List<UserDTO> allUsers = userDAO.getAllUserForSession();
                    session.put("AllUsers", allUsers);
                    url = SUCCESS;
                } else {
                    alert = "Delete user failed";
                }
            } else if (key.equals("armor")) {

                ArmorDAO armorDAO = new ArmorDAO();
                int armorID = armorDAO.getArmorIDByArmorCode(armorCode);
                armorDAO.deleteArmorWeapon(armorID);
                boolean check = armorDAO.delete(armorCode);
                if (check) {
                    alert = "Delete armor successfully";
                    url = SUCCESS;
                } else {
                    alert = "Delete armor failed";
                }
            } else if (key.equals("mission")) {

                MissionDAO missionDAO = new MissionDAO();
                int missionID = missionDAO.getMissionIDByMissionCode(missionCode);
                missionDAO.delelteUserMissionByMissionID(missionID);

                boolean check = missionDAO.delete(missionCode);
                if (check) {
                    alert = "Delete mission successfully";
                    url = SUCCESS;
                } else {
                    alert = "Delete mission failed";
                }
            } else if (key.equals("material")) {
                MaterialDAO dao = new MaterialDAO();
                if (dao.delete(Integer.parseInt(materialID))) {
                    alert = "Delete material successfully";
                    //refresh session
                    List<MaterialDTO> allMaterials = dao.getAllMaterials();
                    session.put("AllMaterials", allMaterials);
                    url = SUCCESS;
                } else {
                    alert = "Failed ! Some armors still need the details of this material";
                }
            } else if (key.equals("weapon")) {
                WeaponDAO dao = new WeaponDAO();
                System.out.println("WeaponID " + weaponID);
                dao.deleteArmorWeaponByWeaponID(Integer.parseInt(weaponID));
                if (dao.delete(Integer.parseInt(weaponID))) {
                    System.out.println("Here");
                    alert = "Delete weapon successfully";
                    //refresh session
                    List<WeaponDTO> allWeapons = dao.getAllWeapons();
                    session.put("AllWeapons", allWeapons);
                    url = SUCCESS;
                } else {
                    alert = "Failed ! Some armors still need the details of this weapon";
                }

            }
        }
        return url;
    }

}
