package com.thoughtworks.tdd.quatitymeasurements;

public class Centimeter implements Length {

    @Override
    public Quantity convertBase(Quantity quantity) {
        double conversionFactor = 2.54;
        return QuantityFactory.inch(quantity.value * conversionFactor);
    }

//    @Override
//    public boolean equals(Object obj) {
//
//        return super.equals(obj);
//    }
}
