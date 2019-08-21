package com.interview.calculator.operator;

import java.math.BigDecimal;

public class SqrtOp extends UnaryOperator {

    @Override
    public BigDecimal apply(BigDecimal firstOperand) {
        try {
            return BigDecimal.valueOf(Math.sqrt(firstOperand.doubleValue()));
        } catch (NumberFormatException ex) {
            throw new ArithmeticException("sqrt number format error");
        }
    }
}
