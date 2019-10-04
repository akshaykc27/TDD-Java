package com.thoughtworks.tdd.quatitymeasurements;

public class Litre implements Volume {

    @Override
    public Quantity convertBase(Quantity quantity) {
        double conversionFactor = 1;
        return QuantityFactory.litre(quantity.value * conversionFactor);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Litre)) return false;
        return true;
    }
}
