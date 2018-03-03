package hanga_gubbe_main;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import jaok.HangmanConsoleWindow;
import sun.applet.Main;


public class hangManGame {
	
	public static int lives;
	
	public static int difficulty;
	
	public static boolean gamemode;		// true == singleplayer ; false == multiplayer
	
	private static char[] guessedArr;
	
	private static String guessedWord;
	
	private static boolean win;
	
	private static boolean lose;
	
	private static ArrayList<String> fileWords = new ArrayList<String>();
	
	private static ArrayList<String> allGuessedLetters = new ArrayList<String>();

	private static ArrayList<String> secretWord = new ArrayList<String>();
	
	private static HangmanConsoleWindow console;
	
	public static void main(String[] args) {
		console = new HangmanConsoleWindow();
		
		console.println("Welcome to hangman!");
		
		gamemode();
		
		if(gamemode == true){
			gameStartSingleplayer();
		}
		else{
			gameStartMultiplayer();
		}
		
		while(win || lose == false){
			guess();
				
			if(win == true){
				gameWon();
				break;
			}
			else if(lose == false){
				gameLose();
				break;
			}
			else{
				continue;
			}
		
		}		
	}
	
	public static void gamemode(){
		char singleplayer =+ 's';
		char multiplayer = 'm';
		console.println("Do you want to play singleplayer(s)");
		console.println("or multiplayer(m)?");
		
		for( int j = 1 ; j <= 1 ; j--){
			char gamemodeInput = console.nextChar();
			
			
			if(gamemodeInput == singleplayer){
				gamemode = true;
				break;
			}
			else if(gamemodeInput == multiplayer){
				gamemode = false;
				break;
			}
			else{
				console.clear();
				console.print("That gamemode don�t exist.");
				console.println("You can only put 's' or 'm' in.");
				console.println("Try again");
				j++;
			}
		}
		return;
	}
	
	public void fillWords(File Words) throws FileNotFoundException{
		
		Scanner fileReader = new Scanner(Words);
		
		while(fileReader.hasNextLine()){
			fileWords.add(fileReader.nextLine());
		}
		fileReader.close();
	}
	private static void gameStartSingleplayer(){
		secretWord.add(getWord());
		
		for(int j = 1 ; j <= 1 ; j--){
			console.clear();
			console.println("How many lives would you like to have? 1(EASY) or 2(MEDIUM) or 3(HARD)?");
			
			String diffInput = console.nextString();
			
			difficulty = Integer.parseInt(diffInput);
			
			if(difficulty == 1){
				lives = 10;
				break;
			}
			else if(difficulty == 2){
				lives = 7;
				break;
			}
			else if(difficulty == 3){
				lives = 5;
				break;
			}
			else{
				console.clear();
				console.println("Den sv�righetsgraden finns inte, testa igen.");
				j++;
			}
				
		}
		return;
	}
	
	private static void gameStartMultiplayer(){
		console.clear();
		console.println("What should the secret word be?");
		
		secretWord.add(console.nextString().split(" ")[0]);
		console.clear();
			
		String secretString = secretWord.toString(); 
		guessedArr = (secretString.toUpperCase()).toCharArray();
			
		for(int i = 0 ; i < secretString.length() ; i++) {
				guessedArr[i] = '_';
		}
			
		for(int j = 1 ; j <= 1 ; j--){
			console.println("How many lives would you like to have?");
			console.println("10(EASY) or 7(MEDIUM) or 5(HARD)?");
			String diffInput = console.nextString();
			
			difficulty = Integer.parseInt(diffInput);
			
			if(difficulty == 10){
				lives = 10;
				break;
			}
			else if(difficulty == 7){
				lives = 7;
				break;
			}
			else if(difficulty == 5){
				lives = 5;
				break;
			}
			else{
				console.clear();
				console.println("Den sv�righetsgraden finns inte, testa igen.");
				j++;
			}
				
		}
		return;	
	}
		
	private static void guess(){
			
		win = false;
		lose = false;
		char guessedLetter = '-';
		String guessedString = "-";
	
		while(lives > 0 && !win){	
			for(int j = 1 ; j <= 1 ; j--){
				guessedWord = guessedArr.toString();
				console.println(guessedWord + "|| Vilken bokstav gissar du p�?");
				guessedString = console.nextString();
	
				if(guessedString.length() > 1){
					console.println("Du kan bara gissa p� en bokstav. F�rs�k igen");
					j++;
				}
				else{
					guessedLetter = guessedString.charAt(0);
					break;
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
				console.println("Du har redan gissat det f�rs�k igen");
				guess();
			}
			
		}
		return;
	}
	
	private static void rightGuess(){			
		console.clear();
		
		if(guessedArr.toString() == secretWord.toString()){
			win = true;
		}
		else{
			console.println("You got something right!");
			printMan.print(lives);
			console.println("You have typed these letters so far:");
			console.println(allGuessedLetters.toString());
			console.println("The word now looks at this:" + guessedArr.toString());
			
		}	
		return;
	}

	private static void wrongGuess(){
		lives--;
		console.clear();
		
		if(lives == 0){
			lose = true;
		}
		else{	
			printMan.print(lives); 
			console.println("You got it Wrong");
			console.println("You have typed these letters so far:"); 
			console.println(allGuessedLetters.toString());
			console.println("The word looks at this:" + guessedArr.toString());
		}
		return;
	}
	
	public static String getWord(){
		return fileWords.get((int) (Math.random()*fileWords.size()));
	}

	
	private static void gameWon(){
		
		console.println("won");
		return;
	}
	
	private static void gameLose(){
		
		console.println("lose");	
		return;
	}
		
}
