package com.interview.calculator.handler.atomic;

import com.interview.calculator.handler.TokenHandler;
import com.interview.calculator.storage.Storage;

import java.math.BigDecimal;

public class StorageHandler implements TokenHandler {

    @Override
    public BigDecimal execute(Storage storage, String token) {
        storage.store(token);
        return null;
    }
}
