
package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;


public class BreakAPlate {
	
	
	
	private JFrame frame;
	private JPanel panel;
	private JButton play;
	private JMenuItem plates, prizeWon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BreakAPlate window = new BreakAPlate();
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
	public BreakAPlate() {
		initialize();		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		ImageIcon placeHolder = new ImageIcon("../chapter10/src/Mastery/placeholder.gif");
		ImageIcon plates_none_broken = new ImageIcon("../chapter10/src/Mastery/plates_none_broken.gif");
		ImageIcon plates_two_broken = new ImageIcon("../chapter10/src/Mastery/plates_two_broken.gif");
		ImageIcon plates_all_broken = new ImageIcon("../chapter10/src/Mastery/plates_all_broken.gif");
		ImageIcon sticker = new ImageIcon("../chapter10/src/Mastery/sticker.gif");
		ImageIcon tiger_plush = new ImageIcon("../chapter10/src/Mastery/tiger_plush.gif");
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		plates = new JMenuItem(plates_none_broken);
		plates.setBounds(37, 11, 349, 89);
		panel.add(plates);
		
		prizeWon = new JMenuItem("");
		prizeWon.setIcon(placeHolder);
		prizeWon.setBounds(238, 127, 196, 95);
		panel.add(prizeWon);
		
		play = new JButton("Play");
		play.setFont(new Font("Tahoma", Font.PLAIN, 16));
		play.addActionListener(new ActionListener() { // Button clicked
			public void actionPerformed(ActionEvent e) {
				
				Random rand = new Random();
				
				int score = 0;
				
				if(play.getText() == "Play") {
					for(int i = 0; i < 3; i++) { score += rand.nextInt(2); }
					
					if(score == 3) {
						plates.setIcon(plates_all_broken);
						prizeWon.setIcon(tiger_plush);
					}
					else {
						plates.setIcon(plates_two_broken);
						prizeWon.setIcon(sticker);
					}
					play.setText("Play Again");
					
				}
				else {
					play.setText("Play");
					prizeWon.setIcon(placeHolder);
					plates.setIcon(plates_none_broken);
				}
			}
		});
		
		play.setBounds(10, 127, 196, 82);
		panel.add(play);
	}
	
	
}

