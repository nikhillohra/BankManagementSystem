package bankmanagementsystem;

import java.awt.Color;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nikhillohra
 */
public class SignupOne extends JFrame implements ActionListener {

    final long random;

    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField,
            stateTextField, pincodeTextField;
    JButton next, back;
    JRadioButton male, female, others, married, unmarried;
    JDateChooser dateChooser;

    SignupOne() {
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        setLayout(null);

        //APPLICATION no
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Cochin-Bold", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        //PD
        JLabel personDetails = new JLabel("Page 1 : Personal Details");
        personDetails.setFont(new Font("Cochin", Font.BOLD, 30));
        personDetails.setBounds(290, 80, 400, 40);
        add(personDetails);

        //name
        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        name.setBounds(100, 140, 200, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        fname.setBounds(100, 200, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 14));
        fnameTextField.setBounds(300, 200, 400, 30);
        add(fnameTextField);

        //DOB
        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        dob.setBounds(100, 260, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 260, 400, 30);
        dateChooser.setForeground(new Color(100, 105, 105));
        add(dateChooser);

        //Gender
        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        gender.setBounds(100, 320, 200, 30);
        add(gender);

        //Button
        male = new JRadioButton("Male");
        male.setBounds(300, 320, 100, 30);

        male.setBackground(Color.WHITE);

        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 320, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        //EMail
        JLabel email = new JLabel("Email Address : ");
        email.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        email.setBounds(100, 380, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 14));
        emailTextField.setBounds(300, 380, 400, 30);
        add(emailTextField);

        //Marital
        JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        marital.setBounds(100, 440, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 440, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        others = new JRadioButton("Others");
        others.setBounds(518, 440, 100, 30);
        others.setBackground(Color.WHITE);
        add(others);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 440, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(others);

        //ADDRESS
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        address.setBounds(100, 500, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 14));
        addressTextField.setBounds(300, 500, 400, 30);
        add(addressTextField);

        //City
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        city.setBounds(100, 560, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 14));
        cityTextField.setBounds(300, 560, 400, 30);
        add(cityTextField);

        //State
        JLabel state = new JLabel("State : ");
        state.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        state.setBounds(100, 620, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 14));
        stateTextField.setBounds(300, 620, 400, 30);
        add(stateTextField);

        //PIncode
        JLabel pincode = new JLabel("Pincode : ");
        pincode.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        pincode.setBounds(100, 680, 200, 30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 680, 400, 30);
        add(pincodeTextField);

        //Button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 14));
        back.setBounds(500, 760, 80, 30);
        back.addActionListener(this);

        add(back);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 14));
        next.setBounds(700, 760, 80, 30);
        next.addActionListener(this);

        add(next);

        getContentPane().setBackground(new Color(120, 150, 200));

        setSize(850, 880);
        setLocation(350, 10);
        setVisible(true);
    }

    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            // Code to go back to the login page
            setVisible(false); // Hide the current frame
            new Login().setVisible(true); // Show the login page
        } else if (ae.getSource() == next) {
            // Data validation and insertion logic
            String formno = "" + random;
            String name = nameTextField.getText();
            String fname = fnameTextField.getText();
            var dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String email = emailTextField.getText();
            
            String nGender = null;
            if (male.isSelected()) {
                nGender = "Male";
            } else if (female.isSelected()) {
                nGender = "Female";
            }  
            final String gender = nGender;
            
            String marital = null;
            if (married.isSelected()) {
                marital = "Married";
            } else if (unmarried.isSelected()) {
                marital = "Unmarried";
            } else if (others.isSelected()) {
                marital = "Others";
            }
             final  String marital_Status = marital;
            
            String address = addressTextField.getText();
            String city = cityTextField.getText();
            String state = stateTextField.getText();
            String pincode = pincodeTextField.getText();

            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Father's Name is Required");
            } else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Date of Birth is Required");
            } else if (gender != null && gender.equals("")) {
                JOptionPane.showMessageDialog(null, "Gender is Required");
            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "E-mail is Required");
            } else if (marital_Status != null && marital_Status.equals("")) {
                JOptionPane.showMessageDialog(null, "Marital Status is Required");
            } else if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is Required");
            } else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "City is Required");
            } else if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "State is Required");
            } else if (pincode.equals("")) {
                JOptionPane.showMessageDialog(null, "Pincode is Required");
            } else {
                SwingUtilities.invokeLater(() -> {
                    try {
                        Conn c = new Conn();
                        String query = "insert into signup values('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "','" + email + "', '" + marital_Status + "','" + gender + "','" + address + "','" + city + "','" + state + "','" + pincode + "')";
                        c.s.executeUpdate(query);

                        setVisible(false);
                        new SignupTwo(formno).setVisible(true);
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                });
            }
        }
    }


public static void main(String[] args) {

        new SignupOne();

    }
}
