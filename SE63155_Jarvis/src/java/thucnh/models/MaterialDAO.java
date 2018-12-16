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
import thucnh.dtos.MaterialDTO;
import thucnh.util.MyConnection;

/**
 *
 * @author USER
 */
public class MaterialDAO implements Serializable {

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

    public boolean insert(MaterialDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Insert into Materials(Name,Description) values(?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getName());
                stm.setString(2, dto.getDescription());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<MaterialDTO> getAllMaterials() throws ClassNotFoundException, SQLException {
        List<MaterialDTO> result = null;
        MaterialDTO dto = null;
        String name, description;
        int id;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select ID,Name,Description from Materials";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("ID");
                    name = rs.getString("Name");
                    description = rs.getString("Description");
                    dto = new MaterialDTO(name, description, id);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public MaterialDTO getMaterialByID(int id) throws ClassNotFoundException, SQLException {
        MaterialDTO dto = null;
        String name, description;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Select Name,Description from Materials where ID=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    name = rs.getString("Name");
                    description = rs.getString("Description");
                    dto = new MaterialDTO(name, description, id);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    //set the check ratio in armorPage
    public MaterialDTO getMaterialByArmorCode(String code) throws ClassNotFoundException, SQLException {
        String name, description;
        int id;
        MaterialDTO dto = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Select Materials.ID,Materials.Name,Materials.Description"
                        + " From Materials,Armors"
                        + " Where Armors.Code = ? AND Materials.ID = Armors.MaterialID ";
                stm = con.prepareStatement(sql);
                stm.setString(1, code);
                rs = stm.executeQuery();
                if (rs.next()) {
                    id = rs.getInt("ID");
                    name = rs.getString("Name");
                    description = rs.getString("Description");
                    dto = new MaterialDTO(name, description, id);
                }
            }
        } finally {
            closeConnection();
        }

        return dto;
    }

    public boolean update(MaterialDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Update Materials SET Name=?,Description=? Where ID=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getName());
                stm.setString(2, dto.getDescription());
                stm.setInt(3, dto.getId());
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
                String sql = "Delete From Materials Where ID=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<MaterialDTO> findByName(String nameSearch) throws ClassNotFoundException, SQLException {
        List<MaterialDTO> result = null;
        MaterialDTO dto = null;
        int id;
        String name, description;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select ID,Name,Description from Materials where Name Like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + nameSearch + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("ID");
                    name = rs.getString("Name");
                    description = rs.getString("Description");
                    dto = new MaterialDTO(name, description, id);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public List<String> getMaterialsUsedID() throws ClassNotFoundException, SQLException {
        String id;
        List<String> result = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select MaterialID from Armors";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    id = rs.getString("MaterialID");
                    result.add(id);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
