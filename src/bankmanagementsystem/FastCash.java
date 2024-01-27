/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;

import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener {
    
    JButton rs100, rs5000, rs1000, rs500, rs10000, back, rs2000;
    String pinNumber;
    
    FastCash(String pinNumber) {
        this.pinNumber = pinNumber;
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);
        
        JLabel text = new JLabel("Please select Withdrawal Amount !!");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Charter", Font.BOLD, 14));
        text.setBounds(300, 120, 700, 32);
        image.add(text);

        //JButton 
        rs100 = new JButton("Rs 100");
        rs100.setBounds(195, 190, 140, 30);
        rs100.addActionListener(this);
        rs100.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        image.add(rs100);
        
        rs500 = new JButton("Rs 500");
        rs500.setBounds(195, 243, 140, 30);
        rs500.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        rs500.addActionListener(this);
        image.add(rs500);
        
        rs1000 = new JButton("Rs 1000");
        rs1000.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        rs1000.setBounds(195, 294, 140, 30);
        rs1000.addActionListener(this);
        image.add(rs1000);
        
        rs2000 = new JButton("Rs 2000");
        rs2000.setBounds(480, 190, 135, 30);
        rs2000.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        rs2000.addActionListener(this);
        image.add(rs2000);
        
        rs5000 = new JButton("Rs 5000");
        rs5000.setBounds(480, 242, 135, 32);
        rs5000.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        rs5000.addActionListener(this);
        image.add(rs5000);
        
        rs10000 = new JButton("Rs 10000");
        rs10000.setBounds(480, 296, 135, 30);
        rs10000.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        rs10000.addActionListener(this);
        image.add(rs10000);
        
        back = new JButton("BACK");
        back.setBounds(480, 353, 135, 30);
        back.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        back.addActionListener(this);
        image.add(back);
        
        setSize(800, 800);
        setLocation(300, 20);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public static void main(String args[]) {
        
        new FastCash("");
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
            
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            
            Conn c = new Conn();
            try {
               ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinNumber + "'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                
                    if(ae.getSource() != back && balance < Integer.parseInt(amount)  ){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                
                
                    Date date = new Date();
                    String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawal','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + amount + "Successfully");
                    
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                    
                }
                
                
            } catch (Exception e) {
                System.out.println(e);
            
            
        }
    }
    
}
}
