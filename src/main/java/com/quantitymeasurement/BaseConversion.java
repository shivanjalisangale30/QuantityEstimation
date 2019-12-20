package com.quantitymeasurement;

public enum BaseConversion {

    INCH(1, EntityType.LENGTH),
    FEET(12, EntityType.LENGTH),
    YARD(36, EntityType.LENGTH),
    CENTIMETER(0.4, EntityType.LENGTH),

    LITER(1000, EntityType.VOLUME),
    MILLILITER(1, EntityType.VOLUME),
    GALLON(3785.41, EntityType.VOLUME),

    GRAM(1, EntityType.WEIGHT),
    KILOGRAM(1000, EntityType.WEIGHT),
    TONNE(1e+6, EntityType.WEIGHT),

    CELSIUS(EntityType.TEMPERATURE),
    FAHRENHEIT(EntityType.TEMPERATURE);

    public EntityType entityType;
    public double basUnitConversion;

    BaseConversion(EntityType entityType) {
        this.entityType = entityType;
    }

    BaseConversion(double baseUnitConversion , EntityType entityType) {
        this.basUnitConversion = baseUnitConversion;
        this.entityType = entityType;
    }
}

