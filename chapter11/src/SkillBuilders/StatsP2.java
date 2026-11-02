/*

Program: StatsP2.java          Last Date of this Revision: October 14, 2026

Purpose: ???

Author: Leif Martin, 
School: CHHS
Course: Computer Programming CSE2130
 
*/

package SkillBuilders;

import java.io.*;
import java.text.NumberFormat;
import java.util.Scanner;

public class StatsP2 {

	public static void main(String[] args) {
		
		File dataFile;
		
		FileReader in;
		BufferedReader readFile;
		
		FileWriter out;
		BufferedWriter writeFile;
		
		Scanner input = new Scanner(System.in);
		
		String fileName;
		String stuName, score;
		
		int numStu;
		int numScores = 0;
		
		double scoreValue, avgScore;
		double lowScore = 100;
		double highScore = 0;
		double totalScores = 0;
		
		NumberFormat percent = NumberFormat.getPercentInstance();
		
		// Write data to a file
		
		System.out.print("Enter file name: ");
		fileName = input.next();
		
		System.out.print("How many students?: ");
		numStu = input.nextInt();
		
		try {
			dataFile = new File(fileName);
			
			out = new FileWriter(dataFile);
			writeFile = new BufferedWriter(out);
			
			for(int i = 0; i < numStu; i++) {
				System.out.print("Enter student name: ");
				stuName = input.next();
				
				System.out.print("Enter test score: ");
				score = input.next();
				
				writeFile.write(stuName);
				writeFile.newLine();
				writeFile.write(score);
				writeFile.newLine();
				
				
			} // End for loop
			writeFile.close();
			out.close();
		
			System.out.println("Data has been written to file.");
			
		}
		catch(IOException e) {
			System.out.println("Problem reading file.");
			System.err.println("IO Exception " + e.getMessage());
		}
		
		
		// Read data from file and process
		
		
		try {
			dataFile = new File(fileName);
			in = new FileReader(dataFile);
			readFile = new BufferedReader(in);
			
			while((stuName = readFile.readLine()) != null) {
				score = readFile.readLine();
				System.out.println(stuName + " " + score);
				
				numScores += 1;
				
				scoreValue = Double.parseDouble(score);
				
				totalScores += scoreValue;
				
				if(scoreValue < lowScore) lowScore = scoreValue; // Set new low score
				
				if(scoreValue > highScore) highScore = scoreValue; // Set new high score
				
			}
			
			avgScore = totalScores / numScores;
			
			System.out.println("Low score = " + percent.format(lowScore/100));
			System.out.println("High score = " + percent.format(highScore/100));
			System.out.println("Average score = " + percent.format(avgScore/100));
			
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
