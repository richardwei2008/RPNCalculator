package com.interview.calculator;


import com.interview.calculator.exception.InsufficientParameterException;
import com.interview.calculator.exception.UnknownOperatorException;
import com.interview.calculator.operator.Operators;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Stack;

public class CalculatorStorage {

    /**
     * stack for operator and operands
     */
    private Stack<String> stack;

    /**
     * stack for undo case like
     * stack: 20 5 *
     * stack: 100 undo
     * stack: 20 5
     */
    private Stack<String> undo;

    public CalculatorStorage() {
        stack = new Stack<>();
        undo = new Stack<>();
    }

    public void store(String op) {
        this.stack.push(op);
    }

    public String[] pop(String op) {
        String[] res = new String[3];

        switch (op) {
            case Operators.ADD:
            case Operators.SUBSTRACT:
            case Operators.MULTIPLY:
            case Operators.DIVIDE :
                res[0] = this.stack.pop(); // pop operator
                if (this.stack.size() < 2) {
                    throw new InsufficientParameterException();
                }
                res[2] = this.stack.pop();
                res[1] = this.stack.pop();
                break;
            case Operators.SQRT :
                res[0] = this.stack.pop(); // pop operator
                if (this.stack.size() < 1) {
                    throw new InsufficientParameterException();
                }
                res[1] = this.stack.pop();
                res[2] = BigDecimal.ZERO.toPlainString();
                break;
            default:
                throw new UnknownOperatorException(String.format("Unknown Operator: %s", op));
        }
        return res;
    }


    public void undo() {
        this.stack.pop(); // pop the undo op
        this.stack.pop(); //

        // restore stack from undoStack
        if (!this.undo.empty()) {
            String effectiveOp = this.undo.pop();
            switch (effectiveOp) {
                case Operators.ADD:
                case Operators.SUBSTRACT:
                case Operators.MULTIPLY:
                case Operators.DIVIDE :
                    this.stack.push(this.undo.pop());
                    this.stack.push(this.undo.pop());
                    break;
                case Operators.SQRT :
                    this.stack.push(this.undo.pop());
                    break;
                default:
            }
        }
    }

    public void clear() {
        this.stack.clear();
        this.undo.clear();
    }

    public String out() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("#0.##########");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        if (stack.empty()) {
            return "";
        }
        for (String op : stack) {
            sb.append(decimalFormat.format(new BigDecimal(op))).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public void capture() {
        this.undo = (Stack<String>) this.stack.clone();
    }
}
