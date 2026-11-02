/*

Program: StatsP1.java          Last Date of this Revision: October 13, 2026

Purpose: ???

Author: Leif Martin, 
School: CHHS
Course: Computer Programming CSE2130
 
*/

package SkillBuilders;

import java.io.*;
import java.text.NumberFormat;

public class StatsP1 {

	public static void main(String[] args) {
		File dataFile = new File("../chapter11/src/SkillBuilders/test1.txt");
		FileReader in;
		BufferedReader readFile;
		
		String stuName, score;
		
		double scoreValue;
		double lowScore = 100;
		double highScore = 0;
		double avgScore;
		double totalScores = 0;
		
		int numScores = 0;
		
		NumberFormat percent = NumberFormat.getPercentInstance();
		
		try {
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
