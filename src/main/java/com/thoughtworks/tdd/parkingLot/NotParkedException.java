package com.thoughtworks.tdd.parkingLot;

public class NotParkedException extends Throwable {
    public NotParkedException(String message) {
        super(message);
    }
}
