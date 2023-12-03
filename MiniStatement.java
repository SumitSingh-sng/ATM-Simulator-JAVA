
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class MiniStatement extends JFrame implements ActionListener{
    String pinnumber;
    JLabel cardnumber,mini;
    JButton ok;
    public MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel bank = new JLabel("Sumit Bank");
        bank.setBounds(275,280,200,30);
        bank.setForeground(Color.WHITE);
        bank.setFont(new Font("System",Font.BOLD,20));
        image.add(bank);
        int i=0;
        try{
            Conn c = new Conn();
            String query = "select * from login where pin = '"+pinnumber+"'";
            ResultSet rs = c.s.executeQuery(query);
            String text="";
            while(rs.next()){
                text = rs.getString("cardnumber").substring(12);
            }
            cardnumber = new JLabel("Card Number : XXXX XXXX XXXX "+text);
            cardnumber.setBounds(170,320,300,30);
            cardnumber.setForeground(Color.WHITE);
            cardnumber.setFont(new Font("System",Font.BOLD,15));
            image.add(cardnumber);
            String query1 = "select * from bank where pin = '"+pinnumber+"' ";
            ResultSet rs1 = c.s.executeQuery(query1);
            mini = new JLabel("");
            while(rs1.next() && i<5){
                i++;
                mini.setText(mini.getText()+ "<html>" + rs1.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs1.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("amount")+"<br><br><html>");
            }
            mini.setBounds(160,350,500,200);
            mini.setForeground(Color.WHITE);
            mini.setFont(new Font("System",Font.BOLD,12));
            image.add(mini);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        ok = new JButton("OK");
        ok.setBounds(365,520,150,30);
        ok.setFont(new Font("System",Font.BOLD,20));
        ok.addActionListener(this);
        image.add(ok);
        
        
        
        setUndecorated(false);
        setLocation(300,0);
        setSize(900,900);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == ok){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }
    
    public static void main(String[] args){
        new MiniStatement("2849");
    }
    
    
    
    
    
    
    
    
    
    
    
}
