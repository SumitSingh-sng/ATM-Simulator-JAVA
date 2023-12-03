
package bank.management.system;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BalanceEnquiry extends JFrame implements ActionListener {
    
    String pinnumber;
    int balance;
    JButton ok;
    
    public BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Current Balance is : ");
        text.setFont(new Font("System",Font.BOLD,20));
        text.setBounds(180,300,450,30);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        try{
            Conn c = new Conn();
            String query = "select * from bank where pin = '"+pinnumber+"'";
            ResultSet rs = c.s.executeQuery(query);
            balance = 0;
            while(rs.next()){
            if(rs.getString("type").equals("Deposit")){
                balance += Integer.parseInt(rs.getString("amount"));
            }
            else if(rs.getString("type").equals("Withdraw")){
                balance -= Integer.parseInt(rs.getString("amount"));
            }
        }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        JLabel currentBalance = new JLabel("Rs. "+balance);
        currentBalance.setFont(new Font("System",Font.BOLD,20));
        currentBalance.setBounds(210,350,450,30);
        currentBalance.setForeground(Color.WHITE);
        image.add(currentBalance);
        
        ok = new JButton("OK");
        ok.setBounds(365,415,150,30);
        ok.setFont(new Font("System",Font.BOLD,20));
        ok.addActionListener(this);
        image.add(ok);
        
        setUndecorated(true);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
 
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == ok){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    
    
    public static void main(String[] args){
        new BalanceEnquiry("");
        
    }
}
