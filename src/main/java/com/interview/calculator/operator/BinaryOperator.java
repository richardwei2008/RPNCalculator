package com.interview.calculator.operator;

import java.math.BigDecimal;

public abstract class BinaryOperator {

    abstract BigDecimal apply(BigDecimal firstOperand, BigDecimal secondOperand);
}
