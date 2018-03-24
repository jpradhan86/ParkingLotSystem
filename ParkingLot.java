package ParkingSystem;
import java.io.*;
import java.util.*;

public class ParkingLot {
    private ParkingSlot[] parkingSlots;
    private Queue<Integer> emptySlots;
    private int totalSlots;

    public void createParkingLot(int slots) {
        this.totalSlots = slots;
        this.parkingSlots = new ParkingSlot[slots];
        emptySlots = new PriorityQueue<Integer>(totalSlots);
        for(int i=1; i<=totalSlots; i++) {
            emptySlots.add(i);
        }
        System.out.println("Created a parking lot with " + this.totalSlots + " slots");
    }
    public boolean parkVehicle(Vehicle vehicle) {
        Integer slotNumber = emptySlots.poll();
        if (slotNumber == null) {
            System.out.println("Sorry, parking lot is full");
            return false;
        }
        ParkingSlot parkingSlot = new ParkingSlot(slotNumber, vehicle);
        parkingSlots[slotNumber-1] = parkingSlot;
        System.out.println("Allocated slot number: " + slotNumber);
        return true;
    }
    public void leave(int slotNumber) {
        if (slotNumber <= 0 && slotNumber > totalSlots) {
            System.out.println("Slot number " + slotNumber + " does not exist");
            return;
        }
        else if(this.parkingSlots[slotNumber-1] == null) {
            System.out.println("Slot number " + slotNumber + " is already empty");
            return;
        }
        this.parkingSlots[slotNumber-1] = null;
        System.out.println("Slot number " + slotNumber + " is free");
        emptySlots.add(slotNumber);
    }
    public void status() {
        System.out.println("Slot No.\tRegistration No\tColour");
        for(int i=0;i<totalSlots;i++) {
            if (parkingSlots[i] != null) 
                System.out.println(parkingSlots[i]);
        }
    }
    public void registrationNumbersForCarsWithColor(String color) {
        ArrayList<String> regNumbers = new ArrayList<String>();
        for(int i=0;i<totalSlots;i++) {
            ParkingSlot currentSlot = parkingSlots[i];
            if (currentSlot == null)
                continue;
            Vehicle vehicle = currentSlot.getVehicle();
            if (vehicle.getColor().equals(color))
                regNumbers.add(vehicle.getRegistrationNumber());
        }
        System.out.println(regNumbers);
    }
    public void slotNumbersForCarsWithColor(String color) {
        ArrayList<Integer> slotNumbers = new ArrayList<Integer>();
        for(int i=0;i<totalSlots;i++) {
            ParkingSlot currentSlot = parkingSlots[i];
            if (currentSlot == null)
                continue;
            Vehicle vehicle = currentSlot.getVehicle();
            if (vehicle.getColor().equals(color))
                slotNumbers.add(i+1);
        }
        System.out.println(slotNumbers);
    }
    public void slotNumberForRegistrationNumber(String registrationNumber) {
        boolean found = false;
        for(int i=0;i<totalSlots;i++) {
            ParkingSlot currentSlot = parkingSlots[i];
            if (currentSlot == null)
                continue;
            Vehicle vehicle = currentSlot.getVehicle();
            if (vehicle.getRegistrationNumber().equals(registrationNumber)) {
                System.out.println(i+1);
                found = true;
                break;
            }
        }
        if (!found) 
            System.out.println("Not found");
    }
}

class ParkingSlot {
    private Vehicle vehicle;
    private int slotNumber;
    public ParkingSlot(int slotNumber, Vehicle vehicle) {
        this.vehicle = vehicle;
        this.slotNumber = slotNumber;
    }
    public String toString() {
        return slotNumber + "\t" + vehicle;
    }
    public int getSlotNumber() {
        return slotNumber;
    }
    public Vehicle getVehicle() {
        return this.vehicle;
    }
}

class Vehicle {
    private String registrationNumber;
    private String color;
    public Vehicle(String registrationNumber, String color) {
        setRegistrationNumber(registrationNumber);
        setColor(color);
    }
    private void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    private void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public String toString() {
        return getRegistrationNumber() + "\t" + getColor(); 
    }
}
