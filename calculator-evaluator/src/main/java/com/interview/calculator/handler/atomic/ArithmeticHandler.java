package com.interview.calculator.handler.atomic;

import com.interview.calculator.core.exception.UnknownOperatorException;
import com.interview.calculator.core.operator.*;
import com.interview.calculator.handler.TokenHandler;
import com.interview.calculator.storage.Storage;

import java.math.BigDecimal;

public class ArithmeticHandler implements TokenHandler {

    @Override
    public BigDecimal execute(Storage storage, String operator) {
        String[] expressions = storage.pop(operator);

        String op = expressions[0];
        String first = expressions[1];
        String second = expressions[2];
        BigDecimal firstOperand = new BigDecimal(first);
        BigDecimal secondOperand = new BigDecimal(second);
        BigDecimal result = this.calculate(op, firstOperand, secondOperand);

        return result;
    }

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
