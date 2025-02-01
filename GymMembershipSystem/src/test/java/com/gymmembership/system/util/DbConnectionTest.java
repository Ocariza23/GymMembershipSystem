/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.gymmembership.system.util;

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
public class DbConnectionTest {
    
    public DbConnectionTest() {
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
     * Test of connect method, of class DbConnection.
     */
    @Test
    public void testConnect() throws Exception {
        System.out.println("connect");
        DbConnection instance = new DbConnectionImpl();
        instance.connect();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dbConnect method, of class DbConnection.
     */
    @Test
    public void testDbConnect() {
        System.out.println("dbConnect");
        DbConnection instance = new DbConnectionImpl();
        instance.dbConnect();
    }

    public class DbConnectionImpl extends DbConnection {
    }
    
}
