package com.interview.calculator;

import com.interview.calculator.exception.UnknownOperatorException;
import com.interview.calculator.operator.*;

import java.math.BigDecimal;

public class ArithmeticCalculator {

    public BigDecimal calculate(String operator, BigDecimal firstOperand, BigDecimal secondOperand) {
        BigDecimal result;
        switch (operator) {
            case Operators.ADD:
                result = new AddOp().apply(firstOperand, secondOperand);
                break;
            case Operators.SUBSTRACT:
                result = new SubstractOp().apply(firstOperand, secondOperand);
                break;
            case Operators.MULTIPLY:
                result = new MultiplyOp().apply(firstOperand, secondOperand);
                break;
            case Operators.DIVIDE :
                result = new DivideOp().apply(firstOperand, secondOperand);
                break;
            case Operators.SQRT :
                result = new SqrtOp().apply(firstOperand);
                break;
            default:
                throw new UnknownOperatorException(String.format("Unknown Operator: %s", operator));
        }

        return result;
    }
}
