package com.thoughtworks.test;

import com.thoughtworks.tdd.parkingLot.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.basic.BasicTreeUI;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MockOwner extends Owner {
    protected boolean isInformedParkingFull = false;
    protected boolean isInformedParkingEmpty = false;
    protected int numberOfTimesInformParkingFullisCalled;
    protected int numberOfTimesInformParkingEmptyIsCalled;

    @Override
    public void update(boolean message) {
        if (message) {
            isInformedParkingFull = true;
            numberOfTimesInformParkingFullisCalled++;
        } else {
            isInformedParkingEmpty = true;
            numberOfTimesInformParkingEmptyIsCalled++;
        }
    }
}

class MockSecurity extends SecurityGuard {
    protected boolean isInformedParkingFull = false;
    protected boolean isInformedParkingEmpty = false;
    protected int numberOfTimesInformParkingFullisCalled;
    protected int numberOfTimesInformParkingEmptyIsCalled;

    @Override
    public void update(boolean message) {
        if (message) {
            isInformedParkingFull = true;
            numberOfTimesInformParkingFullisCalled++;
        } else {
            isInformedParkingEmpty = true;
            numberOfTimesInformParkingEmptyIsCalled++;
        }
    }
}


public class ParkingLotTest {
    MockSecurity mockSecurity = new MockSecurity();

    @Test
    void givenParkingLot_whenCheck_shouldReturnAvailable() throws SameVehicleCannotBeParkedException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1, new Owner(), mockSecurity);
        assertTrue((parkingLot.park(new Object())));
    }

    @Test
    void givenParkingLotAssigningTwoSlots_whenCheck_shouldReturnNotAvailable() throws SameVehicleCannotBeParkedException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1, new Owner(), mockSecurity);
        parkingLot.park(new Object());
        Throwable exception = assertThrows(ParkingLotFullException.class, () -> parkingLot.park(new Object()));
        assertEquals("Parking Full!", exception.getMessage());
    }

    @Test
    void givenParkingLotAssigningTwoSlots_whenChecked_shouldReturnAnException() throws SameVehicleCannotBeParkedException, ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1, new Owner(), mockSecurity);
        parkingLot.park(new Object());
        Throwable exception = assertThrows(ParkingLotFullException.class, () -> parkingLot.park(new Object()));
        assertEquals("Parking Full!", exception.getMessage());
    }

    @Test
    void givenCar_whenUnpark_shouldReturnTheCarParked() throws SameVehicleCannotBeParkedException, ParkingLotFullException, NotParkedException {
        ParkingLot parkingLot = new ParkingLot(2, new Owner(), mockSecurity);
        Object carA = new Object();
        Object carB = new Object();
        assertTrue(parkingLot.park(carA));
        Throwable exception = assertThrows(NotParkedException.class, () -> parkingLot.unPark(carB));
        assertEquals(carA, parkingLot.unPark(carA));
    }

    @Test
    void givenCar_whenUnpark_shouldReturnNotParked() throws SameVehicleCannotBeParkedException, ParkingLotFullException, NotParkedException {
        ParkingLot parkingLot = new ParkingLot(2, new Owner(), mockSecurity);
        Object carA = new Object();
        Object carB = new Object();
        assertTrue(parkingLot.park(carA));
        Throwable exception = assertThrows(NotParkedException.class, () -> parkingLot.unPark(carB));
        assertEquals("Vehicle not parked", exception.getMessage());
    }

    @Test
    void givenParkingLotIfFull_whencheck_shouldInformOwner() throws SameVehicleCannotBeParkedException, ParkingLotFullException {
        MockOwner owner = new MockOwner();
        ParkingLot parkingLot = new ParkingLot(2, owner, mockSecurity);
        ;
        assertTrue(parkingLot.park(new Object()));
        assertTrue(parkingLot.park(new Object()));
        assertTrue(owner.isInformedParkingFull);
    }

    @Test
    void givenParkingLotIfFull_whenchecked_shouldReturnTheNumberOfTimesTheOwnerWasInformed() throws SameVehicleCannotBeParkedException, ParkingLotFullException {
        MockOwner owner = new MockOwner();
        ParkingLot parkingLot = new ParkingLot(2, owner, mockSecurity);
        ;
        assertTrue(parkingLot.park(new Object()));
        assertTrue(parkingLot.park(new Object()));
        assertTrue(owner.isInformedParkingFull);
        assertEquals(1, owner.numberOfTimesInformParkingFullisCalled);
    }

    @Test
    void givenParkingLotIfFull_whenchecked_shouldnotReturnTheNumberOfTimesTheOwnerWasInformed() throws SameVehicleCannotBeParkedException, ParkingLotFullException {
        MockOwner owner = new MockOwner();
        ParkingLot parkingLot = new ParkingLot(2, owner, mockSecurity);
        assertTrue(parkingLot.park(new Object()));
        assertTrue(parkingLot.park(new Object()));
        assertEquals(1, owner.numberOfTimesInformParkingFullisCalled);
    }

    @Test
    void givenParkingLotIsAvailablewhenUnpark_whenChecked_shouldReturnAvailalble() throws SameVehicleCannotBeParkedException, ParkingLotFullException, NotParkedException {
        MockOwner owner = new MockOwner();
        ParkingLot parkingLot = new ParkingLot(1, owner, mockSecurity);
        Object carA = new Object();
        parkingLot.park(carA);
//        Throwable exception = assertThrows(ParkingLotFullException.class ,()-> parkingLot.park(new Object()));
//        assertEquals("Parking Full!", exception.getMessage());
//        assertTrue(owner.isInformed);
        parkingLot.unPark(carA);
        assertTrue(owner.isInformedParkingEmpty);
        assertEquals(1, owner.numberOfTimesInformParkingEmptyIsCalled);


    }

    @Test
    void givenParkingLotIsFull_whenCheck_shouldInformSecurity() throws SameVehicleCannotBeParkedException, ParkingLotFullException {
        MockOwner owner = new MockOwner();
        MockSecurity security = new MockSecurity();
        ParkingLot parkingLot = new ParkingLot(1, owner, security);
        Object carA = new Object();
        parkingLot.park(carA);
        assertTrue(security.isInformedParkingFull);
    }

    @Test
    void givenParkingLotIsFull_whenCheck_shouldInformSecurityAndOwner() throws SameVehicleCannotBeParkedException, ParkingLotFullException {
        MockOwner owner = new MockOwner();
        MockSecurity security = new MockSecurity();
        ParkingLot parkingLot = new ParkingLot(1, owner, security);
        Object carA = new Object();
        parkingLot.park(carA);
        assertEquals(1, security.numberOfTimesInformParkingFullisCalled);
    }

    @Test
    void givenParkingLotsToAttendant_whenCheck_shouldParkInBiggerCapacity() throws SameVehicleCannotBeParkedException, ParkingLotFullException {
        MockOwner owner = new MockOwner();
        MockSecurity security = new MockSecurity();
        ParkingLot parkingLot1 = new ParkingLot(2, owner, security);
        ParkingLot parkingLot2 = new ParkingLot(1, owner, security);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Parking parking=new HighestCapacity();
        Attendant attendant = new Attendant(parkingLots,parking);
        Object carA = new Object();
        attendant.park(carA);
        Throwable exception = assertThrows(SameVehicleCannotBeParkedException.class ,()-> parkingLot1.park(carA));
        assertEquals("Same vehicle can not be parked again", exception.getMessage());
    }

    @Test
    void givenParkingLotsToAttendant_whenCheck_shouldParkInMostSpaceAvailable() throws SameVehicleCannotBeParkedException, ParkingLotFullException {
        MockOwner owner = new MockOwner();
        MockSecurity security = new MockSecurity();
        ParkingLot parkingLot1 = new ParkingLot(2, owner, security);
        ParkingLot parkingLot2 = new ParkingLot(1, owner, security);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Parking parking=new MostSpace();
        Attendant attendant = new Attendant(parkingLots,parking);
        Object carA = new Object();
        attendant.park(carA);
        Throwable exception = assertThrows(SameVehicleCannotBeParkedException.class ,()-> parkingLot1.park(carA));
        assertEquals("Same vehicle can not be parked again", exception.getMessage());
    }


}
