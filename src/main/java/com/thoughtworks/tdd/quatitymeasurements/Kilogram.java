package com.thoughtworks.tdd.quatitymeasurements;

public class Kilogram implements Weight {
    @Override
    public Quantity convertBase(Quantity quantity) {
        double conversionFactor=1000;
        return QuantityFactory.gram(quantity.value * conversionFactor);
    }
}
