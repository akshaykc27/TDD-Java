package com.thoughtworks.tdd.parkingLot;

public class ParkingLotFullException extends Exception {

    public ParkingLotFullException() {
    }

    public ParkingLotFullException(String message) {
        super(message);
    }
}
