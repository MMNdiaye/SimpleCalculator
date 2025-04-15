package sn.ndiaye.domain;

import java.math.BigDecimal;

public class Calculator {
    private final static String MATH_ERROR = "MATH ERROR";

    public String result(BigDecimal n1, BigDecimal n2, String operation) {

        String result = "";
        try {
            switch (operation) {
                case "+":
                    result = String.valueOf(n1.add(n2));
                    break;

                case "-":
                    result = String.valueOf(n1.subtract(n2));
                    break;

                case "*":
                    result = String.valueOf(n1.multiply(n2));
                    break;

                case "/":
                    result = String.valueOf(n1.divide(n2));
                    break;

                default:
                    result = MATH_ERROR;
                    break;
            }
            return result;
        } catch (ArithmeticException e) {
            return MATH_ERROR;
        }
    }

    private String plus(Number n1, Number n2) {
        return "";
    }

    private String minus(Number n1, Number n2) {
        return String.valueOf(n1.doubleValue() - n2.doubleValue());
    }

    private String multiply(Number n1, Number n2) {
        return String.valueOf(n1.doubleValue() * n2.doubleValue());
    }

    private String divide(Number n1, Number n2) throws ArithmeticException{
        if (n2.doubleValue() == 0)
            throw new ArithmeticException();
        return String.valueOf(n1.doubleValue() / n2.doubleValue());
    }


}
