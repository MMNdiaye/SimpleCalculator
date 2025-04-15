package sn.ndiaye.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sn.ndiaye.domain.Controller;

class ControllerTest {
    static Controller simpleController;
    @BeforeAll
    static void init() {
        simpleController = new Controller();
    }
    @AfterAll
    static void cleanup() {
        simpleController = null;
    }

    @Test
    void controller_should_have_a_frame() {
        assertThat(simpleController.getWindow()).isNotNull();
    }

    @Test
    void controller_should_have_a_calculator() {
        assertThat(simpleController.getCalculator()).isNotNull();
    }

    @Test
    void controller_should_have_a_syntax_checker() {
        assertThat(simpleController.getSyntaxChecker()).isNotNull();
    }

    @Test
    void controller_should_process_simple_operations() {
        String operation = "15/3";
        simpleController.process(operation);
        String result = simpleController.getWindow().getInputDisplay().getText();
        assertThat(result).isEqualTo("5");
    }


    @Test
    void controller_should_process_operations_starting_with_negative_sign() {
        String operation = "-15+6";
        simpleController.process(operation);
        String result = simpleController.getWindow().getInputDisplay().getText();
        assertThat(result).isEqualTo("-9");
    }

    @Test
    void controller_should_process_operations_with_a_negative_sign_after_another_sign() {
        String operation = "3*-7";
        simpleController.process(operation);
        String result = simpleController.getWindow().getInputDisplay().getText();
        assertThat(result).isEqualTo("-21");
    }

}
