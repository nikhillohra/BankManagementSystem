/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author nikhillohra
 */
public class PinChange extends JFrame implements ActionListener{

    JPasswordField pinField, rpinField;
    JLabel rePin, newPin;
    JButton back, change;
    String pinNumber;

    PinChange(String pinNumber) {
        this.pinNumber = pinNumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);

//Change
        JLabel text = new JLabel("Change your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Charter", Font.BOLD, 14));
        text.setBounds(340, 120, 700, 32);
        image.add(text);

        //NewPin
        newPin = new JLabel("Enter New Pin : ");
        newPin.setForeground(Color.WHITE);
        newPin.setFont(new Font("Charter", Font.BOLD, 14));
        newPin.setBounds(220, 220, 700, 32);
        image.add(newPin);

        pinField = new JPasswordField("NPIN");
        pinField.setFont(new Font("Cochin", Font.ROMAN_BASELINE, 14));
        pinField.setBounds(350, 220, 200, 32);
        image.add(pinField);

        //reEnter
        rePin = new JLabel("Re - Enter New Pin : ");
        rePin.setForeground(Color.WHITE);
        rePin.setFont(new Font("Charter", Font.BOLD, 14));
        rePin.setBounds(220, 280, 300, 32);
        image.add(rePin);

        rpinField = new JPasswordField("NPIN");
        rpinField.setFont(new Font("Cochin", Font.ROMAN_BASELINE, 14));
        rpinField.setBounds(350, 280, 200, 32);
        image.add(rpinField);

        //back
        back = new JButton("Back");
        back.setBounds(450, 353, 150, 32);
        back.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        back.addActionListener(this);
        image.add(back);

        change = new JButton("Change");
        change.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        change.setBounds(195, 353, 140, 30);
         change.addActionListener(this);
        image.add(change);

        setSize(800, 800);
        setLocation(300, 20);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == change) {

            try {
                String nPin = pinField.getText();
                String rPin = rpinField.getText();

                if (!nPin.equals(rPin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not Match!!");
                    return;

                }
                if (nPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter New PIN !!");
                    return;
                }
                if (rPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN !!");
                    return;
                }

                Conn c = new Conn();
                String query1 = "Update bank set pin= '" + rPin + "' where pin = '" + pinNumber + "'";
                String query2 = "Update login set pin= '" + rPin + "' where pin = '" + pinNumber + "'";
                String query3 = "Update signupthree set pin= '" + rPin + "' where pin = '" + pinNumber + "'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rPin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if (ae.getSource() == back) {
        setVisible(false);
            new Transactions(pinNumber).setVisible(true);

        }
    }

    public static void main(String[] args) {

        new PinChange("").setVisible(true);

    }

}
