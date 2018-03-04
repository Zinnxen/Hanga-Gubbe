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
	
	private static final File File = null;

	public static int lives;
	
	public static int difficulty;
	
	public static boolean gamemode;		// true == singleplayer ; false == multiplayer
	
	private static char[] guessedArr;
	
	private static char[] secretArr;
	
	private static char[] wordArr;
	
	private static String guessedWord;
	
	private static boolean win;
	
	private static boolean lose;
	
	private static ArrayList<String> fileWords = new ArrayList<String>();
	
	private static ArrayList<String> allGuessedLetters = new ArrayList<String>();

	private static ArrayList<String> secretWord = new ArrayList<String>();
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		System.out.println("Welcome to hangman!");
		
		gamemode();
		
		if(gamemode == true){
			fillWords(File);
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
			else if(lose == true){
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
		System.out.println("Do you want to play singleplayer(s)");
		System.out.println("or multiplayer(m)?");
		
		for( int j = 1 ; j <= 1 ; j--){
			char gamemodeInput = sc.next().charAt(0);
			
			
			if(gamemodeInput == singleplayer){
				gamemode = true;
				break;
			}
			else if(gamemodeInput == multiplayer){
				gamemode = false;
				break;
			}
			else{
				consoleClear();
				System.out.print("That gamemode don´t exist.");
				System.out.println("You can only put 's' or 'm' in.");
				System.out.println("Try again");
				j++;
			}
		}
		return;
	}
	
	public static void fillWords(File Words) throws FileNotFoundException{
	
		Scanner fileReader = new Scanner(new File("Words.txt"));
		
		while(fileReader.hasNextLine()){
			fileWords.add(fileReader.nextLine());
		}
		fileReader.close();
	}
	private static void gameStartSingleplayer(){
		
		
		secretWord.add(getWordSingleplayer());
	
		
		for(int f = 0 ; f < secretWord.size() ; f++){
		//	secretArr[f] = secretWord;
		}
		
		getDifficulty();
		
		return;
	}
	
	private static void gameStartMultiplayer(){
		
		getDifficulty();
		
		getWordMultiplayer();
		
		consoleClear();
			
		String secretString = secretWord.toString(); 
		guessedArr = (secretString.toUpperCase()).toCharArray();
			
		//for(int i = 0 ; i < secretString.length() ; i++) {
		//		guessedArr[i] = '-';
		//}
			
		return;	
	}
		
	private static void guess(){
			
		win = false;
		lose = false;
		char guessedLetter = '-';
		String guessedString = "-";
		
		while(lives > 0 && !win){	
			for(int j = 1 ; j <= 1 ; j--){
				
				System.out.println(guessedArr);
				System.out.println("Vilken bokstav gissar du på?");
				guessedString = sc.next().toUpperCase();
	
				if(guessedString.length() > 1){
					System.out.println("Du kan bara gissa på en bokstav. Försök igen");
					j++;
				}
				else{
					guessedLetter = guessedString.charAt(0);
					break;
				}
		
			}
	
			if(!allGuessedLetters.contains(guessedLetter)){				
				allGuessedLetters.add(guessedString);
				
				if(secretWord.contains(guessedLetter)){
					rightGuess();	
				}
				else{
					wrongGuess();
				}
			}
			else{
				System.out.println("Du har redan gissat det försök igen");
				guess();
			}
			
		}
		return;
	}
	
	private static void rightGuess(){			
		consoleClear();
		
		if(guessedArr.toString() == secretWord.toString()){
			win = true;
		}
		else{
			for(int i = 0 ; i < secretWord.size() ; i++){
				if(guessedArr[i] == secretArr[i]){
					guessedArr[i] += secretArr[i];
				}
			}
			
			System.out.println("You got something right!");
			printMan.print(lives);
			System.out.println("You have typed these letters so far:");
			System.out.println(allGuessedLetters.toString());
			System.out.println("The word now looks at this:");
			
		}	
		return;
	}

	private static void wrongGuess(){
		lives--;
		consoleClear();
		
		if(lives == 0){
			lose = true;
		}
		else{	
			printMan.print(lives); 
			System.out.println("You got it Wrong");
			System.out.println("You have typed these letters so far:"); 
			System.out.println(allGuessedLetters.toString());
			System.out.println("The word looks at this:" + guessedArr.toString());
		}
		return;
	}
	
	public static String getWordSingleplayer(){
		return fileWords.get((int) (Math.random()*fileWords.size()));
	}
	
	public static void getWordMultiplayer(){
		
		System.out.println("What should the secret word be?");
		String word = sc.next();
		
		wordArr = new char[word.toUpperCase().length()];
		
		for(int i = 0 ; i < word.length() ; i++){
			char charLetterTemp = wordArr[i];
			String stringLetterTemp = String.valueOf(charLetterTemp);
			secretWord.add(stringLetterTemp);
		}
		return;
		
	}
	
	private static void gameWon(){
		
		System.out.println("won");
		return;
	}
	
	private static void gameLose(){
		
		System.out.println("lose");	
		return;
	}

	private static void consoleClear(){
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		return;
	}
	
	private static void getDifficulty(){
		for(int j = 1 ; j <= 1 ; j--){
			System.out.println("How many lives would you like to have?");
			System.out.println("10(EASY) or 7(MEDIUM) or 5(HARD)?");
			int diffInput = sc.nextInt();
			
			difficulty = diffInput;
			
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
				consoleClear();
				System.out.println("Den svårighetsgraden finns inte, testa igen.");
				j++;
			}
				
		}
		return;
	}
		
}
