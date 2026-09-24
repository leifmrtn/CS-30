package SkillBuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Roll {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Roll window = new Roll();
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
	public Roll() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JMenuItem diceFace;
		
		ImageIcon die1 = new ImageIcon("../chapter10/src/SkillBuilders/diceFace1.gif");
		ImageIcon die2 = new ImageIcon("../chapter10/src/SkillBuilders/diceFace2.gif");
		ImageIcon die3 = new ImageIcon("../chapter10/src/SkillBuilders/diceFace3.gif");
		ImageIcon die4 = new ImageIcon("../chapter10/src/SkillBuilders/diceFace4.gif");
		ImageIcon die5 = new ImageIcon("../chapter10/src/SkillBuilders/diceFace5.gif");
		ImageIcon die6 = new ImageIcon("../chapter10/src/SkillBuilders/diceFace6.gif");
		
		Random rand = new Random();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 136, 157);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
			
		diceFace = new JMenuItem("");
		diceFace.setIcon(new ImageIcon("C:\\Users\\48300001\\git\\CS-30\\chapter10\\src\\SkillBuilders\\diceFace1.gif"));
		diceFace.setBounds(10, 0, 90, 90);
		panel.add(diceFace);
		
		JButton rollButton = new JButton("Roll Dice");
		rollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int roll = rand.nextInt(5);
				
				ImageIcon currentFace = switch(roll) {
				case 0 -> die1;				
				case 1 -> die2;
				case 2 -> die3;
				case 3 -> die4;
				case 4 -> die5;
				case 5 -> die6;
				default -> die1;
				};
				diceFace.setIcon(currentFace);
			}
		});
	
		rollButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rollButton.setBounds(0, 83, 100, 27);
		panel.add(rollButton);
	}
	
	
	
	
	
	
}
