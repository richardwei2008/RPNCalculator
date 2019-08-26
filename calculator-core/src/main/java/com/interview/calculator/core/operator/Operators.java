package com.interview.calculator.core.operator;

public class Operators {

    public static final String ADD = "+";

    public static final String SUBSTRACT = "-";

    public static final String MULTIPLY = "*";

    public static final String DIVIDE = "/";

    public static final String SQRT = "sqrt";

    public static final String UNDO = "undo";

    public static final String CLEAR = "clear";

    public static String[] values() {
        return new String[] {ADD, SUBSTRACT, MULTIPLY, DIVIDE, SQRT, UNDO, CLEAR};
    }

    public static boolean contains(String operator) {
        for (String key : values()) {
            if (operator.equals(key)) {
                return true;
            }
        }
        return false;
    }

}
