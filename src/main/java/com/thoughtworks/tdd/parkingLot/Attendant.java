package com.thoughtworks.tdd.parkingLot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Attendant {

    private final Parking parking;
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public Attendant(List<ParkingLot> parkingLots,Parking parking) {
        this.parkingLots = parkingLots;
        this.parking = parking;
    }

    public void park(Object obj) throws SameVehicleCannotBeParkedException, ParkingLotFullException {
        parking.park(parkingLots,obj);
    }
}
