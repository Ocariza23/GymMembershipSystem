/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gymmembership.system.dao;

import com.gymmembership.system.model.User;
import java.util.ArrayList;

/**
 *
 * @author MJ
 */
public interface UserDAO {
    // Create
    public boolean registerUser(User user);
    
    // Read
    public User getUser(int id);
    public ArrayList<User> fetchMembers();  
    public ArrayList<User> searchUsers(String criteria);
    
    // Update
    public boolean updateUser(User newUser, User oldUser);
    
    // Delete
    public void archiveOrRestoreUser(User user);
    public void deleteUser(User user);
    
    // Login
    
    public String loginUser(String username, String password);
}
