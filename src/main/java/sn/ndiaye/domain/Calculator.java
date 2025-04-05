package sn.ndiaye.domain;

public class Calculator {
    private final static String MATH_ERROR = "MATH ERROR";

    public String result(Number n1, Number n2, String operation) {
        String result = "";
        try {
            switch (operation) {
                case "+":
                    result = plus(n1, n2);
                    break;

                case "-":
                    result = minus(n1, n2);
                    break;

                case "*":
                    result = multiply(n1, n2);
                    break;

                case "/":
                    result = divide(n1, n2);
            }
            return result;
        } catch (ArithmeticException e) {
            return MATH_ERROR;
        }
    }

    private String plus(Number n1, Number n2) {
        return String.valueOf(n1.doubleValue() + n2.doubleValue());
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
