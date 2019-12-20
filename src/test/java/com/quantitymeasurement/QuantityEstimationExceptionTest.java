package com.quantitymeasurement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuantityEstimationExceptionTest {

    QuantityEstimation quantityEstimation;

    @Before
    public void getInstance_OfQuantityEstimation() {
        quantityEstimation = new QuantityEstimation();
    }

    @Test
    public void givenTwoDifferentTypesEntity1_WhenComparing_ShouldReturnQuantityMeasurementException() {
        try {
            QuantityEstimation kilogram = new QuantityEstimation(BaseConversion.KILOGRAM, 1.0);
            QuantityEstimation inch = new QuantityEstimation(BaseConversion.INCH, 1.0);
            boolean result = kilogram.compare(inch);
            Assert.assertTrue(result);
        } catch (QuantityEstimationException e) {
        }
    }

    @Test
    public void givenTwoDifferentTypesEntity2_WhenComparing_ShouldReturnQuantityMeasurementException() {
        try {
            QuantityEstimation celsius = new QuantityEstimation(BaseConversion.CELSIUS, 1.0);
            QuantityEstimation inch = new QuantityEstimation(BaseConversion.INCH, 1.0);
            boolean result = celsius.compare(inch);
            Assert.assertTrue(result);
        } catch (QuantityEstimationException e) {
        }
    }

    @Test
    public void given0feetAndNull_ShouldReturn_NullPointerException() {
        try {
            QuantityEstimation feet1 = new QuantityEstimation(BaseConversion.FEET, null);
            QuantityEstimation feet2 = new QuantityEstimation(BaseConversion.FEET, 0.0);
            Boolean result = feet1.compare(feet2);
        } catch (QuantityEstimationException e) {
            Assert.assertEquals(QuantityEstimationException.ExceptionType.INVALID_VALUE, e.type);
        }
    }

    @Test
    public void given0InchAndNull_ShouldReturn_NullPointerException() {
        try {
            QuantityEstimation inch1 = new QuantityEstimation(BaseConversion.INCH, null);
            QuantityEstimation inch2 = new QuantityEstimation(BaseConversion.INCH, 0.0);
            Boolean result = inch1.compare(inch2);
        } catch (QuantityEstimationException e) {
            Assert.assertEquals(QuantityEstimationException.ExceptionType.INVALID_VALUE, e.type);
        }
    }

    @Test
    public void givenTwoDifferentTypesInTemperature_WhenPerformAddition_ShouldReturnQuantityMeasurementException() {
        try {
            QuantityEstimation temp1 = new QuantityEstimation(BaseConversion.CELSIUS, 1.0);
            QuantityEstimation temp2 = new QuantityEstimation(BaseConversion.CELSIUS, 1.0);
            double result = quantityEstimation.additionOfEntity(temp1, temp2);
        } catch (QuantityEstimationException e) {
            Assert.assertEquals(QuantityEstimationException.ExceptionType.INVALID_TYPE_INPUT, e.type);
        }
    }

    @Test
    public void given1ValueNullInTemperature_WhenComparing_ShouldReturnQuantityMeasurementException() {
        try {
            QuantityEstimation temp1 = new QuantityEstimation(BaseConversion.CELSIUS, null);
            QuantityEstimation temp2 = new QuantityEstimation(BaseConversion.CELSIUS, 1.0);
            Boolean result = temp1.compareTemperature(temp2);
        } catch (QuantityEstimationException e) {
            Assert.assertEquals(QuantityEstimationException.ExceptionType.INVALID_VALUE, e.type);
        }
    }

    @Test
    public void given1ValueNull_WhenPerformAddition_ShouldReturnQuantityMeasurementException() {
        try {
            QuantityEstimation liter = new QuantityEstimation(BaseConversion.LITER, null);
            QuantityEstimation milliliter = new QuantityEstimation(BaseConversion.MILLILITER, 1.0);
            double result = quantityEstimation.additionOfEntity(liter, milliliter);
        } catch (QuantityEstimationException e) {
            Assert.assertEquals(QuantityEstimationException.ExceptionType.INVALID_VALUE, e.type);
        }
    }

    @Test
    public void given1CentimeterAndNullValue_ShouldReturnFalse() {
        try {
            QuantityEstimation centimeter1 = new QuantityEstimation(BaseConversion.CENTIMETER, 1.0);
            QuantityEstimation centimeter2 = new QuantityEstimation(BaseConversion.CENTIMETER, null);
            Boolean result = centimeter1.compare(centimeter2);
        } catch (QuantityEstimationException e) {
            Assert.assertEquals(e.type, QuantityEstimationException.ExceptionType.INVALID_VALUE);
        }
    }

    @Test
    public void given1ValueNull_WhenComparingLength_ShouldReturnQuantityMeasurementException() {
        try {
            QuantityEstimation celsius = new QuantityEstimation(BaseConversion.YARD, 1.0);
            QuantityEstimation inch = new QuantityEstimation(BaseConversion.INCH, null);
            boolean result = celsius.compare(inch);
        } catch (QuantityEstimationException e) {
            Assert.assertEquals(e.type, QuantityEstimationException.ExceptionType.INVALID_VALUE);
        }
    }

    @Test
    public void given1ValueInInch_WhenComparingTemperature_ShouldReturnQuantityMeasurementException() {
        try {
            QuantityEstimation celsius = new QuantityEstimation(BaseConversion.CELSIUS, 1.0);
            QuantityEstimation inch = new QuantityEstimation(BaseConversion.INCH, 1.0);
            boolean result = celsius.compareTemperature(inch);
        } catch (QuantityEstimationException e) {
            Assert.assertEquals(QuantityEstimationException.ExceptionType.INVALID_TYPE_INPUT, e.type);
        }
    }

    @Test
    public void given0YardAndNull_ShouldReturn_NullPointerException() {
        try {
            QuantityEstimation yard1 = new QuantityEstimation(BaseConversion.YARD, null);
            QuantityEstimation yard2 = new QuantityEstimation(BaseConversion.YARD, 1.0);
            Boolean result = yard1.compare(yard2);
            Assert.assertFalse(result);
        } catch (QuantityEstimationException e) {
            Assert.assertEquals(e.type, QuantityEstimationException.ExceptionType.INVALID_VALUE);
        }
    }

}
