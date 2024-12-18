/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Seif Asharf
 */
import java.util.*;

public class ParkingSystem {
    
    // used list not array so we can use list built-in methods
    private List<ParkingSpot> parkingSpots = new ArrayList<>();
    //used hashmap so we can access tickets in (key,value) pair
    private Map<Integer, Ticket> tickets = new HashMap<>();
    private List<User> users = new ArrayList<>();
    private int nextTicketId = 1;

    //initializing the capacity of the parking to 10 spots
    
    public ParkingSystem() {
        
        for (int i = 1; i <= 10; i++) {
            parkingSpots.add(new ParkingSpot(i, true));
        }

        // Default users so i can test the program
        users.add(new Admin("admin", "admin123"));
        users.add(new Operator("operator", "op123"));
        users.add(new Customer("customer", "cust123"));
    }

    //a method to retrieve all the parking spots
    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    //a method to retrieve the tickets
    public Map<Integer, Ticket> getTickets() {
        return tickets;
    }

    //a method to retrieve the users
    public List<User> getUsers() {
        return users;
    }

    
    public int getNextTicketId() {
        return nextTicketId++;
    }

    //a method to show the login menu to the user
    public void loginMenu(Scanner scanner) {
        while (true) {
            System.out.print("\nEnter username: ");
            String username = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();

            User user = authenticate(username, password);
            if (user != null) {
                System.out.println("Welcome, " + user.getUsername());
                user.showMenu(this, scanner);
            } else {
                System.out.println("Invalid credentials!");
            }
        }
    }

    //a method of return type "User" to check the user's credentials
    public User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                return user;
            }
        }
        return null;
    }
}

