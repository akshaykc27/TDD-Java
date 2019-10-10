package com.thoughtworks.tdd.parkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot implements SubjectParkingLot{

    private boolean isFull;
    protected int capacity;
    private List<Observer> observers = new ArrayList<>();

    public ParkingLot(int capacity, Owner owner, SecurityGuard securityGuard) {
        this.capacity = capacity;
        isFull = false;
        attach(owner);
        attach(securityGuard);
    }

    protected List parkingList = new ArrayList();

    public boolean park(Object obj) throws ParkingLotFullException, SameVehicleCannotBeParkedException {
        if (parkingLotNotFull()) {
            if (!sameVehicleParked(obj)) {
                this.parkingList.add(obj);
                if (!parkingLotNotFull()) {
                    isFull = true;
                    notifyUpdate();
                }
                return true;
            }
            throw new SameVehicleCannotBeParkedException("Same vehicle can not be parked again");
        }
        throw new ParkingLotFullException("Parking Full!");
    }

    public Object unPark(Object obj) throws NotParkedException {
        if (!sameVehicleParked(obj))
            throw new NotParkedException("Vehicle not parked");
        this.parkingList.remove(obj);
        if (parkingLotNotFull()) {
            isFull = false;
            notifyUpdate();
        }
        return obj;

    }

    private boolean parkingLotNotFull() {
        return this.parkingList.size() < capacity;
    }

    private boolean sameVehicleParked(Object obj) {
        return this.parkingList.contains(obj);
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyUpdate() {
        for (Observer o : observers) {
            o.update(isFull);
        }
    }

}
