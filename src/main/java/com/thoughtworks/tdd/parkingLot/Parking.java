package com.thoughtworks.tdd.parkingLot;

import java.util.List;

public interface Parking {
    void park(List<ParkingLot> parkingLot, Object obj) throws SameVehicleCannotBeParkedException, ParkingLotFullException;
}
