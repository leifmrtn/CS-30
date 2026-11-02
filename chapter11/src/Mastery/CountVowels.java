/*

Program: CountVowels.java          Last Date of this Revision: October 26, 2026

Purpose: Count the number of vowels in the file

Author: Leif Martin, 
School: CHHS
Course: Computer Programming CSE2130
 
*/

package Mastery;

import java.io.*;
import java.util.Scanner;


public class CountVowels 
{

   public static void main(String[] args) 
   {
       File textFile;
       FileReader in;
       BufferedReader readFile;
       String fileName;
       String lineInFile;
       String[] lowercaseText;
       int numVowels = 0;

       Scanner input = new Scanner(System.in);
   
       /* prompt the user for the name of the file */
       System.out.println("What is the file name?");
       fileName = input.next();

       try {
                //new File object required
    	   textFile = new File(fileName);
                //new File reader object required
    	   in = new FileReader(textFile);
    	   		//new BufferedReader object required
    	   readFile = new BufferedReader(in);
    	       	   
                //read the lines from the file
    	   while((lineInFile = readFile.readLine()) != null) {   	
    		   	//as lines are read convert them to lower case
    		   lowercaseText = lineInFile.toLowerCase().split("");
    		   	//iterate through the lower case text
    		   	for(String letter : lowercaseText) {
                    //using the String class 
                    //check if each character traverse through is a vowel
                    //update total vowels
    			   if("aioue".contains(letter)) numVowels++;
    		   	}           
    	   }
            //user wants to know the number of vowels inside a file name
		   System.out.println("There are: " + numVowels + " vowels in the file.");
    	   
            //close BufferedReader object
    	   readFile.close();
            //close FileReader object
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
