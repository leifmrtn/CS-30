/*

Program: WordGuess.java          Last Date of this Revision: October 27, 2026

Purpose: Chooses a random word and then lets the user guess letters until the have guessed the word

Author: Leif Martin, 
School: CHHS
Course: Computer Programming CSE2130

*/

package Mastery;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class WordGuess {

	public static void main(String[] args) {
		final String FLAG = "!";

		File textFile = new File("../chapter11/src/Mastery/wordGuess.txt");
		
		FileReader fileReader;
		BufferedReader readFile;

		Random rand = new Random();

		int numWords = 0, wordToGuess, wordLength = 0;
		String secretWord = "";
		String wordSoFar = "", updatedWord;
		String letterGuess, wordGuess = "", lettersUsed = "", currentLetter;
		int numGuesses = 0;	

		/* select secret word */
		try {
				fileReader = new FileReader(textFile);
				
				readFile = new BufferedReader(fileReader);
				
				while(readFile.readLine() != null) numWords += 1;	
                
				readFile.close();
				fileReader.close();
				
				fileReader = new FileReader(textFile);
				readFile = new BufferedReader(fileReader);

				wordToGuess = (rand.nextInt(numWords) + 1);
				
				for(int i = 0; i < wordToGuess; i++) {
					secretWord 	= readFile.readLine();
				}
				wordLength = secretWord.length();
				
				readFile.close();
				fileReader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File does not exist or could not be found.");
			System.err.println("FileNotFoundException " + e.getMessage());
		}
		catch(IOException e) {
			System.out.println("Problem reading file.");
			System.err.println("IO Exception " + e.getMessage());
		}

		/* begin the game */
		System.out.println("<-> WordGuess game. <-> \n");

		for(int i = 0; i < wordLength; i++) {
			currentLetter = Character.toString(secretWord.charAt(i));
		
        //iterate through the secret word, and update the word so far variable to represent using dashes 
			if(secretWord.charAt(i) == ' ') {
				wordSoFar += " ";
			} else {
				wordSoFar += "-";
			}
		}
		
		System.out.println("The word is " + wordLength + " characters.");

		/* allow player to make guesses*/
		Scanner input = new Scanner(System.in);

		do {
			System.out.println("the word so far is: " + wordSoFar);
			System.out.print("What is your next letter?: ");
			letterGuess = input.next().trim();

			numGuesses += 1;
			
			if(secretWord.contains(letterGuess)) {
				updatedWord = "";
				for(int i = 0; i < wordLength; i++) {

					currentLetter = Character.toString(secretWord.charAt(i));
					if(currentLetter.equals(letterGuess)) {
						updatedWord += currentLetter;
					} else {
						updatedWord += Character.toString(wordSoFar.charAt(i));
					}
					
				}
				wordSoFar = updatedWord;
			}
			
		} while (!letterGuess.equals(FLAG) && !wordSoFar.equals(secretWord));
        
		/* finish game and display message and number of guesses */
		System.out.println("You guess the right word, with " + numGuesses + "  guesses!");
	}
}

/*	Screen Dump
<-> WordGuess game. <-> 

The word is 11 characters.
the word so far is: ------ ----
What is your next letter?: e
the word so far is: -e--e- ----
What is your next letter?: r
the word so far is: -e-re- --r-
What is your next letter?: s
the word so far is: se-re- --r-
What is your next letter?: t
the word so far is: se-ret --r-
What is your next letter?: c
the word so far is: secret --r-
What is your next letter?: w
the word so far is: secret w-r-
What is your next letter?: o
the word so far is: secret wor-
What is your next letter?: d
You guess the right word, with 8  guesses!

*/