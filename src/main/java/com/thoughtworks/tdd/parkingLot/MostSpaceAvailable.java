package com.thoughtworks.tdd.parkingLot;

import java.util.Comparator;

public class MostSpaceAvailable implements Comparator<ParkingLot> {
    @Override
    public int compare(ParkingLot parkingLot1, ParkingLot parkingLot2) {
        int spaceAvailableP1 = parkingLot1.capacity - parkingLot1.parkingList.size();
        int spaceAvailableP2 = parkingLot2.capacity-parkingLot2.parkingList.size();
        return spaceAvailableP1 - spaceAvailableP2;
    }
}
