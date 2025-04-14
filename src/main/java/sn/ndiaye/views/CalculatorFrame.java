package sn.ndiaye.views;

import sn.ndiaye.domain.Calculator;
import sn.ndiaye.domain.Controller;

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
    private Controller controller;

    private JPanel numbersPanel;
    private JPanel operationsPanel;


    public CalculatorFrame(Controller controller) {
        this.setTitle("Calculator");
        this.setSize(300, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        addInputDisplay();
        addNumbersGrid();
        addOperationsGrid();
        this.setVisible(true);

        this.controller = controller;
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
            // Text on buttons
            opButtons[i] = new JButton(operations[i]);

            // Action on arithmetic buttons press
            if (opButtons[i].getText().matches("[\\+\\-\\*\\/]")) // arithmetic operation
                opButtons[i].addActionListener((ActionEvent e) -> {
                    JButton btn = (JButton) e.getSource();
                    inputDisplay.setText(inputDisplay.getText() + btn.getText());
                });

            // Action on clear button press
            else if (opButtons[i].getText().equals("C"))
                opButtons[i].addActionListener((ActionEvent e) -> {
                    enableAllButtons();
                    inputDisplay.setText("");
                });

            // Action on '=' button press
            else
                opButtons[i].addActionListener((ActionEvent e) -> {
                    disableAllButtons();
                    controller.process();
                });

            operationsPanel.add(opButtons[i]);
        }
    }

    private void disableAllButtons() {
        Arrays.stream(numbersPanel.getComponents())
                .filter(c -> c instanceof JButton)
                .forEach(c -> c.setEnabled(false));

        Arrays.stream(operationsPanel.getComponents())
                .filter(c -> c instanceof JButton &&
                        !((JButton) c).getText().equals("C"))
                .forEach(c -> c.setEnabled(false));
    }

    private void enableAllButtons() {
        Arrays.stream(numbersPanel.getComponents())
                .filter(c -> c instanceof JButton)
                .forEach(c -> c.setEnabled(true));

        Arrays.stream(operationsPanel.getComponents())
                .filter(c -> c instanceof JButton)
                .forEach(c -> c.setEnabled(true));

    }

    public JTextField getInputDisplay() {
        return inputDisplay;
    }
}
