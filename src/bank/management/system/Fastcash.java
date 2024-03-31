
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {
    
    JButton cash100, cash500, cash1000, cash2000, cash5000, cash10000, exit;
    String pincode;
    Fastcash(String pincode) {
        this.pincode = pincode;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("SECLECT WITHDRAWL AMOUNT");
        text.setBounds(200, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        cash100 = new JButton("100");
        cash100.setBounds(170, 415, 150, 30);
        cash100.addActionListener(this);
        image.add(cash100);
        
        cash500 = new JButton("500");
        cash500.setBounds(355, 415, 150, 30);
        cash500.addActionListener(this);
        image.add(cash500);
        
        cash1000 = new JButton("1000");
        cash1000.setBounds(170, 450, 150, 30);
        cash1000.addActionListener(this);
        image.add(cash1000);
        
        cash2000 = new JButton("2000");
        cash2000.setBounds(355, 450, 150, 30);
        cash2000.addActionListener(this);
        image.add(cash2000);
        
        cash5000 = new JButton("5000");
        cash5000.setBounds(170, 485, 150, 30);
        cash5000.addActionListener(this);
        image.add(cash5000);
        
        cash10000 = new JButton("10000");
        cash10000.setBounds(355, 485, 150, 30);
        cash10000.addActionListener(this);
        image.add(cash10000);
        
        exit = new JButton("BACK");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pincode).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText();
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pincode+"'");
                int balance = 0;
                while(rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pincode+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "$AUD " + amount + "Debited Sucessfully");
                
                setVisible(false);
                new Transactions(pincode).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        } 
    }
    public static void main(String args[]) {
        new Fastcash("");
    }
}
