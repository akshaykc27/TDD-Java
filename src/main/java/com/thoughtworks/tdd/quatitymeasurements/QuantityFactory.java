package com.thoughtworks.tdd.quatitymeasurements;

public class QuantityFactory {
    public static Quantity inch(double value) {
        return new Quantity(value, new Inches());
    }

    public static Quantity feet(double value) {
        return new Quantity(value, new Feet());
    }

    public static Quantity centimeter(double value) {
        return new Quantity(value, new Centimeter());
    }

    public static Quantity yard(double value) {
        return new Quantity(value, new Yard());
    }

    public static Quantity gallon(double value) {
        return new Quantity(value, new Gallon());
    }

    public static Quantity litre(double value) {
        return new Quantity(value, new Litre());
    }

    public static Quantity gram(double value) {
        return new Quantity(value, new Gram());
    }

    public static Quantity kilogram(double value) {
        return new Quantity(value, new Kilogram());
    }

    public static NonAddableQuantity farenheit(double value) { return  new NonAddableQuantity(value,new Farenheit());}


}
