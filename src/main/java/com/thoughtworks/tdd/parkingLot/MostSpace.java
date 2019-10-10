package com.thoughtworks.tdd.parkingLot;

import java.util.List;

public class MostSpace implements Parking {

    @Override
    public void park(List<ParkingLot> parkingLot, Object obj) throws SameVehicleCannotBeParkedException, ParkingLotFullException {
        parkingLot.sort(new MostSpaceAvailable());
        parkingLot.get(parkingLot.size()-1).park(obj);
    }
}
