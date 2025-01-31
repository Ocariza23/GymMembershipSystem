package com.app.view;

import com.app.model.User;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;

public class UserView {
    
    /* 
        -------------------------------------------------------------------------
                                        READ
        -------------------------------------------------------------------------
    */
    
    public void displayUsers(ArrayList<User> users){
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-4s| %-30s| %-10s| %-40s| %-20s| %-20s| %-20s| %-10s| %-15s| %n", "ID", "NAME", "GENDER", "ADDRESS", "CONTACT", "REGISTRATION DATE", "EXPIRATION DATE", "STATUS", "PACKAGE_ID");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        users.forEach((user) -> {
            System.out.printf("%-4s| %-30s| %-10s| %-40s| %-20s| %-20s| %-20s| %-10s| %-15s| %n", user.getId(), user.getLastname() + ", " + user.getFirstname() + " " + user.getMiddlename() , user.getGender(), user.getAddress(), user.getContact(), user.getRegistrationDate(), user.getExpirationDate(), user.getStatus(), user.getPackageId());            
        });
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }   
    
    public void displayUser(User user){
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-4s| %-30s| %-10s| %-40s| %-20s| %-20s| %-20s| %-10s| %-15s| %n", "ID", "NAME", "GENDER", "ADDRESS", "CONTACT", "REGISTRATION DATE", "EXPIRATION DATE", "STATUS", "PACKAGE_ID");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        System.out.printf("%-4s| %-30s| %-10s| %-40s| %-20s| %-20s| %-20s| %-10s| %-15s| %n", user.getId(), user.getLastname() + ", " + user.getFirstname() + " " + user.getMiddlename() , user.getGender(), user.getAddress(), user.getContact(), user.getRegistrationDate(), user.getExpirationDate(), user.getStatus(), user.getPackageId());
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    public int getUser(){
        Scanner sc = new Scanner(System.in);
        int id;
        
        System.out.print("Enter ID: ");
        id = sc.nextInt(); 
        
        return id;
    }
    
    public String searchUsers(){
        Scanner sc = new Scanner(System.in); 
        String criteria; 
        
        System.out.println("SEARCH USERS");
        System.out.println("Enter name to search: ");
        criteria = sc.nextLine(); 
        
        return criteria;    
    }
    
    
    /* 
        -------------------------------------------------------------------------
                                        CREATE
        -------------------------------------------------------------------------
    */
    
    public User createUsers(){
        Scanner sc = new Scanner(System.in);   
        String username, password, role, lastname, firstname, middlename, gender, address, contact, status;
        java.sql.Date registration_date, expiration_date; 
        int package_id = 0; 
        
        System.out.println("REGISTER USERS");
        
        System.out.print("Username: ");
        username = sc.nextLine(); 
        System.out.print("Temporary Password: "); // allow the member to change password 
        // Supreme Leader suggesetion: Random password
        password = sc.nextLine();
        
        //At this point we will assume that roles are only admin and member
        System.out.print("Role (admin or member): ");
        role = sc.nextLine(); 
        System.out.print("Lastname: ");
        lastname = sc.nextLine(); 
        System.out.print("Firstname: ");
        firstname = sc.nextLine(); 
        System.out.print("Middlename: ");
        middlename = sc.nextLine();
        System.out.print("Gender: "); 
        gender = sc.nextLine();
        System.out.print("Address: ");
        address = sc.nextLine();
        System.out.print("Contact Number:");
        contact = sc.nextLine();
        System.out.print("Civil Status: ");
        status = sc.nextLine();
        
        //Process Dates 
        
        Calendar cal = Calendar.getInstance();
        registration_date = new java.sql.Date(cal.getTime().getTime());
        // expiration date is based on package duration 
        cal.add(Calendar.YEAR, 1); 
        expiration_date = new java.sql.Date(cal.getTime().getTime());
        
        
        if(role.equals("member")){
           //Package - I need the PackageDAO and PackageDAOIMPL here 
           //Display the packages here 
           /*
            Package ID: 1 
            Access: All Access 
           */
            System.out.print("Choose Package ID:  ");
            package_id = sc.nextInt();
            
            // Get the duration of the Package to change the expiration
           
        }
        
        return new User(
                username, 
                password, 
                role, 
                lastname, 
                firstname, 
                middlename, 
                gender, 
                address, 
                contact, 
                registration_date, 
                expiration_date,
                status,
                package_id, 
                0 // archived
        ); 
    }
    
    /* 
        -------------------------------------------------------------------------
                                        UPDATE
        -------------------------------------------------------------------------
    */
    
    public User updateUser(User user){
        Scanner sc = new Scanner(System.in);
        String lastname, firstname, middlename, gender, address, contact, status; 
             
        System.out.println("UPDATE USERS");
        System.out.print("Lastname [PRESS ENTER TO RETAIN (" + user.getLastname() + ") ]: ");
        lastname = sc.nextLine(); 
        System.out.print("Firstname [PRESS ENTER TO RETAIN (" + user.getFirstname() + ") ]: ");
        firstname = sc.nextLine();
        System.out.print("Middlename [PRESS ENTER TO RETAIN (" + user.getMiddlename() + ") ]: ");
        middlename = sc.nextLine();
        System.out.print("Gender [PRESS ENTER TO RETAIN (" + user.getGender() + ") ]: ");
        gender = sc.nextLine();
        System.out.print("Adress [PRESS ENTER TO RETAIN (" + user.getAddress() + ") ]: ");
        address = sc.nextLine();
        System.out.print("contact [PRESS ENTER TO RETAIN (" + user.getContact() + ") ]: ");
        contact = sc.nextLine();
        System.out.print("Status [PRESS ENTER TO RETAIN (" + user.getStatus() + ") ]: ");
        status = sc.nextLine(); 
        
        return new User(
                lastname, 
                firstname,
                middlename, 
                gender,
                address, 
                contact,
                status
        );
    }
    
    /* 
        -------------------------------------------------------------------------
                                        LOGIN
        -------------------------------------------------------------------------
    */
    
    public User loginUser(){
        Scanner sc = new Scanner(System.in);
        String username, password; 
        
        System.out.print("Username: ");
        username = sc.nextLine(); 
        
        System.out.print("Password: ");
        password = sc.nextLine(); 
        
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        
        return user;
    }
    
}
