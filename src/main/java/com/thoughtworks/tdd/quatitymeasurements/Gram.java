package com.thoughtworks.tdd.quatitymeasurements;

public class Gram implements Weight {
    @Override
    public Quantity convertBase(Quantity quantity) {
        double conversionFactor=1;
        return QuantityFactory.gram(quantity.value* conversionFactor);
    }
}
