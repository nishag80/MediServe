package com.edu.exception;

public class MissingParameterException  extends RuntimeException {

    public MissingParameterException(String parameterName) {
        super("Parameter '" + parameterName + "' is missing.");
    }
}