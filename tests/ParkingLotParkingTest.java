package com.jitendra;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParkingLotParkingTest {

	@Test
	public void test() {
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.createParkingLot(1);
		Vehicle vehicle = new Vehicle("KA-01-HH-1234", "White");
		assertEquals("Allocated slot number: 1", parkingLot.parkVehicle(vehicle));
		vehicle = new Vehicle("KA-01-HH-9999", "Black");
		assertEquals("Sorry, parking lot is full", parkingLot.parkVehicle(vehicle));
	}

}
