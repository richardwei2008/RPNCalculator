package com.interview.calculator.core.operator;

import java.math.BigDecimal;

public abstract class UnaryOperator {

    abstract BigDecimal apply(BigDecimal firstOperand);
}
