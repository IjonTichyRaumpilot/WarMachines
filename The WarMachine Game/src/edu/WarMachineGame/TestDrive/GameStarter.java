package edu.WarMachineGame.TestDrive;

import edu.WarMachineGame.SpielRaum.Regeln;
import edu.WarMachineGame.SpielRaum.Spieler;

public class GameStarter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out
				.println("/===============================================\\\n"
						+ "| Wilkommen zu WAR-MACHINES (Schiffe versenken) |\n"
						+ "\\===============================================/");

		// Init Regeln
		Regeln regeln = Regeln.getRegeln();

		// Init Players
		Spieler spieler1 = new Spieler("Spieler1");
		Spieler spieler2 = new Spieler("Spieler2");

		// Platziere Schiffe
		spieler1.place();
		spieler2.place();

		// Spielschleife
		while (!regeln.isGameOver()) {
			spieler1.shoot(spieler2);
			spieler1.printSpielFeld();
			spieler2.printSpielFeld();
			if (regeln.isGameOver())
				break;
			spieler2.shoot(spieler1);
			spieler1.printSpielFeld();
			spieler2.printSpielFeld();
		}

		spieler1.printStatus();
		spieler2.printStatus();

	}

}
