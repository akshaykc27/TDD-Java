package com.thoughtworks.tdd.quatitymeasurements;

public class Farenheit implements Temperature{

    @Override
    public NonAddableQuantity covertBase(double value) {
        return QuantityFactory.farenheit(value*1.0);}
}
