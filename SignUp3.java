
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUp3 extends JFrame implements ActionListener{
    JLabel l1, type,cardNo,number,detail,pnumber,pdetail,pin,service;
    JRadioButton saving, current,fd,rac; 
    JCheckBox service1,service2,service3,service4,service5,service6,declaration;
    JButton submit, cancel ;
    String formno;
    public SignUp3(String formno){
        this.formno = formno;
        setLayout(null);
        setForeground(Color.BLACK);
        setTitle("Sign Up Page 3");
         l1 = new JLabel("Page 3: Account Details");
        l1.setBounds(250,10,450,30);
        l1.setFont(new Font("Raleway", Font.BOLD,30));
        add(l1);
         type = new JLabel("Account Type:");
        type.setBounds(100,80,200,20);
        type.setFont(new Font("Raleway", Font.BOLD,20));
        add(type);
        saving = new JRadioButton("Savings Account");
        saving.setFont(new Font("Raleway", Font.BOLD,15));
        saving.setBackground(Color.WHITE);
        saving.setBounds(100,120,300,20);
        add(saving);
        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.BOLD,15));
        current.setBounds(400,120,300,20);
        current.setBackground(Color.WHITE);
        add(current);
        fd = new JRadioButton("Fixed Deposit");
        fd.setFont(new Font("Raleway", Font.BOLD,15));
        fd.setBackground(Color.WHITE);
        fd.setBounds(100,160,300,20);
        add(fd);
        rac = new JRadioButton("Recurring Deposit Account");
        rac.setFont(new Font("Raleway", Font.BOLD,15));
        rac.setBackground(Color.WHITE);
        rac.setBounds(400,160,300,20);
        add(rac);
        ButtonGroup acctype = new ButtonGroup();
        acctype.add(saving);
        acctype.add(current);
        acctype.add(fd);
        acctype.add(rac);
        cardNo = new JLabel("Card");
        cardNo.setBounds(100,200,50,20);
        cardNo.setFont(new Font("Raleway", Font.BOLD,20));
        add(cardNo);
        detail = new JLabel("Your 16 Digit card number");
        detail.setBounds(100,220,500,20);
        detail.setFont(new Font("Raleway", Font.BOLD,12));
        add(detail);    
        number = new JLabel("Number : XXXX-XXXX-XXXX-1567");
        number.setBounds(150,200,500,20);
        number.setFont(new Font("Raleway", Font.BOLD,20));
        add(number);
        pin = new JLabel("PIN");
        pin.setBounds(100,270,50,20);
        pin.setFont(new Font("Raleway", Font.BOLD,20));
        add(pin);
        pdetail = new JLabel("Your 16 Digit card number");
        pdetail.setBounds(100,290,500,20);
        pdetail.setFont(new Font("Raleway", Font.BOLD,12));
        add(pdetail);    
        pnumber = new JLabel(": XXXX");
        pnumber.setBounds(150,270,500,20);
        pnumber.setFont(new Font("Raleway", Font.BOLD,20));
        add(pnumber);
        service = new JLabel("Services required :");
        service.setBounds(100,330,450,30);
        service.setFont(new Font("Raleway", Font.BOLD,20));
        add(service);
        service1 = new JCheckBox("ATM CARD");
        service1.setBounds(100,360,150,20);
        service1.setFont(new Font("Raleway", Font.BOLD,12));
        service1.setBackground(Color.WHITE);
        add(service1);
        service2 = new JCheckBox("Net Banking");
        service2.setBounds(250,360,150,20);
        service2.setFont(new Font("Raleway", Font.BOLD,12));
        service2.setBackground(Color.WHITE);
        add(service2);
        service3 = new JCheckBox("Mobile Banking");
        service3.setBounds(400,360,150,20);
        service3.setFont(new Font("Raleway", Font.BOLD,12));
        service3.setBackground(Color.WHITE);
        add(service3);
        service4 = new JCheckBox("Email Alerts");
        service4.setBounds(100,390,150,20);
        service4.setFont(new Font("Raleway", Font.BOLD,12));
        service4.setBackground(Color.WHITE);
        add(service4);
        service5 = new JCheckBox("Cheque Book");
        service5.setBounds(250,390,150,20);
        service5.setFont(new Font("Raleway", Font.BOLD,12));
        service5.setBackground(Color.WHITE);
        add(service5);
        service6 = new JCheckBox("E-Statement");
        service6.setBounds(400,390,150,20);
        service6.setFont(new Font("Raleway", Font.BOLD,12));
        service6.setBackground(Color.WHITE);
        add(service6);
        declaration = new JCheckBox("**I hererby declare that all the information given by me is correct to the best of my knowledge.");
        declaration.setBounds(100,440,600,20);
        declaration.setFont(new Font("Raleway", Font.BOLD,12));
        declaration.setBackground(Color.WHITE);
        add(declaration);
        
        submit = new JButton("Submit");
        submit.setBounds(100,520,100,30);
        submit.setFont(new Font("Raleway", Font.BOLD,12));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        add(submit);
        submit.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.setBounds(500,520,100,30);
        cancel.setFont(new Font("Raleway", Font.BOLD,12));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);
        cancel.addActionListener(this);
        setSize(800,800);
        setVisible(true);
        setLocation(250,100);
        getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource()== submit){
                String Account_type = null;
                if(saving.isSelected()){
                    Account_type = "Savings";
                }
                else if(current.isSelected()){
                    Account_type = "Current";
                }
                else if(fd.isSelected() ){
                    Account_type = "Fixed Deposit";
                }
                else if(rac.isSelected()){
                    Account_type = "Recurring Deposit Account";
                }
                String atmCard = service1.isSelected()?"Yes":"No";
                String netBank = service2.isSelected()?"Yes":"No";
                String mobileBank = service3.isSelected()?"Yes":"No";
                String emailAlert = service4.isSelected()?"Yes":"No";
                String chequeBook = service5.isSelected()?"Yes":"No";
                String eStatement = service6.isSelected()?"Yes":"No";
                String sdeclaration = declaration.isSelected()?"Yes":"No";
                Random random = new Random();
                String cardnumber = "" +  Math.abs((random.nextLong()%90000000L) + 1234567000000000L);
                String pinnumber = ""+Math.abs((random.nextLong()%9000L)+1000L);
                try{
                    if(!(declaration.isSelected())){
                    JOptionPane.showMessageDialog(null,"Declaration is Required");
                    }else{
                    Conn c = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"','"+Account_type+"','"+atmCard+"','"+netBank+"','"+mobileBank+"','"+emailAlert+"','"+chequeBook+"','"+eStatement+"','"+sdeclaration+"','"+cardnumber+"','"+pinnumber+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber+"\nPin :"+pinnumber);
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
                
            }
            else if (ae.getSource() == cancel){
//                JOptionPane.showMessageDialog(null,"Are you Sure?");
                setVisible(false);
            }
        }
     public static void main(String[] args){
         new SignUp3("");
     }
             
}
