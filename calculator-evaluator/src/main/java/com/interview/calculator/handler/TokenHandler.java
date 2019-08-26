package com.interview.calculator.handler;

import com.interview.calculator.storage.Storage;

import java.math.BigDecimal;

public interface TokenHandler {

    BigDecimal execute(Storage storage, String token);
}
