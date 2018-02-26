package hanga_gubbe_main;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import jaok.HangmanConsoleWindow;


public class hangManGame {
	
	public static int lives;
	
	public static int difficulty;

	private static ArrayList<String> guesseWord = new ArrayList<String>();

	private static ArrayList<String> secretWord = new ArrayList<String>();
	
	private static Scanner input = new Scanner(System.in);
	
	private static HangmanConsoleWindow console;
		
	
	
		private static void gameStart(){
			console = new HangmanConsoleWindow();
			
			console.println("What should the secret word?");
			
			secretWord.add(console.nextString());
			console.clear();
			
			String secretString = secretWord.toString(); 
			char[] guessedArr = secretString.toCharArray();
			
			for(int i = 0 ; i < secretString.length() ; i++) {
				guessedArr[i] = '_';
			}
			for(int j = 1 ; j <= 1 ; j--){
				console.println("How many lives would you like to have? 1(EASY) or 2(MEDIUM) or 3(HARD)?");
			
				String diffInput = console.nextString();
			
				difficulty = Integer.parseInt(diffInput);
			
				if(difficulty == 1){
					lives = 10;
					j = j + 3;
				}
				else if(difficulty == 2){
					lives = 7;
					j = j + 3;
				}
				else if(difficulty == 3){
					lives = 5;
					j = j + 3;
				}
				else{
					console.print("Den svårighetsgraden finns inte, testa igen.");
				}
			}
			
		}
		
}
