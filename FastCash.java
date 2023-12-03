
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener{
    String pinnumber;
    JButton exit,o1,o3,o4,o2;
     public FastCash(String pinnumber){
         this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);  
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel text = new JLabel("Select Withdrawal amount : ");
        text.setFont(new Font("System",Font.BOLD,20));
        text.setBounds(180,300,500,30);
        text.setForeground(Color.WHITE);
        image.add(text);
         o1 = new JButton("1000");
        o1.setBounds(170,415,150,30);
        o1.addActionListener(this);
        image.add(o1);
          o2 = new JButton("5000");
        o2.setBounds(355,415,150,30);
        o2.addActionListener(this);
        image.add(o2);
         o3 = new JButton("10000");
        o3.setBounds(170,450,150,30);
        o3.addActionListener(this);
        image.add(o3);
        o4 = new JButton("15000");
        o4.setBounds(355,450,150,30);
        o4.addActionListener(this);
        image.add(o4);
         exit = new JButton("Exit");
        exit.setBounds(170,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
//        setUndecorated(true);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
     }
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
         }
        else{
            String amount = ((JButton)ae.getSource()).getText();
            try{
                Conn c = new Conn();
                java.util.Date d = new java.util.Date();
                ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(balance >= Integer.parseInt(amount)){
                    String query = "insert into bank values('"+pinnumber+"','"+d+"','Withdraw','"+amount+"')";
                JOptionPane.showMessageDialog(null,"'"+amount+"' successfully debited from the acccount");
                c.s.executeUpdate(query);
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
     }
     
     public static void main(String[] args){
         new FastCash("");
     }
        
}
