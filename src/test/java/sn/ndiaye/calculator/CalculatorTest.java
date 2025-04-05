package sn.ndiaye.calculator;

import org.junit.jupiter.api.Test;
import sn.ndiaye.domain.Calculator;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculatorTest {
    private static Calculator calculator = new Calculator();

    @Test
    void basic_plus_operation_works() {
        BigDecimal n1 = new BigDecimal(2);
        BigDecimal n2 = new BigDecimal(3);
        String excepted = "5";
        assertThat(calculator.result(n1, n2, "+"))
                .isEqualTo(excepted);
    }

    @Test
    void basic_minus_operation_works() {
        BigDecimal n1 = new BigDecimal(2);
        BigDecimal n2 = new BigDecimal(3);
        String expected = "-1";
        assertThat(calculator.result(n1, n2, "-"))
                .isEqualTo(expected);
    }

    @Test
    void basic_multiply_operation_works() {
        BigDecimal n1 = new BigDecimal(2);
        BigDecimal n2 = new BigDecimal(3);
        String expected = "6";
        assertThat(calculator.result(n1, n2,"*"))
                .isEqualTo(expected);
    }

    @Test
    void basic_divide_operation_works() {
        BigDecimal n1 = new BigDecimal(3);
        BigDecimal n2 = new BigDecimal(2);
        String expected = "1.5";
        assertThat(calculator.result(n1, n2, "/"))
                .isEqualTo(expected);
    }

    @Test
    void dividing_by_zero_is_unsuccessful() {
        BigDecimal n1 = new BigDecimal(2);
        BigDecimal n2 = new BigDecimal(0);
        String expected = "MATH ERROR";
        assertThat(calculator.result(n1, n2, "/"))
                .isEqualTo(expected);
    }

    @Test
    void floating_points_are_precise() {
        BigDecimal n1 = new BigDecimal(String.valueOf(5.6));
        BigDecimal n2 = new BigDecimal(String.valueOf(5.8));
        String expected = "11.4";
        assertThat(calculator.result(n1, n2,"+"))
                .isEqualTo(expected);
        
    }

}
