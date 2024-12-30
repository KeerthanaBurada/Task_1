import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculatorGUI extends JFrame implements ActionListener {
    // Components of the GUI
    private JTextField num1Field, num2Field, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton;

    public SimpleCalculatorGUI() {
        // Frame setup
        setTitle("Simple Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Input fields and labels
        JLabel num1Label = new JLabel("Enter First Number:");
        num1Field = new JTextField();

        JLabel num2Label = new JLabel("Enter Second Number:");
        num2Field = new JTextField();

        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);

        // Operation buttons
        addButton = new JButton("Add (+)");
        subtractButton = new JButton("Subtract (-)");
        multiplyButton = new JButton("Multiply (*)");
        divideButton = new JButton("Divide (/)");

        // Add action listeners
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        // Add components to the frame
        add(num1Label);
        add(num1Field);
        add(num2Label);
        add(num2Field);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);
        add(resultLabel);
        add(resultField);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Parse input numbers
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            // Determine the operation
            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Error: Division by zero is not allowed.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                result = num1 / num2;
            }

            // Display the result
            resultField.setText(String.format("%.2f", result));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Run the calculator GUI
        new SimpleCalculatorGUI();
    }
}
