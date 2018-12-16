/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucnh.models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import thucnh.dtos.WeaponDTO;
import thucnh.util.MyConnection;

/**
 *
 * @author USER
 */
public class WeaponDAO implements Serializable {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
    }

    //for insert new Armor
    public WeaponDTO getWeaponByWeaponID(int weaponID) throws ClassNotFoundException, SQLException {
        WeaponDTO dto = null;
        String name, description;
        int power;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Select Name,Description,Power from Weapons where ID=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, weaponID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    name = rs.getString("Name");
                    description = rs.getString("Description");
                    power = rs.getInt("Power");
                    dto = new WeaponDTO(name, description, power, weaponID);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public List<WeaponDTO> getAllWeapons() throws ClassNotFoundException, SQLException {
        List<WeaponDTO> result = null;
        WeaponDTO dto = null;
        String name, description;
        int power, id;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select ID,Name,Description,Power from Weapons";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("ID");
                    name = rs.getString("Name");
                    description = rs.getString("Description");
                    power = rs.getInt("Power");
                    dto = new WeaponDTO(name, description, power, id);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<WeaponDTO> getWeaponsByArmorCode(String code) throws ClassNotFoundException, SQLException {
        List<WeaponDTO> result = null;
        WeaponDTO dto = null;
        int id;
        String name, description;
        int power;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select Weapons.ID,Weapons.Name,Weapons.Description,Weapons.Power"
                        + " From Weapons,ArmorWeapon,Armors"
                        + " Where Armors.Code =?"
                        + " AND Weapons.ID = ArmorWeapon.WeaponID"
                        + " AND Armors.ID = ArmorWeapon.ArmorID";
                stm = con.prepareStatement(sql);
                stm.setString(1, code);
                rs = stm.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("ID");
                    name = rs.getString("Name");
                    description = rs.getString("Description");
                    power = rs.getInt("Power");
                    dto = new WeaponDTO(name, description, power, id);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean update(WeaponDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Update Weapons SET Name=?,Description=?,Power=? Where ID=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getName());
                stm.setString(2, dto.getDescription());
                stm.setInt(3, dto.getPower());
                stm.setInt(4, dto.getId());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean delete(int id) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Delete From Weapons Where ID=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insert(WeaponDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Insert into Weapons(Name,Description,Power) values(?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getName());
                stm.setString(2, dto.getDescription());
                stm.setInt(3, dto.getPower());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<WeaponDTO> findByName(String nameSearch) throws ClassNotFoundException, SQLException {
        List<WeaponDTO> result = null;
        WeaponDTO dto = null;
        int id, power;
        String name, description;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select ID,Name,Description,Power from Weapons where Name Like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + nameSearch + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("ID");
                    name = rs.getString("Name");
                    description = rs.getString("Description");
                    power = rs.getInt("Power");
                    dto = new WeaponDTO(name, description, power, id);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public void deleteArmorWeaponByWeaponID(int id) throws ClassNotFoundException, SQLException {
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Delete From ArmorWeapon Where WeaponID=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                stm.executeUpdate();
            }
        } finally {
            closeConnection();
        }
    }
}
