package com.jitendra;

import java.util.*;

public class ParkingLot {
    private ParkingSlot[] parkingSlots;
    private Queue<Integer> emptySlots;
    private int totalSlots;

    public String createParkingLot(int slots) {
        this.totalSlots = slots;
        this.parkingSlots = new ParkingSlot[slots];
        emptySlots = new PriorityQueue<Integer>(totalSlots);
        for(int i=1; i<=totalSlots; i++) {
            emptySlots.add(i);
        }   
        String output = "Created a parking lot with " + this.totalSlots + " slots";
        return output;
    }   
    public String parkVehicle(Vehicle vehicle) {
        Integer slotNumber = emptySlots.poll();
        if (slotNumber == null) {
            return "Sorry, parking lot is full";
        }   
        ParkingSlot parkingSlot = new ParkingSlot(slotNumber, vehicle);
        parkingSlots[slotNumber-1] = parkingSlot;
        return("Allocated slot number: " + slotNumber);
    }   
    public String leave(int slotNumber) {
        if (slotNumber <= 0 || slotNumber > totalSlots) {
            return("Slot number " + slotNumber + " does not exist");
        }   
        else if(this.parkingSlots[slotNumber-1] == null) {
            return("Slot number " + slotNumber + " is empty");
        }   
        this.parkingSlots[slotNumber-1] = null;
        emptySlots.add(slotNumber);
        return("Slot number " + slotNumber + " is free");
    }   
    public String status() {
        String output = "Slot No.\tRegistration No\tColour\n";
        for(int i=0;i<totalSlots;i++) {
            if (parkingSlots[i] != null)
                output += parkingSlots[i] + "\n";
        }
        return output;
    }   
    public String registrationNumbersForCarsWithColor(String color) {
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
        	return("No car of " +color+ " colour parked in the ParkingLot");
        else
        	return(String.join(",", regNumbers));
    }
    public String slotNumbersForCarsWithColor(String color) {
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
        	return("No car of " +color+ " colour parked in the ParkingLot");
        else
        	return(String.join(",", slotNumbers));
    }
    public String slotNumberForRegistrationNumber(String registrationNumber) {
        boolean found = false;
        int slotFound = 0;
        for(int i=0;i<totalSlots;i++) {
            ParkingSlot currentSlot = parkingSlots[i];
            if (currentSlot == null)
                continue;
            Vehicle vehicle = currentSlot.getVehicle();
            if (vehicle.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                slotFound = i+1;
                found = true;
                break;
            }
        }
        if (!found)
            return("Not found");
        else
        	return(Integer.toString(slotFound));
    }
}

