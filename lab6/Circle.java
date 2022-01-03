/*
 ============================================================================
 Name        : Circle.java
 Author      : Brendan Polius Prosper
 Email       : bkpoliusprosper@myseneca.ca
 Student #   : 022541114
 Course Code : JAC 444
 Date        : June 8, 2021
 ============================================================================
 */

package lab6;

public class Circle implements Shapes {
	private double radius;
	
	//Lambda Expression to calculate area
	public ShapeArea obj = () -> Math.PI * getRadius() * getRadius();
	
	public Circle(double rad) {
			this.radius = rad;
	}
	
	public double getRadius() {
		return radius;
	}
	
	//@Override will override the shapes class to use it's functions to calculate perimeter
	@Override
	public String toString() {
		return String.format("Circle {r=%.1f} perimeter = %06g Area = %06g", getRadius(), calculatePerimeter(), obj.calculateArea());
	}
	
	@Override
	public double calculatePerimeter() {
		return 2 * radius * Math.PI;
	}
	
	@Override
	public String getShapetype() {
		return "Circle";
	}
}
