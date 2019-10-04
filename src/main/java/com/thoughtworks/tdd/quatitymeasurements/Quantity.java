package com.thoughtworks.tdd.quatitymeasurements;

public class Quantity {

    protected double value;
    protected Unit unit;


    protected Quantity(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        //if(object == null)return false;
        //if (this == object) return true;
        if (!(object instanceof Quantity)) return false;
        Quantity quantity = (Quantity) object;
        return this.value == quantity.value && this.unit == quantity.unit
                || this.unit.convertBase(this).value == quantity.unit.convertBase(quantity).value;
    }

    public double add(Quantity quantity) {
        double result;
        Quantity quantity1 = this.unit.convertBase(this);
        Quantity quantity2 = quantity.unit.convertBase(quantity);
        if (quantity1.unit.equals(quantity2.unit)) {
            result= quantity1.value + quantity2.value;
            return (double) Math.round(result*100d)/100d;
        }
        throw new RuntimeException("Two different quantities can not be added");


    }
}

