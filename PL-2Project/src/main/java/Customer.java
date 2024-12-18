/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Seif Asharf
 */
// Customer.java
import java.util.Scanner;

public class Customer extends User {
    public Customer(String username, String password) {
        super(username, password);
    }

    @Override
    public void showMenu(ParkingSystem system, Scanner scanner) {
        System.out.println("\n--- Customer Menu ---");
        System.out.println("1. Print Entry Ticket");
        System.out.println("2. Pay for Parking");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> printEntryTicket(system, scanner);
            case 2 -> payForParking(system, scanner);
            default -> System.out.println("Invalid choice.");
        }
    }

    // Method to print a ticket
    private void printEntryTicket(ParkingSystem system, Scanner scanner) {
        System.out.print("Enter your plate number: ");
        String plateNumber = scanner.next();
        int ticketId = system.getNextTicketId();

        for (ParkingSpot spot : system.getParkingSpots()) {
            if (spot.isFree()) {
                spot.setFree(false);
                Ticket ticket = new Ticket(ticketId, plateNumber, spot.getId());
                system.getTickets().put(ticketId, ticket);
                System.out.println("Ticket Generated: " + ticket);
                return;
            }
        }
        System.out.println("No available spots.");
    }

    // Method to pay for parking
    private void payForParking(ParkingSystem system, Scanner scanner) {
        System.out.print("Enter your ticket ID: ");
        int ticketId = scanner.nextInt();
        Ticket ticket = system.getTickets().get(ticketId);

        if (ticket != null) {
            long parkedHours = ticket.calculateHours();
            double fee = parkedHours * 10; // Assume $10/hour
            System.out.println("Total hours: " + parkedHours + ", Total fee: $" + fee);

            for (ParkingSpot spot : system.getParkingSpots()) {
                if (spot.getId() == ticket.getSpotId()) {
                    spot.setFree(true);
                }
            }
            system.getTickets().remove(ticketId);
        } else {
            System.out.println("Invalid ticket ID.");
        }
    }
}

