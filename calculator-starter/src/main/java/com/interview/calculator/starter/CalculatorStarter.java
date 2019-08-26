package com.interview.calculator.starter;

import lombok.extern.slf4j.Slf4j;
import com.interview.calculator.ui.RPNConsole;

@Slf4j
public class CalculatorStarter {

    public static void main(String[] args) {

        new RPNConsole().start();
    }
}
