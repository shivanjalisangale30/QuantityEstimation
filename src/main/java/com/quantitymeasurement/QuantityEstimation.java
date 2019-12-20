package com.quantitymeasurement;

public class QuantityEstimation {

    public Double value;
    public BaseConversion unit;

    public QuantityEstimation() {
    }

    public QuantityEstimation(BaseConversion unit, Double value) {
        this.unit = unit;
        this.value = value;
    }

    public Boolean compare(QuantityEstimation that) throws QuantityEstimationException {
        try {
            if (this.unit.entityType.equals(that.unit.entityType))
                return Double.compare(Math.round(this.value * this.unit.basUnitConversion),
                        Math.round(that.value * that.unit.basUnitConversion)) == 0;
            else
                throw new QuantityEstimationException("Invalid Type of Input", QuantityEstimationException.ExceptionType.INVALID_TYPE_INPUT);
        } catch (NullPointerException e) {
            throw new QuantityEstimationException("Please Enter Valid Value", QuantityEstimationException.ExceptionType.INVALID_VALUE);
        }

    }

    public double additionOfEntity(QuantityEstimation quantity_1, QuantityEstimation quantity_2) throws QuantityEstimationException {
        try {
            if ((quantity_1.unit.entityType.equals(quantity_2.unit.entityType)) && !(quantity_1.unit.entityType.equals(EntityType.TEMPERATURE))) {
                return Math.round((quantity_1.value * quantity_1.unit.basUnitConversion)
                        + (quantity_2.value * quantity_2.unit.basUnitConversion));
            } else
                throw new QuantityEstimationException("Invalid Type of Input", QuantityEstimationException.ExceptionType.INVALID_TYPE_INPUT);
        } catch (NullPointerException e) {
            throw new QuantityEstimationException("Please Enter Valid Value", QuantityEstimationException.ExceptionType.INVALID_VALUE);
        }
    }

    public boolean compareTemperature(QuantityEstimation that) throws QuantityEstimationException {
        double temperature = 0.0;
        try {
            if ((this.unit.entityType.equals(EntityType.TEMPERATURE)) && (that.unit.entityType.equals(EntityType.TEMPERATURE))) {
                if (this.unit.equals(BaseConversion.CELSIUS))
                    temperature = ((1.8 * this.value) + 32);
                if (this.unit.equals(BaseConversion.FAHRENHEIT))
                    temperature = ((this.value - 32) / 1.8);
                return Double.compare(temperature, that.value) == 0;
            } else
                throw new QuantityEstimationException("Invalid Type of Input", QuantityEstimationException.ExceptionType.INVALID_TYPE_INPUT);
        } catch (NullPointerException e) {
            throw new QuantityEstimationException("Please Enter Valid Value", QuantityEstimationException.ExceptionType.INVALID_VALUE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityEstimation quantityEstimation = (QuantityEstimation) o;
        return (Double.compare(quantityEstimation.value, value) == 0 && quantityEstimation.unit == unit);
    }
}
