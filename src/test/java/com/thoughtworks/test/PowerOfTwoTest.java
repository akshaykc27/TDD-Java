package com.thoughtworks.test;


import com.thoughtworks.tdd.poweroftwo.PowerOfTwo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PowerOfTwoTest {
    @Test
    void givenNumberZero_whenCompute_thenReturnOne() {
        PowerOfTwo power = new PowerOfTwo();
        Assertions.assertEquals(1, power.compute(0));
    }

    @Test
    void givenNumberOne_whenCompute_thenReturnTwo() {
        PowerOfTwo power = new PowerOfTwo();
        Assertions.assertEquals(2, power.compute(1));
    }

    @Test
    void givenNumberThree_whenCompare_thenReturnEight(){
        Assertions.assertEquals(8,new PowerOfTwo().compute(3));
    }

    @Test
    void givenNumberMinusOne_whenCompare_thenReturnDotFive(){
        Assertions.assertEquals(0.5,new PowerOfTwo().compute(-1));
    }
}
