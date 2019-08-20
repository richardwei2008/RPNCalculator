package com.interview.calculator.operator;

import java.math.BigDecimal;

public class MultiplyOp extends BinaryOperator {

    @Override
    public BigDecimal apply(BigDecimal firstOperand, BigDecimal secondOperand) {
        return firstOperand.multiply(secondOperand);
    }
}
