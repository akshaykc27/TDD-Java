package com.thoughtworks.tdd.poweroftwo;

public class PowerOfTwo {

    private int result = 1;

    public double compute(int exponent) {
        if (exponent < 0) {
            int positivePower = computePositiveValue(Math.abs(exponent));
            System.out.println("positive number "+positivePower);
            return (double) 1 / positivePower;
        }
        return computePositiveValue(exponent);
    }

    private int computePositiveValue(int exponent) {
        for (int i = 0; i < exponent; i++) {
            result *= 2;
        }
        return result;
    }
}
