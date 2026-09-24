import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClassDemo {

	private JFrame frame;
	private JTextField firstName;
	private JTextField lastName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassDemo window = new ClassDemo();
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
	public ClassDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 714, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 850, 486);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		firstName = new JTextField();
		firstName.setForeground(new Color(0, 0, 0));
		firstName.setText("Enter First Name");
		firstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(firstName.getText().equals("Enter First Name")) {
					firstName.setText("");
				}		
			}
		});
		
		firstName.setBounds(71, 42, 100, 20);
		panel.add(firstName);
		firstName.setColumns(10);
		
		
		lastName = new JTextField();
		lastName.setText("Enter Last Name");
		lastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {				
				if(lastName.getText().equals("Enter Last Name")) {
					lastName.setText("");
				}							
			}
		});
		
		lastName.setBounds(240, 42, 100, 20);
		panel.add(lastName);
		lastName.setColumns(10);
		
		JLabel display = new JLabel("");
		display.setBounds(83, 149, 583, 201);
		panel.add(display);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fN = firstName.getText();
				String lN = lastName.getText();
				display.setText("Your first name is: " 
						+ fN + " "
						+ "Your last name is: "
						+ lN);
			}
		
	});
		submit.setFont(new Font("Tahoma", Font.PLAIN, 46));
		submit.setBounds(350, 11, 316, 328);
		panel.add(submit);
		

	}
}
