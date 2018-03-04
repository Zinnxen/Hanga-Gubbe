package hanga_gubbe_main;
import java.io.Console;

import jaok.HangmanConsoleWindow;
public class printMan {
	
	private static HangmanConsoleWindow console;
	
	public static void print(int lives) {
		
		if(lives == 0){
			
			print0();
			
		}
		
		if(lives == 1){
			
			print1();
			
		}
		
		if(lives == 2){
			
			print2();
			
		}
		
		if(lives == 3){
			
			print3();
			
		}
		
		if(lives == 4){
			
			print4();
			
		}
		
		if(lives == 5){
			
			print5();
			
		}
		
		if(lives == 6){
			
			print6();
			
		}
		
		if(lives == 7){
			
			print7();
			
		}
		
		if(lives == 8){
			
			print8();
			
		}
		
		if(lives == 9){
			
			print9();
			
		}
		
		if(lives == 10){
			
			print10();
			
		}
		
	}
	
	public static void print0(){
		System.out.println("   =||=========  ");
		System.out.println("    ||   /   |   ");
		System.out.println("    || /     O/  ");
		System.out.println("    ||	    /|   ");
		System.out.println("    ||      /|)  ");
		System.out.println("    ||           ");
		System.out.println("  *******        ");

	}
	
	public static void print1(){
		System.out.println("   =||=========  ");
		System.out.println("    ||   /   |   ");
		System.out.println("    || /     O/  ");
		System.out.println("    ||	    /|   ");
		System.out.println("    ||           ");
		System.out.println("    ||           ");
		System.out.println("  *******        ");
	}
	
	public static void print2(){
		System.out.println("   =||=========  ");
		System.out.println("    ||   /   |   ");
		System.out.println("    || /     O/  ");
		System.out.println("    ||	         ");
		System.out.println("    ||           ");
		System.out.println("    ||           ");
		System.out.println("  *******        ");
	}
	
	public static void print3(){
		System.out.println("   =||=========  ");
		System.out.println("    ||   /   |   ");
		System.out.println("    || /         ");
		System.out.println("    ||	         ");
		System.out.println("    ||           ");
		System.out.println("    ||           ");
		System.out.println("  *******        ");
	}
	
	public static void print4(){
		System.out.println("   =||=======    ");
		System.out.println("    ||   /       ");
		System.out.println("    || /         ");
		System.out.println("    ||	         ");
		System.out.println("    ||           ");
		System.out.println("    ||           ");
		System.out.println("  *******        ");
	}
	
	public static void print5(){
		System.out.println("   =||===        ");
		System.out.println("    ||           ");
		System.out.println("    || /         ");
		System.out.println("    ||	         ");
		System.out.println("    ||           ");
		System.out.println("    ||           ");
		System.out.println("  *******        ");
	}
	
	public static void print6(){
		System.out.println("    ||           ");
		System.out.println("    ||           ");
		System.out.println("    ||           ");
		System.out.println("    ||	         ");
		System.out.println("    ||           ");
		System.out.println("    ||           ");
		System.out.println("  *******        ");
	}
	
	public static void print7(){
		System.out.println("                 ");
		System.out.println("                 ");
		System.out.println("                 ");
		System.out.println("    ||	         ");
		System.out.println("    ||           ");
		System.out.println("    ||           ");
		System.out.println("  *******        ");
	}
	
	public static void print8(){
		System.out.println("                 ");
		System.out.println("                 ");
		System.out.println("                 ");
		System.out.println("      	         ");
		System.out.println("    ||           ");
		System.out.println("    ||           ");
		System.out.println("  *******        ");
	}
	
	public static void print9(){
		System.out.println("                 ");
		System.out.println("                 ");
		System.out.println("                 ");
		System.out.println("    	         ");
		System.out.println("                 ");
		System.out.println("    ||           ");
		System.out.println("  *******        ");
	}
	
	public static void print10(){
		System.out.println("                 ");
		System.out.println("                 ");
		System.out.println("                 ");
		System.out.println("      	         ");
		System.out.println("                 ");
		System.out.println("                 ");
		System.out.println("  *******        ");
	}
	
}
