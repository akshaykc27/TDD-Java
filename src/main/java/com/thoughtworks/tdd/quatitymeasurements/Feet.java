package com.thoughtworks.tdd.quatitymeasurements;

public class Feet implements Length {
    @Override
    public Quantity convertBase(Quantity quantity) {

        double conversionFactor = 12;
        return QuantityFactory.inch(quantity.value * conversionFactor);
    }
}
