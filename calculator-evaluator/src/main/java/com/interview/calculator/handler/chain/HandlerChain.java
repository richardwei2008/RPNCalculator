package com.interview.calculator.handler.chain;

import com.interview.calculator.handler.TokenHandler;
import com.interview.calculator.storage.Storage;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class HandlerChain implements TokenHandler {

    private List<TokenHandler> handlers;

    public HandlerChain(List<TokenHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public BigDecimal execute(Storage storage, String token) {
        Iterator<TokenHandler> iterator = handlers.iterator();

        BigDecimal result = null;
        String passThrough = token;
        while (iterator.hasNext()) {
            TokenHandler handler = iterator.next();
            result = handler.execute(storage, passThrough);
            if (result != null) {
                passThrough = result.toPlainString();
            }
        }
        return result;
    }

}
