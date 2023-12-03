
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class PinChange extends JFrame implements ActionListener{
    String pinnumber;
    JPasswordField oldpin,newpin,confirmpin;
     JButton submit,cancel,clear;
    
    
    public PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System",Font.BOLD,20));
        text.setBounds(180,300,450,30);
         text.setForeground(Color.WHITE);
         image.add(text);
        
         JLabel oldpintext =  new JLabel("Enter your Current Pin :");
         oldpintext.setFont(new Font("System",Font.BOLD,15));
        oldpintext.setBounds(180,350,200,20);
         oldpintext.setForeground(Color.WHITE);
         image.add(oldpintext);
         oldpin = new JPasswordField();
        oldpin.setFont(new Font("System",Font.BOLD,15));
        oldpin.setBounds(360,350,100,20);
         image.add(oldpin);
         
          JLabel newpintext =  new JLabel("Enter your New Pin :");
         newpintext.setFont(new Font("System",Font.BOLD,15));
        newpintext.setBounds(180,380,200,20);
         newpintext.setForeground(Color.WHITE);
         image.add(newpintext);
         newpin = new JPasswordField();
        newpin.setFont(new Font("System",Font.BOLD,15));
        newpin.setBounds(360,380,100,20);
         image.add(newpin);
         
          JLabel confirmpintext =  new JLabel("Re-Enter your New Pin :");
         confirmpintext.setFont(new Font("System",Font.BOLD,15));
        confirmpintext.setBounds(180,410,200,20);
         confirmpintext.setForeground(Color.WHITE);
         image.add(confirmpintext);
         confirmpin = new JPasswordField();
        confirmpin.setFont(new Font("System",Font.BOLD,15));
        confirmpin.setBounds(360,410,100,20);
         image.add(confirmpin);
         
          submit = new JButton("Submit");
        submit.setBounds(415,450,100,30);
        submit.setFont(new Font("System",Font.BOLD,15));
        submit.addActionListener(this);
        image.add(submit);
        
         clear = new JButton("Clear");
        clear.setBounds(415,485,100,30);
        clear.setFont(new Font("System",Font.BOLD,15));
        clear.addActionListener(this);
        image.add(clear);
        
         cancel = new JButton("Cancel");
        cancel.setBounds(415,520,100,30);
        cancel.setFont(new Font("System",Font.BOLD,15));
        cancel.addActionListener(this);
        image.add(cancel);
        
        setUndecorated(true);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
                Conn c = new Conn();
                String oldpins = oldpin.getText();
                String newpins = newpin.getText();
                String confirmpins = confirmpin.getText();
                if(oldpins.equals("") || newpins.equals("") || confirmpins.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter the fields");
                }
                else if(!(pinnumber.equals(oldpins))){
                    JOptionPane.showMessageDialog(null,"Incorrect Current pin!!");
                }
                else if(!(newpins.equals(confirmpins))){
                    JOptionPane.showMessageDialog(null,"New pin does not match!!");
                }
                else{
                    String query1 = "update bank set pin = '"+newpins+"' where pin = '"+pinnumber+"'";
                    String query2 = "update signupthree set pin = '"+newpins+"' where pin = '"+pinnumber+"'";
                    String query3 = "update login set pin = '"+newpins+"' where pin = '"+pinnumber+"'";
                    
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null,"PIN changed successfully");
                    setVisible(false);
                    new Transactions(newpins).setVisible(true);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource() == clear){
            oldpin.setText("");
            newpin.setText("");
            confirmpin.setText("");
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    
    public static void main(String[] args){
        
        
        
     new PinChange("");
    }
}
