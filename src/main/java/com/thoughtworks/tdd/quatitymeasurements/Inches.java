package com.thoughtworks.tdd.quatitymeasurements;

public class Inches implements Length {

    @Override
    public Quantity convertBase(Quantity quantity) {

        double conversionFactor = 1;
        return QuantityFactory.inch(quantity.value * conversionFactor);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Inches)) return false;
        return true;
    }
}
