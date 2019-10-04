package com.thoughtworks.tdd.quatitymeasurements;

public class Yard implements Length {

    @Override
    public Quantity convertBase(Quantity quantity) {

        double conversionFactor = 36;
        return QuantityFactory.inch(quantity.value * conversionFactor);
    }
}
