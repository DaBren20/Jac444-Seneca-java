/*
 ============================================================================
 Name        : Triangle.java
 Author      : Brendan Polius Prosper
 Email       : bkpoliusprosper@myseneca.ca
 Student #   : 022541114
 Course Code : JAC 444
 Date        : June 8, 2021
 ============================================================================
 */

package lab6;

public class Triangle implements Shapes{
	private double sideA;
	private double sideB;
	private double sideC;
	
	
	public Triangle(double a, double b, double c) {

		this.sideA = a;
		this.sideB = b;
		this.sideC = c;
	}
	
	public double getSideA() {
		return sideA;
	}
	
	public double getSideB() {
		return sideB;
	}
	
	public double getSideC() {
		return sideC;
	}
	
	public void setSideA(double a) {
		this.sideA = a;
	}
	
	public void setSideB(double b) {
		this.sideB = b;
	}
	
	public void setSideC(double c) {
		this.sideC = c;
	}
	
	//@Override will override the shapes class to use it's functions to calculate perimeter
	@Override
	public double calculatePerimeter() {
		return getSideA() + getSideB() + getSideC();
	}
	
	@Override
	public String toString() {
		return String.format("Triangle {s1=%.1f, s2=%.1f, s3=%.1f} perimeter = %06g", getSideA(), getSideB(), getSideC(), calculatePerimeter());
	}
	
	@Override
	public String getShapetype() {
		return "Triangle";
	}
}
