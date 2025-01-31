package com.app.dao.impl;

import com.app.dao.UserDAO;
import com.app.model.User;
import com.app.util.DbConnection;   
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOIMPL extends DbConnection implements UserDAO{
    
    /* 
        -------------------------------------------------------------------------
                                        CREATE
        -------------------------------------------------------------------------
    */
    
    @Override
    public boolean registerUser(User user){
        String query = "INSERT INTO tblusers(user_username, user_password, user_role, user_lastname, user_firstname, user_middlename, user_gender, user_address, user_contact, user_registration_date, user_expiration_date, user_status, user_package_id, user_archived) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        boolean isSuccessful = false; 
        
        try {
            connect();
            prep = con.prepareStatement(query);
            prep.setString(1, user.getUsername());
   
            String encryptedPassword = encryptPassword(user.getPassword());
            
            prep.setString(2, encryptedPassword);
            prep.setString(3,user.getRole());
            prep.setString(4, user.getLastname());
            prep.setString(5, user.getFirstname());
            prep.setString(6, user.getMiddlename());
            prep.setString(7, user.getGender());
            prep.setString(8, user.getAddress());
            prep.setString(9, user.getContact());
            prep.setDate(10, user.getRegistrationDate());
            prep.setDate(11, user.getExpirationDate());
            prep.setString(12, user.getStatus());
            prep.setInt(13, user.getPackageId());
            prep.setInt(14, user.getArchived());
            prep.executeUpdate();
            isSuccessful = true; 
        } catch (SQLException e) {
            System.out.println("UserDAOIMPL: registerUser() " + e.getMessage());
        } finally{
            try {
                con.close();
                state.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        return isSuccessful; 
    }
    
    /* 
        -------------------------------------------------------------------------
                                        READ
        -------------------------------------------------------------------------
    */
    
    @Override
    public User getUser(int id){
        String query = "SELECT * FROM tblusers WHERE user_id = " + id 
                + " AND user_role = 'member' AND user_archived = 0";
        User user = new User();
        
        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(query);
                       
            while(result.next()){     
                user.setId(result.getInt("user_id"));
                user.setUsername(result.getString("user_username"));
                user.setPassword(result.getString("user_password"));
                user.setRole(result.getString("user_role"));
                user.setLastname(result.getString("user_lastname"));
                user.setFirstname(result.getString("user_firstname"));
                user.setMiddlename(result.getString("user_middlename"));
                user.setGender(result.getString("user_gender"));
                user.setAddress(result.getString("user_address"));
                user.setContact(result.getString("user_contact"));
                user.setRegistrationDate(result.getDate("user_registration_date"));
                user.setExpirationDate(result.getDate("user_expiration_date"));
                user.setStatus(result.getString("user_status"));
                user.setPackageId(result.getInt("user_package_id"));
                user.setArchived(result.getInt("user_archived"));
                return user;
            }   
        } catch (SQLException e) {
            System.out.println("UserDAOIMPL: getUser() " + e.getMessage());
        } finally{
            try {
                con.close();
                state.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
       
        return user;   
    }
    
    @Override
    public ArrayList<User> fetchMembers(){
        String query = "SELECT * FROM tblusers WHERE user_archived = 0 AND user_role = 'member'";
        ArrayList<User> users = new ArrayList<>();
        
        try {
            connect(); 
            state = con.createStatement();
            result = state.executeQuery(query);
            
            while(result.next()){
                users.add(
                        new User(
                            result.getInt("user_id"), 
                            result.getString("user_username"),
                            result.getString("user_password"),
                            result.getString("user_role"),
                            result.getString("user_lastname"),
                            result.getString("user_firstname"),
                            result.getString("user_middlename"),
                            result.getString("user_gender"),
                            result.getString("user_address"),
                            result.getString("user_contact"),
                            result.getDate("user_registration_date"),
                            result.getDate("user_expiration_date"),
                            result.getString("user_status"),
                            result.getInt("user_package_id"),
                            result.getInt("user_archived")
                        )
                );
            }
            
        } catch (SQLException e) {
            System.out.println("UserDAOIMPL: fetchUser() " + e.getMessage());
        }
        finally{
            try {
                con.close();
                state.close();
                result.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        return users;
    }
    
    @Override
    public ArrayList<User> searchUsers(String criteria){
        String query = "SELECT * FROM tblusers WHERE user_lastname LIKE '%" + criteria 
                + "%' OR user_firstname LIKE '%" + criteria 
                + "%' OR user_middlename LIKE '%" + criteria 
                + "%' AND user_role = 'member'";
        
        ArrayList<User> users = new ArrayList<>();
        
        try {
            connect(); 
            state = con.createStatement();
            result = state.executeQuery(query);
            
            while(result.next()){
                users.add(
                        new User(
                            result.getInt("user_id"), 
                            result.getString("user_username"),
                            result.getString("user_password"),
                            result.getString("user_role"),
                            result.getString("user_lastname"),
                            result.getString("user_firstname"),
                            result.getString("user_middlename"),
                            result.getString("user_gender"),
                            result.getString("user_address"),
                            result.getString("user_contact"),
                            result.getDate("user_registration_date"),
                            result.getDate("user_expiration_date"),
                            result.getString("user_status"),
                            result.getInt("user_package_id"),
                            result.getInt("user_archived")
                        )
                );
            }
            
        } catch (SQLException e) {
            System.out.println("UserDAOIMPL: searchUsers() " + e.getMessage());
        }
        finally{
            try {
                con.close();
                state.close();
                result.close();
            } catch (SQLException e) {
                System.out.println("Unable to close connection! " + e.getMessage());
            }
        }
        
        return users;
    }
    
    /* 
        -------------------------------------------------------------------------
                                        UPDATE
        -------------------------------------------------------------------------
    */
    
    @Override
    public boolean updateUser(User newUser, User oldUser){
        String query = "UPDATE tblusers SET user_lastname = ?, user_firstname = ?, user_middlename = ?, user_gender = ?, user_address = ?, user_contact = ?, user_status = ? " 
                + "WHERE user_id = ?";
        boolean isSuccessful = false; 
        
        try {
            connect();
            prep = con.prepareStatement(query);
            if(newUser.getLastname().equals("")){
                prep.setString(1, oldUser.getLastname());
            } else{
                prep.setString(1, newUser.getLastname());
            }
            if(newUser.getFirstname().equals("")){
                prep.setString(2, oldUser.getFirstname());
            } else{
                prep.setString(2, newUser.getFirstname());
            } 
            if(newUser.getMiddlename().equals("")){
                prep.setString(3, oldUser.getMiddlename());
            } else{
                prep.setString(3, newUser.getMiddlename());
            }
            if(newUser.getGender().equals("")){
                prep.setString(4, oldUser.getGender());
            } else{
                prep.setString(4, newUser.getGender());
            }
            if(newUser.getAddress().equals("")){
                prep.setString(5, oldUser.getAddress());
            } else{
                prep.setString(5, newUser.getAddress());
            }
            if(newUser.getContact().equals("")){
                prep.setString(6, oldUser.getContact());
            } else{
                prep.setString(6, newUser.getContact());
            }
            if(newUser.getStatus().equals("")){
                prep.setString(7, oldUser.getStatus());
            } else{
                prep.setString(7, newUser.getStatus());
            }
            prep.setInt(8, oldUser.getId());
            prep.executeUpdate();
            
            isSuccessful = true; 
  
        } catch (SQLException e) {
            System.out.println("UserDAOIMPL: updateUser() " + e.getMessage());
        } finally{
            try {
                con.close();
                prep.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        return isSuccessful; 
    }
    
    /* 
        -------------------------------------------------------------------------
                                        DELETE
        -------------------------------------------------------------------------
    */
    
    @Override
    public void archiveOrRestoreUser(User user){
        String  query = "UPDATE tblusers SET user_archived = ? WHERE user_id = ?"; 
        
        try {
            connect();
            prep = con.prepareStatement(query);
            int archived = user.getArchived() == 0 ? 1: 0;  // Reverse the archive value 
            prep.setInt(1, archived);
            prep.setInt(2, user.getId());
            prep.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("UserDAOIMPL: archiveOrRestoreUser() " + e.getMessage());
        } finally{
            try {
                con.close();
                prep.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    @Override
    public void deleteUser(User user){
        String query = "DELETE FROM tblusers WHERE user_id = ?";
        
        try {
            connect();
            prep = con.prepareStatement(query);
            prep.setInt(1, user.getId());
            prep.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("UserDAOIMPL: deleteUser() " + e.getMessage());
        } finally{
            try {
                con.close();
                prep.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    /* 
        -------------------------------------------------------------------------
                                        LOGIN
        -------------------------------------------------------------------------
    */
    
    @Override
    public String loginUser(String username, String password){
        String encryptedPassword = encryptPassword(password);
        String query = "SELECT user_role FROM tblusers WHERE user_username = " + username +  " AND user_password = " + encryptedPassword;
        String role = ""; 
        
        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(query);
                       
            while(result.next()){     
                role = result.getString("user_role");
            }   
        } catch (SQLException e) {
            System.out.println("UserDAOIMPL: loginUser() " + e.getMessage());
        } finally{
            try {
                con.close();
                state.close();
            } catch (SQLException e) {
                System.out.println("Unable to close connection! " + e.getMessage());
            }
        }
       
        return role;
        
    }
    
    public String encryptPassword( String password ){
        String encryptedPass = null;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes());  
            
            byte[] bytes = m.digest();  
            
            StringBuilder s = new StringBuilder();  
            for(int i=0; i< bytes.length ;i++)  
            {  
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            }  
            
            encryptedPass = s.toString();  
            
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm Exists " + e.getMessage());
        }
        
        return encryptedPass;
    }
}
