package Mastery;

import java.util.ArrayList;

public class Bank {
	
	private ArrayList<Account> accounts;

	public Bank() {
		accounts = new ArrayList();
	}
	
	public String addAccount(double bal, String fName, String lName) {
		Account newAcct;
		
		newAcct = new Account(bal, fName, lName);
		
		accounts.add(newAcct);
		return "Account created. Your ID is: " + newAcct.getID();
	}
	
	public String deleteAccount(String acctID) {
		int acctIndex;
		Account acctToMatch;
		
		acctToMatch = new Account(acctID);
		acctIndex = accounts.indexOf(acctToMatch);
		if (acctIndex >= 0) {
			accounts.remove(acctIndex);
			
			return "Account: " + acctID + " has been deleted.";
		}
		
		else {
			return "We cannot find that Account, please try again.";
		}	
	}
	
	public String transaction(String transactionCode, String acctID, double amt) {
		int acctIndex = accounts.indexOf(getAccount(acctID));
		
		if(acctIndex < 0) { return "Error, account not found"; }
		
		switch(transactionCode) {
		case "Deposit":	
			return accounts.get(acctIndex).deposit(amt);	
		case "Withdrawel":	
			return accounts.get(acctIndex).withdrawel(amt);
		}
		return "Error";
	}	
	
	public String getBalance(String acctID) {
		int acctIndex = accounts.indexOf(getAccount(acctID));	
		if(acctIndex < 0) { return "Error, account not found"; }
		
		return accounts.get(acctIndex).getBalance();		
	}
	
	private Account getAccount(String acctID) {
		int acctIndex;
		Account acctToMatch;
		
		acctToMatch = new Account(acctID);
		acctIndex = accounts.indexOf(acctToMatch);
		
		if (acctIndex >= 0) {
			return accounts.get(acctIndex);
		}
		return null;
	}
	
}

 