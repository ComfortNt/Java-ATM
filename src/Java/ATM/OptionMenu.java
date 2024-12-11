package Java.ATM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
	
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyformat = new DecimalFormat("'$'###,##0.00");
	
	HashMap<Integer , Integer> data = new HashMap<Integer , Integer>();
	
	public void getLogin() throws IOException{
		
			int x = 1;	
		do {

			try {
				
				data.put(952141, 19104);
				data.put(989947, 71976);
				
				System.out.println("Welcome to the ATM Project");
				System.out.println("Enter Your Customer Number");
				//Customer number has been put into the hashMap
				setCustomerNumber(menuInput.nextInt());
				
				System.out.println("Enter Pin Number:");
				setPinNumber(menuInput.nextInt());
				
			}catch(Exception e) {
				System.err.print( "\n" +"Invalid Character(s) . Only Numbers." +"\n");
				x=2;
			}
			
				int cn = getCustomerNumber();
				int pn = getPinNumber();
				
				if( data.containsKey(cn) && data.get(cn) == pn) {
					getAccountType();
				}else {
					System.out.println("\n" + "Wrong Customer Number or Pin" + "\n");
				
			}
		}while(x == 1);
		
	}
	
	public void getAccountType() {
		System.out.println("Select the Account you want to access");
		System.out.println("Type 1 - Checking Account");
		System.out.println("Type 2 - Savings Account");
		System.out.println("Type 3 - Exit");
		
		int selection = menuInput.nextInt();
		
		switch(selection) {
			
		case 1 : getChecking();
		break;
		
		case 2 : getSaving();
		break;
		
		case 3 : System.out.println("Thanky for Banking with Us."+"\n");
		break;
		}
	}

	public void getChecking() {
		
		System.out.println("Checking Account");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw  Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.print("Choice: ");
		
		int selection = menuInput.nextInt();
		
		switch(selection) {
		
		case 1 : System.out.println("Checking Account Balance: " + moneyformat.format(getCheckingBalance()));
		getChecking();
		break;
		
		case 2:
		getCheckingWithdrawInput();
		getAccountType();
		break;
		
		case 3: 
		getCheckingDepositInput();
		getAccountType();
		break;
		
		case 4 : System.out.println("Type 3 - Exit");
		break;
		
		default: System.err.println("\n" +"Invalid Choice "+ "\n");
		getChecking();
		break;
		}
		
		
		
	}

	public void getSaving() {
	
	System.out.println("Saving Account");
	System.out.println("Type 1 - View Balance");
	System.out.println("Type 2 - Withdraw  Funds");
	System.out.println("Type 3 - Deposit Funds");
	System.out.println("Type 4 - Exit");
	System.out.print("Choice: ");
	
	int selection = menuInput.nextInt();
	
	switch(selection) {
	
	case 1 : System.out.println("Savings Account Balance: " + moneyformat.format(getSavingBalance()));
	getAccountType();
	break;
	
	case 2:
	getsavingWithdrawInput();
	getAccountType();
	break;
	
	case 3: 
	getsavingDepositInput();
	getAccountType();
	break;
	
	case 4 : System.out.println("Exit");
	break;
	
	default: System.err.println("\n" +"Invalid Choice "+ "\n");
	getChecking();
	break;
	}
	
	
	}




}