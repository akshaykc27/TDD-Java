package com.thoughtworks.tdd.parkingLot;

public interface SubjectParkingLot {

    void attach(Observer o);

    void detach(Observer o);

    void notifyUpdate();

}
