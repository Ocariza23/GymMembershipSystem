package com.app.main;

import com.app.controller.UserController;
import com.app.dao.UserDAO;
import com.app.dao.impl.UserDAOIMPL;
import com.app.view.UserView;

public class Main {
    public static void main(String[] args) {
        
        //Dashboard views 
        
        UserDAO userDAO = new UserDAOIMPL();
        UserView userView = new UserView();
        UserController userController = new UserController( userDAO, userView );
        
        userController.displayUsers();
        userController.loginUser();
        
    }
}
