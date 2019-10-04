package com.thoughtworks.tdd.parkingLot;

public class Consumer {

   private ParkingLot parkingLot1;
   private ParkingLot parkingLot2;

    public Consumer(ParkingLot parkingLot1, ParkingLot parkingLot2) {
        this.parkingLot1 = parkingLot1;
        this.parkingLot2 = parkingLot2;
    }

    public void park(Object obj){
        try {
            parkingLot1.park(obj);
            System.out.println("Vehicle parked in parking lot 1");
        } catch (ParkingLotFullException e) {
            System.out.println("Parking full in parking lot 1");
            try {
                parkingLot2.park(obj);
                System.out.println("Vehicle parked in parking lot 2");
            } catch (ParkingLotFullException ex) {
                System.out.println("Parking full in parking lot 2");
            } catch (SameVehicleCannotBeParkedException ex) {
                System.out.println("Vehicle already parked in parking lot 2");
            }
        } catch (SameVehicleCannotBeParkedException e) {
            System.out.println("Vehicle already parked 1");
        }
    }

    public static void main(String[] args) {
        Consumer consumer = new Consumer(new ParkingLot(2,new Owner()),new ParkingLot(3,new Owner()));
        Object carA = new Object();
        Object carB = new Object();
        Object carC = new Object();
        consumer.park(carA);
        consumer.park(carB);
        consumer.park(carC);

    }
}
