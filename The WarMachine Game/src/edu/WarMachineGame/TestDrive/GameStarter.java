package edu.WarMachineGame.TestDrive;

import java.io.ObjectInputStream.GetField;

import edu.WarMachineGame.SpielRaum.Regeln;
import edu.WarMachineGame.SpielRaum.Spieler;

public class GameStarter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		System.out.println("/===============================================\\\n"
				+ "| Wilkommen zu WAR-MACHINES (Schiffe versenken) |\n"
				+ "\\===============================================/");
		
		//Init Regeln
		Regeln regeln = Regeln.getRegeln();
		
		// Init Players
		Spieler spieler1 = new Spieler("Spieler1");
		Spieler spieler2 = new Spieler("Spieler2");
		
		
		
		spieler1.place();
		
	}

}
