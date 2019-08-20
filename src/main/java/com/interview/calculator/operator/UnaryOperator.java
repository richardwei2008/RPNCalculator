package com.interview.calculator.operator;

import java.math.BigDecimal;

public abstract class UnaryOperator {

    abstract BigDecimal apply(BigDecimal firstOperand);
}
