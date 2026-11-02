/*

Program: StudentSemesterAverage.java          Last Date of this Revision: October x, 2026

Purpose: ???

Author: Leif Martin, 
School: CHHS
Course: Computer Programming CSE2130
 
*/

package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class StudentSemesterAverage {

	private JFrame frame;
	private JTextField inputStudentName, inputGradeLevel, inputGrade2, inputSemesterNumber, inputGrade1, inputGrade3, inputGrade4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSemesterAverage window = new StudentSemesterAverage();
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
	public StudentSemesterAverage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		File dataFile = new File("../chapter11/src/Mastery/studentSemesterAvg.txt");
		
		
//		String stuFName, stuLName;
//		int grLvl, sNum;
//		double gr1, gr2, gr3, gr4;
//		String grAvg;
		
		NumberFormat percent = NumberFormat.getPercentInstance();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel studentNameText = new JLabel("Student Name:");
		studentNameText.setBounds(10, 10, 250, 20);
		panel.add(studentNameText);
		
		JTextArea outputField = new JTextArea();
		outputField.setBounds(10, 210, 500, 150);
		panel.add(outputField);
		
		inputStudentName = new JTextField();
		inputStudentName.setBounds(265, 10, 250, 20);
		panel.add(inputStudentName);
		inputStudentName.setColumns(10);
		
		JLabel gradeLevelText = new JLabel("Grade Level:");
		gradeLevelText.setBounds(10, 35, 250, 20);
		panel.add(gradeLevelText);
		
		JLabel semesterNumberText = new JLabel("Semester Number:");
		semesterNumberText.setBounds(10, 60, 200, 20);
		panel.add(semesterNumberText);
		
		JLabel grade1Text = new JLabel("Grade 1:");
		grade1Text.setBounds(10, 85, 250, 20);
		panel.add(grade1Text);
		
		JLabel grade2Text = new JLabel("Grade 2:");
		grade2Text.setBounds(10, 110, 250, 20);
		panel.add(grade2Text);
		
		JLabel grade3Text = new JLabel("Grade 3:");
		grade3Text.setBounds(10, 135, 250, 20);
		panel.add(grade3Text);
		
		JLabel grade4Text = new JLabel("Grade 4:");
		grade4Text.setBounds(10, 160, 250, 20);
		panel.add(grade4Text);
		
		JLabel averageText = new JLabel("Average:");
		averageText.setBounds(10, 185, 250, 20);
		panel.add(averageText);
		
		inputGradeLevel = new JTextField();
		inputGradeLevel.setColumns(10);
		inputGradeLevel.setBounds(265, 35, 250, 20);
		panel.add(inputGradeLevel);
		
		inputGrade2 = new JTextField();
		inputGrade2.setColumns(10);
		inputGrade2.setBounds(265, 110, 250, 20);
		panel.add(inputGrade2);
		
		inputSemesterNumber = new JTextField();
		inputSemesterNumber.setColumns(10);
		inputSemesterNumber.setBounds(265, 60, 250, 20);
		panel.add(inputSemesterNumber);
		
		inputGrade1 = new JTextField();
		inputGrade1.setColumns(10);
		inputGrade1.setBounds(265, 85, 250, 20);
		panel.add(inputGrade1);
		
		inputGrade3 = new JTextField();
		inputGrade3.setColumns(10);
		inputGrade3.setBounds(265, 135, 250, 20);
		panel.add(inputGrade3);
		
		inputGrade4 = new JTextField();
		inputGrade4.setColumns(10);
		inputGrade4.setBounds(265, 160, 250, 20);
		panel.add(inputGrade4);
		
		JButton saveButton = new JButton("Save To File");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				
				String stuName = inputStudentName.getText();

				
				int grLvl = Integer.parseInt(inputGradeLevel.getText().trim());
				int sNum = Integer.parseInt(inputSemesterNumber.getText().trim());
				
				double gr1 = Double.parseDouble(inputGrade1.getText().trim());
				double gr2 = Double.parseDouble(inputGrade1.getText().trim());
				double gr3 = Double.parseDouble(inputGrade1.getText().trim());
				double gr4 = Double.parseDouble(inputGrade1.getText().trim());
				
				double grAvg = (gr1 + gr2 + gr3 + gr4) / 4.0;
					
				try (FileWriter fileWriter = new FileWriter(dataFile, true);
					     BufferedWriter writeFile = new BufferedWriter(fileWriter)) {
						
						// Comma-separated layout for perfect organization
						String outputText = String.format("Name: %s, Grade Level: %d, Semester: %d, Grades: [%.1f, %.1f, %.1f, %.1f], Average: %.1f%%", 
								stuName, grLvl, sNum, gr1, gr2, gr3, gr4, grAvg);
						averageText.setText(String.format("Average: %.1f%%", grAvg));
						
						writeFile.write(outputText);
						writeFile.newLine();
						
						outputField.setText(outputText);
				}
				
				catch(FileNotFoundException error) {
					System.out.println("File does not exist or could not be found.");
					System.err.println("FileNotFoundException " + error.getMessage());
				}
				catch(IOException error) {
					System.out.println("Problem reading file.");
					System.err.println("IO Exception " + error.getMessage());
				}
				
				JOptionPane.showMessageDialog(null, "Data saved successfully!", "Message", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		
		
		saveButton.setBounds(115, 365, 150, 25);
		panel.add(saveButton);
		
		JButton viewFileButton = new JButton("View File Contents");
		viewFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (FileReader fileReader = new FileReader(dataFile);
					     BufferedReader readFile = new BufferedReader(fileReader)) {
					String line, outputText = "";
					while((line = readFile.readLine()) != null) {
						outputText += line + "\n";
					}
					outputField.setText(outputText);
				}
				
				catch(FileNotFoundException error) {
					System.out.println("File does not exist or could not be found.");
					System.err.println("FileNotFoundException " + error.getMessage());
				}
				catch(IOException error) {
					System.out.println("Problem reading file.");
					System.err.println("IO Exception " + error.getMessage());
				}
			}
		});
		viewFileButton.setBounds(275, 365, 150, 25);
		panel.add(viewFileButton);
	}
}
/*	Screen Dump

*/