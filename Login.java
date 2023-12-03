package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login  extends JFrame implements ActionListener{
    JButton SignIN, Reset, SignUP;
    JTextField cardTextField;
    JPasswordField PinTextField;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);  
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        JLabel text = new JLabel("Welcome to ATM!!!");
        
        text.setFont(new Font("Osward", Font.BOLD,30));
        text.setBounds(200,40,400,40);
        add(text);
         JLabel cardNo = new JLabel("Enter your card Number : ");
        
        cardNo.setFont(new Font("Osward", Font.BOLD,20));
        cardNo.setBounds(120,130,250,30);
        add(cardNo);
        cardTextField = new JTextField();
        cardTextField.setBounds(380,130,200,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
         JLabel Pin = new JLabel("Enter your card Pin: ");
        
        Pin.setFont(new Font("Osward", Font.BOLD,20));
        Pin.setBounds(120,180,200,30);
        add(Pin);
        PinTextField = new JPasswordField();
        PinTextField.setBounds(380,180,200,30);
        add(PinTextField);
        SignIN = new JButton("Sign In");
        SignIN.setBounds(200,250,100,30);SignIN.setBackground(Color.BLACK);
        SignIN.setForeground(Color.WHITE);
        SignIN.addActionListener(this);
        add(SignIN);
        Reset = new JButton("Reset");
        Reset.setBounds(400,250,100,30);
        Reset.setBackground(Color.BLACK);
        Reset.setForeground(Color.WHITE);
        Reset.addActionListener(this);
        add(Reset);
        SignUP = new JButton("Sign Up");
        SignUP.setBounds(300,300,100,30);
        SignUP.setBackground(Color.BLACK);
        SignUP.setForeground(Color.WHITE);
        SignUP.addActionListener(this);
        add(SignUP);
        getContentPane().setBackground(Color.WHITE);
        setSize(800,600);
        setVisible(true);
        setLocation(250,100);
        
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == SignIN){
            Conn c = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = PinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect CardNumber or PIN");
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
            if (cardnumber.equals("")){
                
            }
        }
        else if (ae.getSource() == Reset){
            cardTextField.setText("");
            PinTextField.setText("");
        }
        else if (ae.getSource() == SignUP){
            setVisible(false);
            new SignUp1().setVisible(true);
        }
        else{

        }
    }
    public static void main(String[] args) {
        new Login();

    }
}