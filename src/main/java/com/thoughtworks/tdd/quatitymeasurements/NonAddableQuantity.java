package com.thoughtworks.tdd.quatitymeasurements;

import java.util.Objects;

public class NonAddableQuantity  {

    public double value;
    Temperature temperature;

    public NonAddableQuantity(double value, Temperature temperature) {
        this.value = value;
        this.temperature = temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NonAddableQuantity)) return false;
        NonAddableQuantity that = (NonAddableQuantity) o;
        return true;
    }

}
