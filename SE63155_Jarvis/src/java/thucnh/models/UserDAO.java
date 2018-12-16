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
import thucnh.dtos.UserDTO;
import thucnh.util.MyConnection;

/**
 *
 * @author USER
 */
public class UserDAO implements Serializable {

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

    public String checkLogin(String username, String password) throws ClassNotFoundException, SQLException {
        String role = "failed";
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "SELECT Role FROM Users where Username=? and Password=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    role = rs.getString("Role");
                }
            }
        } finally {
            closeConnection();
        }
        return role;
    }

    public List<UserDTO> getAllUserForSession() throws ClassNotFoundException, SQLException {
        String username, lastName, firstName,image;
        UserDTO dto = null;
        List<UserDTO> result = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select Username,LastName,FirstName,Image FROM Users where Role NOT LIKE 'admin'";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    username = rs.getString("Username");
                    lastName = rs.getString("LastName");
                    firstName = rs.getString("FirstName");
                    image = rs.getString("Image");
                    dto = new UserDTO(username, lastName, firstName);
                    dto.setImage(image);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
 public List<UserDTO> getAllUser(String adminUsername) throws ClassNotFoundException, SQLException {
        String username, lastName, firstName, role, email;
        String image;
        UserDTO dto = null;
        List<UserDTO> result = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select Username,LastName,FirstName,Email,Role,Image FROM Users where Username NOT LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, adminUsername);
                rs = stm.executeQuery();
                while (rs.next()) {
                    username = rs.getString("Username");
                    lastName = rs.getString("LastName");
                    firstName = rs.getString("FirstName");
                    email = rs.getString("Email");
                    role = rs.getString("Role");
                    image = rs.getString("Image");
                    dto = new UserDTO(username, lastName, firstName, email, role, image);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    public boolean insert(UserDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Insert into Users(Username,Password,LastName,FirstName,Email,Role,Image) values(?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
               
                stm.setString(1, dto.getUsername());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getLastName());
                stm.setString(4, dto.getFirstName());
                stm.setString(5, dto.getEmail());
                stm.setString(6, dto.getRole());
                stm.setString(7, dto.getImage());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean delete(String username) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Delete From Users where Username=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public int getUserIDByUsername(String username) throws ClassNotFoundException, SQLException {
        int id = -1;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Select ID From Users where Username=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
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

    public String getUserPasswordByUsername(String username) throws ClassNotFoundException, SQLException {
        String password = "";
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Select Password From Users where Username=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                rs = stm.executeQuery();
                if (rs.next()) {
                    password = rs.getString("Password");
                }
            }
        } finally {
            closeConnection();
        }
        return password;
    }

    public List<UserDTO> findByName(String name,String adminUsername) throws ClassNotFoundException, SQLException {
        String username, lastName, firstName, email, role, image;
        UserDTO dto = null;
        List<UserDTO> result = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                result = new ArrayList<>();
                String sql = "Select Username,LastName,FirstName,Email,Role,Image FROM Users where LastName LIKE ? OR FirstName LIKE ? AND Username NOT LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + name + "%");
                stm.setString(2, "%" + name + "%");
                stm.setString(3, adminUsername);
                rs = stm.executeQuery();
                while (rs.next()) {
                    username = rs.getString("Username");
                    lastName = rs.getString("LastName");
                    firstName = rs.getString("FirstName");
                    email = rs.getString("Email");
                    role = rs.getString("Role");
                    image = rs.getString("Image");
                    dto = new UserDTO(username, lastName, firstName, email, role, image);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public UserDTO getUserByUsername(String username) throws ClassNotFoundException, SQLException {
        UserDTO dto = null;
        String lastName = null;
        String firstName = null;
        String email = null;
        String role = null;
        String image = null;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Select LastName,FirstName,Email,Role,Image from Users where Username=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                rs = stm.executeQuery();
                if (rs.next()) {
                    lastName = rs.getString("LastName");
                    firstName = rs.getString("FirstName");
                    email = rs.getString("Email");
                    role = rs.getString("Role");
                    image = rs.getString("Image");
                    dto = new UserDTO(username, lastName, firstName, email, role, image);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean updateByUser(UserDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Update Users SET Password=?,LastName=?,FirstName=?,Email=? where Username=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getPassword());
                stm.setString(2, dto.getLastName());
                stm.setString(3, dto.getFirstName());
                stm.setString(4, dto.getEmail());
                stm.setString(5, dto.getUsername());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateByAdmin(UserDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Update Users SET Password=?,LastName=?,FirstName=?,Role=?,Email=? where Username=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getPassword());
                stm.setString(2, dto.getLastName());
                stm.setString(3, dto.getFirstName());
                stm.setString(4, dto.getRole());
                stm.setString(5, dto.getEmail());
                stm.setString(6, dto.getUsername());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateImage(String url, String username) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Update Users SET Image=? where Username=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, url);
                stm.setString(2, username);
                check = stm.executeUpdate() > 0;
               
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean checkDupplicateUsername(String username) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            if (con != null) {
                String sql = "Select Username from Users where Username=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
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
