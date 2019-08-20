package com.interview.calculator;

import org.junit.Assert;
import org.junit.Test;

public class RPNCalculatorTest {

    @Test
    public void textExample1() {
        RPNCalculator calculator = new RPNCalculator();
        String line = "5 2\n";
        String stack = calculator.parseExpression(line);
        Assert.assertEquals("5 2", stack);
    }

    @Test
    public void textExample2() {
        RPNCalculator calculator = new RPNCalculator();
        String line1 = "2 sqrt\n";
        String stack = calculator.parseExpression(line1);
        Assert.assertEquals("1.4142135623", stack);

        String line2 = "clear 9 sqrt\n";
        stack = calculator.parseExpression(line2);
        Assert.assertEquals("3", stack);
    }

    @Test
    public void textExample3() {
        RPNCalculator calculator = new RPNCalculator();
        String line1 = "5 2 -\n";
        String stack = calculator.parseExpression(line1);
        Assert.assertEquals("3", stack);

        String line2 = "clear\n";
        stack = calculator.parseExpression(line2);
        Assert.assertEquals("", stack);
    }

    @Test
    public void textExample4() {
        RPNCalculator calculator = new RPNCalculator();
        String line1 = "5 4 3 2\n";
        String stack = calculator.parseExpression(line1);
        Assert.assertEquals("5 4 3 2", stack);

        String line2 = "clear\n";
        stack = calculator.parseExpression(line2);
        Assert.assertEquals("", stack);
    }

    @Test
    public void textExample5() {
        RPNCalculator calculator = new RPNCalculator();
        String line1 = "7 12 2 /\n";
        String stack = calculator.parseExpression(line1);
        Assert.assertEquals("7 6", stack);

        String line2 = "*\n";
        stack = calculator.parseExpression(line2);
        Assert.assertEquals("42", stack);

        String line3 = "4 /\n";
        stack = calculator.parseExpression(line3);
        Assert.assertEquals("10.5", stack);
    }

    @Test
    public void textExample6() {
        RPNCalculator calculator = new RPNCalculator();
        String line1 = "1 2 3 4 5\n";
        String stack = calculator.parseExpression(line1);
        Assert.assertEquals("1 2 3 4 5", stack);

        String line2 = "*\n";
        stack = calculator.parseExpression(line2);
        Assert.assertEquals("1 2 3 20", stack);

        String line3 = "clear 3 4 -\n";
        stack = calculator.parseExpression(line3);
        Assert.assertEquals("-1", stack);
    }

    @Test
    public void textExample7() {
        RPNCalculator calculator = new RPNCalculator();
        String line1 = "1 2 3 4 5\n";
        String stack = calculator.parseExpression(line1);
        Assert.assertEquals("1 2 3 4 5", stack);

        String line2 = "* * * *\n";
        stack = calculator.parseExpression(line2);
        Assert.assertEquals("120", stack);
    }

    @Test
    public void textExample8() {
        RPNCalculator calculator = new RPNCalculator();
        String line1 = "1 2 3 * 5 + * * 6 5\n";
        String stack = calculator.parseExpression(line1);
        Assert.assertEquals("11", stack);
    }
}
