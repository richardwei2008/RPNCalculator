package com.interview.calculator;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class RPNConsole {

    public static void main(String[] args) {
        new RPNConsole().start();
    }

    public void start() {
        log.info("\n\t Welcome RPN Calculator" +
                "\n\t Please input expression to calculate::(Enter q to quit)");


        Scanner scanner = new Scanner(System.in);
        RPNCalculator rpnCalculator = new RPNCalculator();

        while(scanner.hasNext()){
            String nextLine = scanner.nextLine();
            log.debug(nextLine);

            String stackRead = rpnCalculator.parseExpression(nextLine);
            log.info("\n\t Stack: {}", stackRead);
        }

        scanner.close();
        log.info("\n\t Bye RPN Calculator");
    }


}
