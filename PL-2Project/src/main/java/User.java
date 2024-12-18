/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Scanner;

/**
 *
 * @author Seif Asharf
 */
// User.java
public abstract class User {
    private String username;
    private String password;

    // Constructor to initialize the attributes
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    // Method to check the password of the user
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    // Abstract method to show the starting menu for each user
    public abstract void showMenu(ParkingSystem system, Scanner scanner);
}
