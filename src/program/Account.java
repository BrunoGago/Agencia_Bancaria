package program;

import utilities.Useful;

public class Account {
	
	private static int AccountNumberCount = 1;
	
	private int accountNumber;
	private Client client;
	private Double accountBalance = 0.0;
	
	public Account() {
		
	}
	
	public Account(int accountNumber, Client client, Double inicialBalance) {
		this.accountNumber = AccountNumberCount;
		this.client = client;
		AccountNumberCount += 1;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public String toString() {
		return "\nAccount number: " + this.getAccountNumber() +
				"\nName: " + this.client.getName() +
				"\nCPF: " + this.client.getCpf() +
				"\nEmail: " + this.client.getEmail() +
				"\nAccount Balance: " + Useful.doubleToString(this.getAccountBalance());
	}
	
	public void deposit(Double value) {
		if(value > 0) {
			setAccountBalance(getAccountBalance() + value);
			System.out.println("Your deposit was successful!");
		}else {
			System.out.println("Your deposit was not sucessful, please check the typed amount!");
		}
	}
	
	public void withdraw(Double value) {
		if(value > 0 && this.getAccountBalance() >= value) {
			setAccountBalance(getAccountBalance() - value);
			System.out.println("Your withdraw was successful!");
		}else {
			System.out.println("Your withdraw was not sucessful, please check the typed amount!");
		}
	}
	
	public void transferMoney(Account accountTransfer, Double value) {
		if(value > 0 && this.getAccountBalance() >= value) {
			setAccountBalance(getAccountBalance() - value);
			//this.accountBalance = this.getAccountBalance() - accountBalance;
			accountTransfer.accountBalance = accountTransfer.getAccountBalance() + value;
			System.out.println("Transfer performed successfully!");
		}else {
			System.out.println("Your money transfer was not sucessful, please check the typed amount!");
		}
	}
}