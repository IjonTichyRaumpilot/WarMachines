package edu.WarMachineGame.TestDrive;

import edu.WarMachineGame.SpielRaum.LokalerSpieler;
import edu.WarMachineGame.SpielRaum.Regeln;
import edu.WarMachineGame.Visualisierung.SwingFenster;
import edu.WarMachineGame.Visualisierung.Visualisierbar;

public class GameStarter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out
				.println("/===============================================\\\n"
						+ "|             Willkommen zu WAR-MACHINES        |\n"
						+ "\\===============================================/");

		// Init Regeln
		Regeln regeln = Regeln.getRegeln();

		// Connection

		// Init Players
		LokalerSpieler spieler1 = new LokalerSpieler("Spieler1");
		LokalerSpieler spieler2 = new LokalerSpieler("Spieler2");

		// Platziere Schiffe
		spieler1.place();
		spieler2.place();

		// Visualisierbar visualisierung = new TextAusgabe();
		Visualisierbar visualisierungSpieler1 = new SwingFenster();
		Visualisierbar visualisierungSpieler2 = new SwingFenster();

		// Spielschleife
		while (!regeln.isGameOver()) {
			spieler1.shoot(spieler2);
			visualisierungSpieler1.zeigeSpielFeld(spieler1);
			visualisierungSpieler2.zeigeSpielFeld(spieler2);
			if (spieler2.isGameOver())
				break;
			spieler2.shoot(spieler1);
			visualisierungSpieler1.zeigeSpielFeld(spieler1);
			visualisierungSpieler2.zeigeSpielFeld(spieler2);
			if (spieler1.isGameOver())
				break;
		}

		spieler1.printStatus();
		spieler2.printStatus();

	}

}
