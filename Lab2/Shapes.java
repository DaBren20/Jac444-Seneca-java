/*
 ============================================================================
 Name        : Shapes.java
 Author      : Brendan Polius Prosper
 Email       : bkpoliusprosper@myseneca.ca
 Student #   : 022541114
 Course Code : JAC 444
 Date        : June 8, 2021
 ============================================================================
 */


//This class is an interface that will be used by all of the other shape classes to calculate perimeter and radius
package Lab2;

public interface Shapes {
	public String toString();
	public double calculatePerimeter();
	public String getShapetype();
}
