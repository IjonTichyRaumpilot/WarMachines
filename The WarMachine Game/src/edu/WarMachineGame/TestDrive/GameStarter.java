package edu.WarMachineGame.TestDrive;

import edu.WarMachineGame.ClientConnection.Client;
import edu.WarMachineGame.SpielRaum.ComputerSpieler;
import edu.WarMachineGame.SpielRaum.LokalerSpieler;
import edu.WarMachineGame.SpielRaum.Regeln;
import edu.WarMachineGame.SpielRaum.RemoteSpieler;
import edu.WarMachineGame.SpielRaum.Spieler;
import edu.WarMachineGame.Visualisierung.Visualisierbar;
import edu.WarMachineGame.Visualisierung.GUI_Version1.GUI_Version1;

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

		// Init Players
		LokalerSpieler spieler1 = new LokalerSpieler("Spieler1");
		Spieler spieler2 = null;

		if (Client.getClient().getIsLocal()) {
			spieler2 = new ComputerSpieler("Spieler2");
		} else {
			spieler2 = new RemoteSpieler("Spieler2");
		}

		// Platziere Schiffe (Host zuerst)
		if (Client.getClient().getIsHost()) {
			spieler1.place();
			spieler2.place();
		} else {
			spieler2.place();
			spieler1.place();
		}

		Visualisierbar visualisierungSpieler1 = new GUI_Version1();

		// Spielschleife (Host fängt an)
		if (spieler1.isHost()) {
			spieler1.shoot(spieler2);
			visualisierungSpieler1.zeigeSpielFeld(spieler1, spieler2);
			spieler2.shoot(spieler1);
			visualisierungSpieler1.zeigeSpielFeld(spieler1, spieler2);
		} else {
			spieler2.shoot(spieler1);
			visualisierungSpieler1.zeigeSpielFeld(spieler1, spieler2);
		}

		while (!regeln.isGameOver()) {
			spieler1.shoot(spieler2);
			visualisierungSpieler1.zeigeSpielFeld(spieler1, spieler2);
			if (spieler2.isGameOver())
				break;
			spieler2.shoot(spieler1);
			visualisierungSpieler1.zeigeSpielFeld(spieler1, spieler2);
			if (spieler1.isGameOver())
				break;
		}

		spieler1.printStatus();
		Client.getClient().closeConnection();
	}
}
