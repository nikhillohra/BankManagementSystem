package bankmanagementsystem;

import bankmanagementsystem.Transactions;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author nikhillohra
 */
public class BalanceEnquiry extends JFrame implements ActionListener {
 JLabel btext;
    String pinNumber;
    JButton back;

    BalanceEnquiry(String pinNumber) {
        this.pinNumber = pinNumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_AREA_AVERAGING);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);

        JLabel text = new JLabel("Balance Enquiry");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Charter", Font.BOLD, 18));
        text.setBounds(330, 120, 700, 32);
        image.add(text);

        back = new JButton("Back");
        back.setBounds(450, 353, 150, 32);
        back.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        back.addActionListener(this);
        image.add(back);

        Conn c = new Conn();
          int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinNumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        
       btext = new JLabel("Your Current Account Balance is Rs " + balance);
      btext.setForeground(Color.WHITE);
        btext.setFont(new Font("Charter", Font.BOLD, 18));
        btext.setBounds(200, 210, 700, 32);
        image.add(btext);


        setSize(800, 800);
        setLocation(300, 20);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);

        }
    }

    public static void main(String[] args) {

        new BalanceEnquiry("");

    }
}
