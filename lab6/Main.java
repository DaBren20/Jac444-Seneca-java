package lab6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static int counter;
	public static String name;
	
	//Reads from Shapes.txt file
	public static void readFile(final String data, List<Shapes> shapes) { 
	try (BufferedReader br = new BufferedReader(new FileReader(data))) {
		while ((name = br.readLine()) != null) {
		String[] tokens = name.split(",");
		if(tokens[0].equals("Circle")) {
            if(Double.parseDouble(tokens[1]) <= 0) {
                System.out.println("Invalid radius!");
            }
            else {
                shapes.add(new Circle(Double.parseDouble(tokens[1])));
                counter++;
            }
		}
        else if(tokens[0].equals("Square")) {
            if(Double.parseDouble(tokens[1]) <= 0) {
                System.out.println("Invalid Side!");
            }
            else {
                    shapes.add(new Square(name, Double.parseDouble(tokens[1])));
                    counter++;
               	 }
            }
        else if(tokens[0].equals("Rectangle")) {
            if(Double.parseDouble(tokens[1]) <= 0 || Double.parseDouble(tokens[2]) <= 0) {
                    System.out.println("Invalid Side(s)!");
            }
            else {
                	shapes.add(new Rectangle(name, Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])));
                    counter++;
                 }
            }
         else if(tokens[0].equals("Parallelogram")) {
            if(Double.parseDouble(tokens[1]) <= 0 || Double.parseDouble(tokens[2]) <= 0) {
                 	System.out.println("Invalid Side(s)!");
            }
            else {
                 	shapes.add(new Parallogram(name, Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])));
                    counter++;
                 }
            }
         else if(tokens[0].equals("Triangle")) {
            if(Double.parseDouble(tokens[1]) <= 0 || Double.parseDouble(tokens[2]) <= 0 || Double.parseDouble(tokens[3]) <= 0) {
                    System.out.println("Invalid Side(s)!");
                }
            else {
                   shapes.add(new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3])));
                   counter++;
                }
            }
		
		}
		} catch (IOException e) {
		System.out.println(e.getMessage());
		}
	}
	
	public static void printList(List<Shapes> shapes) {
		for(Shapes i: shapes) {
			System.out.println(i);
			System.out.println();
		}
	}
	
	
	public static void removeShape(List<Shapes> shapes) {
		double smallTriangle = 1000;
		double bigCircle = 0;
		int smallTriangleIndex = -1;
		int bigCircleindex = -1;
		
		for(int i = 0; i < shapes.size(); i++) {
			if(shapes.get(i).calculatePerimeter() <= smallTriangle && shapes.get(i).getShapetype().equals("Triangle")) {
				smallTriangle = shapes.get(i).calculatePerimeter();
				smallTriangleIndex = i;
			}
		}
		
		shapes.remove(smallTriangleIndex);
		
		for(int i = 0; i < shapes.size(); i++) {
			if(shapes.get(i).calculatePerimeter() >= bigCircle  && shapes.get(i).getShapetype().equals("Circle")) {
				bigCircle = shapes.get(i).calculatePerimeter();
				bigCircleindex = i;
			}
		}
		
		shapes.remove(bigCircleindex);
	}
	
	//Task 3
	public static double addParallogram(List<Shapes> shapes) {
		double totalParallogram = 0;
		
		for(int i = 0; i < shapes.size(); i++) {
			if(shapes.get(i).getShapetype().equals("Triangle")) {
				totalParallogram += shapes.get(i).calculatePerimeter();
			}
		}
		
		return totalParallogram;
	}
	
	
	public static double addTriangle(List<Shapes> shapes) {
		double totalTriangle = 0;
		
		for(int i = 0; i < shapes.size(); i++) {
			if(shapes.get(i).getShapetype().equals("Parallelogram")) {
				totalTriangle += shapes.get(i).calculatePerimeter();
			}
		}
		
		return totalTriangle;
	}
	

	
	//Prints out a list of shapes
	public static void main(String args[]) {
		List<Shapes> count = new ArrayList<>();
		System.out.println("------->JAC 444 Assignment 1<-------");
		System.out.println("------->Task 1 ... <-------\r\n");
		readFile("Shapes.txt", count);
		System.out.println(counter + " shapes were created:");
		printList(count);
		System.out.println("------->Task 2 ... <-------\r\n");
		removeShape(count);
		printList(count);
		System.out.println("------->Task 3 ... <-------\r\n");
		System.out.println("Total perimeter of Parallelogram is: " + addParallogram(count));
		System.out.println("Total perimeter of Triangle is: " + addTriangle(count));
		System.out.println("------->Task 4 ... <-------\r\n");
		//readFile("Shapes.txt", count);
		//System.out.println(counter + " shapes were created:");
		printList(count);
	}
	
}
