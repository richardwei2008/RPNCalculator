package com.interview.calculator.core.operator;

import java.math.BigDecimal;

public class DivideOp extends BinaryOperator {

    @Override
    public BigDecimal apply(BigDecimal firstOperand, BigDecimal secondOperand) {
        return firstOperand.divide(secondOperand);
    }
}
