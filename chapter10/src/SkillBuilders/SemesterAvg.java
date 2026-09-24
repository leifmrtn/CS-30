package SkillBuilders;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SemesterAvg {

	private JFrame frame;
	private JTextField gr1;
	private JTextField gr2;
	private JTextField gr3;
	private JButton submitButton;
	private JLabel finalGrade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SemesterAvg window = new SemesterAvg();
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
	public SemesterAvg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 355, 235);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		gr1 = new JTextField();
		gr1.setText("Enter the First Grade");
		gr1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {				
				if(gr1.getText().equals("Enter the First Grade")) {
					gr1.setText("");
				}							
			}
		});
		gr1.setBounds(10, 11, 150, 50);
		panel.add(gr1);
		gr1.setColumns(10);
		
		gr2 = new JTextField();
		gr2.setText("Enter the Second Grade");
		gr2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {				
				if(gr2.getText().equals("Enter the Second Grade")) {
					gr2.setText("");
				}							
			}
		});
		gr2.setBounds(10, 72, 150, 50);
		panel.add(gr2);
		gr2.setColumns(10);
		
		gr3 = new JTextField();
		gr3.setText("Enter the Third Grade");
		gr3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {				
				if(gr3.getText().equals("Enter the Third Grade")) {
					gr3.setText("");
				}							
			}
		});
		gr3.setBounds(10, 133, 150, 50);
		panel.add(gr3);
		gr3.setColumns(10);
		
		submitButton = new JButton("Submit");
		
		submitButton.setBounds(170, 11, 150, 112);
		panel.add(submitButton);
		submitButton.addActionListener(new submitListener());
		
		finalGrade = new JLabel("Average");
		finalGrade.setBounds(170, 133, 150, 50);
		panel.add(finalGrade);
	}
	
	class submitListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			double avgGrade;
			
			Double grade1 = Double.parseDouble(gr1.getText());
			Double grade2 = Double.parseDouble(gr2.getText());
			Double grade3 = Double.parseDouble(gr3.getText());
			
			avgGrade = (grade1 + grade2 + grade3)/3;
			
			finalGrade.setText(String.format("Average: %.2f", avgGrade) + "%");
		}
	}
	
}
