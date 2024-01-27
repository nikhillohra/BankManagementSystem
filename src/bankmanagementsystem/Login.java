
package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{

    JButton login, clear, signup;
      JTextField cardTextField;
      JPasswordField pinTextField;
      
      
    
  
 
  
   Login(){
       setTitle("AUTOMATED TELLER MACHINE");
       
       setLayout(null);
       
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank1.png"));
       Image i2= i1.getImage().getScaledInstance(140, 140, Image.SCALE_AREA_AVERAGING);
       ImageIcon i3 = new ImageIcon(i2);
       
       JLabel label = new JLabel(i3);
       label.setBounds(10, 2, 200, 200);
       
       add(label);
      
       //INTRO
       JLabel text = new JLabel("Welcome to E-Bank ATM");
       text.setFont(new Font("HelveticaNeue-Bold", Font.ITALIC, 36));
       text.setBounds(240, 40, 600, 30);
       add(text);
       
       //CARD
       JLabel cardno = new JLabel("CARD NO : ");
       cardno.setFont(new Font("Cochin", Font.BOLD, 28));
       cardno.setBounds(150, 180, 400, 30);
       add(cardno);
       
        cardTextField = new JTextField();
       cardTextField.setBounds(330, 180, 250, 30);
       cardTextField.setFont(new Font("Arial", Font.BOLD,14));
       add(cardTextField);
       
       
       //PIN
       JLabel pin = new JLabel("PIN : ");
       pin.setFont(new Font("Cochin", Font.BOLD, 28));
       pin.setBounds(235, 220, 400, 30);
       
       add(pin);
       
         pinTextField = new JPasswordField();
       pinTextField.setBounds(330, 220, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD,14));
       add(pinTextField);
       
       //SIGNIN BUTTON
       login = new JButton("SIGN IN");
       login.setBounds(300, 300, 100, 25);
       login.setBackground(Color.DARK_GRAY);
       login.setForeground(Color.BLACK);
       login.addActionListener(this);
       
       add(login);
       
       //CLEAR BUTTON
       clear = new JButton("CLEAR");
       clear.setBounds(450, 300, 100, 25);
       clear.setBackground(Color.DARK_GRAY);
       clear.setForeground(Color.BLACK);
        clear.addActionListener(this);
       add(clear);
       
        //SIGNUP BUTTON
        signup = new JButton("SIGN UP");
       signup.setBounds(300, 340, 250, 25);
       signup.setBackground(Color.DARK_GRAY);
       signup.setForeground(Color.BLACK);
        signup.addActionListener(this);
       add(signup);
       
       
       getContentPane().setBackground(new Color(120, 150, 200));
       
  setSize(800,400);
   setVisible(true);
   setLocation(350, 200);
   
   
    }
   
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==clear){
           cardTextField.setText("");
            pinTextField.setText("");
       }
       
   else if(ae.getSource()==login){
       Conn conn = new Conn();
       String cardNumber = cardTextField.getText();
   
       String pinNumber = pinTextField.getText();
       String query = "select * from login where cardnumber = '"+cardNumber+"' and pin = '"+pinNumber+"'";
       
       try{
           
      
           
           
          ResultSet rs =  conn.s.executeQuery(query);
          if(rs.next()){
              setVisible(false);
              new Transactions(pinNumber).setVisible(true);
          }else{
              JOptionPane.showMessageDialog(null, "Incorrect card Number or PIN");
          }
           
       }catch(Exception e){
           System.out.println(e);
           
       }
      
   }
else if(ae.getSource()==signup){
       setVisible(false);
       new SignupOne().setVisible(true);
       
   }}
 
    public static void main(String[] args) {
   
new Login();

    
        
    }
    
}
