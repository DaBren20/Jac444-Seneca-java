/*
 ============================================================================
 Name        : Student.java
 Author      : Brendan Polius Prosper
 Email       : bkpoliusprosper@myseneca.ca
 Student #   : 022541114
 Course Code : JAC 444
 Date        : June 22, 2021
 ============================================================================
 */

package lab5;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{
	private int stdID = 0;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses = new ArrayList<String>();
	
	public Student() {
		
	}
	
	public Student(int id, String firstname, String lastname, ArrayList<String> courses) {
		this.stdID = id;
		this.firstName = firstname;
		this.lastName = lastname;
		this.courses = courses;
	}
	
	public void setID(int id) {
		this.stdID = id;
	}
	
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}
	
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}
	
	public void setCourses(String courses) {
		this.courses.add(courses);
	}
	
	public int getID() {
		return stdID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public ArrayList<String> getCourses() {
		return courses;
	}
}
