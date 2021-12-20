/*
 ============================================================================
 Name        : Square.java
 Author      : Brendan Polius Prosper
 Email       : bkpoliusprosper@myseneca.ca
 Student #   : 022541114
 Course Code : JAC 444
 Date        : June 8, 2021
 ============================================================================
 */

package Lab2;

public class Square implements Shapes{
	
	private String name = "Square";
	private double sLength;

	
	public Square(String n, double a) {
		this.name = n;
		this.sLength = a;
	}
	
	public double getLength() {
		return sLength;
	}
	
	public void setLength(double sides) {
		sLength = sides;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	
	//@Override will override the shapes class to use it's functions to calculate perimeter
	@Override
	public String toString() {
		return String.format("Square {S=%.1f} perimeter = %06g", getLength(), calculatePerimeter());
	}
	
	@Override
	public double calculatePerimeter() {
		return 4*sLength;
	}
	
	@Override
	public String getShapetype() {
		return "Square";
	}
}
