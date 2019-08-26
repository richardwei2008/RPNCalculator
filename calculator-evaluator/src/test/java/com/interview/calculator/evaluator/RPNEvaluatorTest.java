package com.interview.calculator.evaluator;

import org.junit.Assert;
import org.junit.Test;

public class RPNEvaluatorTest {

    @Test
    public void textExample1() {
        RPNEvaluator calculator = new RPNEvaluator();
        String line = "5 2\n";
        String stack = calculator.evaluate(line);
        Assert.assertEquals("5 2", stack);
    }

    @Test
    public void textExample2() {
        RPNEvaluator calculator = new RPNEvaluator();
        String line1 = "2 sqrt\n";
        String stack = calculator.evaluate(line1);
        Assert.assertEquals("1.4142135623", stack);

        String line2 = "clear 9 sqrt\n";
        stack = calculator.evaluate(line2);
        Assert.assertEquals("3", stack);
    }

    @Test
    public void textExample3() {
        RPNEvaluator calculator = new RPNEvaluator();
        String line1 = "5 2 -\n";
        String stack = calculator.evaluate(line1);
        Assert.assertEquals("3", stack);

        String line2 = "clear\n";
        stack = calculator.evaluate(line2);
        Assert.assertEquals("", stack);
    }

    @Test
    public void textExample4() {
        RPNEvaluator calculator = new RPNEvaluator();
        String line1 = "5 4 3 2\n";
        String stack = calculator.evaluate(line1);
        Assert.assertEquals("5 4 3 2", stack);

        String line2 = "clear\n";
        stack = calculator.evaluate(line2);
        Assert.assertEquals("", stack);
    }

    @Test
    public void textExample5() {
        RPNEvaluator calculator = new RPNEvaluator();
        String line1 = "7 12 2 /\n";
        String stack = calculator.evaluate(line1);
        Assert.assertEquals("7 6", stack);

        String line2 = "*\n";
        stack = calculator.evaluate(line2);
        Assert.assertEquals("42", stack);

        String line3 = "4 /\n";
        stack = calculator.evaluate(line3);
        Assert.assertEquals("10.5", stack);
    }

    @Test
    public void textExample6() {
        RPNEvaluator calculator = new RPNEvaluator();
        String line1 = "1 2 3 4 5\n";
        String stack = calculator.evaluate(line1);
        Assert.assertEquals("1 2 3 4 5", stack);

        String line2 = "*\n";
        stack = calculator.evaluate(line2);
        Assert.assertEquals("1 2 3 20", stack);

        String line3 = "clear 3 4 -\n";
        stack = calculator.evaluate(line3);
        Assert.assertEquals("-1", stack);
    }

    @Test
    public void textExample7() {
        RPNEvaluator calculator = new RPNEvaluator();
        String line1 = "1 2 3 4 5\n";
        String stack = calculator.evaluate(line1);
        Assert.assertEquals("1 2 3 4 5", stack);

        String line2 = "* * * *\n";
        stack = calculator.evaluate(line2);
        Assert.assertEquals("120", stack);
    }

    @Test
    public void textExample8() {
        RPNEvaluator calculator = new RPNEvaluator();
        String line1 = "1 2 3 * 5 + * * 6 5\n";
        String stack = calculator.evaluate(line1);
        Assert.assertEquals("11", stack);
    }

    @Test
    public void textExample9() {
        RPNEvaluator calculator = new RPNEvaluator();
        String line1 = "2 0 /\n";
        String stack = calculator.evaluate(line1);
        Assert.assertEquals("", stack);
    }

    @Test
    public void textExample10() {
        RPNEvaluator calculator = new RPNEvaluator();
        String line1 = "-2 sqrt\n";
        String stack = calculator.evaluate(line1);
        Assert.assertEquals("", stack);
    }

    @Test
    public void textExample11() {
        RPNEvaluator calculator = new RPNEvaluator();
        String line1 = "-2.1 1.2 +\n";
        String stack = calculator.evaluate(line1);
        Assert.assertEquals("-0.9", stack);
    }

    @Test
    public void textExample12() {
        RPNEvaluator calculator = new RPNEvaluator();
        String line1 = "-2 sqrt\n";
        String stack = calculator.evaluate(line1);
        Assert.assertEquals("", stack);
    }
}
