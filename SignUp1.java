package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignUp1 extends JFrame implements ActionListener{
    JButton next,Reset;
    long random;
    JDateChooser dateChooser ;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, pincodeTextField,stateTextField;
    JRadioButton male, female, other, married , unmarried, otherM;
    SignUp1(){
        setLayout(null);
        setForeground(Color.BLACK);
        Random ran = new Random();
        random = Math.abs(ran.nextLong()%9000L + 1000L);
        JLabel formNo = new JLabel("APPLICATION FORM NO."+ random);
        formNo.setFont(new Font("Raleway", Font.BOLD,30));
        formNo.setBounds(150,10,450,30);
        add(formNo);
        JLabel PersonalDetail = new JLabel("Page 1 : Personal Details");
        PersonalDetail.setFont(new Font("Raleway", Font.BOLD,20));
        PersonalDetail.setBounds(250,70,300,20);
        add(PersonalDetail);
        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100,110,200,20);
        add(name);
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,15));
        nameTextField.setBounds(300,110 ,200 ,30);
        add(nameTextField);
        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100,150,200,20);
        add(fname);
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,15));
        fnameTextField.setBounds(300,150 ,200 ,30);
        add(fnameTextField);
        JLabel dob = new JLabel("Date Of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100,190,200,20);
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,190,200,20);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100,230,200,20);
        add(gender);
        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway",Font.BOLD,20));
        male.setBounds(300,230,100,20);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway",Font.BOLD,20));
        female.setBounds(400,230,100,20);
        female.setBackground(Color.WHITE);
        add(female);
        other = new JRadioButton("Others");
        other.setFont(new Font("Raleway",Font.BOLD,20));
        other.setBounds(500,230,100,20);
        other.setBackground(Color.WHITE);
        add(other);
        ButtonGroup genderButton = new ButtonGroup();
        genderButton.add(male);
        genderButton.add(female);
        genderButton.add(other);
        JLabel email = new JLabel("E-mail : ");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100,270,200,20);
        add(email);
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,15));
        emailTextField.setBounds(300,270 ,200 ,30);
        add(emailTextField);
        JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Raleway", Font.BOLD,20));
        marital.setBounds(100,310,200,20);
        add(marital);
        married = new JRadioButton("Married");
        married.setFont(new Font("Raleway",Font.BOLD,20));
        married.setBounds(300,310,100,20);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleway",Font.BOLD,20));
        unmarried.setBounds(400,310,150,20);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        otherM = new JRadioButton("Others");
        otherM.setFont(new Font("Raleway",Font.BOLD,20));
        otherM.setBounds(550,310,100,20);
        otherM.setBackground(Color.WHITE);
        add(otherM);
        ButtonGroup MaritalButton = new ButtonGroup();
        MaritalButton.add(married);
        MaritalButton.add(unmarried);
        MaritalButton.add(otherM);
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100,350,200,20);
        add(address);
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,15));
        addressTextField.setBounds(300,350 ,200 ,30);
        add(addressTextField);
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100,390,200,20);
        add(city);
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,15));
        cityTextField.setBounds(300,390 ,200 ,30);
        add(cityTextField);
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100,430,200,20);
        add(state);
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,15));
        stateTextField.setBounds(300,430 ,200 ,30);
        add(stateTextField);
        JLabel pincode = new JLabel("Pin Code: ");
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        pincode.setBounds(100,470,200,20);
        add(pincode);
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,15));
        pincodeTextField.setBounds(300,470 ,200 ,30);
        add(pincodeTextField);
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
        setTitle("Sign Up form");
        setSize(800,600);
        setVisible(true);
        setLocation(250,100);
        getContentPane().setBackground(Color.WHITE);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == next){
            String formno =  ""+random;
            String name = nameTextField.getText();
            String fname = fnameTextField.getText();
            String email = emailTextField.getText();
            String address = addressTextField.getText();
            String city = cityTextField.getText();
            String pincode = pincodeTextField.getText();
            String State = stateTextField.getText();
            String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
            String gender = null;
            if(male.isSelected()){
                gender = "Male";
            }
            else if (female.isSelected()){
                gender = "Female";
            }
            else if(other.isSelected()){
                gender = "Others";
            }
            String marital = null;
            if(married.isSelected()){
                marital = "Married";
            }
            else if (unmarried.isSelected()){
                marital = "Unmarried";
            }
            else if (otherM.isSelected()){
                marital = "Other";
            }
            try{
                if(name.equals("")){
                    JOptionPane.showMessageDialog(null,"Name is Required");
                }
                else{
                    Conn c = new Conn();
                    String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+email+"','"+address+"','"+city+"','"+pincode+"','"+State+"','"+dob+"','"+gender+"','"+marital+"')";
                    c.s.executeUpdate(query);
                    
                    setVisible(false);
                    new SignUp2(formno).setVisible(true);
                }   
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == Reset ){
            nameTextField.setText("");
            fnameTextField.setText("");
            addressTextField.setText("");
            emailTextField.setText("");
            cityTextField.setText("");
            stateTextField.setText("");
            pincodeTextField.setText("");
        }
      
    }

    public static void main(String[] args) {
        new SignUp1();
    }
}
