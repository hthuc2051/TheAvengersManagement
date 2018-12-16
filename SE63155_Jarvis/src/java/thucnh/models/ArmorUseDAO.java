/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucnh.models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import thucnh.dtos.ArmorUseDTO;
import thucnh.util.MyConnection;

/**
 *
 * @author USER
 */
public class ArmorUseDAO implements Serializable {

    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;

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

    public boolean insertRequestUse(int userID, int armorID, String status, String weaponRequest) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try { 
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Insert into ArmorUse(UserID,ArmorID,Status,WeaponRequest) values(?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, userID);
                stm.setInt(2, armorID);
                stm.setString(3, status);
                stm.setString(4, weaponRequest);
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean clearNotAllowedRequest() throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Delete from ArmorUse where Status = 'Refused'";
                stm = con.prepareStatement(sql);
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<Integer> getAllRequestWaitingIDOfArmor(int armorID) throws ClassNotFoundException, SQLException {
        List<Integer> result = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select ID from ArmorUse where Status = 'Waiting' AND ArmorID =?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, armorID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    result.add(rs.getInt("ID"));
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ArmorUseDTO> getAllArmorRequested() throws ClassNotFoundException, SQLException {
        List<ArmorUseDTO> result = null;
        int id, armorID;
        String armorName, username, weaponRequest;
        ArmorUseDTO dto = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select ArmorUse.ID AS idRequest ,Armors.ID AS armorID ,Armors.Name,Users.Username,ArmorUse.WeaponRequest"
                        + " From ArmorUse,Armors,Users"
                        + " Where Armors.ID = ArmorUse.ArmorID AND ArmorUse.UserID=Users.ID"
                        + " AND ArmorUse.Status LIKE 'Waiting' AND Armors.Available ='true'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("idRequest");
                    armorID = rs.getInt("armorID");
                    armorName = rs.getString("Name");
                    username = rs.getString("Username");
                    weaponRequest = rs.getString("WeaponRequest");
                    dto = new ArmorUseDTO(armorName, username, weaponRequest, id, armorID);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ArmorUseDTO> findArmorRequestedByArmorName(String name) throws ClassNotFoundException, SQLException {
        List<ArmorUseDTO> result = null;
        int id, armorID;
        String armorName, username, weaponRequest;
        ArmorUseDTO dto = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select ArmorUse.ID AS idRequest ,Armors.ID AS armorID ,Armors.Name,Users.Username,ArmorUse.WeaponRequest"
                        + " From ArmorUse,Armors,Users"
                        + " Where Armors.ID = ArmorUse.ArmorID AND ArmorUse.UserID=Users.ID"
                        + " AND Armors.Name Like ? AND ArmorUse.Status LIKE 'Waiting' AND Armors.Available ='true'";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + name + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("idRequest");
                    armorID = rs.getInt("armorID");
                    armorName = rs.getString("Name");
                    username = rs.getString("Username");
                    weaponRequest = rs.getString("WeaponRequest");
                    dto = new ArmorUseDTO(armorName, username, weaponRequest, id, armorID);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ArmorUseDTO> getAllRequestHistory() throws ClassNotFoundException, SQLException {
        List<ArmorUseDTO> result = null;
        String armorName, username, startDate, endDate, status;
        ArmorUseDTO dto = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = " Select Armors.Name,Users.Username,ArmorUse.StartDate,ArmorUse.EndDate,ArmorUse.Status"
                        + " From ArmorUse,Armors,Users"
                        + " Where Armors.ID = ArmorUse.ArmorID AND ArmorUse.UserID=Users.ID AND ArmorUse.Status NOT LIKE 'Waiting'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    armorName = rs.getString("Name");
                    username = rs.getString("Username");
                    startDate = rs.getString("StartDate");
                    endDate = rs.getString("EndDate");
                    status = rs.getString("Status");
                    dto = new ArmorUseDTO(armorName, username, startDate, endDate, status);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ArmorUseDTO> findRequestHistoryByArmorName(String name) throws ClassNotFoundException, SQLException {
        List<ArmorUseDTO> result = null;
        String armorName, username, startDate, endDate, status;
        ArmorUseDTO dto = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = " Select Armors.Name,Users.Username,ArmorUse.StartDate,ArmorUse.EndDate,ArmorUse.Status"
                        + " From ArmorUse,Armors,Users"
                        + " Where Armors.ID = ArmorUse.ArmorID AND ArmorUse.UserID=users.ID"
                        + " AND ArmorUse.Status NOT LIKE 'Waiting' AND Armors.Name Like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + name + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    armorName = rs.getString("Name");
                    username = rs.getString("Username");
                    startDate = rs.getString("StartDate");
                    endDate = rs.getString("EndDate");
                    status = rs.getString("Status");
                    dto = new ArmorUseDTO(armorName, username, startDate, endDate, status);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean refuse(int idRequest) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Update ArmorUse SET Status = 'Refused' where ID=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, idRequest);
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateStatus(int idRequest, String status) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Update ArmorUse SET Status = 'Refused' where ID=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, idRequest);
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean allowed(String startDate, int idRequest) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Update ArmorUse SET StartDate=?,Status = 'Allowed' where ID=?";
                stm = con.prepareStatement(sql);
                stm.setDate(1, Date.valueOf(startDate));
                stm.setInt(2, idRequest);
                check = stm.executeUpdate() > 0;
          
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean ironmanUse(ArmorUseDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Insert into ArmorUse(UserID,ArmorID,Status,StartDate,WeaponRequest) values(?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, dto.getUserID());
                stm.setInt(2, dto.getArmorID());
                stm.setString(3, dto.getStatus());
                stm.setDate(4, Date.valueOf(dto.getStartDate()));
                stm.setString(5, dto.getWeaponRequest());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<ArmorUseDTO> getListArmorUseByUsername(String username) throws ClassNotFoundException, SQLException {
        List<ArmorUseDTO> result = null;
        int id, armorID;
        String armorName, startDate, endDate, status;
        ArmorUseDTO dto = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select ArmorUse.ID AS idRequest ,Armors.ID AS armorID ,Armors.Name,ArmorUse.StartDate,ArmorUse.EndDate,ArmorUse.Status"
                        + " From ArmorUse,Armors,Users"
                        + " Where Users.Username = ? AND ArmorUse.STATUS NOT LIKE 'Waiting' "
                        + " AND Armors.ID = ArmorUse.ArmorID AND ArmorUse.UserID=Users.ID";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                rs = stm.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("idRequest");
                    armorID = rs.getInt("armorID");
                    armorName = rs.getString("Name");
                    startDate = rs.getString("StartDate");
                    endDate = rs.getString("EndDate");
                    status = rs.getString("Status");
                    dto = new ArmorUseDTO(id, armorID, armorName, startDate, endDate, status);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ArmorUseDTO> findArmorUseOfUserByArmorName(String username, String name) throws ClassNotFoundException, SQLException {
        List<ArmorUseDTO> result = null;
        int id, armorID;
        String armorName, startDate, endDate, status;
        ArmorUseDTO dto = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select ArmorUse.ID AS idRequest ,Armors.ID AS armorID ,Armors.Name,ArmorUse.StartDate,ArmorUse.EndDate,ArmorUse.Status"
                        + " From ArmorUse,Armors,Users"
                        + " Where Users.Username = ? AND Armors.Name LIKE ? AND ArmorUse.STATUS NOT LIKE 'Waiting'"
                        + " AND Armors.ID = ArmorUse.ArmorID AND ArmorUse.UserID=Users.ID";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, "%" + name + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("idRequest");
                    armorID = rs.getInt("armorID");
                    armorName = rs.getString("Name");
                    startDate = rs.getString("StartDate");
                    endDate = rs.getString("EndDate");
                    status = rs.getString("Status");
                    dto = new ArmorUseDTO(id, armorID, armorName, startDate, endDate, status);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
public List<ArmorUseDTO> getListArmorUsedOnly(String username) throws ClassNotFoundException, SQLException {
        List<ArmorUseDTO> result = null;
        int id, armorID;
        String armorName, startDate, endDate, status;
        ArmorUseDTO dto = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select ArmorUse.ID AS idRequest ,Armors.ID AS armorID ,Armors.Name,ArmorUse.StartDate,ArmorUse.EndDate,ArmorUse.Status"
                        + " From ArmorUse,Armors,Users"
                        + " Where Users.Username = ? AND ArmorUse.STATUS LIKE 'Allowed' AND Armors.Available ='true'"
                        + " AND Armors.ID = ArmorUse.ArmorID AND ArmorUse.UserID=Users.ID";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                rs = stm.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("idRequest");
                    armorID = rs.getInt("armorID");
                    armorName = rs.getString("Name");
                    startDate = rs.getString("StartDate");
                    endDate = rs.getString("EndDate");
                    status = rs.getString("Status");
                    dto = new ArmorUseDTO(id, armorID, armorName, startDate, endDate, status);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    public boolean setEndDate(String endDate, int idRequest) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Update ArmorUse SET EndDate=?,Status = 'Allowed' where ID=?";
                stm = con.prepareStatement(sql);
                stm.setDate(1, Date.valueOf(endDate));
                stm.setInt(2, idRequest);
                check = stm.executeUpdate() > 0;
                
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean checkRequestArmorExisted(int armorID) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Select ArmorUse.ID"
                        + " From ArmorUse,Armors"
                        + " Where ArmorUse.ArmorID = Armors.ID"
                        + " AND ArmorUse.Status LIKE 'Allowed'"
                        + " AND Armors.ID = ?"
                        + " AND Armors.Available ='false'";
                stm = con.prepareStatement(sql);
                stm.setInt(1, armorID);
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
