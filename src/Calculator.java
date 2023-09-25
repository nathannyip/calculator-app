import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Arial", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;
    
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setSize(420, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("÷");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        decButton = new JButton(".");
        equButton = new JButton("=");
        negButton = new JButton("+/-");

        
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = delButton;
        functionButtons[5] = clrButton;
        functionButtons[6] = decButton;
        functionButtons[7] = equButton;
        functionButtons[8] = negButton;
        
        for(int i = 0; i < functionButtons.length; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(new Color(255,149,0));
            
        }

        for(int i = 0; i <10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Comfortaa", Font.PLAIN, 30));
            numberButtons[i].setForeground(Color.white);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(new Color(80,80,80));
        }
        
       
        //positions negative, delete, and clear function buttons.
        negButton.setBounds(50,430, 97,50);
        delButton.setBounds(155,430,95,50);
        clrButton.setBounds(255,430,95, 50);

        negButton.setFont(new Font("Ariel", Font.BOLD, 20));
        delButton.setFont(new Font("Ariel" , Font.BOLD, 16));
        clrButton.setFont(new Font("Ariel" , Font.BOLD, 16));

        
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.black);

        
       
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        
        


        frame.add(panel);
        frame.add(textField);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.setVisible(true);
        


    }

    public static void main (String[] args){
       

        Calculator calc = new Calculator();
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i<10; i++){
        if(e.getSource() == numberButtons[i]){
            textField.setText(textField.getText().concat(String.valueOf(i)));
        }
    }
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){
           num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subButton){
           num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

       

        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());
            switch(operator) {
                case '+':
                
                result = num1 + num2;
                break;

                case '-':
                result = num1 - num2;
                break;

                case '/':
              
                result = num1/ num2;
               
                break;

                case '*':
                result = num1 * num2;
                break;

            }
            if(result - (int)result == 0){
                int newResult = (int)result;
                textField.setText(String.valueOf(newResult));
            }
            else
            textField.setText(String.valueOf(result));
           
            num1 =result;
           
        
        }
         if(e.getSource() == negButton){
        if(textField.getText().substring(0,1).equals("-")){
            textField.setText(textField.getText().substring(1));
        }
        else
         textField.setText("-" + textField.getText());

        }
        if(e.getSource() == delButton){
           textField.setText(textField.getText().substring(0, textField.getText().length()-1));
        }
        if(e.getSource() == clrButton){
            textField.setText("");
        }
    
    }
}
