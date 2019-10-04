package com.thoughtworks.tdd.parkingLot;

public class Owner {
    private String message;
    public boolean getNotification () {
        if(message.equals("ParkingFull"));
            return true;
    }

    public void Inform(String parkingFull) {
        this.message = parkingFull;
    }
}
