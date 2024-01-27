/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankmanagementsystem;

import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author nikhillohra
 */
public class MiniStatement extends JFrame {

    MiniStatement(String pinNumber) {
        setTitle("Mini Statement");
        setLayout(null);

        JLabel bank = new JLabel("E-Bank ATM");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        JLabel mini = new JLabel();
        mini.setBounds(20, 120, 400, 200);
        add(mini);

        int bal = 0;

        try {
            Conn conn = new Conn();

            ResultSet rs = conn.s.executeQuery("select * from login where pin = '" + pinNumber + "'");
            if (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin =  '" + pinNumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else if (rs.getString("type").equals("Withdrawal")) {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
                
                mini.setText(mini.getText() + "<html>"
                        + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "
                        + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "
                        + rs.getString("amount")
                        + "<br><br><html>");

                balance.setText("Your Current Account Balance is Rs " + bal);
                balance.setVisible(true);

            }
            balance.setText("Your Current Account Balance is Rs " + bal);
            balance.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
        mini.setBounds(20, 120, 400, 200);

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(new Color(120, 150, 200));
        setVisible(true);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MiniStatement(" ");

    }

}
