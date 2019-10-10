package com.thoughtworks.tdd.parkingLot;

import java.util.List;

public class HighestCapacity implements Parking{

    @Override
    public void park(List<ParkingLot> parkingLots, Object obj) throws SameVehicleCannotBeParkedException, ParkingLotFullException {
        parkingLots.sort(new HighestCapacityComparator());
        parkingLots.get(parkingLots.size()-1).park(obj);
    }
}
