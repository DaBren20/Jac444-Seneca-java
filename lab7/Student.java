/*
 ============================================================================
 Name        : Student.java
 Author      : Brendan Polius Prosper
 Email       : bkpoliusprosper@myseneca.ca
 Student #   : 022541114
 Course Code : JAC 444
 Date        : July 7, 2021
 ============================================================================
 */

package lab7;


import java.text.DecimalFormat;
import java.util.ArrayList;

public class Student {
	private double grade;
	private String firstName;
	private String lastName;
	private String department;

	
	public Student() {
		
	}
	
	public Student(String firstname, String lastname, double grade, String department) {
		this.firstName = firstname;
		this.lastName = lastname;
		this.grade = grade;
		this.department = department;
	}
		
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}
	
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}
	
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	public void setDepartment(String dep) {
		this.department = dep;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public double getGrade() {
		return this.grade;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	@Override
	public String toString() {
		return getFirstName() + "		" + getLastName() + "		" + new DecimalFormat("0.00").format(getGrade()) 
				+ "		" + getDepartment();
	}
	
	
	
}
