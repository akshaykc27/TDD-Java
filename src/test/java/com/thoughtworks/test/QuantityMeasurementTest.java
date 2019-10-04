package com.thoughtworks.test;

import com.sun.source.doctree.UnknownInlineTagTree;
import com.thoughtworks.tdd.quatitymeasurements.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementTest {

    // quantityFactory = new QuantityFactory();
    @Test
    void givenValueZero_whenCompare_thenReturnEqual() {
        Quantity zeroFeet = QuantityFactory.feet(0);
        Assertions.assertTrue(zeroFeet.equals(zeroFeet));
    }

    @Test
    void givenValueNull_whenCompare_thenReturnException() {
        Quantity zeroFeet = QuantityFactory.feet(0);
        Assertions.assertFalse(zeroFeet.equals(null));
    }

    @Test
    void givenValueOneFeet_whenCompare_thenReturnEqual() {
        Quantity zeroFeet = QuantityFactory.feet(0);
        Quantity oneFeet = QuantityFactory.feet(1);
        Assertions.assertFalse(zeroFeet.equals(oneFeet));
    }

    @Nested
    class FeetToInchTest {
        @Test
        void givenValueOneFeetAndOneInch_whenCompare_thenReturnNotEqual() {
            Quantity oneFeet = QuantityFactory.feet(1);
            Quantity oneInch = QuantityFactory.inch(1);
            Assertions.assertFalse(oneFeet.equals(oneInch));
        }

        @Test
        void givenValueOneFeetAndTweleveInch_whenCompare_thenReturnEqual() {
            Quantity oneFeet = QuantityFactory.feet(1);
            Quantity tweleveInch = QuantityFactory.inch(12);
            Assertions.assertTrue(oneFeet.equals(tweleveInch));
        }

        @Test
        void givenValueOneFeetAndTwentyFourInch_whenCompare_thenReturnEqual() {
            Quantity twoFeet = QuantityFactory.feet(2);
            Quantity twentyFourInch = QuantityFactory.inch(24);
            Assertions.assertTrue(twoFeet.equals(twentyFourInch));
        }
    }

    //
    @Nested
    class CentimeterToInchesTest {
        @Test
        void givenValueZeroCentimeterAndZeroInch_whenCompare_thenReturnNotEqual() {
            Quantity zeroCenti = QuantityFactory.centimeter(0);
            Quantity zeroInch = QuantityFactory.feet(0);
            Assertions.assertTrue(zeroCenti.equals(zeroInch));
        }

        @Test
        void givenValueZeroCentimeterAndZeroCenti_whenCompare_thenReturnEqual() {
            Quantity zeroCenti = QuantityFactory.centimeter(0);

            Assertions.assertTrue(zeroCenti.equals(zeroCenti));
        }

        @Test
        void givenValueOneCentimeterAndOneInch_whenCompare_thenReturnNotEqual() {
            Quantity oneCenti = QuantityFactory.centimeter(1);
            Quantity oneInch = QuantityFactory.inch(1);
            Assertions.assertFalse(oneCenti.equals(oneInch));
        }

//        @Test
//        void givenValueOneInchAndTwoDotFiveFour_whenCompare_thenReturnEqual() {
//            Quantity twoDotFiveFour = QuantityFactory.centimeter(2.54);
//            Quantity oneInch = QuantityFactory.inch(1);
//            Assertions.assertTrue(twoDotFiveFour.equals(oneInch));
//        }
    }

    @Nested
    class YardToInchesTest {

        @Test
        void givenValueZeroYardAndZeroInches_whenCompare_thenReturnEqual() {
            Quantity zeroYard = QuantityFactory.yard(0);
            Quantity zeroInch = QuantityFactory.inch(0);
            Assertions.assertTrue(zeroYard.equals(zeroInch));
        }

        @Test
        void givenValueOneYardAndOneInches_whenCompare_thenReturnNotEqual() {
            Quantity oneYard = QuantityFactory.yard(1);
            Quantity oneInch = QuantityFactory.inch(1);
            Assertions.assertFalse(oneYard.equals(oneInch));
        }

        @Test
        void givenValueOneYardAndThirtySixInches_whenCompare_thenReturnEqual() {
            Quantity oneYard = QuantityFactory.yard(1);
            Quantity thirtySixInches = QuantityFactory.inch(36);
            Assertions.assertTrue(oneYard.equals(thirtySixInches));
        }

        @Test
        void givenValueTwoYardAndSixtyFourInches_whenCompare_thenReturnEqual() {
            Quantity twoYard = QuantityFactory.yard(2);
            Quantity seventyTwoInches = QuantityFactory.inch(72);
            Assertions.assertTrue(twoYard.equals(seventyTwoInches));
        }
    }

    @Nested
    class GallonTest {

        @Test
        void givenValueZeroGallonAndZeroGallon_whenCompare_thenReturnEqual() {
            Quantity zeroGallon = QuantityFactory.gallon(0);
            //Quantity oneInch = new Quantity(1, Unit.gallon);
            Assertions.assertTrue(zeroGallon.equals(zeroGallon));
        }

        @Test
        void givenValueZeroGallonAndZeroLitre_whenCompare_thenReturnEqual() {
            Quantity zeroGallon = QuantityFactory.gallon(0);
            Quantity zeroLitre = QuantityFactory.litre(0);
            Assertions.assertTrue(zeroGallon.equals(zeroLitre));
        }

        @Test
        void givenValueOneGallonAndThreeDotSevenEightLitre_whenCompare_thenReturnEqual() {
            Quantity oneGallon = QuantityFactory.gallon(1);
            Quantity threeLitre = QuantityFactory.litre(3.78);
            Assertions.assertTrue(oneGallon.equals(threeLitre));
        }
    }

    @Test
    void givenOneFeetAndTwoInches_whenAdded_ShouldReturnFourteenInches() {
        Quantity oneFeet = QuantityFactory.feet(1);
        Quantity twoInches = QuantityFactory.inch(2);
        Assertions.assertEquals(14, oneFeet.add(twoInches));
    }

    @Test
    void givenOneGallonAndTwoInches_whenAdded_ShouldReturnSixDotSevenEightLitres() {
        Quantity oneGallon = QuantityFactory.gallon(1);
        Quantity threeLitres = QuantityFactory.litre(3);
        Assertions.assertEquals(6.78, oneGallon.add(threeLitres));
    }

    @Test
    void givenOneKiloAndThousandGram_whenCompared_ShouldReturnEqual() {
        Quantity oneKilo = QuantityFactory.kilogram(1);
        Quantity thousandGrams = QuantityFactory.gram(1000);
        Assertions.assertTrue(oneKilo.equals(thousandGrams));
    }

    @Test
    void givenOneKiloAndOneGram_whenCompared_ShouldReturnNotEqual() {
        Quantity oneKilo = QuantityFactory.kilogram(1);
        Quantity oneGrams = QuantityFactory.gram(1);
        Assertions.assertFalse(oneKilo.equals(oneGrams));
    }




}



