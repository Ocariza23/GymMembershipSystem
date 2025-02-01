/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.gymmembership.system.impl;

import com.gymmembership.system.model.User;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author MJ
 */
public class UserDaoImplTest {
    
    public UserDaoImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of registerUser method, of class UserDaoImpl.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");

//        User user = new User();
//        user.setUsername("testuser");
//        user.setPassword("testpassword");
//        user.setRole("admin");
//        user.setLastname("Doe");
//        user.setFirstname("John");
//        user.setMiddlename("M");
//        user.setGender("Male");
//        user.setAddress("123 Main St");
//        user.setContact("1234567890");
//        user.setRegistrationDate(Date.valueOf("2025-02-01"));
//        user.setExpirationDate(Date.valueOf("2026-02-01"));
//        user.setStatus("Active");
//        user.setPackageId(1);
//        user.setArchived(0);
        c
        
        UserDaoImpl instance = new UserDaoImpl();
        boolean expResult = false;
        boolean result = instance.registerUser(user);
        System.out.println(result);
    }

    /**
     * Test of getUser method, of class UserDaoImpl.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        int id = 12;
        UserDaoImpl instance = new UserDaoImpl();
        User expResult = null;
        User result = instance.getUser(id);
        System.out.println(result.toString());
    }

    /**
     * Test of fetchMembers method, of class UserDaoImpl.
     */
    @Test
    public void testFetchMembers() {
        System.out.println("fetchMembers");
        UserDaoImpl instance = new UserDaoImpl();
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.fetchMembers();
        
        for(User user: result){
            System.out.println(user.toString());
        }

    }

    /**
     * Test of searchUsers method, of class UserDaoImpl.
     */
    @Test
    public void testSearchUsers() {
        System.out.println("searchUsers");
        String criteria = "";
        UserDaoImpl instance = new UserDaoImpl();
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.searchUsers(criteria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class UserDaoImpl.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        User newUser = new User(1, "john_doe", "password456", "member", "Doe", "John", "M", 
                       "Male", "123 Main St", "555-1234", Date.valueOf("2025-01-01"), 
                       Date.valueOf("2026-01-01"), "Single", 1, 0);
        User oldUser = new User();
        oldUser.setId(20);
        UserDaoImpl instance = new UserDaoImpl();
        boolean expResult = false;
        boolean result = instance.updateUser(newUser, oldUser); 
        System.out.println(result);
    }

    /**
     * Test of archiveOrRestoreUser method, of class UserDaoImpl.
     */
    @Test
    public void testArchiveOrRestoreUser() {
        System.out.println("archiveOrRestoreUser");
        User user = null;
        UserDaoImpl instance = new UserDaoImpl();
        instance.archiveOrRestoreUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class UserDaoImpl.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        User user = null;
        UserDaoImpl instance = new UserDaoImpl();
        instance.deleteUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class UserDaoImpl.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String username = "";
        String password = "";
        UserDaoImpl instance = new UserDaoImpl();
        String expResult = "";
        String result = instance.loginUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
