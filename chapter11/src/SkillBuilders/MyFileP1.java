package SkillBuilders;

import java.io.*;
import java.util.Scanner;

public class MyFileP1 {

	public static void main(String[] args) {
		
		//do not use scanner to access file
		File textFile;
		String fileName;
		Scanner input = new Scanner(System.in);
		
		//Obtain file name from user
		System.out.println("Enter file name: ");
		//Store file name
		fileName = input.next();
		
		// Determine if file exists
		textFile = new File(fileName);
		
		if(textFile.exists()) {
			System.out.println("File exists.");
			
			
		}
		else {
			System.out.println("File does NOT exist.");
		}
		
		
		
	}

}
