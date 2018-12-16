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
import thucnh.dtos.MissionDTO;
import thucnh.dtos.UserDTO;
import thucnh.util.MyConnection;

/**
 *
 * @author USER
 */
public class MissionDAO implements Serializable {

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

    public List<MissionDTO> getAllMission() throws ClassNotFoundException, SQLException {
        String code, title, status, location;
        MissionDTO dto = null;
        List<MissionDTO> result = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select Code,Title,Location,Status From Missions";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    code = rs.getString("Code");
                    title = rs.getString("Title");
                    location = rs.getString("Location");
                    status = rs.getString("Status");
                    dto = new MissionDTO(code, title, location, status);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
  public List<MissionDTO> getAllNotFinishedMission() throws ClassNotFoundException, SQLException {
        String code, status, endDate;
        MissionDTO dto = null;
        List<MissionDTO> result = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select Code,Status,EndDate From Missions where Status Like 'Not Finished'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    code = rs.getString("Code");
                    status = rs.getString("Status");
                    endDate = rs.getString("EndDate");
                    dto = new MissionDTO(code, status, endDate);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    public List<MissionDTO> findByTitle(String searchTitle) throws ClassNotFoundException, SQLException {
        String code, title, status, location;
        MissionDTO dto = null;
        List<MissionDTO> result = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select Code,Title,Location,Status From Missions where Title Like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchTitle + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    code = rs.getString("Code");
                    title = rs.getString("Title");
                    location = rs.getString("Location");
                    status = rs.getString("Status");
                    dto = new MissionDTO(code, title, location, status);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public boolean update(MissionDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Update Missions Set Title=?,Location=?,Status=?,StartDate=?,EndDate=?,Description=? where Code=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getTitle());
                stm.setString(2, dto.getLocation());
                stm.setString(3, dto.getStatus());
                stm.setDate(4, Date.valueOf(dto.getStartDate()));
                stm.setDate(5, Date.valueOf(dto.getEndDate()));
                stm.setString(6, dto.getDescription());
                stm.setString(7, dto.getCode());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateStatusMission(MissionDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Update Missions Set Status=?,EndDate=? where Code=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getStatus());
                stm.setDate(2, Date.valueOf(dto.getEndDate()));
                stm.setString(3, dto.getCode());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean delete(String missionCode) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Delete From Missions where Code=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, missionCode);
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public void delelteUserMissionByMissionID(int missionID) throws ClassNotFoundException, SQLException {
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Delete From UserMission where MissionID=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, missionID);
                stm.executeUpdate();
            }
        } finally {
            closeConnection();
        }
    }

    public void delelteUserDoMissionByUserID(int userID) throws ClassNotFoundException, SQLException {
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Delete From UserMission where UserID=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, userID);
                stm.executeUpdate();
            }
        } finally {
            closeConnection();
        }

    }

    public boolean insert(MissionDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Insert into Missions(Code,Title,Location,Status,StartDate,EndDate,Description) values(?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getCode());
                stm.setString(2, dto.getTitle());
                stm.setString(3, dto.getLocation());
                stm.setString(4, dto.getStatus());
                stm.setDate(5, Date.valueOf(dto.getStartDate()));
                stm.setDate(6, Date.valueOf(dto.getEndDate()));
                stm.setString(7, dto.getDescription());
                check = stm.executeUpdate() > 0;

            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public int getMissionIDByMissionCode(String missionCode) throws ClassNotFoundException, SQLException {
        int id = -1;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Select ID From Missions Where Code =?";
                stm = con.prepareStatement(sql);
                stm.setString(1, missionCode);
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

    public MissionDTO getMissionByMissionCode(String missionCode) throws ClassNotFoundException, SQLException {
        String code, title, location, status, startDate, endDate, description;
        MissionDTO dto = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Select Code,Title,Location,Status,StartDate,EndDate,Description From Missions where Code=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, missionCode);
                rs = stm.executeQuery();
                while (rs.next()) {
                    code = rs.getString("Code");
                    title = rs.getString("Title");
                    location = rs.getString("Location");
                    status = rs.getString("Status");
                    startDate = rs.getString("StartDate");
                    endDate = rs.getString("EndDate");
                    description = rs.getString("Description");
                    dto = new MissionDTO(code, title, location, status, startDate, endDate, description);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean deleteUserMissionByMissionID(int missionID) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Delete from UserMission where MissionID=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, missionID);
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insertUserMission(int missionID, List<Integer> usersID) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                for (Integer userID : usersID) {
                    String sql = "Insert into UserMission(UserID,MissionID) values(?,?)";
                    stm = con.prepareStatement(sql);
                    stm.setInt(1, userID);
                    stm.setInt(2, missionID);
                    check = stm.executeUpdate() > 0;
                }
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<UserDTO> getUsersDoMissionByMissionCode(String missionCode) throws ClassNotFoundException, SQLException {
        List<UserDTO> result = null;
        String username = null;
        String lastName = null;
        String firstName = null;
        UserDTO dto = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "SELECT Users.Username, Users.LastName, Users.FirstName"
                        + " FROM Users, UserMission, Missions"
                        + " WHERE Missions.Code=?"
                        + " AND Users.ID=UserMission.UserID"
                        + " AND UserMission.MissionID = Missions.ID";
                stm = con.prepareStatement(sql);
                stm.setString(1, missionCode);
                rs = stm.executeQuery();
                while (rs.next()) {
                    username = rs.getString("Username");
                    lastName = rs.getString("LastName");
                    firstName = rs.getString("FirstName");
                    dto = new UserDTO(username, lastName, firstName);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<MissionDTO> getMissionsByUsername(String username) throws ClassNotFoundException, SQLException {
        List<MissionDTO> result = null;
        MissionDTO dto = null;
        String code, title, location, status, startDate, endDate, description;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "SELECT Missions.Code,Missions.Title,Missions.Location,Missions.Status,"
                        + " Missions.StartDate,Missions.EndDate,Missions.Description"
                        + " FROM Users, UserMission , Missions"
                        + " WHERE Users.Username =?"
                        + " AND Users.ID = UserMission.UserID"
                        + " AND Missions.ID = UserMission.MissionID";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                rs = stm.executeQuery();
                while (rs.next()) {
                    code = rs.getString("Code");
                    title = rs.getString("Title");
                    location = rs.getString("Location");
                    status = rs.getString("Status");
                    startDate = rs.getString("StartDate");
                    endDate = rs.getString("EndDate");
                    description = rs.getString("Description");
                    dto = new MissionDTO(code, title, location, status, startDate, endDate, description);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<MissionDTO> findMissionOfUserByTitle(String username, String search) throws ClassNotFoundException, SQLException {
        List<MissionDTO> result = null;
        MissionDTO dto = null;
        String code, title, location, status, startDate, endDate, description;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "SELECT Missions.Code,Missions.Title,Missions.Location,Missions.Status,"
                        + " Missions.StartDate,Missions.EndDate,Missions.Description"
                        + " FROM Users, UserMission , Missions"
                        + " WHERE Users.Username =? AND Title LIKE ?"
                        + " AND Users.ID = UserMission.UserID"
                        + " AND Missions.ID = UserMission.MissionID";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    code = rs.getString("Code");
                    title = rs.getString("Title");
                    location = rs.getString("Location");
                    status = rs.getString("Status");
                    startDate = rs.getString("StartDate");
                    endDate = rs.getString("EndDate");
                    description = rs.getString("Description");
                    dto = new MissionDTO(code, title, location, status, startDate, endDate, description);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public List<MissionDTO> findMissionNotFinishedOnly(String username) throws ClassNotFoundException, SQLException {
        List<MissionDTO> result = null;
        MissionDTO dto = null;
        String code, title, location, status, startDate, endDate, description;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "SELECT Missions.Code,Missions.Title,Missions.Location,Missions.Status,"
                        + " Missions.StartDate,Missions.EndDate,Missions.Description"
                        + " FROM Users, UserMission , Missions"
                        + " WHERE Users.Username =? AND Missions.Status LIKE 'Not finished'"
                        + " AND Users.ID = UserMission.UserID"
                        + " AND Missions.ID = UserMission.MissionID";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                rs = stm.executeQuery();
                while (rs.next()) {
                    code = rs.getString("Code");
                    title = rs.getString("Title");
                    location = rs.getString("Location");
                    status = rs.getString("Status");
                    startDate = rs.getString("StartDate");
                    endDate = rs.getString("EndDate");
                    description = rs.getString("Description");
                    dto = new MissionDTO(code, title, location, status, startDate, endDate, description);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean checkDupplicateCode(String missionCode) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Select ID From Missions Where Code =?";
                stm = con.prepareStatement(sql);
                stm.setString(1, missionCode);
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
