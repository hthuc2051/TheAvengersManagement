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
public class SearchAction {

    private static final String ADMIN = "admin";
    private static final String USER = "user";
    private static final String ARMORUSER = "armorUser";
    private static final String NULL = "null";
    private String searchValue, key, alert;

    private List<UserDTO> usersData;
    private List<ArmorDTO> armorsData;
    private List<MissionDTO> missionsData;
    private List<ArmorUseDTO> armorRequestData;
    private List<ArmorUseDTO> armorUseHistory;
    private List<MaterialDTO> materialsData;
    private List<String> materialsUsedID;
    private List<WeaponDTO> weaponsData;
    private UserDTO userDTO;

    public SearchAction() {
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        String url = NULL;
        if (searchValue != null) {
            if (key.equals("armorUser")) {
                url = ARMORUSER;
                ArmorDAO dao = new ArmorDAO();
                armorsData = dao.findByNameArmorPage(searchValue);
            } else if (key.equals("user_ArmorUse") || key.equals("user_Mission")) {
                String username = (String) session.get("Username");
                MissionDAO missionDAO = new MissionDAO();
                ArmorUseDAO armorUseDAO = new ArmorUseDAO();
                if (username != null) {
                    UserDAO userDAO = new UserDAO();
                    userDTO = userDAO.getUserByUsername(username);

                    if (key.equals("user_ArmorUse")) {
                        armorRequestData = armorUseDAO.findArmorUseOfUserByArmorName(username, searchValue);
                        List<MissionDTO> listMission = missionDAO.getMissionsByUsername(username);
                        for (MissionDTO dto : listMission) {
                            List<UserDTO> partners = missionDAO.getUsersDoMissionByMissionCode(dto.getCode());
                            dto.setListUsers(partners);
                        }
                        userDTO = userDAO.getUserByUsername(username);
                        userDTO.setListMission(listMission);

                    } else if (key.equals("user_Mission")) {
                        userDTO = userDAO.getUserByUsername(username);
                        List<MissionDTO> listMission = missionDAO.findMissionOfUserByTitle(username, searchValue);
                        for (MissionDTO dto : listMission) {
                            List<UserDTO> partners = missionDAO.getUsersDoMissionByMissionCode(dto.getCode());
                            dto.setListUsers(partners);
                        }
                        userDTO.setListMission(listMission);

                        armorRequestData = armorUseDAO.getListArmorUseByUsername(username);
                    }
                }

                url = USER;
            } else {
                url = ADMIN;
                if (key.equals("user")) {
                    UserDAO dao = new UserDAO();
                     String username = (String) session.get("Username");
                    usersData = dao.findByName(searchValue,username.trim());
                } else if (key.equals("armor")) {
                    ArmorDAO dao = new ArmorDAO();
                    armorsData = dao.findByName(searchValue);
                } else if (key.equals("mission")) {
                    MissionDAO dao = new MissionDAO();
                    missionsData = dao.findByTitle(searchValue);
                } else if (key.equals("material")) {
                    MaterialDAO dao = new MaterialDAO();
                    materialsUsedID = dao.getMaterialsUsedID();
                    materialsData = dao.findByName(searchValue);
                } else if (key.equals("weapon")) {
                    WeaponDAO dao = new WeaponDAO();
                    weaponsData = dao.findByName(searchValue);
                } else if (key.equals("requestArmor")) {
                    ArmorUseDAO dao = new ArmorUseDAO();
                    armorRequestData = dao.findArmorRequestedByArmorName(searchValue);
                } else if (key.equals("requestArmorHistory")) {
                    ArmorUseDAO dao = new ArmorUseDAO();
                    armorUseHistory = dao.findRequestHistoryByArmorName(searchValue);
                }
            }
        }
        return url;
    }

}
