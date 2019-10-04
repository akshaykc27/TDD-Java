package com.thoughtworks.test;

import com.thoughtworks.tdd.parkingLot.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void givenParkingLot_whenCheck_shouldReturnAvailable() throws SameVehicleCannotBeParkedException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1, new Owner());
        assertTrue((parkingLot.park(new Object())));
    }

    @Test
    void givenParkingLotAssigningTwoSlots_whenCheck_shouldReturnNotAvailable() throws SameVehicleCannotBeParkedException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1, new Owner());
        parkingLot.park(new Object());
        Throwable exception = assertThrows(ParkingLotFullException.class, () -> parkingLot.park(new Object()));
        assertEquals("Parking Full!", exception.getMessage());
    }

    @Test
    void givenParkingLotAssigningTwoSlots_whenChecked_shouldReturnAnException() throws SameVehicleCannotBeParkedException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1, new Owner());
        parkingLot.park(new Object());
        Throwable exception = assertThrows(ParkingLotFullException.class, () -> parkingLot.park(new Object()));
        assertEquals("Parking Full!", exception.getMessage());
    }

    @Test
    void givenCar_whenUnpark_shouldReturnTheCarParked() throws SameVehicleCannotBeParkedException, ParkingLotFullException, NotParkedException {
        ParkingLot parkingLot = new ParkingLot(2, new Owner());
        Object carA = new Object();
        Object carB = new Object();
        assertTrue(parkingLot.park(carA));
        Throwable exception = assertThrows(NotParkedException.class, () -> parkingLot.unPark(carB));
        assertEquals(carA, parkingLot.unPark(carA));
    }

    @Test
    void givenCar_whenUnpark_shouldReturnNotParked() throws SameVehicleCannotBeParkedException, ParkingLotFullException, NotParkedException {
        ParkingLot parkingLot = new ParkingLot(2, new Owner());
        Object carA = new Object();
        Object carB = new Object();
        assertTrue(parkingLot.park(carA));
        Throwable exception = assertThrows(NotParkedException.class, () -> parkingLot.unPark(carB));
        assertEquals("Vehicle not parked", exception.getMessage());
    }

    @Test
    void givenParkingLotIfFull_whencheck_shouldInformOwner() throws SameVehicleCannotBeParkedException, ParkingLotFullException {
        Owner owner = new Owner();
        ParkingLot parkingLot = new ParkingLot(2, owner);;
        assertTrue(parkingLot.park(new Object()));
        assertTrue(parkingLot.park(new Object()));
        assertTrue(owner.getNotification());

    }

}
