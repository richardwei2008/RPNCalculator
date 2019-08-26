package com.interview.calculator.core.operator;

import java.math.BigDecimal;

public abstract class BinaryOperator {

    abstract BigDecimal apply(BigDecimal firstOperand, BigDecimal secondOperand);
}
