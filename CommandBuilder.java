package com.jitendra;

public class CommandBuilder {
    public static String run_cmd(ParkingLot parkingLot, String command) {
        String[] valueList = command.split(" ");
        String firstValue = valueList[0];
        if (firstValue.equals("create_parking_lot")) {
            return(parkingLot.createParkingLot(Integer.parseInt(valueList[1])));
        }   
        if (firstValue.equals("park")) {
            Vehicle vehicle = new Vehicle(valueList[1], valueList[2]);
            return(parkingLot.parkVehicle(vehicle));
        }   
        if (firstValue.equals("leave")) {
        	return(parkingLot.leave(Integer.parseInt(valueList[1])));
        }   
        if (firstValue.equals("status")) {
        	return(parkingLot.status());
        }   
        if (firstValue.equals("registration_numbers_for_cars_with_colour")) {
        	return(parkingLot.registrationNumbersForCarsWithColor(valueList[1]));
        }   
        if (firstValue.equals("slot_numbers_for_cars_with_colour")) {
        	return(parkingLot.slotNumbersForCarsWithColor(valueList[1]));
        }   
        if (firstValue.equals("slot_number_for_registration_number")) {
        	return(parkingLot.slotNumberForRegistrationNumber(valueList[1]));
        }
        return "Invalid command";
    }   
}

