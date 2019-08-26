package com.interview.calculator.ui;

import com.interview.calculator.evaluator.RPNEvaluator;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class RPNConsole {

    public void start() {
        log.info("\n\t Welcome RPN Calculator" +
                "\n\t Please input expression to calculate::(Enter q to quit)");


        Scanner scanner = new Scanner(System.in);
        RPNEvaluator rpnEvaluator = new RPNEvaluator();

        while(scanner.hasNext()){
            String nextLine = scanner.nextLine();
            log.debug(nextLine);

            String stackRead = rpnEvaluator.evaluate(nextLine);
            log.info("\n\t Stack: {}", stackRead);
        }

        scanner.close();
        log.info("\n\t Bye RPN Calculator");
    }


}
