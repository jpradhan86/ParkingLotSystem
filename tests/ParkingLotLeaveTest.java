package com.jitendra;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParkingLotLeaveTest {

	@Test
	public void test() {
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.createParkingLot(2);
		Vehicle vehicle = new Vehicle("KA-01-HH-1234", "White");
		parkingLot.parkVehicle(vehicle);
		vehicle = new Vehicle("KA-01-HH-9999", "Black");
		parkingLot.parkVehicle(vehicle);
		assertEquals("Slot number 1 is free", parkingLot.leave(1));
		assertEquals("Slot number 1 is empty", parkingLot.leave(1));
		assertEquals("Slot number 4 does not exist", parkingLot.leave(4));
		assertEquals("2", parkingLot.slotNumberForRegistrationNumber("KA-01-HH-9999"));
	}

}
