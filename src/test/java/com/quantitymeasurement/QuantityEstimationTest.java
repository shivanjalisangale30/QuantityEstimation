package com.quantitymeasurement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuantityEstimationTest {

    QuantityEstimation quantityEstimation;

    @Before
    public void getInstance_OfQuantityMeasurement() {
        quantityEstimation = new QuantityEstimation();
    }

    @Test
    public void given1LiterAnd1Liter_WhenCompared_ShouldReturnEqualVolume() {
        QuantityEstimation liter1 = new QuantityEstimation(BaseConversion.LITER, 1.0);
        QuantityEstimation liter2 = new QuantityEstimation(BaseConversion.LITER, 1.0);
        Boolean compare = null;
        try {
            compare = liter1.compare(liter2);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compare);
    }

    @Test
    public void givenLiterAndMilliLiter_WhenCompared_ShouldReturnEqualVolume() {
        QuantityEstimation mililitter = new QuantityEstimation(BaseConversion.MILLILITER, 1000.0);
        QuantityEstimation liter = new QuantityEstimation(BaseConversion.LITER, 1.0);
        Boolean compare = null;
        try {
            compare = liter.compare(mililitter);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compare);
    }

    @Test
    public void givenLiterAndMilliliter_WhenCompared_ShouldReturnEqualVolume() {
        QuantityEstimation liter = new QuantityEstimation(BaseConversion.LITER, 3.78);
        QuantityEstimation mililitter = new QuantityEstimation(BaseConversion.MILLILITER, 3780.0);
        Boolean compare = null;
        try {
            compare = liter.compare(mililitter);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compare);
    }

    @Test
    public void givenMilliliterAndGallon_WhenCompared_ShouldReturnEqualVolume() {
        QuantityEstimation milliliter = new QuantityEstimation(BaseConversion.MILLILITER, 3785.41);
        QuantityEstimation gallon = new QuantityEstimation(BaseConversion.GALLON, 1.0);
        Boolean compare = null;
        try {
            compare = milliliter.compare(gallon);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compare);
    }


    @Test
    public void givenGallonAndMilliliter_WhenCompared_ShouldReturnEqualVolume() {
        QuantityEstimation milliliter = new QuantityEstimation(BaseConversion.MILLILITER, 1.0);
        QuantityEstimation gallon = new QuantityEstimation(BaseConversion.GALLON, 1.0 / 3785.41);
        Boolean compare = null;
        try {
            compare = milliliter.compare(gallon);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compare);
    }


    @Test
    public void givenKilogramsAndKilograms_WhenPerformAddition_ShouldReturnCorrectResultGram() {
        QuantityEstimation kilogram = new QuantityEstimation(BaseConversion.KILOGRAM, 1.0);
        QuantityEstimation tonne = new QuantityEstimation(BaseConversion.KILOGRAM, 1.0);
        double result = 0;
        try {
            result = quantityEstimation.additionOfEntity(kilogram, tonne);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2000.0, result, 0.0);
    }

    @Test
    public void givenKilogramsAndGrams_WhenPerformAddition_ShouldReturnCorrectResultGram() {
        QuantityEstimation kilogram = new QuantityEstimation(BaseConversion.KILOGRAM, 1.0);
        QuantityEstimation grams = new QuantityEstimation(BaseConversion.GRAM, 1.0);
        double result = 0;
        try {
            result = quantityEstimation.additionOfEntity(kilogram, grams);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(1001.0, result, 0.0);
    }

    @Test
    public void givenGramAndTonne_WhenPerformAddition_ShouldReturnCorrectResultGram() {
        QuantityEstimation tonne = new QuantityEstimation(BaseConversion.TONNE, 1.0);
        QuantityEstimation grams = new QuantityEstimation(BaseConversion.GRAM, 1000.0);
        double result = 0;
        try {
            result = quantityEstimation.additionOfEntity(tonne, grams);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(1001000.0, result, 0.0);
    }

    @Test
    public void givenGramsAndKillograms_WhenCompared_ShouldReturnEqualWeight() {
        QuantityEstimation grams = new QuantityEstimation(BaseConversion.GRAM, 1.0);
        QuantityEstimation killograms = new QuantityEstimation(BaseConversion.KILOGRAM, 1.0 / 1000.0);
        Boolean compare = null;
        try {
            compare = grams.compare(killograms);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compare);
    }

    @Test
    public void givenKillogramsAndGrams_WhenCompared_ShouldReturnEqualWeight() {
        QuantityEstimation killograms = new QuantityEstimation(BaseConversion.KILOGRAM, 1.0);
        QuantityEstimation grams = new QuantityEstimation(BaseConversion.GRAM, 1000.0);
        Boolean compareCheck = null;
        try {
            compareCheck = killograms.compare(grams);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void givenTonnesAndKilograms_WhenCompared_ShouldReturnEqualWeight() {
        QuantityEstimation kilogram = new QuantityEstimation(BaseConversion.KILOGRAM, 1.0);
        QuantityEstimation tonne = new QuantityEstimation(BaseConversion.TONNE, 0.001);
        Boolean compare = null;
        try {
            compare = kilogram.compare(tonne);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compare);
    }

    @Test
    public void givenKillogramsAndTonnes_WhenCompared_ShouldReturnEqualWeight() {
        QuantityEstimation kilogram = new QuantityEstimation(BaseConversion.KILOGRAM, 1.0);
        QuantityEstimation tonne = new QuantityEstimation(BaseConversion.TONNE, 0.001);
        Boolean compare = null;
        try {
            compare = kilogram.compare(tonne);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compare);
    }

    @Test
    public void givenTonnesAndGrams_WhenCompared_ShouldReturnEqualWeight() {
        QuantityEstimation tonne = new QuantityEstimation(BaseConversion.TONNE, 1.0 / 1e+6);
        QuantityEstimation grams = new QuantityEstimation(BaseConversion.GRAM, 1.0);
        Boolean compare = null;
        try {
            compare = tonne.compare(grams);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compare);
    }

    @Test
    public void givenGramsAndTonnes_WhenCompared_ShouldReturnEqualWeight() {
        QuantityEstimation tonne = new QuantityEstimation(BaseConversion.TONNE, 1.0);
        QuantityEstimation grams = new QuantityEstimation(BaseConversion.GRAM, 1e+6);
        Boolean compare = null;
        try {
            compare = grams.compare(tonne);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compare);
    }

    @Test
    public void givenTwoLengthsInInches_WhenPerformAddition_ShouldReturnCorrectResultsInInches() {
        QuantityEstimation inch1 = new QuantityEstimation(BaseConversion.INCH, 1.0);
        QuantityEstimation inch2 = new QuantityEstimation(BaseConversion.INCH, 1.0);
        double result = 0;
        try {
            result = quantityEstimation.additionOfEntity(inch1, inch2);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2.0, result, 0.0);
    }

    @Test
    public void givenOneLengthInFeetAndOneLengthInInches_WhenPerformAddition_ShouldReturnCorrectResultInInches() {
        QuantityEstimation feet = new QuantityEstimation(BaseConversion.FEET, 1.0);
        QuantityEstimation inch = new QuantityEstimation(BaseConversion.INCH, 2.0);
        double result = 0;
        try {
            result = quantityEstimation.additionOfEntity(feet, inch);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(14.0, result, 0.0);
    }

    @Test
    public void givenTwoLengthsInFeet_WhenPerformAddition_ShouldReturnCorrectResultInInches() {
        QuantityEstimation feet1 = new QuantityEstimation(BaseConversion.FEET, 1.0);
        QuantityEstimation feet2 = new QuantityEstimation(BaseConversion.FEET, 1.0);
        double result = 0;
        try {
            result = quantityEstimation.additionOfEntity(feet1, feet2);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(24.0, result, 0.0);
    }

    @Test
    public void givenOneLengthInInchesAndOneLengthInCentimeter_WhenPerformAddition_ShouldReturnCorrectResultInInches() {
        QuantityEstimation feet1 = new QuantityEstimation(BaseConversion.INCH, 2.0);
        QuantityEstimation feet2 = new QuantityEstimation(BaseConversion.CENTIMETER, 2.5);
        double result = 0;
        try {
            result = quantityEstimation.additionOfEntity(feet1, feet2);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(3.0, result, 0.0);
    }

    @Test
    public void given0FeetAnd0Feet_ShouldReturnEquals() {
        QuantityEstimation feet1 = new QuantityEstimation(BaseConversion.FEET, 0.0);
        QuantityEstimation feet2 = new QuantityEstimation(BaseConversion.FEET, 0.0);
        Assert.assertEquals(feet1, feet2);
    }

    @Test
    public void given0FeetAnd1Feet_ShouldReturnNotEquals() {
        QuantityEstimation feet1 = new QuantityEstimation(BaseConversion.FEET, 1.0);
        QuantityEstimation feet2 = new QuantityEstimation(BaseConversion.FEET, 0.0);
        Assert.assertNotEquals(feet1, feet2);
    }


    @Test
    public void given0InchAnd0Inch_ShouldReturnEqual() {
        QuantityEstimation inch1 = new QuantityEstimation(BaseConversion.INCH, 0.0);
        QuantityEstimation inch2 = new QuantityEstimation(BaseConversion.INCH, 0.0);
        Assert.assertEquals(inch1, inch2);
    }

    @Test
    public void given0InchAnd1Inch_ShouldReturnNotEqual() {
        QuantityEstimation inch1 = new QuantityEstimation(BaseConversion.INCH, 0.0);
        QuantityEstimation inch2 = new QuantityEstimation(BaseConversion.INCH, 1.0);
        Assert.assertNotEquals(inch1, inch2);
    }

    @Test
    public void given0FeetAnd0Inch_ShouldReturnEqualLength() {
        QuantityEstimation inch1 = new QuantityEstimation(BaseConversion.INCH, 0.0);
        QuantityEstimation feet1 = new QuantityEstimation(BaseConversion.FEET, 0.0);
        Boolean compareCheck = null;
        try {
            compareCheck = feet1.compare(inch1);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void given1FeetAnd1Inch_ShouldReturnNotEqual() {
        QuantityEstimation inch = new QuantityEstimation(BaseConversion.INCH, 1.0);
        QuantityEstimation feet = new QuantityEstimation(BaseConversion.FEET, 1.0);
        Assert.assertNotEquals(inch, feet);
    }

    @Test
    public void given1FeetAnd1Inch_ShouldReturnNotEqualLength() {
        QuantityEstimation inch1 = new QuantityEstimation(BaseConversion.INCH, 1.0);
        QuantityEstimation feet1 = new QuantityEstimation(BaseConversion.FEET, 1.0);
        Boolean compareCheck = null;
        try {
            compareCheck = feet1.compare(inch1);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(compareCheck);
    }

    @Test
    public void given1FeetAnd1feet_WhenCompared_ShouldReturnEqualLength() {
        QuantityEstimation feet1 = new QuantityEstimation(BaseConversion.FEET, 1.0);
        QuantityEstimation feet2 = new QuantityEstimation(BaseConversion.FEET, 1.0);
        Boolean compareCheck = null;
        try {
            compareCheck = feet1.compare(feet2);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void given1InchAnd1Inch_WhenCompared_ShouldReturnEqualLength() {
        QuantityEstimation inch1 = new QuantityEstimation(BaseConversion.INCH, 1.0);
        QuantityEstimation inch2 = new QuantityEstimation(BaseConversion.INCH, 1.0);
        Boolean compareCheck = null;
        try {
            compareCheck = inch1.compare(inch2);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void givenInchAndFeet_ShouldReturnEqualLength() {
        QuantityEstimation inch1 = new QuantityEstimation(BaseConversion.INCH, 12.0);
        QuantityEstimation feet1 = new QuantityEstimation(BaseConversion.FEET, 1.0);
        Boolean compareCheck = null;
        try {
            compareCheck = inch1.compare(feet1);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void givenFeetAndInch_ShouldReturnEqual() {
        QuantityEstimation feet1 = new QuantityEstimation(BaseConversion.FEET, 2.0);
        QuantityEstimation inch1 = new QuantityEstimation(BaseConversion.INCH, 24.0);
        Boolean compareCheck = null;
        try {
            compareCheck = feet1.compare(inch1);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void given0YardAnd0Yard_ShouldReturnEqual() {
        QuantityEstimation yard1 = new QuantityEstimation(BaseConversion.YARD, 0.0);
        QuantityEstimation yard2 = new QuantityEstimation(BaseConversion.YARD, 0.0);
        Boolean result = yard1.equals(yard2);
        Assert.assertTrue(result);
    }

    @Test
    public void given0YardAnd1Yard_ShouldReturnNotEqual() {
        QuantityEstimation yard1 = new QuantityEstimation(BaseConversion.YARD, 0.0);
        QuantityEstimation yard2 = new QuantityEstimation(BaseConversion.YARD, 1.0);
        Boolean result = yard1.equals(yard2);
        Assert.assertFalse(result);
    }

    @Test
    public void givenYardToFeet_ShouldReturnEqual() {
        QuantityEstimation yard = new QuantityEstimation(BaseConversion.YARD, 1.0);
        QuantityEstimation feet = new QuantityEstimation(BaseConversion.FEET, 3.0);
        Boolean compareCheck = null;
        try {
            compareCheck = yard.compare(feet);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void givenYardToFeet_ShouldReturnNotEqual() {
        QuantityEstimation yard = new QuantityEstimation(BaseConversion.YARD, 1.0);
        QuantityEstimation feet = new QuantityEstimation(BaseConversion.FEET, 1.0);
        Boolean compareCheck = null;
        try {
            compareCheck = yard.compare(feet);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(compareCheck);
    }

    @Test
    public void givenFeetToYard_ShouldReturnEqual() {
        QuantityEstimation yard = new QuantityEstimation(BaseConversion.YARD, 1.0 / 3.0);
        QuantityEstimation feet = new QuantityEstimation(BaseConversion.FEET, 1.0);
        Boolean compareCheck = null;
        try {
            compareCheck = feet.compare(yard);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void givenFeetToYard_ShouldReturnNotEqual() {
        QuantityEstimation yard = new QuantityEstimation(BaseConversion.YARD, 1.0);
        QuantityEstimation feet = new QuantityEstimation(BaseConversion.FEET, 1.0);
        Boolean compareCheck = null;
        try {
            compareCheck = feet.compare(yard);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(compareCheck);
    }

    @Test
    public void givenYardToInch_ShouldReturnEqual() {
        QuantityEstimation yard = new QuantityEstimation(BaseConversion.YARD, 1.0);
        QuantityEstimation inch = new QuantityEstimation(BaseConversion.INCH, 36.0);
        Boolean compareCheck = null;
        try {
            compareCheck = yard.compare(inch);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void givenYardToInch_ShouldReturnNotEqual() {
        QuantityEstimation yard = new QuantityEstimation(BaseConversion.YARD, 1.0);
        QuantityEstimation inch = new QuantityEstimation(BaseConversion.INCH, 1.0);
        Boolean compareCheck = null;
        try {
            compareCheck = yard.compare(inch);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(compareCheck);
    }

    @Test
    public void givenInchToYard_ShouldReturnEqual() {
        QuantityEstimation yard = new QuantityEstimation(BaseConversion.YARD, 1.0 / 36.0);
        QuantityEstimation inch = new QuantityEstimation(BaseConversion.INCH, 1.0);
        Boolean compareCheck = null;
        try {
            compareCheck = inch.compare(yard);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void givenInchToYard_ShouldReturnNotEqual() {
        QuantityEstimation yard = new QuantityEstimation(BaseConversion.YARD, 1.0);
        QuantityEstimation inch = new QuantityEstimation(BaseConversion.INCH, 1.0);
        Boolean compareCheck = null;
        try {
            compareCheck = inch.compare(yard);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(compareCheck);
    }

    @Test
    public void given0CentimeterAnd0Centimeter_ShouldReturnTrue() {
        QuantityEstimation centimeter1 = new QuantityEstimation(BaseConversion.CENTIMETER, 0.0);
        QuantityEstimation centimeter2 = new QuantityEstimation(BaseConversion.CENTIMETER, 0.0);
        Assert.assertEquals(centimeter1, centimeter2);
    }

    @Test
    public void given1Centimeter0Centimeter_ShouldReturnFalse() {
        QuantityEstimation centimeter1 = new QuantityEstimation(BaseConversion.CENTIMETER, 1.0);
        QuantityEstimation centimeter2 = new QuantityEstimation(BaseConversion.CENTIMETER, 0.0);
        Assert.assertNotEquals(centimeter1, centimeter2);
    }

    @Test
    public void givenInchAndCentimeter_WhenCompared_ShouldReturnEqualLength() {
        QuantityEstimation centimeter = new QuantityEstimation(BaseConversion.CENTIMETER, 1.0);
        QuantityEstimation inch = new QuantityEstimation(BaseConversion.INCH, 0.4);
        Boolean compareCheck = null;
        try {
            compareCheck = centimeter.compare(inch);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void givenCentimeterAndInch_WhenCompared_ShouldReturnEqualLength() {
        QuantityEstimation inch = new QuantityEstimation(BaseConversion.INCH, 1.0);
        QuantityEstimation centimeter = new QuantityEstimation(BaseConversion.CENTIMETER, 2.5);
        Boolean compareCheck = null;
        try {
            compareCheck = inch.compare(centimeter);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void givenFeetAndCentimeter_WhenCompared_ShouldReturnEqualLength() {
        QuantityEstimation feet = new QuantityEstimation(BaseConversion.FEET, 1.0);
        QuantityEstimation centimeter = new QuantityEstimation(BaseConversion.CENTIMETER, 30.0);
        Boolean compareCheck = null;
        try {
            compareCheck = feet.compare(centimeter);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void givenCentimeterAndFeet_WhenCompared_ShouldReturnEqualLength() {
        QuantityEstimation feet = new QuantityEstimation(BaseConversion.FEET, 1.0 / 30.0);
        QuantityEstimation centimeter = new QuantityEstimation(BaseConversion.CENTIMETER, 1.0);
        Boolean compare = null;
        try {
            compare = centimeter.compare(feet);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compare);
    }

    @Test
    public void givenYardAndCentimeter_WhenCompared_ShouldReturnEqualLength() {
        QuantityEstimation yard = new QuantityEstimation(BaseConversion.YARD, 1.0);
        QuantityEstimation centimeter = new QuantityEstimation(BaseConversion.CENTIMETER, 90.0);
        Boolean compareCheck = null;
        try {
            compareCheck = yard.compare(centimeter);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void givenCentimeterAndYard_WhenCompared_ShouldReturnEqualLength() {
        QuantityEstimation yard = new QuantityEstimation(BaseConversion.YARD, 1.0 / 90.0);
        QuantityEstimation centimeter = new QuantityEstimation(BaseConversion.CENTIMETER, 1.0);
        Boolean compare = null;
        try {
            compare = centimeter.compare(yard);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(compare);
    }

    @Test
    public void givenTwoVolumesInLiters_WhenPerformAddition_ShouldReturnCorrectResultsInMilliliter() {
        QuantityEstimation liter1 = new QuantityEstimation(BaseConversion.LITER, 1.0);
        QuantityEstimation liter2 = new QuantityEstimation(BaseConversion.LITER, 1.0);
        double result = 0;
        try {
            result = quantityEstimation.additionOfEntity(liter1, liter2);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2000.0, result, 0.0);
    }

    @Test
    public void givenOneVolumeInLitersAndOneVolumeInGallon_WhenPerformAddition_ShouldReturnCorrectResultInMilliLiter() {
        QuantityEstimation liter = new QuantityEstimation(BaseConversion.LITER, 1.0);
        QuantityEstimation gallon = new QuantityEstimation(BaseConversion.GALLON, 2.0);
        double result = 0;
        try {
            result = quantityEstimation.additionOfEntity(liter, gallon);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(8571.0, result, 0.00);
    }

    @Test
    public void givenOneVolumeInLitersAndOneVolumeInGallon_WhenPerformAddition_ShouldReturnCorrectResultsInMilliLiter() {
        QuantityEstimation liter = new QuantityEstimation(BaseConversion.LITER, 3.78);
        QuantityEstimation gallon = new QuantityEstimation(BaseConversion.GALLON, 1.0);
        double result = 0;
        try {
            result = quantityEstimation.additionOfEntity(liter, gallon);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(7565.0, result, 0.00);
    }

    @Test
    public void givenOneVolumeInLitersAndOneVolumeInMilliliter_WhenPerformAddition_ShouldReturnCorrectResultsInMilliLiter() {
        QuantityEstimation liter = new QuantityEstimation(BaseConversion.LITER, 1.0);
        QuantityEstimation milliliter = new QuantityEstimation(BaseConversion.MILLILITER, 1000.0);
        double result = 0;
        try {
            result = quantityEstimation.additionOfEntity(liter, milliliter);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(2000.0, result, 0.00);
    }

    @Test
    public void givenTwoTemperatureValuesInFahrenheitAndCelsius_WhenCompared_ShouldReturnEqualTemperature() {
        QuantityEstimation celsius = new QuantityEstimation(BaseConversion.CELSIUS, 1.0);
        QuantityEstimation fahrenheit = new QuantityEstimation(BaseConversion.FAHRENHEIT, 33.8);
        boolean result = false;
        try {
            result = celsius.compareTemperature(fahrenheit);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }

    @Test
    public void givenTwoTemperatureValuesInFahrenheitAndCelsius_WhenCompared_ShouldReturnEqualTemperature2() {
        QuantityEstimation celsius = new QuantityEstimation(BaseConversion.CELSIUS, 100.0);
        QuantityEstimation fahrenheit = new QuantityEstimation(BaseConversion.FAHRENHEIT, 212.0);
        boolean result = false;
        try {
            result = fahrenheit.compareTemperature(celsius);
        } catch (QuantityEstimationException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
}
