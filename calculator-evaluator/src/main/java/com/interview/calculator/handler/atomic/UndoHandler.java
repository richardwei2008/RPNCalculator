package com.interview.calculator.handler.atomic;

import com.interview.calculator.core.exception.InsufficientParameterException;
import com.interview.calculator.handler.TokenHandler;
import com.interview.calculator.storage.Storage;

import java.math.BigDecimal;
import java.util.EmptyStackException;

public class UndoHandler implements TokenHandler {

    @Override
    public BigDecimal execute(Storage storage, String token) {

        try {
            storage.undo();
        } catch (EmptyStackException ex) {
            throw new InsufficientParameterException();
        }
        return null;
    }
}
