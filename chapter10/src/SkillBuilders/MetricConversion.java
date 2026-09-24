package SkillBuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

public class MetricConversion {
	
	private JFrame frame;
	private JPanel contentPanel;
	private JComboBox comboBox;
	private JLabel selectConversionType;
	private JLabel finalAnswer;
	private JTextField inputUnits;
	private JLabel ratioLabel;
	

	
	String[] conversions = {"meters to feet", "feet to meters", "centimeters to inches", "inches to centimeters", "kilograms to pounds", "pounds to kilograms", "litres to gallons", "gallons to litres"};
	
	record ConversionData(double ratio, String unit1, String unit2) {}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MetricConversion window = new MetricConversion();
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
	public MetricConversion() {
		initialize();
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 231, 181);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		finalAnswer = new JLabel("Final Answer");
		finalAnswer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		finalAnswer.setBounds(10, 112, 200, 20);
		panel.add(finalAnswer);
		
		selectConversionType = new JLabel("Select Conversion Type");
		selectConversionType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		selectConversionType.setBounds(10, 11, 200, 20);
		panel.add(selectConversionType);
		
		ratioLabel = new JLabel();
		ratioLabel.setText("ratio");
		ratioLabel.setBounds(120, 81, 90, 20);
		panel.add(ratioLabel);
				
		inputUnits = new JTextField();
		inputUnits.setText("Input Units");
		inputUnits.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {				
				if(inputUnits.getText().equals("Input Units")) {
					inputUnits.setText("");
				}							
			}
		});
		inputUnits.setBounds(10, 81, 90, 20);
		panel.add(inputUnits);
		inputUnits.setColumns(10);
			
		comboBox = new JComboBox(conversions);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double unitsEntered = Double.parseDouble(inputUnits.getText());
				
				comboBox = (JComboBox)e.getSource();
				String conversionType = (String)comboBox.getSelectedItem();
				
				ConversionData data;
				
				data = switch(conversionType) {
				case "meters to feet" -> new ConversionData(3.281, "m", "ft");
				case "feet to meters" -> new ConversionData(0.3048, "ft", "m");
				case "centimeters to inches" -> new ConversionData(0.3937, "cm", "''");
				case "inches to centimeters" -> new ConversionData(2.54, "''", "cm");
				case "kilograms to pounds" -> new ConversionData(2.205, "kg", "lbs");
				case "pounds to kilograms" -> new ConversionData(0.4536, "lbs", "kg");
				case "litres to gallons" -> new ConversionData(0.2642, "L", "gal");
				case "gallons to litres" -> new ConversionData(3.785, "gal", "L");				
				default -> new ConversionData(0.0, "", "");
				};			
			
			Double ratio = data.ratio();
			String unit1 = data.unit1();
			String unit2 = data.unit2();
						
			String answer = String.valueOf(unitsEntered*ratio);
		
			ratioLabel.setText("* " + String.valueOf(ratio));
			finalAnswer.setText(inputUnits.getText() + unit1 + " = " + answer + unit2);
			}
		});

		comboBox.setBounds(10, 42, 200, 35);
		panel.add(comboBox);
		
		
		
		
	}
	

	

}
