/*

Program: LocalBank.java          Last Date of this Revision: October 6, 2026

Purpose: Allow a user to create or delete their bank account, and withdraw, deposit or check their ballance

Author: Leif Martin, 
School: CHHS
Course: Computer Programming CSE3010

*/

package Mastery;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LocalBank {

	private JFrame frame;
	private JTextField inputAccountID, inputDepositWithdrawel, inputFirstName, inputLastName, inputBeginningBalance;
	private JComboBox selectAction;
	private JTextArea outputTxt;

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

	public LocalBank() {
		initialize();
	}

	private void initialize() {
		
		Bank bank = new Bank();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 302, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		selectAction = new JComboBox();
		selectAction.setModel(new DefaultComboBoxModel(new String[] {"Deposit", "Withdrawel", "Check Balance", "Add Account", "Remove Account"}));
		selectAction.setBounds(20, 36, 250, 22);
		panel.add(selectAction);
		
		JLabel selectActionTxt = new JLabel("Select an Action");
		selectActionTxt.setBounds(20, 11, 113, 14);
		panel.add(selectActionTxt);
		
		JLabel completeInformationTxt = new JLabel("Complete the information in RED");
		completeInformationTxt.setBounds(20, 69, 155, 14);
		panel.add(completeInformationTxt);
		
		JLabel accountIDTxt = new JLabel("Account ID:");
		accountIDTxt.setForeground(Color.RED);
		accountIDTxt.setBounds(20, 94, 237, 14);
		panel.add(accountIDTxt);
		
		JLabel depositWithdrawelTxt = new JLabel("Amount of deposit/withdrawel:");
		depositWithdrawelTxt.setForeground(Color.RED);
		depositWithdrawelTxt.setBounds(20, 140, 267, 14);
		panel.add(depositWithdrawelTxt);
		
		JLabel firstNameTxt = new JLabel("First Name:");
		firstNameTxt.setBounds(20, 185, 218, 14);
		panel.add(firstNameTxt);
		
		JLabel lastNameTxt = new JLabel("Last Name:");
		lastNameTxt.setBounds(20, 233, 113, 14);
		panel.add(lastNameTxt);
		
		JLabel beginningBalanceTxt = new JLabel("Beginning Balance:");
		beginningBalanceTxt.setBounds(20, 278, 246, 14);
		panel.add(beginningBalanceTxt);
		
		inputAccountID = new JTextField();
		inputAccountID.setBounds(20, 109, 250, 20);
		panel.add(inputAccountID);
		inputAccountID.setColumns(10);
		
		inputDepositWithdrawel = new JTextField();
		inputDepositWithdrawel.setColumns(10);
		inputDepositWithdrawel.setBounds(20, 154, 250, 20);
		panel.add(inputDepositWithdrawel);
		
		inputFirstName = new JTextField();
		inputFirstName.setColumns(10);
		inputFirstName.setBounds(20, 202, 250, 20);
		panel.add(inputFirstName);
		
		inputLastName = new JTextField();
		inputLastName.setColumns(10);
		inputLastName.setBounds(20, 247, 250, 20);
		panel.add(inputLastName);
		
		inputBeginningBalance = new JTextField();
		inputBeginningBalance.setColumns(10);
		inputBeginningBalance.setBounds(20, 293, 250, 20);
		panel.add(inputBeginningBalance);
		
		outputTxt = new JTextArea("Account Info Displayed Here");
		outputTxt.setBounds(20, 324, 250, 48);
		panel.add(outputTxt);
			
		JButton processTransaction = new JButton("Process Transaction");
		processTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String acctID = inputAccountID.getText().trim();				
				String lName = inputLastName.getText();
				String fName = inputFirstName.getText();
				double initialBal = Double.parseDouble(inputBeginningBalance.getText());				
							
				switch((String)selectAction.getSelectedItem()) {			
				case "Deposit":
					outputTxt.setText(bank.transaction("Deposit", acctID, Double.parseDouble(inputDepositWithdrawel.getText())));
					break;			
				case "Withdrawel":
					outputTxt.setText(bank.transaction("Withdrawel", acctID, Double.parseDouble(inputDepositWithdrawel.getText())));
					break;				
				case "Remove Account":
					outputTxt.setText(bank.deleteAccount(acctID));
					break;								
				case "Add Account":
					 if(inputBeginningBalance.getText().isEmpty()) { outputTxt.setText("Please enter an initial balance."); break; }
					outputTxt.setText(bank.addAccount(initialBal, fName, lName));
					break;				
				case "Check Balance":
					outputTxt.setText(bank.getBalance(acctID));
					break;			
				default:
					outputTxt.setText("Please select an action and try again.");
					break;
				}
			}
		});
		processTransaction.setBounds(20, 384, 250, 23);
		panel.add(processTransaction);
	}

}

