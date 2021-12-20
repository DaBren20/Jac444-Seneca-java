/*
 ============================================================================
 Name        : Rectangle.java
 Author      : Brendan Polius Prosper
 Email       : bkpoliusprosper@myseneca.ca
 Student #   : 022541114
 Course Code : JAC 444
 Date        : June 8, 2021
 ============================================================================
 */
package Lab2;

public class Rectangle implements Shapes {
	
	private String name = "Rectangle";
	private double sideA;
	private double sideB;

	
	public Rectangle(String n, double a, double b) {
		this.name = n;
		this.sideA = a;
		this.sideB = b;
	}
	
	public double getSideA() {
		return sideA;
	}
	
	public double getSideB() {
		return sideB;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public void setSideA(double a) {
		this.sideA = a;
	}
	
	public void setSideB(double b) {
		this.sideB = b;
	}
	
	//@Override will override the shapes class to use it's functions to calculate perimeter
	@Override
	public double calculatePerimeter() {
		return 2 * sideA + 2 * sideB;
	}
	
	@Override
	public String toString() {
		return String.format("Rectangle {w=%.1f, h=%.1f} perimeter = %06g", getSideA(), getSideB(), calculatePerimeter());
	}
	
	@Override
	public String getShapetype() {
		return "Rectangle";
	}
	
}
