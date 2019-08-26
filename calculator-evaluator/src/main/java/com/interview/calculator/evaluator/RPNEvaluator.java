package com.interview.calculator.evaluator;


import com.interview.calculator.core.exception.InsufficientParameterException;
import com.interview.calculator.core.exception.InsufficientStorageException;
import com.interview.calculator.core.exception.InvalidExpressionException;
import com.interview.calculator.dispatcher.TokenDispatcher;
import com.interview.calculator.handler.chain.HandlerChain;
import com.interview.calculator.storage.Storage;
import com.interview.calculator.storage.impl.CalculatorStorage;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class RPNEvaluator {

    private TokenDispatcher dispatcher = new TokenDispatcher();
    private Storage storage = new CalculatorStorage();

    public String evaluate(String nextLine) {
        String curToken = null;
        int pos = 0;
        try {
            Scanner inner = new Scanner(nextLine).useDelimiter("\\s+|\\n");

            while(inner.hasNext()){
                String next = inner.next();
                log.debug(next);
                curToken = next;
                pos += next.length() + 1;

                HandlerChain chain = dispatcher.requireHandlerChain(curToken);
                chain.execute(storage, curToken);

                if ("q".equalsIgnoreCase(curToken)) {
                    break;
                }
            }
            inner.close();
        } catch (InvalidExpressionException ex) {
            log.error(String.format("operator %s (position: %d): invalid expression",
                    curToken, pos - 1));
        } catch (ArithmeticException ex) {
            log.error(String.format("operator %s (position: %d): %s",
                    curToken, pos - 1, ex.getMessage()));
        } catch (InsufficientParameterException ex) {
            log.error(String.format("operator %s (position: %d): insufficient parameters",
                    curToken, pos - 1));
        } catch (InsufficientStorageException ex) {
            log.error(String.format("operator %s (position: %d): %s",
                    curToken, pos - 1, ex.getMessage()));
        }
        return status();
    }

    private String status() {
        return this.storage.out();
    }



}
