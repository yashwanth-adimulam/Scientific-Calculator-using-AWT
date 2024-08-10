import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AwtCalculator extends Frame implements ActionListener {
   // Textfield to display input and result
   private TextField textField;
   // Store the first and second operand along with the operator
   private double firstOperand, secondOperand;
   private char operator;
   // Constructor to set up the UI
   public AwtCalculator() {
   // Set layout
     setLayout(new BorderLayout());
     // Create textfield
     textField = new TextField();
     textField.setFont(new Font("Arial", Font.PLAIN, 20));
     add(textField, BorderLayout.NORTH);
     // Create buttons panel
     Panel panel = new Panel();
     panel.setLayout(new GridLayout(4, 4));
     // Create numeric buttons
     for (int i = 1; i <= 9; i++) {
       Button button = new Button(String.valueOf(i));
       button.addActionListener(this);
       panel.add(button);
     }
     // Create operator buttons
     String[] operators = {"+", "-", "*", "/"};
     for (String op : operators) {
       Button button = new Button(op);
       button.addActionListener(this);
       panel.add(button);
     }
     // Create zero button
     Button zeroButton = new Button("0");
     zeroButton.addActionListener(this);
     panel.add(zeroButton);
     // Create equals button
     Button equalsButton = new Button("=");
     equalsButton.addActionListener(this);
     panel.add(equalsButton);
     // Create clear button
     Button clearButton = new Button("C");
     clearButton.addActionListener(this);
     panel.add(clearButton);
     add(panel, BorderLayout.CENTER);
     // Set up frame properties
     setTitle("AWT Calculator");
     setSize(400, 500);
     setResizable(false);
     setVisible(true);
   }
     // ActionListener implementation
     public void actionPerformed(ActionEvent e) {
       String command = e.getActionCommand();
       if (Character.isDigit(command.charAt(0))) {
         textField.setText(textField.getText() + command);
       }
       else if (command.equals("C")) {
         textField.setText("");
         firstOperand = secondOperand = 0;
         operator = '\u0000';
       }
       else if (command.equals("=")) {
         secondOperand = Double.parseDouble(textField.getText());
         calculate();
         operator = '\u0000';
       }
       else {
         firstOperand = Double.parseDouble(textField.getText());
         operator = command.charAt(0);
         textField.setText("");
       }
       }
       private void calculate() {
         switch (operator) {
           case '+':
             firstOperand += secondOperand;
             break;
           case '-':
             firstOperand -= secondOperand;
             break;
           case '*':
             firstOperand *= secondOperand;
             break;
           case '/':
             if (secondOperand != 0) {
               firstOperand /= secondOperand;
             }
             else {
               textField.setText("Error: Division by zero");
               return;
             }
             break;
         }
         textField.setText(String.valueOf(firstOperand));
     } 
     public static void main(String[] args) {
     new AwtCalculator();
   }
}
