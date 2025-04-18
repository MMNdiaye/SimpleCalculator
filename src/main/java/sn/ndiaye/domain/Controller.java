package sn.ndiaye.domain;

import sn.ndiaye.views.CalculatorFrame;

import java.math.BigDecimal;

public final class Controller {
    private Calculator calculator;
    private SyntaxChecker syntaxChecker;
    private CalculatorFrame window;

    public Controller() {
        this(1);
    }

    public Controller(int option) {
        calculator = new Calculator();
        switch (option) {
            case 1:
                createBasicOperations();
                break;

            default:
                createBasicOperations();
                break;
        }

    }

    private void createBasicOperations() {
        window = new CalculatorFrame(this);
        syntaxChecker = new SimpleSyntaxChecker();
    }

    public void process(String fullOperation) {
        String result = "";
        if (syntaxChecker.check(fullOperation)) {
            // For the future, implements order manager
            String numSplitPattern = "(?<=\\d)([\\+\\-\\*\\/])";
            String[] nums = fullOperation.split(numSplitPattern);
            String opSplitPattern = "\\d+(\\.\\d+)?|(?<=[\\+\\-\\*\\/])(\\-)";
            String[] operation = fullOperation.split(opSplitPattern);
            BigDecimal num1 = new BigDecimal(nums[0]);
            BigDecimal num2 = new BigDecimal(nums[1]);
            result = calculator.result(num1, num2, operation[1]);
        }

        else
            result = syntaxChecker.SYNTAX_ERROR;
        window.getInputDisplay().setText(result);
    }

    public void start() {
        this.window.setVisible(true);
    }

    public CalculatorFrame getWindow() {
        return window;
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public SyntaxChecker getSyntaxChecker() {
        return syntaxChecker;
    }
}
