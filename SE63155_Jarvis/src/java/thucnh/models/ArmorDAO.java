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
import thucnh.dtos.ArmorDTO;
import thucnh.util.MyConnection;

/**
 *
 * @author USER
 */
public class ArmorDAO implements Serializable {

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

    public List<ArmorDTO> getAllArmor() throws ClassNotFoundException, SQLException {
        List<ArmorDTO> result = null;
        ArmorDTO dto = null;
        String code, name, description;
        boolean available;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select Code,Name,Available,Description from Armors";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    code = rs.getString("Code");
                    name = rs.getString("Name");
                    description = rs.getString("Description");
                    available = rs.getBoolean("Available");
                    dto = new ArmorDTO(code, name, description, available);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public List<ArmorDTO> findByName(String nameSearch) throws ClassNotFoundException, SQLException {
        List<ArmorDTO> result = null;
        ArmorDTO dto = null;
        String code, name, description;
        boolean available;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select Code,Name,Available,Description from Armors where Name Like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + nameSearch + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    code = rs.getString("Code");
                    name = rs.getString("Name");
                    description = rs.getString("Description");
                    available = rs.getBoolean("Available");
                    dto = new ArmorDTO(code, name, description, available);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public boolean delete(String armorCode) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Delete From Armors where Code=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, armorCode);
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insert(ArmorDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Insert into Armors(Code,Name,MaterialID,Available,Description,Image) values(?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getCode());
                stm.setString(2, dto.getName());
                stm.setInt(3, dto.getMaterials().getId());
                stm.setBoolean(4, dto.isAvailable());
                stm.setString(5, dto.getDescription());
                stm.setString(6, dto.getImage());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(ArmorDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Update Armors set Name=?,MaterialID=?,Available=?,Description=? Where Code=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getName());
                stm.setInt(2, dto.getMaterials().getId());
                stm.setBoolean(3, dto.isAvailable());
                stm.setString(4, dto.getDescription());
                stm.setString(5, dto.getCode());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public ArmorDTO getArmorByArmorCode(String code) throws ClassNotFoundException, SQLException {
        ArmorDTO dto = null;
        String name, description, image;
        boolean available;
        int id;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Select ID,Code,Name,Available,Description,Image from Armors where Code=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, code);
                rs = stm.executeQuery();
                if (rs.next()) {
                    id = rs.getInt("ID");
                    name = rs.getString("Name");
                    description = rs.getString("Description");
                    available = rs.getBoolean("Available");
                    image = rs.getString("Image");
                    dto = new ArmorDTO(id, code, name, description, image, available);
                }
            }
        } finally {
            closeConnection();

        }

        return dto;
    }

    // get ID for insert new Armor and add ArmorWeapon
    public int getArmorIDByArmorCode(String code) throws ClassNotFoundException, SQLException {
        int id = -1;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Select ID from Armors where Code=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, code);
                rs = stm.executeQuery();
                if (rs.next()) {
                    id = rs.getInt("ID");
                }
            }
        } finally {
            closeConnection();

        }
        return id;
    }

    public boolean insertArmorWeapon(List<String> weaponsID, int armorID) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                for (String weaponID : weaponsID) {
                    String sql = "Insert into ArmorWeapon(WeaponID,ArmorID) values(?,?)";
                    stm = con.prepareStatement(sql);
                    stm.setInt(1, Integer.parseInt(weaponID));
                    stm.setInt(2, armorID);
                    check = stm.executeUpdate() > 0;

                }
            }
        } finally {
            closeConnection();

        }
        return check;
    }

    public void deleteArmorWeapon(int armorID) throws ClassNotFoundException, SQLException {
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Delete From ArmorWeapon where ArmorID=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, armorID);
                stm.executeUpdate();
            }
        } finally {
            closeConnection();

        }
    }

    //for armorPage
    public List<ArmorDTO> getAllArmorForArmorPage() throws ClassNotFoundException, SQLException {
        List<ArmorDTO> result = null;
        ArmorDTO dto = null;
        String code, name, image;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select Code,Name,Image from Armors where Available ='True'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    code = rs.getString("Code");
                    name = rs.getString("Name");
                    image = rs.getString("Image");
                    dto = new ArmorDTO(code, name, image);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();

        }
        return result;
    }

    public List<ArmorDTO> getNewsArmor() throws ClassNotFoundException, SQLException {
        List<ArmorDTO> result = null;
        ArmorDTO dto = null;
        String code, name, image;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select Code,Name,Image from Armors where Available ='True'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                int count = 0;
                while (rs.next()) {
                    code = rs.getString("Code");
                    name = rs.getString("Name");
                    image = rs.getString("Image");
                    dto = new ArmorDTO(code, name, image);
                    result.add(dto);
                    count++;
                    if (count > 4) {
                        break;
                    }
                }
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public List<ArmorDTO> findByNameArmorPage(String search) throws ClassNotFoundException, SQLException {
        List<ArmorDTO> result = null;
        ArmorDTO dto = null;
        String code, name;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select Code,Name from Armors where Available ='True' AND Name Like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    code = rs.getString("Code");
                    name = rs.getString("Name");
                    dto = new ArmorDTO(code, name);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public boolean updateImage(String url, String armorCode) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Update Armors SET Image=? where Code=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, url);
                stm.setString(2, armorCode);
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateAvailable(int armorID, boolean type) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                System.out.println("updateAvailable ArmorID" + armorID);
                String sql = "Update Armors SET Available=? where ID=?";
                stm = con.prepareStatement(sql);
                stm.setBoolean(1, type);
                stm.setInt(2, armorID);
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean checkDupplicateCode(String code) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Select Code from Armors where Code=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, code);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } finally {
            closeConnection();
        }
        return check;
    }

}
