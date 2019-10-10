package com.thoughtworks.tdd.parkingLot;

import java.util.Comparator;

public class HighestCapacityComparator implements Comparator<ParkingLot>{
    @Override
    public int compare(ParkingLot p1, ParkingLot p2) {
        return p1.capacity - p2.capacity;
    }
}
