package com.thoughtworks.tdd.parkingLot;

public class SameVehicleCannotBeParkedException extends Throwable {

    public SameVehicleCannotBeParkedException() {
    }

    public SameVehicleCannotBeParkedException(String message) {
        super(message);
    }
}
