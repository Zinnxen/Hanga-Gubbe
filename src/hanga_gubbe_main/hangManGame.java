package hanga_gubbe_main;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import jaok.HangmanConsoleWindow;
import sun.applet.Main;


public class hangManGame {
	
	public static int lives;
	
	public static int difficulty;
	
	private static char[] guessedArr;
	
	private static boolean win;
	
	private static boolean lose;
	
	private static ArrayList<String> fileWords = new ArrayList<String>();
	
	private static ArrayList<String> allGuessedLetters = new ArrayList<String>();

	private static ArrayList<String> secretWord = new ArrayList<String>();
	
	private static HangmanConsoleWindow console;
	
	public static void main(String[] args) {
		console = new HangmanConsoleWindow();
		
		console.print("Welcome to hangman!");
		console.print("Do you want to play singelplayer or mulitplayer?");
		
		if(console.nextString().toLowerCase() == "singleplayer"){
			gameStartSingleplayer();
		}
		else if(console.nextString().toLowerCase() == "multiplayer"){
			gameStartMultiplayer();
		}
		
		
	}
	public void words(File f) throws FileNotFoundException{
		
		Scanner fileReader = new Scanner(f);
		
		while(fileReader.hasNextLine()){
			fileWords.add(fileReader.nextLine());
		}

		
	}
	private static void gameStartSingleplayer(){
		
		console = new HangmanConsoleWindow();
		
		secretWord.add(fileWords.get( (int) Math.random()*(fileWords.toArray()).length));
		
		
		for(int j = 1 ; j <= 1 ; j--){
			console.println("How many lives would you like to have? 1(EASY) or 2(MEDIUM) or 3(HARD)?");
			
			String diffInput = console.nextString();
			
			difficulty = Integer.parseInt(diffInput);
			
			if(difficulty == 1){
				lives = 10;
				j =+ 3;
			}
			else if(difficulty == 2){
				lives = 7;
				j =+ 3;
			}
			else if(difficulty == 3){
				lives = 5;
				j =+ 3;
			}
			else{
				console.print("Den svårighetsgraden finns inte, testa igen.");
				j++;
			}
				
		}
		
	}
	
	private static void gameStartMultiplayer(){
		console = new HangmanConsoleWindow();
		
		console.println("What should the secret word?");
		
		secretWord.add(console.nextString().split(" ")[0]);
		console.clear();
			
		String secretString = secretWord.toString(); 
		guessedArr = (secretString.toUpperCase()).toCharArray();
			
		for(int i = 0 ; i < secretString.length() ; i++) {
				guessedArr[i] = '_';
		}
			
		for(int j = 1 ; j <= 1 ; j--){
			console.println("How many lives would you like to have? 1(EASY) or 2(MEDIUM) or 3(HARD)?");
			
			String diffInput = console.nextString();
			
			difficulty = Integer.parseInt(diffInput);
			
			if(difficulty == 1){
				lives = 10;
				j =+ 3;
			}
			else if(difficulty == 2){
				lives = 7;
				j =+ 3;
			}
			else if(difficulty == 3){
				lives = 5;
				j =+ 3;
			}
			else{
				console.print("Den svårighetsgraden finns inte, testa igen.");
				j++;
			}
				
		}
			
	}
		
	private static void guess(){
			
		win = false;
		lose = false;
		char guessedLetter = '-';
		String guessedString = "-";
		
		while(lives > 0 && !win){	
			for(int j = 1 ; j <= 1 ; j--){
			console.println(guessedArr.toString() + "|| Vilken bokstav gissar du på?");
			guessedString = console.nextString();
		
				if(guessedString.length() > 1){
					console.println("Du kan bara gissa på en bokstav. Försök igen");
					j++;
				}
				else{
					guessedLetter = guessedString.charAt(0);
					j = j + 3;
				}
			
			}
		
			if(!allGuessedLetters.contains(guessedLetter)){				
				if(secretWord.contains(guessedLetter)){
					rightGuess();
				}
				
				else{
					wrongGuess();
				}
				allGuessedLetters.add(guessedString);
			}
			
			else{
				console.println("Du har redan gissat det försök igen");
			}
			
		}
		
	}
	
	private static void rightGuess(){			
		printMan.print(lives);
		
		if(guessedArr.toString() == secretWord.toString()){
			win = true;
		}
		
			
	}

	private static void wrongGuess(){
		lives--;
		if(lives == 0){
			lose = true;
		}
		else{	
			printMan.print(lives); 
		}
			
	}
		
}
