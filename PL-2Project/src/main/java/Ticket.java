/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Seif Asharf
 */
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Ticket {
    private int id;
    private String plateNumber;
    private int spotId;
    private LocalDateTime entryTime;

    public Ticket(int id, String plateNumber, int spotId) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.spotId = spotId;
        this.entryTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public int getSpotId() {
        return spotId;
    }
    
    
    public long calculateHours() {
        return ChronoUnit.HOURS.between(entryTime, LocalDateTime.now()) + 1;
    }

    public double calculateFee(double hourlyRate) {
        return calculateHours() * hourlyRate;
    }
    
    public LocalDateTime getEntryTime() {
           return entryTime;
       }

    @Override
    public String toString() {
        return "Ticket ID: " + id + ", Plate: " + plateNumber + ", Spot: " + spotId + ", Entry: " + entryTime +", Entry Time: " + entryTime ;
    }
}
