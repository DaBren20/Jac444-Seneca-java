/*
 ============================================================================
 Name        : Account.java
 Author      : Brendan Polius Prosper
 Email       : bkpoliusprosper@myseneca.ca
 Student #   : 022541114
 Course Code : JAC 444
 Date        : August 3, 2021
 ============================================================================
 */

package lab9;

public class Account {
	
	private int balance;
	private String currency;
	
	Account(int balance, String currency) {
		this.balance = balance;
		this.currency = currency;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public String getCurrency() {
		return this.currency;
	}
	
	public synchronized void withdraw(int value) {
		while (getBalance() < value) {
			try {
				System.out.println("Insufficient Balance!!!");
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		
		setBalance(getBalance() - value);
		System.out.println("Withdraw: " + value + " " + getCurrency() + ".");
		System.out.println("Balance: " + getBalance() + " " + getCurrency() + ".\n");
		notify();
	}
	
	public synchronized void deposit(int value, String currency) {
		while (getBalance() != 0 && getCurrency() != currency) {
			try {
					System.out.println("Invalid Currency!!! Different currency!!!");
					wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		if(getCurrency() == currency) {
			setCurrency(currency);
			setBalance(balance += value);
		}
		
		else {
			setCurrency(currency);
			setBalance(value);
		}
		
		System.out.println("Deposit: " + value + " " + currency + ".");
		System.out.println("Balance: " + getBalance() + " " + getCurrency() + ".\n");
		notify();
	}
}
