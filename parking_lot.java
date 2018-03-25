package com.jitendra;

public class parking_lot {
	public static void main(String[] args) {
    	ParkingSystem ps = new ParkingSystem();
        if (args.length > 0) {
        	ps.processThroughFile(args[0]);
        }   
        else {
            ps.processThroughUserInput();
        }   
    } 
}
