package com.interview.calculator.operator;

import java.math.BigDecimal;

public class SqrtOp extends UnaryOperator {

    @Override
    public BigDecimal apply(BigDecimal firstOperand) {
        return BigDecimal.valueOf(Math.sqrt(firstOperand.doubleValue()));
    }
}
