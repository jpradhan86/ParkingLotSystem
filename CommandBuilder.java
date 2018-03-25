package com.jitendra;

public class CommandBuilder {
    public static void run_cmd(ParkingLot parkingLot, String command) {
        String[] valueList = command.split(" ");
        String firstValue = valueList[0];
        if (firstValue.equals("create_parking_lot")) {
            parkingLot.createParkingLot(Integer.parseInt(valueList[1]));
        }   
        if (firstValue.equals("park")) {
            Vehicle vehicle = new Vehicle(valueList[1], valueList[2]);
            parkingLot.parkVehicle(vehicle);
        }   
        if (firstValue.equals("leave")) {
            parkingLot.leave(Integer.parseInt(valueList[1]));
        }   
        if (firstValue.equals("status")) {
            parkingLot.status();
        }   
        if (firstValue.equals("registration_numbers_for_cars_with_colour")) {
            parkingLot.registrationNumbersForCarsWithColor(valueList[1]);
        }   
        if (firstValue.equals("slot_numbers_for_cars_with_colour")) {
            parkingLot.slotNumbersForCarsWithColor(valueList[1]);
        }   
        if (firstValue.equals("slot_number_for_registration_number")) {
            parkingLot.slotNumberForRegistrationNumber(valueList[1]);
        }   
    }   
}

