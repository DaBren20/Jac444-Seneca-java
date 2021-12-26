/*
 ============================================================================
 Name        : SerializeGUI.java
 Author      : Brendan Polius Prosper
 Email       : bkpoliusprosper@myseneca.ca
 Student #   : 022541114
 Course Code : JAC 444
 Date        : July 6, 2021
 ============================================================================
 */

package lab5;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Lab3.Student;

public class SerializeGUI extends Student{
	
	public static void main(String args[]) throws IOException {
		
		JFrame frame = new JFrame("Serialize");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel input = new JPanel();
		input.setLayout(new BoxLayout(input, BoxLayout.Y_AXIS));
		input.setPreferredSize(new Dimension(300, 200));
		frame.add(input);
		
		JLabel studentIDLabel = new JLabel("Student ID: ");
		JTextField studentIDinput = new JTextField(10);
		studentIDinput.setPreferredSize(new Dimension(10, 20));
		input.add(studentIDLabel);
		input.add(studentIDinput);
		
		JLabel studentFirstNamelabel = new JLabel("First name: ");
		JTextField studentFirstNameInput = new JTextField(20);
		input.add(studentFirstNamelabel);
		input.add(studentFirstNameInput);
		
		JLabel studentLastNameLabel = new JLabel("Last name: ");
		JTextField studentLastNameInput = new JTextField(20);
		input.add(studentLastNameLabel);
		input.add(studentLastNameInput);
		
		JLabel coursesLabel = new JLabel("Courses seperated by commas: ");
		JTextField coursesInput = new JTextField(20);
		input.add(coursesLabel);
		input.add(coursesInput);
		
		JButton submit = new JButton("Submit");
		input.add(submit);
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent err1) {
				int stdID;
				String firstName;
				String lastName;
				String courses;
				
				Student stdInfo = new Student();
				
				//Saving inputs to the object	
				try {
					stdID = Integer.parseInt(studentIDinput.getText());
					stdInfo.setID(stdID);
				} catch(Throwable err2) {
					System.err.println(err2);
				}
				
				firstName = studentFirstNameInput.getText();
				stdInfo.setFirstName(firstName);
				
				lastName = studentLastNameInput.getText();
				stdInfo.setLastName(lastName);
				
				courses = coursesInput.getText();
				String[] comma = courses.split(",");
				for(int i = 0; i < comma.length; i++) {
					stdInfo.setCourses(comma[i]);
				}
				
				//Writing the object to a file
				try {
					
					File f = new File("Output.out");
					FileOutputStream fos = new FileOutputStream(f);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					
					oos.writeObject(stdInfo);
					
					oos.flush();
					fos.close();
					
					//DeserializeGUI.java displays the output from the file
					JPanel submitPanel = new JPanel();
					submitPanel.setLayout(new BoxLayout(submitPanel, BoxLayout.Y_AXIS));
					
					JLabel successLabel = new JLabel("Output Saved to file!");
					submitPanel.add(successLabel);
					
					frame.setSize(300, 200);
					frame.add(submitPanel);
					frame.validate();
					
					System.out.println("Output Saved to file!");
				} catch(Throwable e) {
					System.err.println(e);
				}

			}

		});
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
}
