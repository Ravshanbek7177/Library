package org.example;

import org.example.Controller.AuthController;
import org.example.db.Database;

public class Main {
    public static void main(String[] args) {

        AuthController authController = new AuthController();
        authController.start();


    }
}