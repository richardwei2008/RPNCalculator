package com.interview.calculator.util;

public class NumericUtil {


    /**
     * match a number with optional '-' and decimal.
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

}
