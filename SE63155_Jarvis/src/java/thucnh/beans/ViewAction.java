/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucnh.beans;

import java.util.List;
import thucnh.dtos.ArmorDTO;
import thucnh.dtos.MaterialDTO;
import thucnh.dtos.MissionDTO;
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
public class ViewAction {

    private static final String USER = "user";
    private static final String ARMOR = "armor";
    private static final String MISSION = "mission";
    private static final String ARMORUSER = "armorUser";
    private static final String ERROR = "error";
    private String key, searchValue;

    private String username;
    private String armorCode;
    private String missionCode;

    private UserDTO userDTO;
    private ArmorDTO armorDTO;
    private MissionDTO missionDTO;

    public ViewAction() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public ArmorDTO getArmorDTO() {
        return armorDTO;
    }

    public void setArmorDTO(ArmorDTO armorDTO) {
        this.armorDTO = armorDTO;
    }

    public MissionDTO getMissionDTO() {
        return missionDTO;
    }

    public void setMissionDTO(MissionDTO missionDTO) {
        this.missionDTO = missionDTO;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String execute() throws Exception {
        System.out.println("ViewAction Key " + key);
        String url = ERROR;
        if (key.equals("user")) {
            UserDAO dao = new UserDAO();
            userDTO = dao.getUserByUsername(username);
            url = USER;
        } else if (key.equals("armor")) {
            ArmorDAO dao = new ArmorDAO();
            WeaponDAO weaponDAO = new WeaponDAO();
            MaterialDAO materialDAO = new MaterialDAO();

            MaterialDTO materialDTO = materialDAO.getMaterialByArmorCode(armorCode);
            List<WeaponDTO> listWeapons = weaponDAO.getWeaponsByArmorCode(armorCode);
            armorDTO = dao.getArmorByArmorCode(armorCode);
            armorDTO.setMaterials(materialDTO);
            armorDTO.setWeapons(listWeapons);
            url = ARMOR;
        } else if (key.equals("mission")) {
            MissionDAO dao = new MissionDAO();
            List<UserDTO> listUsers = dao.getUsersDoMissionByMissionCode(missionCode);
            missionDTO = dao.getMissionByMissionCode(missionCode);
            missionDTO.setListUsers(listUsers);
            url = MISSION;
        } else if (key.equals("armorUser")) {
            ArmorDAO dao = new ArmorDAO();
            WeaponDAO weaponDAO = new WeaponDAO();
            MaterialDAO materialDAO = new MaterialDAO();
            MaterialDTO materialDTO = materialDAO.getMaterialByArmorCode(armorCode);
            List<WeaponDTO> listWeapons = weaponDAO.getWeaponsByArmorCode(armorCode);
            armorDTO = dao.getArmorByArmorCode(armorCode);
            armorDTO.setMaterials(materialDTO);
            armorDTO.setWeapons(listWeapons);
            url = ARMORUSER;
        }
        return url;
    }

}
