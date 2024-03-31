package bank.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener {
    
    JTextField pan, aaha;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, education, income;
    String formno;
    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        
        JLabel additionallDetails = new JLabel("Page 2: Additional Details");
        additionallDetails.setFont(new Font("Raleway", Font.BOLD, 18));
        additionallDetails.setBounds(290, 80, 250, 30);
        add(additionallDetails);
        
        JLabel religionlabel = new JLabel("Religion");
        religionlabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionlabel.setBounds(100, 140, 100, 30);
        add(religionlabel);
        
        String valReligion[] = {"Christian", "Budha", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel categorylabel = new JLabel("Category ");
        categorylabel.setFont(new Font("Raleway", Font.BOLD, 20));
        categorylabel.setBounds(100, 190, 200,  30);
        add(categorylabel);
        
        String valcategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel incomelabel = new JLabel("Income ");
        incomelabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomelabel.setBounds(100, 240, 200, 30);
        add(incomelabel);
        
        String incomecategory[] = {"Null", "< 1000", "< 1200", "< 1500", "Up to 2000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel educationlabel = new JLabel("Educational ");
        educationlabel.setFont(new Font("Raleway", Font.BOLD, 20));
        educationlabel.setBounds(100, 290, 200, 30);
        add(educationlabel);

        JLabel qualifycation = new JLabel("Qualifycation ");
        qualifycation.setFont(new Font("Raleway", Font.BOLD, 20));
        qualifycation.setBounds(100, 315, 200, 30);
        add(qualifycation);
        
        String educationValue[] = {"Non-Graduation", "Graduated", "Post-Graduated", "Doctare", "Others"};
        education = new JComboBox(educationValue);
        education.setBounds(300, 310, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel occupationlabel = new JLabel("Occupation: ");
        occupationlabel.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationlabel.setBounds(100, 390, 200, 30);
        add(occupationlabel);
        
        String occupationValue[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationValue);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel address = new JLabel("PAN Number: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD,14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        JLabel city = new JLabel("AaHa Number: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        aaha = new JTextField();
        aaha.setFont(new Font("Raleway", Font.BOLD,14));
        aaha.setBounds(300, 490, 400, 30);
        add(aaha);
        
        JLabel state = new JLabel("Senior Citizen: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        syes = new JRadioButton("YES");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        
        ButtonGroup citizenGroup = new ButtonGroup();
        citizenGroup.add(syes);
        citizenGroup.add(sno);
        
        JLabel eaccount = new JLabel("Existing Account:");
        eaccount.setFont(new Font("Raleway", Font.BOLD, 20));
        eaccount.setBounds(100, 590, 200, 30);
        add(eaccount);
        
        eyes = new JRadioButton("YES");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        
        ButtonGroup eAccountGroup = new ButtonGroup();
        eAccountGroup.add(eyes);
        eAccountGroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLUE);
        next.setForeground(Color.RED); 
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 620, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) religion.getSelectedItem();
        String sincome = (String) religion.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "YES";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }
        
        String existingAccount = null;
        if (eyes.isSelected()) {
            existingAccount = "Yes";
        } else if (eno.isSelected()) {
            existingAccount = "No";
        }
        String span = pan.getText();
        String sahaa = aaha.getText();

        
        
        try {  
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+sahaa+"', '"+seniorcitizen+"', '"+existingAccount+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);

        }   catch (Exception e) { 
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
        new SignupTwo("");
    }
    
}
