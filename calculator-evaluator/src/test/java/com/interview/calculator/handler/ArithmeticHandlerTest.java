package com.interview.calculator.handler;

import com.interview.calculator.core.exception.UnknownOperatorException;
import com.interview.calculator.handler.atomic.ArithmeticHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

@Slf4j
public class ArithmeticHandlerTest {

    @Test
    public void testAdd() {
        BigDecimal a = new BigDecimal("2.4");
        BigDecimal b = new BigDecimal("1.3");
        String operator = "+";

        BigDecimal res = new ArithmeticHandler().calculate(operator, a, b);

        log.info("Result: {}", res);
        Assert.assertEquals(0, new BigDecimal("3.7").compareTo(res));
    }

    @Test
    public void testSubstract() {
        BigDecimal a = new BigDecimal("2.4");
        BigDecimal b = new BigDecimal("1.3");
        String operator = "-";

        BigDecimal res = new ArithmeticHandler().calculate(operator, a, b);

        log.info("Result: {}", res);
        Assert.assertEquals(0, new BigDecimal("1.1").compareTo(res));
    }

    @Test
    public void testMultiply() {
        BigDecimal a = new BigDecimal("2.4");
        BigDecimal b = new BigDecimal("1.3");
        String operator = "*";

        BigDecimal res = new ArithmeticHandler().calculate(operator, a, b);

        log.info("Result: {}", res);
        Assert.assertEquals(0, new BigDecimal("3.12").compareTo(res));
    }

    @Test
    public void testDivide() {
        BigDecimal a = new BigDecimal("2.4");
        BigDecimal b = new BigDecimal("1.2");
        String operator = "/";

        BigDecimal res = new ArithmeticHandler().calculate(operator, a, b);

        log.info("Result: {}", res);
        Assert.assertEquals(0, new BigDecimal("2").compareTo(res));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivide_error() {
        BigDecimal a = new BigDecimal("4");
        BigDecimal b = new BigDecimal("0");
        String operator = "/";

        BigDecimal res = new ArithmeticHandler().calculate(operator, a, b);

        log.info("Result: {}", res);
        Assert.assertEquals(0, new BigDecimal("2").compareTo(res));
    }

    @Test
    public void testSqrt() {
        BigDecimal a = new BigDecimal("1.44");
        String operator = "sqrt";

        BigDecimal res = new ArithmeticHandler().calculate(operator, a, null);

        log.info("Result: {}", res);
        Assert.assertEquals(0, new BigDecimal("1.2").compareTo(res));
    }

    @Test
    public void testSqrt_infinite() {
        BigDecimal a = new BigDecimal("1.2");
        String operator = "sqrt";

        BigDecimal res = new ArithmeticHandler().calculate(operator, a, null);

        log.info("Result: {}", res);
        Assert.assertEquals(-1, res.subtract(new BigDecimal("1.095445")).compareTo(new BigDecimal("0.000001")));
    }

    @Test(expected = UnknownOperatorException.class)
    public void testOperator_unknown() {
        BigDecimal a = new BigDecimal("1.2");
        BigDecimal b = new BigDecimal("1.2");
        String operator = "!";

        BigDecimal res = new ArithmeticHandler().calculate(operator, a, b);

        log.info("Result: {}", res);
    }
}
