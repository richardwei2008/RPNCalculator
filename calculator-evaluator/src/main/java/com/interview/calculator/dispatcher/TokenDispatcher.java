package com.interview.calculator.dispatcher;


import com.interview.calculator.core.exception.InvalidExpressionException;
import com.interview.calculator.core.operator.Operators;
import com.interview.calculator.handler.ChainHandlerFactory;
import com.interview.calculator.handler.chain.HandlerChain;
import com.interview.calculator.util.NumericUtil;


public class TokenDispatcher {

    public HandlerChain requireHandlerChain(String op) {
        if (!isValidExpression(op)) {
            throw new InvalidExpressionException();
        }

        return ChainHandlerFactory.getInstance().createHandlerChain(op);
    }


    private boolean isValidExpression(String input) {
        return  Operators.contains(input) || NumericUtil.isNumeric(input);
    }


}
