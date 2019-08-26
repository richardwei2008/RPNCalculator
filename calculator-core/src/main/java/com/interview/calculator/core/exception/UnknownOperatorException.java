package com.interview.calculator.core.exception;

public class UnknownOperatorException extends RuntimeException {
    public UnknownOperatorException(String message) {
        super(message);
    }
}
