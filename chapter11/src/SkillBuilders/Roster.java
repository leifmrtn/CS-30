/*

Program: Roster.java          Last Date of this Revision: October 16, 2026

Purpose: Create a StudentRoster application that prompts the user for the number of students in the class and then 
		prompts the user for each student’s name and stores the names in an array. After all the names have been 
		entered, the application should display the title ”Student Roster” and then list the names in the array

Author: Leif Martin, 
School: CHHS
Course: Computer Programming CSE2130
 
*/




package SkillBuilders;

import java.io.*;
import java.util.Scanner;

public class Roster {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);	
		
		String fileName = input.next();
		
		File stuRostFile = new File(fileName);
		
		FileReader in;
		BufferedReader readFile;
		
		FileWriter out;
		BufferedWriter writeFile;
		
		
		
		System.out.print("How many students: ");
		int numStu = input.nextInt();
		
		try {
			out = new FileWriter(stuRostFile);
			writeFile = new BufferedWriter(out);
			
			for(int i = 0; i < numStu; i++) {
				System.out.print("Enter student first name: ");
				writeFile.write(input.next());
				writeFile.newLine();
				
				System.out.print("Enter student last name: ");
				writeFile.write(input.next());
				writeFile.newLine();
			}
			
			writeFile.close();
			out.close();
			input.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File does not exist or could not be found.");
			System.err.println("FileNotFoundException " + e.getMessage());
		}
		catch(IOException e) {
			System.out.println("Problem reading file.");
			System.err.println("IO Exception " + e.getMessage());
		}
		
		
		try {
			in = new FileReader(stuRostFile);
			readFile = new BufferedReader(in);
			
			System.out.println("--- Student Roster ---");
			
			String line;
			
			while((line = readFile.readLine()) != null) {
				System.out.println(line);			
			}
			
			
			readFile.close();
			in.close();
			
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File does not exist or could not be found.");
			System.err.println("FileNotFoundException " + e.getMessage());
		}
		catch(IOException e) {
			System.out.println("Problem reading file.");
			System.err.println("IO Exception " + e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		

	}

}
