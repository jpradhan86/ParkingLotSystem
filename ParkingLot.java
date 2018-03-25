package com.jitendra;

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
            System.out.println("Slot number " + slotNumber + " is empty");
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
    	boolean found = false;
        ArrayList<String> regNumbers = new ArrayList<String>();
        for(int i=0;i<totalSlots;i++) {
            ParkingSlot currentSlot = parkingSlots[i];
            if (currentSlot == null)
            	continue;
            Vehicle vehicle = currentSlot.getVehicle();
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                regNumbers.add(vehicle.getRegistrationNumber());
                found = true;
            }
        }
        if (!found)
        	System.out.println("No car of " +color+ " colour parked in the ParkingLot");
        else
        	System.out.println(String.join(",", regNumbers));
    }
    public void slotNumbersForCarsWithColor(String color) {
    	boolean found = false;
        ArrayList<String> slotNumbers = new ArrayList<String>();
        for(int i=0;i<totalSlots;i++) {
            ParkingSlot currentSlot = parkingSlots[i];
            if (currentSlot == null)
                continue;
            Vehicle vehicle = currentSlot.getVehicle();
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                slotNumbers.add(Integer.toString(i+1));
            	found = true;
            }
        }
        if (!found)
        	System.out.println("No car of " +color+ " colour parked in the ParkingLot");
        else
        	System.out.println(String.join(",", slotNumbers));
    }
    public void slotNumberForRegistrationNumber(String registrationNumber) {
        boolean found = false;
        for(int i=0;i<totalSlots;i++) {
            ParkingSlot currentSlot = parkingSlots[i];
            if (currentSlot == null)
                continue;
            Vehicle vehicle = currentSlot.getVehicle();
            if (vehicle.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                System.out.println(i+1);
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println("Not found");
    }
}

