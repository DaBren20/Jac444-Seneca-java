/*
 ============================================================================
 Name        : StudentProcess.java
 Author      : Brendan Polius Prosper
 Email       : bkpoliusprosper@myseneca.ca
 Student #   : 022541114
 Course Code : JAC 444
 Date        : July 27, 2021
 ============================================================================
 */

package lab7;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentProcess {
	
	private static Student[] students = {
			 new Student("Jack", "Smith", 50.0, "IT"),
			 new Student("Aaron", "Johnson", 76.0, "IT"),
			 new Student("Maaria", "White", 35.8, "Business"),
			 new Student("John", "White", 47.0, "Media"),
			 new Student("Laney", "White", 62.0, "IT"),
			 new Student("Jack", "Jones", 32.9, "Business"),
			 new Student("Wesley", "Jones", 42.89, "Media")
	};
	
	public static void main(String[] args) {
		
		//Task 1
		System.out.println("Task 1:\n");
		System.out.println("Complete Student List:");
		List<Student> list = Arrays.asList(students);
		list.forEach(System.out::println);
		
		//Task 2
		System.out.println("------------------------------------------\n");
		System.out.println("Task 2:\n");
		System.out.println("Students who got 50.0-100.0 sorted by grade:\n");
		list.stream()
			.filter(s -> s.getGrade() >= 50 && s.getGrade() <= 100)
			.sorted(Comparator.comparing(Student::getGrade))
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		//Task 3
		System.out.println("------------------------------------------\n");
		System.out.println("Task 3:\n");
		System.out.println("First Student who got 50.0-100.0:\r\n");
		Optional<Student> student = list.stream()
			.filter(s -> s.getGrade() >= 50 && s.getGrade() <= 100)
			.findFirst();
		System.out.println(student.get());
		
		//Task 4
		System.out.println("------------------------------------------\n");
		System.out.println("Task 4:\n");
		System.out.println("Students in ascending order by last name then first:\n");
		list.stream()
			.sorted(Comparator.comparing(Student::getFirstName))
			.sorted(Comparator.comparing(Student::getLastName))
			.collect(Collectors.toList())
			.forEach(System.out::println);
		System.out.println();
		
		System.out.println("Students in descending order by last name then first:\r\n");
		list.stream()
			.sorted(Comparator.comparing(Student::getFirstName).reversed())
			.sorted(Comparator.comparing(Student::getLastName).reversed())
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		//Task 5
		System.out.println("------------------------------------------\n");
		System.out.println("Task 5:\n");
		System.out.println("Unique Student last names:\n");
		list.stream()
			.sorted(Comparator.comparing(Student::getLastName))
			.map(Student::getLastName)
			.distinct()
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		//Task 6
		System.out.println("------------------------------------------\n");
		System.out.println("Task 6:\n");
		System.out.println("Student names in order by last name then first name: \n");
		list.stream()
			.sorted(Comparator.comparing(Student::getFirstName))
			.sorted(Comparator.comparing(Student::getLastName))
			.map(Student::getName)
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		//Task 7
		System.out.println("------------------------------------------\n");
		System.out.println("Task 7:\n");
		System.out.println("Students by department: \n");
		System.out.println("Business:\n");
		list.stream()
			.filter(s -> s.getDepartment().equalsIgnoreCase("Business"))
			.map(s -> s.toString())
			.collect(Collectors.toList())
			.forEach(System.out::println);
		System.out.println();
		System.out.println("Media:\n");
		list.stream()
			.filter(s -> s.getDepartment().equalsIgnoreCase("Media"))
			.map(s -> s.toString())
			.collect(Collectors.toList())
			.forEach(System.out::println);
		System.out.println();
		System.out.println("IT:\n");
		list.stream()
			.filter(s -> s.getDepartment().equalsIgnoreCase("IT"))
			.map(s -> s.toString())
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		//Task 8
		System.out.println("------------------------------------------\n");
		System.out.println("Task 8:\n");
		System.out.println("Count of Students by department:\n");
		System.out.println("Business has " + 
		list.stream()
			.filter(s -> s.getDepartment().equalsIgnoreCase("Business"))
			.map(s -> "  " + s.toString())
			.collect(Collectors.toList())
			.size() + " student(s)");
		
		System.out.println("Media has " + 
		list.stream()
			.filter(s -> s.getDepartment().equalsIgnoreCase("Media"))
			.map(s -> "  " + s.toString())
			.collect(Collectors.toList())
			.size() + " student(s)");
		
		System.out.println("IT has " + 
		list.stream()
			.filter(s -> s.getDepartment().equalsIgnoreCase("IT"))
			.map(s -> "  " + s.toString())
			.collect(Collectors.toList())
			.size() + " student(s)");
		
		//Task 9
		System.out.println("------------------------------------------\n");
		System.out.println("Task 9:\n");
		System.out.println("Sum of Students' grades: " + 
		list.stream()
			.mapToDouble(Student::getGrade)
			.sum());
		
		//Task 10
		System.out.println("------------------------------------------\n");
		System.out.println("Task 10:\n");
		System.out.println("Average of Students' grades: " + 
				new DecimalFormat("0.00")
				.format(list.stream()
						.mapToDouble(Student::getGrade)
						.sum()/list.stream()
						.collect(Collectors.toList()).size()));
	}
}
