package sn.ndiaye.views;

import sn.ndiaye.domain.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Arrays;


public class CalculatorFrame extends JFrame {
    private JTextField inputDisplay;
    private static Color inputForeColor = Color.GREEN;
    private static Color inputBgColor = Color.BLACK;

    private JPanel numbersPanel;
    private JPanel operationsPanel;

    public CalculatorFrame() {
        this.setTitle("Calculator");
        this.setSize(300, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        addInputDisplay();
        addNumbersGrid();
        addOperationsGrid();
        this.setVisible(true);
    }

    private void addInputDisplay() {
        inputDisplay = new JTextField();
        inputDisplay.setFont(new Font("Sans serif", Font.PLAIN, 20));
        inputDisplay.setForeground(inputForeColor);
        inputDisplay.setBackground(inputBgColor);
        inputDisplay.setEditable(false);
        inputDisplay.setBounds(10, 10, 250, 40);
        this.add(inputDisplay);
    }

    private void addNumbersGrid() {
        numbersPanel = new JPanel();
        numbersPanel.setLayout(new GridLayout(4,3, 5, 5));
        numbersPanel.setBounds(10, 60, 180, 300);
        addNumberButtons();
        this.add(numbersPanel);
    }

    private void addNumberButtons() {
        JButton[] numbers = new JButton[10];
        for (int i = 1; i <= 10; i++) {
            if (i == 10)
                i = 0;
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener((ActionEvent e) -> {
                JButton btn = (JButton) e.getSource();
                inputDisplay.setText(inputDisplay.getText() + btn.getText());
            });
            numbersPanel.add(numbers[i]);
            if (i == 0)
                break;
        }
        JButton pointButton = new JButton(".");
        JButton signButton = new JButton("+/-");
        signButton.setName("-");

        pointButton.addActionListener((ActionEvent e) -> {
            JButton btn = (JButton)e.getSource();
            inputDisplay.setText(inputDisplay.getText() + btn.getText());
        });

        signButton.addActionListener((ActionEvent e) -> {
            JButton btn = (JButton)e.getSource();
            String sign = btn.getName();
            inputDisplay.setText(sign + inputDisplay.getText()
                    .replace("-", ""));
            sign = (sign.equals("-"))? "" : "-";
            btn.setName(sign);
        });

        numbersPanel.add(pointButton);
        numbersPanel.add(signButton);
    }

    private void addOperationsGrid() {
        operationsPanel = new JPanel();
        operationsPanel.setLayout(new GridLayout(3,2));
        operationsPanel.setBounds(200, 100, 85, 200);
        addOperationButtons();
        this.add(operationsPanel);
    }

    private void addOperationButtons() {
        JButton[] opButtons = new JButton[6];
        String[] operations = {"+", "-", "*", "/", "C", "="};
        for (int i = 0; i < opButtons.length; i++) {
            opButtons[i] = new JButton(operations[i]);

            if (opButtons[i].getText().matches("[\\+\\-\\*\\/]")) // arithmetic operation
                opButtons[i].addActionListener((ActionEvent e) -> {
                    JButton btn = (JButton) e.getSource();
                    inputDisplay.setText(inputDisplay.getText() + btn.getText());
                });

            else if (opButtons[i].getText().equals("C"))
                opButtons[i].addActionListener((ActionEvent e) -> {
                    JButton btn = (JButton) e.getSource();
                    inputDisplay.setText("");
                });

            else // '=' button pressed
                opButtons[i].addActionListener((ActionEvent e) -> {
                    String fullOperation = inputDisplay.getText();
                    String pattern = "\\d+[\\+\\-\\*\\/]\\d+";

                    if (fullOperation.matches(pattern)) {
                        String[] nums = fullOperation.split("[\\+\\-\\*\\/]");
                        String[] operation = fullOperation.split("\\d+");
                        BigDecimal num1 = new BigDecimal(nums[0]);
                        BigDecimal num2 = new BigDecimal(nums[1]);
                        inputDisplay.setText(fullOperation + "=" +
                                new Calculator().result(num1, num2, operation[1]));
                    }
                });

            operationsPanel.add(opButtons[i]);
        }
    }

    public static void main(String[] args) {
        new CalculatorFrame();
    }
}
