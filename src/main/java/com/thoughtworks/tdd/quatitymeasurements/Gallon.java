package com.thoughtworks.tdd.quatitymeasurements;

public class Gallon implements Volume {

    @Override
    public Quantity convertBase(Quantity quantity) {
        double conversionFactor = 3.78;
        return QuantityFactory.litre(quantity.value * conversionFactor);
    }

}
