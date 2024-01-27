/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;

import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, mini, pinchange, fast, balance, exit, withdrawal;
    String pinNumber;

    Transactions(String pinNumber) {
        this.pinNumber = pinNumber;
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);

        JLabel text = new JLabel("Please select your Transaction !!");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Charter", Font.BOLD, 14));
        text.setBounds(300, 120, 700, 32);
        image.add(text);

        //JButton 
        deposit = new JButton("Deposit");
        deposit.setBounds(195, 190, 140, 30);
        deposit.addActionListener(this);
        deposit.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        image.add(deposit);

        fast = new JButton("FastCash");
        fast.setBounds(195, 243, 140, 30);
        fast.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        fast.addActionListener(this);
        image.add(fast);

        pinchange = new JButton("Pin Change");
        pinchange.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        pinchange.setBounds(195, 294, 140, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        exit = new JButton("Exit");
        exit.setBounds(480, 353, 135, 30);
        exit.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        exit.addActionListener(this);
        image.add(exit);

        withdrawal = new JButton("Withdrawal");
        withdrawal.setBounds(480, 190, 135, 30);
        withdrawal.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        mini = new JButton("Mini Statement");
        mini.setBounds(480, 242, 135, 32);
        mini.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        mini.addActionListener(this);
        image.add(mini);

        balance = new JButton("Balance Enquiry");
        balance.setBounds(480, 296, 135, 30);
        balance.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        balance.addActionListener(this);
        image.add(balance);

        setSize(800, 800);
        setLocation(300, 20);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String args[]) {

        new Transactions("");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        }else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }else if (ae.getSource() == withdrawal){
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        }else if (ae.getSource() == fast){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }else if (ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }else if (ae.getSource() == balance){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if (ae.getSource() == mini){
           
            new MiniStatement(pinNumber).setVisible(true);
        }
    }

}
