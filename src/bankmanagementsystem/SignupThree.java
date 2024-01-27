/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;

import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author nikhillohra
 */
public class SignupThree extends JFrame implements ActionListener {

    JRadioButton save, fd, current, recurr;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    SignupThree(String formno) {
        this.formno = formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APLLICATION FORM - PAGE 3");

        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Cochin", Font.BOLD, 30));
        l1.setBounds(270, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type : ");
        type.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 24));
        type.setBounds(100, 160, 200, 40);
        add(type);

        //Saving
        save = new JRadioButton("Savings Account");
        save.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        save.setBackground(Color.WHITE);
        save.setBounds(160, 205, 400, 50);
        add(save);

        //current
        current = new JRadioButton("Current Account");
        current.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        current.setBackground(Color.WHITE);
        current.setBounds(460, 205, 400, 50);
        add(current);

        //fd
        fd = new JRadioButton("Fixed Deposite Account");
        fd.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        fd.setBackground(Color.WHITE);
        fd.setBounds(460, 245, 400, 50);
        add(fd);

        //recurr
        recurr = new JRadioButton("Recurring Account");
        recurr.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        recurr.setBackground(Color.WHITE);
        recurr.setBounds(160, 245, 400, 50);
        add(recurr);

        ButtonGroup account = new ButtonGroup();
        account.add(fd);
        account.add(current);
        account.add(save);
        account.add(recurr);

        //CARD
        JLabel card = new JLabel("Card Number : ");
        card.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 24));
        card.setBounds(100, 330, 200, 40);
        add(card);

        JLabel cardno = new JLabel("XXXX-XXXX-XXXX-4139");
        cardno.setFont(new Font("Raleway", Font.BOLD, 24));
        cardno.setBounds(300, 330, 400, 40);
        add(cardno);

        JLabel detail = new JLabel("Your 16 Digit Card Number");
        detail.setFont(new Font("HelveticaNeue-Light", Font.BOLD, 12));
        detail.setBounds(100, 350, 400, 40);
        add(detail);

        //pin
        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 24));
        pin.setBounds(100, 400, 200, 40);
        add(pin);

        JLabel pinno = new JLabel("XXXX");
        pinno.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 24));
        pinno.setBounds(300, 400, 400, 40);
        add(pinno);

        JLabel pdetail = new JLabel("Your 4 Digit Password");
        pdetail.setFont(new Font("HelveticaNeue-Light", Font.BOLD, 12));
        pdetail.setBounds(100, 420, 400, 40);
        add(pdetail);

        //Service
        JLabel service = new JLabel("Services Required : ");
        service.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 24));
        service.setBounds(100, 480, 400, 40);
        add(service);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        c1.setBounds(100, 515, 300, 40);
        add(c1);

        c2 = new JCheckBox("INTERNET BANKING");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        c2.setBounds(450, 515, 300, 40);
        add(c2);

        c3 = new JCheckBox("MOBILE BANKING");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        c3.setBounds(450, 555, 300, 40);
        add(c3);

        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        c5.setBounds(100, 555, 300, 40);
        add(c5);

        c4 = new JCheckBox("E-MAIL & SMS ALERT");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        c4.setBounds(100, 595, 300, 40);
        add(c4);

        c6 = new JCheckBox("E-STATEMENT");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        c6.setBounds(450, 595, 300, 40);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Cochin", Font.BOLD, 15));
        c7.setBounds(100, 700, 1000, 40);
        add(c7);

//Submit
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 12));
        submit.setBounds(660, 745, 100, 40);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.BLACK);
        cancel.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 12));
        cancel.setBounds(500, 745, 100, 40);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(new Color(120, 150, 200));

        setSize(850, 830);
        setLocation(350, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (save.isSelected()) {
                accountType = "Savings Account";
            } else if (fd.isSelected()) {
                accountType = "Fixed Deposit Account";

            } else if (current.isSelected()) {
                accountType = "Current Account";

            } else if (recurr.isSelected()) {
                accountType = "Recurring Account";
            }

            Random random = new Random();
            String cardNumber = "" + Math.abs(random.nextLong() % 90000000L + 4059368900000000L);
            String pinNumber = "" + Math.abs(random.nextLong() % 9000L + 1000L);

            String facility = "";
            if (c1.isSelected()) {
                facility = "ATM CARD";
            } else if (c2.isSelected()) {
                facility = "INTERNET BANKING";
            } else if (c3.isSelected()) {
                facility = "MOBILE BANKING";
            } else if (c4.isSelected()) {
                facility = "CHEQUE BOOK";
            } else if (c5.isSelected()) {
                facility = "E-MAIL & SMS ALERT";
            } else if (c6.isSelected()) {
                facility = "E-STATEMENT";
            }

            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account type is Required");
                } else if (facility.equals("")) {
                    JOptionPane.showMessageDialog(null, "At least one facility is required");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('" + formno + "','" + accountType + "','" + cardNumber + "', '" + pinNumber + "', '" + facility + "')";
                    String query2 = "insert into login values('" + formno + "','" + cardNumber + "', '" + pinNumber + "')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "  Pin No: " + pinNumber);

                }
            } catch (Exception e) {
                System.out.println(e);
            }
// Close the current window after submitting the form
            setVisible(false);

            // Open the login page
            new Login().setVisible(true);

        } else if (ae.getSource() == cancel) {
            setVisible(false);

            // Open the login page
            new Login().setVisible(true);
        }
    }

    public static void main(String args[]) {

        new SignupThree("");

    }
}
