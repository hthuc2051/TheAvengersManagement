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
import thucnh.models.MaterialDAO;
import thucnh.models.UserDAO;
import thucnh.models.WeaponDAO;

/**
 *
 * @author USER
 */
public class WelcomeAction {

    public WelcomeAction() {
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        UserDAO userDAO = new UserDAO();
        MaterialDAO materialDAO = new MaterialDAO();
        WeaponDAO weaponDAO = new WeaponDAO();
        List<MaterialDTO> allMaterials = materialDAO.getAllMaterials();
        List<WeaponDTO> allWeapons = weaponDAO.getAllWeapons();
        List<UserDTO> allUsers = userDAO.getAllUserForSession();
        session.put("AllUsers", allUsers);
        session.put("AllMaterials", allMaterials);
        session.put("AllWeapons", allWeapons);
        if (session.get("Username") != null || session.get("Password") != null) {
            session.remove("Username");
            session.remove("Password");
        }

        return "home";
    }

}
