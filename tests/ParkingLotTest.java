package com.jitendra;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParkingLotTest {

	@Test
	public void test() {
		ParkingLot parkingLot = new ParkingLot();
		assertEquals("Created a parking lot with 10 slots", parkingLot.createParkingLot(10));
	}
}
