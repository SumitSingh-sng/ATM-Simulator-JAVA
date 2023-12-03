
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener{
    
    JButton submit,clear,back;
    JTextField amount;
    String pinnumber;
    
    public Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);  
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to deposit:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,15));
        text.setBounds(180,300,500,30);
        image.add(text);
         amount = new JTextField();
        amount.setFont(new Font("System",Font.BOLD,20));
        amount.setBounds(180,350,300,30);
        image.add(amount);
         submit = new JButton("Submit");
        submit.setBounds(360,450,150,30);
        submit.setFont(new Font("System",Font.BOLD,15));
        submit.addActionListener(this);
        image.add(submit);
         clear = new JButton("Clear");
        clear.setBounds(360,485,150,30);
        clear.setFont(new Font("System",Font.BOLD,15));
         clear.addActionListener(this);
        image.add(clear);
         back = new JButton("Exit");
        back.setBounds(360,520,150,30);
        back.setFont(new Font("System",Font.BOLD,15));
         back.addActionListener(this);
        image.add(back);
        
        setUndecorated(true);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
                String amount = this.amount.getText();
                Date d = new Date();
                if(amount.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter the amount to be deposited");
                }
                else{
                Conn c = new Conn();
                String query = "insert into bank values('"+pinnumber+"','"+d+"','Deposit','"+amount+"')";
                JOptionPane.showMessageDialog(null,"'"+amount+"' successfully credited to the acccount");
                c.s.executeUpdate(query);
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == clear){
            amount.setText("");
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    
    
    
    public static void main(String[] args){
        new Deposit("");
    }
}
