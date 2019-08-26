package com.interview.calculator.handler;

import com.interview.calculator.core.operator.Operators;
import com.interview.calculator.handler.atomic.*;
import com.interview.calculator.handler.chain.HandlerChain;
import com.interview.calculator.util.NumericUtil;

import java.util.Arrays;

public class ChainHandlerFactory {

    private ChainHandlerFactory() {}

    public static ChainHandlerFactory getInstance() {
        return new ChainHandlerFactory();
    }

    public HandlerChain createHandlerChain(String token) {
        if (NumericUtil.isNumeric(token)) {
            return new HandlerChain(Arrays.asList(
                    new StorageHandler()
            ));
        }

        if (Operators.contains(token)) {
            switch (token) {
                case Operators.UNDO:
                    return new HandlerChain(Arrays.asList(
                            new StorageHandler(),
                            new UndoHandler()
                    ));
                case Operators.CLEAR:
                    return new HandlerChain(Arrays.asList(
                            new StorageHandler(),
                            new ClearHandler()
                    ));
                default:
                    return new HandlerChain(Arrays.asList(
                            new StorageHandler(),
                            new CaptureHandler(),
                            new ArithmeticHandler(),
                            new StorageHandler()
                    ));
            }
        }

        return null;
    }





}
