package sn.ndiaye.views;

import javax.swing.*;
import java.awt.*;


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
        numbersPanel.add(new JButton("1"));
        numbersPanel.add(new JButton("2"));
        numbersPanel.add(new JButton("3"));
        numbersPanel.add(new JButton("4"));
        numbersPanel.add(new JButton("5"));
        numbersPanel.add(new JButton("6"));
        numbersPanel.add(new JButton("7"));
        numbersPanel.add(new JButton("8"));
        numbersPanel.add(new JButton("9"));
        numbersPanel.add(new JButton("0"));
        numbersPanel.add(new JButton("."));
        numbersPanel.add(new JButton("+/-"));

    }

    private void addOperationsGrid() {
        operationsPanel = new JPanel();
        operationsPanel.setLayout(new GridLayout(3,2));
        operationsPanel.setBounds(200, 100, 85, 200);
        addOperationButtons();
        this.add(operationsPanel);
    }

    private void addOperationButtons() {
        operationsPanel.add(new JButton("+"));
        operationsPanel.add(new JButton("-"));
        operationsPanel.add(new JButton("*"));
        operationsPanel.add(new JButton("/"));
        operationsPanel.add(new JButton("del"));
        operationsPanel.add(new JButton("="));
    }

    public static void main(String[] args) {
        new CalculatorFrame();
    }
}
