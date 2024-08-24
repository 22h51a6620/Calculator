package rule;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calci implements ActionListener {
	    JFrame frame;
	    JTextField textField;
	    JButton[] numberButtons = new JButton[10];
	    JButton addButton, subtractButton, multiplyButton, divideButton, equalButton, clearButton;
	    JPanel panel;

	    double number1, number2, result;
	    char operation;

	    public calci() {
	        createGUI();
	    }

	    public void createGUI() {
	        frame = new JFrame("Calculator");
	        frame.setSize(200, 250);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        textField = new JTextField();
	        frame.add(textField, BorderLayout.NORTH);

	        panel = new JPanel();
	        panel.setLayout(new GridLayout(4, 4));
	        frame.add(panel, BorderLayout.CENTER);

	        for (int i = 0; i < 10; i++) {
	            numberButtons[i] = new JButton(String.valueOf(i));
	            numberButtons[i].addActionListener(this);
	            panel.add(numberButtons[i]);
	        }

	        addButton = new JButton("+");
	        subtractButton = new JButton("-");
	        multiplyButton = new JButton("*");
	        divideButton = new JButton("/");
	        equalButton = new JButton("=");
	        clearButton = new JButton("Clear");

	        addButton.addActionListener(this);
	        subtractButton.addActionListener(this);
	        multiplyButton.addActionListener(this);
	        divideButton.addActionListener(this);
	        equalButton.addActionListener(this);
	        clearButton.addActionListener(this);

	        panel.add(addButton);
	        panel.add(subtractButton);
	        panel.add(multiplyButton);
	        panel.add(divideButton);
	        panel.add(equalButton);
	        panel.add(clearButton);

	        frame.setVisible(true);
	    }

	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() instanceof JButton) {
	            JButton button = (JButton) e.getSource();
	            String text = button.getText();

	            if (text.equals("+")) {
	                number1 = Double.parseDouble(textField.getText());
	                operation = '+';
	                textField.setText("");
	            } else if (text.equals("-")) {
	                number1 = Double.parseDouble(textField.getText());
	                operation = '-';
	                textField.setText("");
	            } else if (text.equals("*")) {
	                number1 = Double.parseDouble(textField.getText());
	                operation = '*';
	                textField.setText("");
	            } else if (text.equals("/")) {
	                number1 = Double.parseDouble(textField.getText());
	                operation = '/';
	                textField.setText("");
	            } else if (text.equals("=")) {
	                number2 = Double.parseDouble(textField.getText());
	                switch (operation) {
	                    case '+':
	                        result = number1 + number2;
	                        break;
	                    case '-':
	                        result = number1 - number2;
	                        break;
	                    case '*':
	                        result = number1 * number2;
	                        break;
	                    case '/':
	                        result = number1 / number2;
	                        break;
	                }
	                textField.setText(String.valueOf(result));
	            } else if (text.equals("Clear")) {
	                textField.setText("");
	            } else {
	                textField.setText(textField.getText() + text);
	            }
	        }
	    }

	    public static void main(String[] args) {
	        new calci();
	    }
	}

