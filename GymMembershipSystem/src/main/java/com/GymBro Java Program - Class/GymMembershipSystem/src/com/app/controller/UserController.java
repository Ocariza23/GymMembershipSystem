package com.app.controller;

import com.app.dao.UserDAO;
import com.app.model.User;
import com.app.view.UserView;
import java.util.ArrayList;


public class UserController {
    private UserDAO userDAO; 
    private UserView userView; 
    
    public UserController( UserDAO userDAO, UserView userView ) {
        this.userDAO = userDAO;
        this.userView = userView;
    }
    
    /* 
        -------------------------------------------------------------------------
                                        CREATE
        -------------------------------------------------------------------------
    */
    
     public void registerUsers(){
        
        User newUser = userView.createUsers(); 
     
        if(userDAO.registerUser(newUser)){
            System.out.println("Registration Successful!");
        }
        else{
            System.out.println("Registration Failed!");
        }
    }
    
    
    /* 
        -------------------------------------------------------------------------
                                        READ
        -------------------------------------------------------------------------
    */
    
    public void displayUsers(){
        ArrayList<User> users = userDAO.fetchMembers(); 
        userView.displayUsers(users); 
    }
    
    public void displayUser(){
        
        int id = userView.getUser();
        User user = userDAO.getUser(id);
        
        userView.displayUser(user);
    }
    
    public void searchUsers(){
         
        String criteria = userView.searchUsers();
        
        ArrayList<User> users = userDAO.searchUsers(criteria);
        userView.displayUsers(users);
    }
    
    /* 
        -------------------------------------------------------------------------
                                        UPDATE
        -------------------------------------------------------------------------
    */
    
    public void updateUser(){
        
        int id = userView.getUser(); 
        User user = userDAO.getUser(id);
        
        User newUser = userView.updateUser(user);
        if (userDAO.updateUser(newUser, user)){
            System.out.println("Update Sucessful!");
        }
        else{
            System.out.println("Update Failed");
        }   
    }
    
    /* 
        -------------------------------------------------------------------------
                                        DELETE
        -------------------------------------------------------------------------
    */
    
    public void softDeleteUser(){
        int id = userView.getUser(); 
        User user = userDAO.getUser(id);
        
        if(user.getArchived() == 0){
            userDAO.archiveOrRestoreUser(user);
            System.out.println("User Archived Successfully!");
        }
        else{
            System.out.println("User already archived!");
        }
    }
    
    public void restoreUser(){
        int id = userView.getUser();
        User user = userDAO.getUser(id);
        
        if(user.getArchived() == 1){
            userDAO.archiveOrRestoreUser(user);
            System.out.println("User Restored Successfully!");
        }
        else{
            System.out.println("User already restored!");
        }
    }
    
    public void permaDeleteUser(){
        int id = userView.getUser();
        User user = userDAO.getUser(id);
        
        if(user != null){
            userDAO.deleteUser(user);
        }
        else{
            System.out.println("User doesn't exist!");
        }
    }
    
    /* 
        -------------------------------------------------------------------------
                                        LOGIN
        -------------------------------------------------------------------------
    */
    
    public void loginUser(){
        User user = userView.loginUser();
        
        String role = userDAO.loginUser(user.getUsername(), user.getPassword());
        
        if(!role.equals("")){
            switch(role){
                case "admin" -> {
                    // Go to Admin Dashboard
                    System.out.println("Admin!");
                }
                case "member" -> {
                    // Go to Member Dashboard
                    System.out.println("Member!");
                }
                default -> System.out.println("Something went wrong!");
            }
                        
        }
        else{
            System.out.println("Login Failed!");
            loginUser();
        }
    }
    
}
