package com.thoughtworks.tdd.parkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private int capacity;
    private Owner owner;

    public ParkingLot(int capacity,Owner owner) {
        this.capacity = capacity;
        this.owner = owner;
    }

    private List parkingList = new ArrayList();

    public boolean park(Object obj) throws ParkingLotFullException, SameVehicleCannotBeParkedException {
        if (parkingLotNotFull()) {
            if (!sameVehicleParked(obj)) {
                 this.parkingList.add(obj);
                 if(!parkingLotNotFull())
                 {
                     owner.Inform("ParkingFull");
                 }
                 return true;
            }
            throw new SameVehicleCannotBeParkedException("Same vehicle can not be parked again");
        }
        throw new ParkingLotFullException("Parking Full!");
    }

    public Object unPark(Object obj) throws NotParkedException {
        if(!sameVehicleParked(obj))
            throw new NotParkedException("Vehicle not parked");
         this.parkingList.remove(obj);
         return obj;

    }

    private boolean parkingLotNotFull() {
        return this.parkingList.size() < capacity;
    }

    private boolean sameVehicleParked(Object obj) {
        return this.parkingList.contains(obj);
    }
}
