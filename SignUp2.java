package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SignUp2 extends JFrame implements ActionListener{
    JButton next,Reset;
    JTextField  occuTextField, pan_numberTextField, aadhar_numberTextField;
    JRadioButton yes, yes1, no, no1;
    JComboBox rel,cat,edu,inc;
    String formno;
    SignUp2(String formno){
        this.formno = formno; 
        setLayout(null);
        setForeground(Color.BLACK);
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 2");
        JLabel additionalDetail = new JLabel("Page 2 : Additional Details");
        additionalDetail.setFont(new Font("Raleway", Font.BOLD,20));
        additionalDetail.setBounds(250,70,300,20);
        add(additionalDetail);
        JLabel religion = new JLabel("Religion : ");
        religion.setFont(new Font("Raleway", Font.BOLD,20));
        religion.setBounds(100,110,200,20);
        add(religion);
        String[] valReligion = {"","Hindu","Muslim","Christian","Sikh","Jain"};
         rel = new JComboBox(valReligion);
        rel.setBounds(300,110,200,20);
        rel.setBackground(Color.WHITE);
        add(rel);
        JLabel category = new JLabel("Category : ");
        category.setFont(new Font("Raleway", Font.BOLD,20));
        category.setBounds(100,150,200,20);
        add(category);
        String[] valCategory = {"","General","OBC","SC","ST"};
         cat = new JComboBox(valCategory);
        cat.setBounds(300,150,200,20);
        cat.setBackground(Color.WHITE);
        add(cat);
        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD,20));
        income.setBounds(100,190,200,20);
        add(income);
        String[] valIncome = {"","<=1,00,000","<=2,00,000","<=5,00,000","<=10,00,000",">10,00,000"};
         inc = new JComboBox(valIncome);
        inc.setBounds(300,190,200,20);
        inc.setBackground(Color.WHITE);
        add(inc);
        
        JLabel qualification = new JLabel("Qualification : ");
        qualification.setFont(new Font("Raleway", Font.BOLD,20));
        qualification.setBounds(100,230,200,20);
        add(qualification);
        String[] valedu = {"","UnEducated","10th","12th","UnderGraduate","PostGraduate"};
         edu = new JComboBox(valedu);
        edu.setBounds(300,230,200,20);
        edu.setBackground(Color.WHITE);
        add(edu);
        JLabel occuptaion = new JLabel("Occuptaion : ");
        occuptaion.setFont(new Font("Raleway", Font.BOLD,20));
        occuptaion.setBounds(100,270,200,20);
        add(occuptaion);
        occuTextField = new JTextField();
        occuTextField.setFont(new Font("Raleway",Font.BOLD,15));
        occuTextField.setBounds(300,270 ,200 ,20);
        add(occuTextField);
        JLabel pan_number = new JLabel("PAN Number : ");
        pan_number.setFont(new Font("Raleway", Font.BOLD,20));
        pan_number.setBounds(100,310,200,20);
        add(pan_number);
        pan_numberTextField = new JTextField();
        pan_numberTextField.setFont(new Font("Raleway",Font.BOLD,15));
        pan_numberTextField.setBounds(300,310 ,200 ,20);
        add(pan_numberTextField);
        JLabel aadhar_number = new JLabel("Aadhar Card No.: ");
        aadhar_number.setFont(new Font("Raleway", Font.BOLD,20));
        aadhar_number.setBounds(100,350,200,20);
        add(aadhar_number);
        aadhar_numberTextField = new JTextField();
        aadhar_numberTextField.setFont(new Font("Raleway",Font.BOLD,15));
        aadhar_numberTextField.setBounds(300,350 ,200 ,20);
        add(aadhar_numberTextField);
        JLabel senior = new JLabel("Senior Citizen (>60): ");
        senior.setFont(new Font("Raleway", Font.BOLD,20));
        senior.setBounds(100,390,200,20);
        add(senior);
       yes = new JRadioButton("Yes");
       yes.setFont(new Font("Raleway",Font.BOLD,20));
        yes.setBounds(300,390,100,20);
        yes.setBackground(Color.WHITE);
        add(yes);
       no = new JRadioButton("No");
       no.setFont(new Font("Raleway",Font.BOLD,20));
        no.setBounds(400,390,100,20);
        no.setBackground(Color.WHITE);
        add(no);
       ButtonGroup seniorButton = new ButtonGroup();
        seniorButton.add(yes);
        seniorButton.add(no);
        JLabel account_exist = new JLabel("Already Have Account?: ");
        account_exist.setFont(new Font("Raleway", Font.BOLD,20));
        account_exist.setBounds(100,430,200,20);
        add(account_exist);
        yes1 = new JRadioButton("Yes");
       yes1.setFont(new Font("Raleway",Font.BOLD,20));
        yes1.setBounds(300,430,100,20);
        yes1.setBackground(Color.WHITE);
        add(yes1);
       no1 = new JRadioButton("No");
       no1.setFont(new Font("Raleway",Font.BOLD,20));
        no1.setBounds(400,430,100,20);
        no1.setBackground(Color.WHITE);
        add(no1);
       ButtonGroup seniorButton1 = new ButtonGroup();
        seniorButton1.add(yes1);
        seniorButton1.add(no1);
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBounds(200,510,100,20);
        next.addActionListener(this);
        add(next);
        Reset = new JButton("Reset");
        Reset.setBackground(Color.BLACK);
        Reset.setForeground(Color.WHITE);
        Reset.setFont(new Font("Raleway",Font.BOLD,15));
        Reset.setBounds(350,510,100,20);
        Reset.addActionListener(this);
        add(Reset);
        setSize(800,600);
        setVisible(true);
        setLocation(250,100);
        getContentPane().setBackground(Color.WHITE);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == next){
            String religion = (String)rel.getSelectedItem();
            String category = (String)cat.getSelectedItem();
            String income = (String)inc.getSelectedItem();
            String Qualification = (String)edu.getSelectedItem();
            String occupation = occuTextField.getText();
            String pan_number = pan_numberTextField.getText();
            String aadhar_number = aadhar_numberTextField.getText();
            String existacc = null;
            String senior = null;
            
            if(yes.isSelected()){
                senior = "Yes";
            }
            else if (no.isSelected()){
                senior = "No";
            }
            if(yes1.isSelected()){
                existacc = "Yes";
            }
            else if (no1.isSelected()){
                existacc = "No";
            }
            
            try{
                if(religion.equals("")){
                    JOptionPane.showMessageDialog(null,"Religion is Required");
                }
                else{
                    Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+Qualification+"','"+occupation+"','"+pan_number+"','"+aadhar_number+"','"+existacc+"','"+senior+"')";
                c.s.executeUpdate(query);
                setVisible(false);
            new SignUp3(formno);
                }   
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == Reset ){
            occuTextField.setText("");
            pan_numberTextField.setText("");
            aadhar_numberTextField.setText("");
        }
      
    }

    public static void main(String[] args) {
        new SignUp2("");
    }
}

