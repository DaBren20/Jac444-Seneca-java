/*
 ============================================================================
 Name        : Parallogram.java
 Author      : Brendan Polius Prosper
 Email       : bkpoliusprosper@myseneca.ca
 Student #   : 022541114
 Course Code : JAC 444
 Date        : June 8, 2021
 ============================================================================
 */

package Lab2;

public class Parallogram implements Shapes{
	private String name = "Parallelogram";
	private double pLength;
	private double pWidth;

	
	public Parallogram(String n, double length, double width) {
		this.name = n;
		this.pLength = length;
		this.pWidth = length;
	}
	
	public double getLength() {
		return pLength;
	}
	
	public double getWidth() {
		return pWidth;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public void setLength(double a) {
		this.pLength = a;
	}
	
	public void setSideB(double b) {
		this.pWidth = b;
	}
	
	
	//@Override will override the shapes class to use it's functions to calculate perimeter
	@Override
	public double calculatePerimeter() {
		return 2 * pWidth + 2 * pLength;
	}
	
	@Override
	public String toString() {
		return String.format("Parallogram {W=%.1f, H=%.1f} perimeter = %06g", getLength(), getWidth(), calculatePerimeter());
	}
	
	@Override
	public String getShapetype() {
		return "Parallelogram";
	}
}
