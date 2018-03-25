package com.gojek.assignment;

public class ParkingSlot {
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
