/*
 ============================================================================
 Name        : Deposit.java
 Author      : Brendan Polius Prosper
 Email       : bkpoliusprosper@myseneca.ca
 Student #   : 022541114
 Course Code : JAC 444
 Date        : August 3, 2021
 ============================================================================
 */

package lab9;

public class Deposit extends Thread {
	private Account sharedAccount;
	private String[] currency;
	private int[] balance;
	
	public Deposit(Account sharedAccount, int[] balance, String[] currency) {
		this.sharedAccount = sharedAccount;
		this.balance = balance;
		this.currency = currency;
	}
	
	@Override
	public void run() {
		int i = 0;
		
		System.out.println("*** Deposit thread started ***\n");
		
		while (i >= 0 && i < balance.length) {
			synchronized(sharedAccount) {
				sharedAccount.deposit(balance[i], currency[i]);
				
				try {
					if (i < balance.length && i >= 0) {
						i++;
					}
					
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
