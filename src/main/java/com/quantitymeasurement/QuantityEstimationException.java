package com.quantitymeasurement;

public class QuantityEstimationException extends Exception {

    public enum ExceptionType {INVALID_TYPE_INPUT, INVALID_VALUE}

    ;

    public ExceptionType type;

    public QuantityEstimationException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }


}
