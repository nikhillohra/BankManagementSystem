package bankmanagementsystem;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

/**
 *
 * @author nikhillohra
 */
public class SignupTwo extends JFrame implements ActionListener {

    JTextField aadharTextField, panTextField;
    JComboBox religionCb, educationCb, occupationCb, incomeCb, citizenshipCb;
    JButton next, back;
    JRadioButton seniorY, seniorN, existY, existN;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APLLICATION FORM - PAGE 2");

        //PD
        JLabel addDetails = new JLabel("Page 2 : Additional Details");
        addDetails.setFont(new Font("Cochin", Font.BOLD, 30));
        addDetails.setBounds(290, 50, 400, 40);
        add(addDetails);

        //Religion
        JLabel religion = new JLabel("Religion : ");
        religion.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        religion.setBounds(100, 140, 200, 30);
        add(religion);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Others"};
        religionCb = new JComboBox(valReligion);
        religionCb.setBounds(300, 140, 400, 30);
        add(religionCb);

        //Citizenship
        JLabel citizenship = new JLabel("Citizenship : ");
        citizenship.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        citizenship.setBounds(100, 200, 200, 30);
        add(citizenship);

        String[] citizen = {"Indian", "Non-Indian"};
        citizenshipCb = new JComboBox(citizen);
        citizenshipCb.setBounds(300, 200, 400, 30);
        add(citizenshipCb);

        //Income
        JLabel income = new JLabel("Annual Income : ");
        income.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        income.setBounds(100, 260, 200, 30);
        add(income);

        String[] valIncome = {"< 150000", "< 250000", "< 350000", "< 550000", "> 550000"};
        incomeCb = new JComboBox(valIncome);
        incomeCb.setBounds(300, 260, 400, 30);
        add(incomeCb);

        //Educational
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        education.setBounds(100, 320, 200, 30);
        add(education);

        JLabel education1 = new JLabel("Qulification : ");
        education1.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        education1.setBounds(100, 345, 200, 30);
        add(education1);

        String[] valEducation = {"High School", "Some Graduate", "Graduate", "Post Graduate", "Ph.D"};
        educationCb = new JComboBox(valEducation);
        educationCb.setBounds(300, 330, 400, 30);
        add(educationCb);

        //Occupation
        JLabel occupation = new JLabel("Occupation  : ");
        occupation.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        occupation.setBounds(100, 400, 200, 30);
        add(occupation);

        String[] valoccupation = {"Employed", "Self-Employed", "Buisness", "Student", "Retired"};
        occupationCb = new JComboBox(valoccupation);
        occupationCb.setBounds(300, 400, 400, 30);
        add(occupationCb);

        //PAN
        JLabel pan = new JLabel("PAN Number : ");
        pan.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        pan.setBounds(100, 460, 200, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 14));
        panTextField.setBounds(300, 460, 400, 30);
        add(panTextField);

        //Aadhar
        JLabel aadhar = new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        aadhar.setBounds(100, 520, 200, 30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 14));
        aadharTextField.setBounds(300, 520, 400, 30);
        add(aadharTextField);

        //Senior
        JLabel senior = new JLabel("Senior Citizen : ");
        senior.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        senior.setBounds(100, 579, 200, 30);
        add(senior);

        seniorY = new JRadioButton("Yes");
        seniorY.setBounds(320, 579, 100, 30);
        seniorY.setBackground(Color.WHITE);
        add(seniorY);

        seniorN = new JRadioButton("No");
        seniorN.setBounds(518, 579, 100, 30);
        seniorN.setBackground(Color.WHITE);
        add(seniorN);

        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(seniorY);
        seniorgroup.add(seniorN);

        //Existing account
        JLabel exist = new JLabel("Existing Account : ");
        exist.setFont(new Font("HelveticaNeue-Bold", Font.BOLD, 22));
        exist.setBounds(100, 640, 300, 30);
        add(exist);

        existY = new JRadioButton("Yes");
        existY.setBounds(320, 640, 100, 30);
        existY.setBackground(Color.WHITE);
        add(existY);

        existN = new JRadioButton("No");
        existN.setBounds(518, 640, 100, 30);
        existN.setBackground(Color.WHITE);
        add(existN);

        ButtonGroup existgroup = new ButtonGroup();
        existgroup.add(existY);
        existgroup.add(existN);

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

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }

        String sreligion = (String) religionCb.getSelectedItem();
        String scitizen = (String) citizenshipCb.getSelectedItem();

        String sincome = (String) incomeCb.getSelectedItem();
        String seducation = (String) educationCb.getSelectedItem();
        String soccupation = (String) occupationCb.getSelectedItem();

        String ssenior = null;
        if (seniorY.isSelected()) {
            ssenior = "Yes";
        } else if (seniorY.isSelected()) {
            ssenior = "No";

        }

        String sexist = null;
        if (existY.isSelected()) {
            sexist = "Yes";
        } else if (existN.isSelected()) {
            sexist = "No";

        }
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();

        try {
            if (sreligion == null || sreligion.toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Religion is Required");
            } else if (scitizen == null || scitizen.toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Citizen is Required");
            } else if (sincome == null || scitizen.toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Income is Required");
            } else if (seducation == null || seducation.toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Education is Required");
            } else if (soccupation == null || seducation.toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Occupation is Required");
            } else if (span.equals("")) {
                JOptionPane.showMessageDialog(null, "PAN Number is Required");
            } else if (saadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "Aadhar Number is Required");
            } else if (ssenior != null && ssenior.equals("")) {
                JOptionPane.showMessageDialog(null, "Senior Citizen is Required");
            } else if (sexist != null && sexist.equals("")) {
                JOptionPane.showMessageDialog(null, "Existing Account is Required");
            } else {

                Conn c = new Conn();
                String query = "insert into signuptwo values('" + formno + "', '" + sreligion + "', '" + scitizen + "', '" + sincome + "','" + seducation + "', '" + soccupation + "','" + span + "','" + saadhar + "','" + ssenior + "','" + sexist + "')";
                c.s.executeUpdate(query);

                // Move to the next frame
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String args[]) {

        new SignupTwo("");

    }
}
