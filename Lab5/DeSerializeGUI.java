/*
 ============================================================================
 Name        : DeSerializeGUI.java
 Author      : Brendan Polius Prosper
 Email       : bkpoliusprosper@myseneca.ca
 Student #   : 022541114
 Course Code : JAC 444
 Date        : July 6, 2021
 ============================================================================
 */

package lab5;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Lab3.Student;

public class DeSerializeGUI extends Student {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		try {
			
			File f = new File("Output.out");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
		
			Student stdInfo = (Student)ois.readObject();
			
			ois.close();
		
			JFrame frame = new JFrame("DeSerialize");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
	
			
			frame.setSize(600, 600);
			JPanel display = new JPanel();
			//display.setLayout(new FlowLayout());
			display.setLayout(new BoxLayout(display, BoxLayout.X_AXIS));
			frame.add(display);
		
			JLabel title = new JLabel("Click to show student information");
			JButton showData = new JButton("Student Data");
			frame.add(title);
			frame.add(showData);
			
			showData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent err1) {
					JLabel studentInfo = new JLabel("Student info from object:");
					JTextArea studentData = new JTextArea(
							"Student ID: " + stdInfo.getID() + "\n" +
							"Student First name: " + stdInfo.getFirstName() + "\n" +
							"Student Last name: " + stdInfo.getLastName() + "\n" +
							"Courses: " + stdInfo.getCourses()
					);
				
					frame.add(studentInfo);
					frame.add(studentData);
			}});

			frame.pack();
			frame.setSize(400, 400);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} catch(Throwable e) {
			System.err.println(e);
		}
		
		}	
}
