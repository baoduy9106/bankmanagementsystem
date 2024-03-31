package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	
	JButton login, signup, clear;
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	Login() {
		setTitle("AUTOMATED TELLER MACHINE");
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(180, 10, 100, 100);
		add(label);
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward", Font.BOLD, 30));
		text.setBounds(300, 40, 300, 40);
		add(text);
		
		JLabel cardno = new JLabel("Card No.");
		cardno.setFont(new Font("Raleway", Font.BOLD, 25));
		cardno.setBounds(120, 150, 150, 40);
		add(cardno);
		
		cardTextField = new JTextField();
		cardTextField.setBounds(300, 150, 250, 40);
		cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(cardTextField);
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Osward", Font.BOLD, 25));
		pin.setBounds(120, 220, 400, 40);
		add(pin);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300, 220, 250, 40);
                pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(pinTextField);
		
		login = new JButton("LOGIN");
		login.setBounds(300, 300, 100, 40);
		login.setBackground(Color.WHITE);
		login.setForeground(Color.BLACK);
		login.addActionListener(this);
		add(login);
                
                signup = new JButton("SIGN UP");
		signup.setBounds(300, 350, 100, 40);
		signup.setBackground(Color.WHITE);
		signup.setForeground(Color.BLACK);
		signup.addActionListener(this);
		add(signup);
		
		clear = new JButton("CLEAR");
		clear.setBounds(430, 300, 100, 40);
		clear.setBackground(Color.WHITE);
		clear.setForeground(Color.BLACK);
		clear.addActionListener(this);
		add(clear);
		
		
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800, 480);
		setVisible(true);
		setLocation(350, 200);
	}
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		} else if (ae.getSource() == login) {
			Conn conn = new Conn();
                        String cardnumber = cardTextField.getText();
                        String pincode = pinTextField.getText();
			String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pincode+"'";
			try {
                            ResultSet rs = conn.s.executeQuery(query);
                            if (rs.next()) {
                                setVisible(false);
                                new Transactions("").setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }
		} else if (ae.getSource() == signup) {
			setVisible(false);
                        new SignupOne().setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Login();

	}

}
