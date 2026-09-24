package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuItem;

public class Schoolhting {

	private JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtLastName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Schoolhting window = new Schoolhting();
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
	public Schoolhting() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(168, 56, 89, 23);
		panel.add(btnNewButton);
		
		JTextArea txtrFirstNameLast = new JTextArea();
		txtrFirstNameLast.setText("First Name LAst Name is in grade x goes to x school");
		txtrFirstNameLast.setBounds(10, 90, 172, 67);
		panel.add(txtrFirstNameLast);
		
		txtFirstName = new JTextField();
		txtFirstName.setForeground(Color.LIGHT_GRAY);
		txtFirstName.setText("first name");
		txtFirstName.setBounds(10, 11, 86, 20);
		panel.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setText("last name");
		txtLastName.setForeground(Color.LIGHT_GRAY);
		txtLastName.setColumns(10);
		txtLastName.setBounds(113, 11, 86, 20);
		panel.add(txtLastName);
		
		JComboBox inputGrade = new JComboBox();
		inputGrade.setModel(new DefaultComboBoxModel(new String[] {"10", "11", "12"}));
		inputGrade.setBounds(10, 56, 66, 23);
		panel.add(inputGrade);
		
		JComboBox inputSchool = new JComboBox();
		inputSchool.setModel(new DefaultComboBoxModel(new String[] {"Crescent Heights", "Western"}));
		inputSchool.setBounds(92, 56, 66, 23);
		panel.add(inputSchool);
		
		JMenuItem schoolLogo = new JMenuItem("");
		schoolLogo.setBounds(10, 197, 137, 26);
		panel.add(schoolLogo);
	}
}
