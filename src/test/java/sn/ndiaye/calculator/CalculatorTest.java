package sn.ndiaye.calculator;

import org.junit.jupiter.api.Test;
import sn.ndiaye.domain.Calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculatorTest {
    private static Calculator calculator = new Calculator();

    @Test
    void basic_plus_operation_works() {
        String excepted = "5.0";
        assertThat(calculator.result(2, 3, "+"))
                .isEqualTo(excepted);
    }

    @Test
    void basic_minus_operation_works() {
        String expected = "-1.0";
        assertThat(calculator.result(2, 3, "-"))
                .isEqualTo(expected);
    }

    @Test
    void basic_multiply_operation_works() {
        String expected = "6.0";
        assertThat(calculator.result(2, 3, "*"))
                .isEqualTo(expected);
    }

    @Test
    void basic_divide_operation_works() {
        String expected = "1.5";
        assertThat(calculator.result(3, 2, "/"))
                .isEqualTo(expected);
    }

    @Test
    void dividing_by_zero_is_unsuccessful() {
        String expected = "MATH ERROR";
        assertThat(calculator.result(3, 0, "/"))
                .isEqualTo(expected);
    }

}
