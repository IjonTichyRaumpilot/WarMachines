package edu.WarMachineGame.TestDrive;

import edu.WarMachineGame.SpielRaum.LokalerSpieler;
import edu.WarMachineGame.SpielRaum.Regeln;
import edu.WarMachineGame.SpielRaum.RemoteSpieler;
import edu.WarMachineGame.Visualisierung.SwingFenster;
import edu.WarMachineGame.Visualisierung.Visualisierbar;

/**
 * 
 * Dieses Spiel ist ein Angriffssimulator für einen realgetreuen Flottenkampf.
 * Kann auch zur strategischen Angriffsplanung auf westliche Mächte verwendet
 * werden.
 * 
 * @author Arthur und Constantin
 * 
 */
public class GameStarter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out
				.println("/===================================================\\\n"
						+ "|   \\\\             /     /\\\\      |–––\\\\            |\n"
						+ "|    \\\\    /\\\\    /     /  \\\\     |    ||           |\n"
						+ "|     \\\\  /  \\\\  /     /––––\\\\    |–––//            |\n"
						+ "|      \\\\/    \\\\/     /      \\\\   |   \\\\ - Machines |\n"
						+ "|===================================================|\n"
						+ "|     Das klassische Flottensimulationsspiel.       |\n"
						+ "\\===================================================/");

		// Init Regeln
		Regeln regeln = Regeln.getRegeln();

		// Connection

		// Init Players
		LokalerSpieler spieler1 = new LokalerSpieler("Spieler1");
		// LokalerSpieler spieler2 = new LokalerSpieler("Spieler2");
		RemoteSpieler spieler2 = new RemoteSpieler("Spieler2");

		// Platziere Schiffe (Host zuerst)
		if (spieler1.isHost()) {
			spieler1.place();
			spieler2.place();
		} else {
			spieler2.place();
			spieler1.place();
		}

		// Visualisierbar visualisierung = new TextAusgabe();
		Visualisierbar visualisierungSpieler1 = new SwingFenster();

		// Spielschleife (Host fängt an)
		if (spieler1.isHost()) {
			spieler1.shoot(spieler2);
			visualisierungSpieler1.zeigeSpielFeld(spieler1);
			spieler2.shoot(spieler1);
			visualisierungSpieler1.zeigeSpielFeld(spieler1);
		} else {
			spieler2.shoot(spieler1);
			visualisierungSpieler1.zeigeSpielFeld(spieler1);
		}

		while (!regeln.isGameOver()) {
			spieler1.shoot(spieler2);
			visualisierungSpieler1.zeigeSpielFeld(spieler1);
			if (spieler2.isGameOver())
				break;
			spieler2.shoot(spieler1);
			visualisierungSpieler1.zeigeSpielFeld(spieler1);
			if (spieler1.isGameOver())
				break;
		}

		spieler1.printStatus();

	}

}
