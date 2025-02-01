package com.gymmembership.system.impl;

import com.app.dao.UserDAO;
import com.app.model.User;
import com.gymmembership.system.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;

public class UserDaoImpl extends DbConnection implements UserDAO {

    private Connection getConnection() {
        return dbConnect();
    }

    @Override
    public boolean registerUser(User user) {
        String sql = "INSERT INTO users (username, password, role, lastname, firstname, middlename, gender, address, contact, registrationDate, expirationDate, status, packageId, archived) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.setString(4, user.getLastname());
            stmt.setString(5, user.getFirstname());
            stmt.setString(6, user.getMiddlename());
            stmt.setString(7, user.getGender());
            stmt.setString(8, user.getAddress());
            stmt.setString(9, user.getContact());
            stmt.setDate(10, user.getRegistrationDate());
            stmt.setDate(11, user.getExpirationDate());
            stmt.setString(12, user.getStatus());
            stmt.setInt(13, user.getPackageId());
            stmt.setInt(14, user.getArchived());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.out.println("Failed to register user!");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUser(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("lastname"),
                        rs.getString("firstname"),
                        rs.getString("middlename"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getString("contact"),
                        rs.getDate("registrationDate"),
                        rs.getDate("expirationDate"),
                        rs.getString("status"),
                        rs.getInt("packageId"),
                        rs.getInt("archived")
                );
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve user!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<User> fetchMembers() {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("lastname"),
                        rs.getString("firstname"),
                        rs.getString("middlename"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getString("contact"),
                        rs.getDate("registrationDate"),
                        rs.getDate("expirationDate"),
                        rs.getString("status"),
                        rs.getInt("packageId"),
                        rs.getInt("archived")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch users!");
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public ArrayList<User> searchUsers(String criteria) {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE username LIKE ? OR lastname LIKE ? OR firstname LIKE ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, "%" + criteria + "%");
            stmt.setString(2, "%" + criteria + "%");
            stmt.setString(3, "%" + criteria + "%");
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("lastname"),
                        rs.getString("firstname"),
                        rs.getString("middlename"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getString("contact"),
                        rs.getDate("registrationDate"),
                        rs.getDate("expirationDate"),
                        rs.getString("status"),
                        rs.getInt("packageId"),
                        rs.getInt("archived")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to search users!");
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean updateUser(User newUser, User oldUser) {
        String sql = "UPDATE users SET username = ?, password = ?, role = ?, lastname = ?, firstname = ?, middlename = ?, gender = ?, address = ?, contact = ?, registrationDate = ?, expirationDate = ?, status = ?, packageId = ?, archived = ? WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, newUser.getUsername());
            stmt.setString(2, newUser.getPassword());
            stmt.setString(3, newUser.getRole());
            stmt.setString(4, newUser.getLastname());
            stmt.setString(5, newUser.getFirstname());
            stmt.setString(6, newUser.getMiddlename());
            stmt.setString(7, newUser.getGender());
            stmt.setString(8, newUser.getAddress());
            stmt.setString(9, newUser.getContact());
            stmt.setDate(10, newUser.getRegistrationDate());
            stmt.setDate(11, newUser.getExpirationDate());
            stmt.setString(12, newUser.getStatus());
            stmt.setInt(13, newUser.getPackageId());
            stmt.setInt(14, newUser.getArchived());
            stmt.setInt(15, oldUser.getId());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Failed to update user!");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void archiveOrRestoreUser(User user) {
        String sql = "UPDATE users SET archived = ? WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, user.getArchived() == 0 ? 1 : 0);  // Toggle archived state
            stmt.setInt(2, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to archive/restore user!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(User user) {
        String sql = "DELETE FROM users WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to delete user!");
            e.printStackTrace();
        }
    }

    @Override
    public String loginUser(String username, String password) {
        String sql = "SELECT role FROM users WHERE username = ? AND password = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("role");
            }
        } catch (SQLException e) {
            System.out.println("Login failed!");
            e.printStackTrace();
        }
        return null;
    }
}
