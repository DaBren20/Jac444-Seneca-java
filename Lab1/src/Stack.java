/*
 ============================================================================
 Name        : Stack.java
 Author      : Brendan Polius Prosper
 Email       : bkpoliusprosper@myseneca.ca
 Student #   : 022541114
 Course Code : JAC 444
 Date        : June 1, 2021
 ============================================================================
 */

package lab1;

public class Stack {

    private char[] storage;

    public Stack(char [] array) {
    	this.storage = array;
    }

    //Takes the first character of the given string
    public void push(char word) {
        char temp[] = new char[storage.length + 1];
        System.arraycopy(storage, 0, temp, 0, storage.length);
        temp[temp.length - 1] = word;
        storage = temp;
    }

  //Takes the last character of the given string
    public char pop() {
        char[] temp = new char[storage.length - 1];
        char temp2 = storage[storage.length - 1];
        System.arraycopy(storage, 0, temp, 0, storage.length - 1);
        storage = temp;
        
        return temp2;
    }
    
    public char[] getArray() {
    	return storage;
    }
}