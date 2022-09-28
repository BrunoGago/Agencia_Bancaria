package program;

import java.util.ArrayList;
import java.util.Scanner;

public class BankBranch {
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Account> bankAccount;
	
	public static void main(String[] args) {
		bankAccount = new ArrayList<Account>();
		
		operation();		
	}
	
	public static void operation() {
        System.out.println("------------------------------------------------------");
        System.out.println("-------------Welcome to Bank of Brazil---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Select an operation you want to perform *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Option 1 - Create account	 |");
        System.out.println("|   Option 2 - Deposit       	 |");
        System.out.println("|   Option 3 - Withdraw          |");
        System.out.println("|   Option 4 - Transfer          |");
        System.out.println("|   Option 5 - Account statement |");
        System.out.println("|   Option 6 - Exit          	 |");
        
        int operation = sc.nextInt();
        
        switch(operation) {
        case 1:
        	createAccount();
        	break;
        case 2:
        	deposit();
        	break;
        case 3:
        	withdraw();
        	break;
        case 4:
        	transferMoney();
        	break;
        case 5:
        	listAccount();
        	break;
        case 6:
        	System.out.println("Thanks for using Bank of Brazil!");
        	System.exit(0);
        default:
        	System.out.println("Invalid option!");
        	System.out.println();
        	operation();
        	break;        	
        }
	}
	
	public static void createAccount() {
		System.out.println("\nFull name: ");
    	sc.nextLine();
    	String name = sc.nextLine();
    	System.out.println("\nCPF: ");
    	String cpf = sc.next();
    	System.out.println("\nE-mail: ");
    	sc.nextLine();
    	String email = sc.nextLine();
    	
    	Client client = new Client(name, cpf, email);
    	
    	Account account = new Account(0, client, null);
    	bankAccount.add(account);
    	System.out.println("Your account number #" + account.getAccountNumber() + " was create sucessfully");
    	
    	System.out.println();
    	operation();    	
	}
	
	private static Account findAccount(int accountNumber) {
		Account account = null;
		if(bankAccount.size() > 0) {
			for(Account a : bankAccount) {
				if(a.getAccountNumber() == accountNumber) {
				account = a;
				}
			}
		}
		return account;
	}
	
	public static void deposit() {
		System.out.println("Account number: ");
		int accountNumber = sc.nextInt();
		
		Account account = findAccount(accountNumber);
		
		if(account != null) {
			System.out.println("Enter the deposit amount: ");
			Double depositAmount = sc.nextDouble();
			account.deposit(depositAmount);
		}else {
			System.out.println("Your deposit was not sucessful, account not found!");
		}
    	System.out.println();
		operation();
	}
	
	public static void withdraw() {
		System.out.println("Account number: ");
		int accountNumber = sc.nextInt();
		
		Account account = findAccount(accountNumber);
		
		if(account != null) {
			System.out.println("Enter the withdrawal amount: ");
			Double withdrawAmount = sc.nextDouble();
			account.withdraw(withdrawAmount);
		}else {
			System.out.println("Your withdrawal was not sucessful, account not found!");
		}
    	System.out.println();
		operation();
	}
	
	public static void transferMoney() {
		System.out.println("Sender account number: ");
		int accountNumberSender = sc.nextInt();
		
		Account accountSender = findAccount(accountNumberSender);
		
		if(accountSender != null) {
			System.out.println("Enter the recipient account number: ");
			int accountNumberRecipient = sc.nextInt();
			
			Account accountRecipient = findAccount(accountNumberRecipient);
			
			if(accountRecipient != null) {
				System.out.println("Enter the transfer amount: ");
				Double value = sc.nextDouble();
				
				accountSender.transferMoney(accountRecipient, value);
			}
		}
    	System.out.println();
		operation();
	}
	
	public static void listAccount() {
		if(bankAccount.size() > 0) {
			for(Account account : bankAccount) {
				System.out.println(account);
			}
		}else{
			System.out.println("Account not found!");
		}
    	System.out.println();
		operation();
	}
}