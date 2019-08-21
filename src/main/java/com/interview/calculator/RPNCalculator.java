package com.interview.calculator;


import com.interview.calculator.exception.InsufficientParameterException;
import com.interview.calculator.exception.InvalidExpressionException;
import com.interview.calculator.exception.UnknownOperatorException;
import com.interview.calculator.operator.Operators;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.EmptyStackException;
import java.util.Scanner;

@Slf4j
public class RPNCalculator {

    private CalculatorStorage storage = new CalculatorStorage();
    private ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();

    public String parseExpression(String nextLine) {
        String curOp = null;
        int pos = 0;
        try {
            Scanner inner = new Scanner(nextLine).useDelimiter("\\s+|\\n");

            while(inner.hasNext()){
                String next = inner.next();
                log.debug(next);
                curOp = next;
                pos += next.length() + 1;
                this.evaluate(curOp);

                if ("q".equalsIgnoreCase(curOp)) {
                    break;
                }
            }
            inner.close();
        } catch (InvalidExpressionException ex) {
            log.error(String.format("operator %s (position: %d): invalid expression",
                    curOp, pos - 1));
        } catch (ArithmeticException ex) {
            log.error(String.format("operator %s (position: %d): %s",
                    curOp, pos - 1, ex.getMessage()));
        } catch (InsufficientParameterException ex) {
            log.error(String.format("operator %s (position: %d): insufficient parameters",
                    curOp, pos - 1));
        }
        return status();
    }

    private String status() {
        return this.storage.out();
    }

    private void evaluate(String op) {
        if (!isValidExpression(op)) {
            throw new InvalidExpressionException();
        }

        if (isNumeric(op)) {
            store(op);
        }

        if (isOperator(op)) {
            store(op);
            switch (op) {
                case Operators.UNDO:
                    undo();
                    break;
                case Operators.CLEAR:
                    clear();
                    break;
                default:
                    calculate(op);
                    break;
            }
        }

    }

    private void store(String op) {
        this.storage.store(op);
    }

    private void clear() {
        this.storage.clear();
    }


    private void calculate(String operator) {

            capture();
            String[] expressions = this.storage.pop(operator);

            String op = expressions[0];
            String first = expressions[1];
            String second = expressions[2];
            BigDecimal firstOperand = new BigDecimal(first);
            BigDecimal secondOperand = new BigDecimal(second);
            BigDecimal result = this.arithmeticCalculator.calculate(op, firstOperand, secondOperand);
            store(result.toString());

    }

    private void capture() {
        this.storage.capture();
    }

    private boolean isValidExpression(String input) {
        return  isOperator(input) || isNumeric(input);
    }


    /**
     * match a number with optional '-' and decimal.
     * @param str
     * @return
     */
    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private boolean isOperator(String str) {
        return Operators.contains(str);
    }


    private void undo() {
        try {
            this.storage.undo();

        } catch (EmptyStackException ex) {
            throw new InsufficientParameterException();
        }

    }

}
