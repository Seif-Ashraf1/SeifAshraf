/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Seif Asharf
 */
// Operator.java

import java.util.Scanner;

public class Operator extends User {
    public Operator(String username, String password) {
        super(username, password);
    }

    @Override
   
public void showMenu(ParkingSystem system, Scanner scanner) {
    System.out.println("\n--- Operator Menu ---");
    System.out.println("1. View Free Spots");
    System.out.println("2. View Parking Hours");
    System.out.print("Enter your choice: ");
    int choice = scanner.nextInt();

    if (choice == 1) {
        viewFreeSpots(system);
    } else if (choice == 2) {
        System.out.print("Enter Ticket ID: ");
        int ticketId = scanner.nextInt();
        try {
            double hours = calculateParkingHours(ticketId,system);
            System.out.println("Total Parking Hours: " + hours);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    } else {
        System.out.println("Invalid choice.");
    }
}


    // Method to view free parking spots
    private void viewFreeSpots(ParkingSystem system) {
        System.out.println("Free Spots:");
        for (ParkingSpot spot : system.getParkingSpots()) {
            if (spot.isFree()) {
                System.out.println("Spot ID: " + spot.getId());
            }
        }
    }

    // Method to calculate parking hours based on ticket ID
double calculateParkingHours(int ticketId, ParkingSystem system) {
    // Retrieve the ticket using the ParkingSystem instance
    Ticket ticket = system.getTickets().get(ticketId);

    if (ticket == null) {
        throw new IllegalArgumentException("Ticket ID not found.");
    }

    // Calculate the hours using entryTime and the current time
    long hours = java.time.Duration.between(ticket.getEntryTime(), java.time.LocalDateTime.now()).toHours();
    return hours > 0 ? hours : 0; // Ensure non-negative value
}

}

