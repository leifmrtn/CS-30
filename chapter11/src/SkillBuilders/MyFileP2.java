/*

Program: MyFileP2.java          Last Date of this Revision: October 8, 2026

Purpose: ???

Author: Leif Martin, 
School: CHHS
Course: Computer Programming CSE2130
 
*/

package SkillBuilders;

import java.io.*;
import java.util.Scanner;

public class MyFileP2 {

	public static void main(String[] args) {
		
		// Do not use scanner to access file
		File textFile;
		String response;
		Scanner input = new Scanner(System.in);
		
		// Create a file
		textFile = new File("C:\\Users\\48300001\\git\\CS-30\\chapter11\\src\\SkillBuilders\\zZZ.txt");
		
		// Obtain file name from user
		System.out.println("Enter file name: ");
		
		// Store file name
		response = input.next();
		
		// Check if file exists
		if(textFile.exists()) {
			System.out.println("zZZ.txt file exists");
		
		}
		else {
			try {
				textFile.createNewFile();
				System.out.println("zZZ.txt file created.");
			}
			catch(IOException e) {
				System.out.println("File could be created.");
				System.err.println("IO Exception " + e.getMessage());
			}
		}
		
		// Delete if user chooses to delete the file
		System.out.print("Would you like to (K)eep or (D)elete the file?: ");
		response = input.next();
		input.close();
		
		if(response.equalsIgnoreCase("D")) {
			// Delete the file
			if(textFile.delete()) {
				System.out.println("File has been deleted.");
			}
		}
		else {
			System.out.println("File has been kept.");
		}
		
		
		
		
	}
}

/*	Screen Dump
	
*/