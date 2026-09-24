package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;

public class LocalBank {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocalBank window = new LocalBank();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LocalBank() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Process Transaction");
		btnNewButton.setBounds(24, 427, 214, 23);
		panel.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(24, 36, 30, 22);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Select an Action");
		lblNewLabel.setBounds(25, 11, 113, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Complete the information in RED");
		lblNewLabel_1.setBounds(24, 69, 155, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Account number:");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(20, 94, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Amount of deposit/withdrawel:");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setBounds(43, 136, 46, 14);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(39, 196, 113, 14);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(39, 292, 113, 14);
		panel.add(lblLastName);
		
		JLabel lblBeginningBalance = new JLabel("Beginning Balance:");
		lblBeginningBalance.setBounds(24, 358, 113, 14);
		panel.add(lblBeginningBalance);
		
		textField = new JTextField();
		textField.setBounds(24, 105, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(20, 165, 86, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(24, 241, 86, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(24, 327, 86, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(24, 383, 86, 20);
		panel.add(textField_4);
		
		JLabel lblAccountInfoDisplayed = new JLabel("Account Info Displayed Here");
		lblAccountInfoDisplayed.setBounds(25, 402, 113, 14);
		panel.add(lblAccountInfoDisplayed);
	}
}
/*
 * Ask transaction type
 * add Account
 * 
 */
