/*
 ============================================================================
 Name        : Withdraw.java
 Author      : Brendan Polius Prosper
 Email       : bkpoliusprosper@myseneca.ca
 Student #   : 022541114
 Course Code : JAC 444
 Date        : August 3, 2021
 ============================================================================
 */

package lab9;

public class Withdraw extends Thread{
	private Account sharedAccount;
	private int amount;
	
	public Withdraw(Account sharedAccount, int[] deposit) {
		this.sharedAccount = sharedAccount;
		this.amount = deposit.length;
	}
	
	@Override
	public void run() {
		
		System.out.println("*** Withdraw thread started ***\n");
		
		for (int i = 0; i < amount; i++) {
			synchronized(sharedAccount) {
				sharedAccount.withdraw(1);
				
				try {
						Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
