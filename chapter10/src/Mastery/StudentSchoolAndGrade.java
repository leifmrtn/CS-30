/*

Program: StudentSchoolAndGrade.java          Last Date of this Revision: October 2, 2026

Purpose: Allow the user to input their school and grade, first and last name, and then output the data and their school logo.

Author: Leif Martin, 
School: CHHS
Course: Computer Programming CSE3010
 
*/
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
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class StudentSchoolAndGrade {

	private JFrame frame;
	private JTextField enterFirstName, enterLastName;
	private JComboBox inputSchool, inputGrade;
	private JMenuItem schoolLogo;
	private JTextArea outputText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSchoolAndGrade window = new StudentSchoolAndGrade();
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
	public StudentSchoolAndGrade() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ImageIcon crescentLogo = new ImageIcon("../chapter10/src/Mastery/crescentHeightsLogo.png");
		ImageIcon westernLogo = new ImageIcon("../chapter10/src/Mastery/westernLogo.png");
		ImageIcon sirWinstonChurchillLogo = new ImageIcon("../chapter10/src/Mastery/sirWinstonChurchillLogo.png");
		ImageIcon ernestManningLogo = new ImageIcon("../chapter10/src/Mastery/ernestManningLogo.png");

		
		frame = new JFrame();
		frame.setBounds(100, 100, 509, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		/// Button Submit Pressed ///
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 48));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = enterFirstName.getText();
				String lastName = enterLastName.getText();
				String schoolName = (String)inputSchool.getSelectedItem();
				String gradeNum = (String)inputGrade.getSelectedItem();

				outputText.setText(firstName + " " + lastName + " is in grade: " + gradeNum + "\nand goes to " + schoolName + " high school.");
				
				ImageIcon logo = switch(schoolName) {
				case "Crescent Heights" -> crescentLogo;
				case "Western" -> westernLogo;
				case "Sir Winston Churchill" -> sirWinstonChurchillLogo;
				case "Ernest Manning" -> ernestManningLogo;
				default -> null;
				};
				
				schoolLogo.setIcon(logo);
			}
		});
		btnNewButton.setBounds(269, 174, 213, 181);
		panel.add(btnNewButton);
		
		outputText = new JTextArea();
		outputText.setBounds(10, 88, 472, 75);
		panel.add(outputText);
		
		enterFirstName = new JTextField();
		
		enterFirstName.setForeground(Color.LIGHT_GRAY);
		enterFirstName.setText("first name");
		enterFirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(enterFirstName.getText().equals("first name")) {
					enterFirstName.setText("");
					enterFirstName.setForeground(Color.BLACK);
				}
			}
		});
		
		enterFirstName.setBounds(10, 11, 225, 25);
		panel.add(enterFirstName);
		enterFirstName.setColumns(10);
		
		enterLastName = new JTextField();
		
		enterLastName.setText("last name");
		enterLastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(enterLastName.getText().equals("last name")) {
					enterLastName.setText("");
					enterLastName.setForeground(Color.BLACK);
				}
			}
		});
		
		enterLastName.setForeground(Color.LIGHT_GRAY);
		enterLastName.setColumns(10);
		enterLastName.setBounds(10, 47, 225, 25);
		panel.add(enterLastName);
		
		inputGrade = new JComboBox();
		inputGrade.setModel(new DefaultComboBoxModel(new String[] {"Input Grade", "10", "11", "12"}));
		inputGrade.setBounds(257, 47, 225, 25);
		panel.add(inputGrade);
		inputGrade.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				inputGrade.removeItemAt(0);
			}
		});
		
		inputSchool = new JComboBox();
		inputSchool.setModel(new DefaultComboBoxModel(new String[] {"Input School", "Crescent Heights", "Western", "Sir Winston Churchill", "Ernest Manning"}));
		inputSchool.setBounds(257, 11, 225, 25);
		panel.add(inputSchool);
		inputSchool.addPopupMenuListener(new PopupMenuListener() {
		public void popupMenuCanceled(PopupMenuEvent e) {}
		public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
		public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			inputSchool.removeItemAt(0);

			}
		});
		
		schoolLogo = new JMenuItem("");

		schoolLogo.setBounds(10, 174, 249, 181);
		panel.add(schoolLogo);
	}
}
