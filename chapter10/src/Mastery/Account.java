package Mastery;

import java.text.NumberFormat;
import java.util.Currency;

public class Account {
	private double balance;
	private Customer cust;
	private String acctID;
	
	public Account(double bal, String fName, String lName) {
		balance = bal;
		cust = new Customer(fName, lName);
		acctID = fName.substring(0, 1) + lName;
	}
	
	public Account(String ID) {
		balance = 0;
		cust = new Customer("", "");
		acctID = ID;
	}
	
	public String getID() { 
		return acctID; 
	}
	
	public String getBalance() { 
		return "Balance is: " + String.valueOf(balance); 
	}
	
	public String deposit(double amt) {
		balance += amt; 
		return "Balance is now: " + String.valueOf(balance);
	}
	
	public String withdrawel(double amt) {
		if(amt <= balance) {
			balance -= amt;
			return "Balance is now: " + String.valueOf(balance);
		}
		else {
			return "You do not have enough money for that transaction.";
		}
	}
	
	public boolean equals(Object acct) {
		Account testAcct = (Account)acct;
		if(acctID.equals(testAcct.acctID)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String accountString;
		NumberFormat money = NumberFormat.getCurrencyInstance();
		
		accountString = acctID + "\n";	
		accountString += cust.toString();
		accountString += "Current balance is " + money.format(balance);
		
		return accountString;
	}
}
