package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit, back;
    String pinNumber;

    Deposit(String pinNumber) {
        this.pinNumber = pinNumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_AREA_AVERAGING);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Deposit.");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Charter", Font.BOLD, 18));
        text.setBounds(250, 120, 700, 32);
        image.add(text);

        amount = new JTextField("Amount");
        amount.setFont(new Font("Cochin", Font.ROMAN_BASELINE, 14));
        amount.setBounds(250, 290, 300, 32);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(200, 353, 150, 32);
        deposit.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(450, 353, 150, 32);
        back.setFont(new Font("HelveticaNeue", Font.PLAIN, 14));
        back.addActionListener(this);
        image.add(back);

        setSize(800, 800);
        setLocation(300, 100);
        setVisible(true);


 
    } private void handleFrameAfterDeposit(boolean showDeposit, boolean showTransactions) {
        SwingUtilities.invokeLater(() -> {
            if (!showDeposit) {
                setVisible(false);
                dispose();  // Dispose of the current frame
            }
            new Transactions(pinNumber).setVisible(showTransactions);
        });
    }
  
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String number = amount.getText();
            Date date = new Date();
            
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Deposit");
                
            }else{
                try{
              
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Deposit', '"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " +number+" Deposited Successfully");
            handleFrameAfterDeposit(false, true);
                setVisible(false);
                dispose();
                new Transactions(pinNumber).setVisible(true);
            }catch(Exception e ){
                  System.out.println("Error depositing money: " + e);
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred while depositing money. Please try again.");
            }
            }
             

        } else if (ae.getSource() == back) {
              handleFrameAfterDeposit(true, true);

        }
        {

        }

    }

    public static void main(String[] args) {
        new Deposit("");

    }

}
