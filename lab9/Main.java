/*
 ============================================================================
 Name        : Main.java
 Author      : Brendan Polius Prosper
 Email       : bkpoliusprosper@myseneca.ca
 Student #   : 022541114
 Course Code : JAC 444
 Date        : August 3, 2021
 ============================================================================
 */

package lab9;

public class Main {
	public static void main(String[] args) {
		int[] balance = { 1, 1, 1, 1, 1, 1};
		String[] currency = {"Dollar(s)", "Euro(s)", "Euro(s)", "Pound(s)", "Pound(s)", "Pound(s)"};
		Account sharedAccount = new Account(0, "");
		
		Thread withdraw = new Withdraw(sharedAccount, balance);
		Thread deposit = new Deposit(sharedAccount, balance, currency);
		
		withdraw.start();
		deposit.start();
		
		try {
			withdraw.join();
			deposit.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
