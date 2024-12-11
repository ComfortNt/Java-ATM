package Java.ATM;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Account {
	
	private int customerNumber;
	private int pinNumber;
	private double checkingBalance = 0;
	private double savingBalance = 0;
	
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyformat = new DecimalFormat("'$'###,##0.00");
	
	
	public void setCustomerNumber(int customer) {
		 this.customerNumber = customer;
	};
	
	public int getCustomerNumber() {
		return customerNumber;
	};
	
	public void setPinNumber(int pin) {
		this.pinNumber = pin;
	};
	
	public int getPinNumber() {
		return pinNumber;
	};
	
	
	public double getCheckingBalance() {
		return checkingBalance;
	}
	
	
	public double getSavingBalance() {
		return savingBalance;
	}
	
	
	public double caclCheckingWithdraw(double amount) {
		checkingBalance = (checkingBalance - amount);
		return checkingBalance;
	}
	
	public double calcSavingWithdraw(double amount) {
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}
	
	public double calcCheckingDeposit( double amount) {
		checkingBalance = (checkingBalance + amount);
		return checkingBalance;
	}
	
	public double calcSavingDeposit( double amount) {
		checkingBalance = (savingBalance + amount);
		return savingBalance;
	}
	 
	public void getCheckingWithdrawInput() {
		
		System.out.println("Checking Account Balance: " + moneyformat.format(checkingBalance));
		System.out.println("Amount You want to withdraw");
		// amount customer wants to withdraw
		double amount = input.nextDouble();
		
		if((checkingBalance - amount) >=0) {
			caclCheckingWithdraw(amount);
			System.out.println("Updated Balance: " + moneyformat.format(checkingBalance));
		}else {
			System.out.println("\n"+"Balance cannot be negetive");
		}
		
	}


	public void getCheckingDepositInput() {
		System.out.println("Checking Account Balance: " + moneyformat.format(checkingBalance));
		System.out.println("Amount You want to Deposit");
		double amount = input.nextDouble();
		
		if((checkingBalance + amount) >= 0) {
		calcCheckingDeposit(amount);
		System.out.println("Updated Balance: " + moneyformat.format(checkingBalance));
		}else {
			System.out.println("\n"+"Balance cannot be negetive");
		}
	}
	
	public void getsavingWithdrawInput(){
		
		System.out.println("Saving Account Balance: " + moneyformat.format(savingBalance));
		System.out.println("Amount You want to withdraw");
		// amount customer wants to withdraw from saving
		double amount = input.nextDouble();
		
		if((savingBalance - amount) >=0) {
			calcSavingWithdraw(amount);
			System.out.println("Updated Balance: " + moneyformat.format(savingBalance));
		}else {
			System.out.println("\n"+"Balance cannot be negetive");
		}
	}
	
	public void getsavingDepositInput() {
		
		System.out.println("Saving Account Balance: " + moneyformat.format(savingBalance));
		System.out.println("Amount You want to Deposit");
		// amount customer wants to Deposit into saving
		double amount = input.nextDouble();
		
		if((savingBalance + amount) >=0) {
			calcSavingDeposit(amount);
			System.out.println("Updated Balance: " + moneyformat.format(savingBalance));
		}else {
			System.out.println("\n"+"Balance cannot be negetive");
		}
	}
	
	
	

}
