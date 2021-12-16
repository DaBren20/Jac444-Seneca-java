/*
 ============================================================================
 Name        : Palindrome.java
 Author      : Brendan Polius Prosper
 Email       : bkpoliusprosper@myseneca.ca
 Student #   : 022541114
 Course Code : JAC 444
 Date        : June 1, 2021
 ============================================================================
 */

package lab1;

public class Palindrome {
	
	//Checks if the string is a boolean
	public static boolean isPalindrome(String input) {
		char[] word1 = input.toCharArray();
		char[] word2 = new char[0];
		
		Stack palindrome = new Stack(word1);
		Stack revPalindrome = new Stack(word2);
		
		//Reverses the string
		for(int i = 0; i < word1.length; i++) {
			revPalindrome.push(palindrome.pop());
		}
		
		word2 = revPalindrome.getArray();
		
		//Compares if the reverse string is the same as the inputed string
		for(int i = 0; i < word1.length; i++) {
			if(word1[i] == word2[i] ) {
				return true;
			}
			
			else if (word1[i] != word2[i]) {
				return false;
			}
		}
		return true;
	}

	
	//main
	public static void main(String[] args) {	
		
		String input = args[0];
		
		if(isPalindrome(input)) {
			System.out.println(input + " is a correct Palindrome");
		}
		
		else {
			System.out.println(input + " is not a correct Palindrome");
		}
		
	}
}