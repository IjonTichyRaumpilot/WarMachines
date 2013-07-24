package edu.WarMachineGame.SpielRaum;

import java.util.ArrayList;
import java.util.List;

import edu.WarMachineGame.ClientConnection.Client;
import edu.WarMachineGame.Enumerations.Ausrichtung;
import edu.WarMachineGame.IO.Ausgabe;
import edu.WarMachineGame.IO.Eingabe;
import edu.WarMachineGame.Interfaces.Spielerstatus;
import edu.WarMachineGame.Spielerstatus.StatusGewonnen;
import edu.WarMachineGame.Spielerstatus.StatusVerloren;
import edu.WarMachineGame.TestDrive.GameStarter;
import edu.WarMachineGame.WarMachines.Fregatte;
import edu.WarMachineGame.WarMachines.Kreuzer;
import edu.WarMachineGame.WarMachines.Schlauchboot;
import edu.WarMachineGame.WarMachines.WarMachine;

/**
 * 
 * @author Constantin
 * 
 */
public class LokalerSpieler implements Spieler {

	// --------- VARIABLES --------- //
	private String name;
	private Eingabe eingabe;
	private Ausgabe ausgabe;
	private Client client;
	private SpielFeld spielfeld;
	private Spielerstatus spielerstatus;
	private List<WarMachine> warMachine = new ArrayList<WarMachine>();

	// ----------------------------- //

	/**
	 * Erstellt einen Spieler mit dem angegebenen Namen.
	 * 
	 * @param String
	 *            name
	 * @author Constantin
	 */
	public LokalerSpieler(String name) {
		this.name = name;
		this.client = Client.getClient();
		this.spielfeld = new SpielFeld();
		this.eingabe = Eingabe.getEingabe();
		this.ausgabe = Ausgabe.getAusgabe();
		this.spielerstatus = new StatusGewonnen();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.WarMachineGame.SpielRaum.Spieler#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.WarMachineGame.SpielRaum.Spieler#place()
	 */
	@Override
	public void place() {

		// ausgabe.printSeparator();
		GameStarter.setIniStatus("Platziere Sie die Schiffe.");
		Ausgabe.getAusgabe()
				.showMessage(
						"Platzierung der Schiffe",
						"Platzieren sie ihre Schiffe(Laenge).\n"
								+ "Geben sie dazu zuerst die Koordinate(x,y) f�r das Schiff an\n"
								+ "und danach die Ausrichtung, wobei:\n"
								+ "nach rechts  =  1\n"
								+ "nach links     = -1\n"
								+ "nach oben     =  2\n" + "nach unten    = -2");
		// ausgabe.printSeparator();

		warMachine.add(platziereWarMachine(new Schlauchboot()));
		warMachine.add(platziereWarMachine(new Fregatte()));
		warMachine.add(platziereWarMachine(new Kreuzer()));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.WarMachineGame.SpielRaum.Spieler#shoot(edu.WarMachineGame.SpielRaum
	 * .Spieler)
	 */
	@Override
	public void shoot(Spieler gegner) {

		boolean invalidInput = true;
		String input = null;

		// ausgabe.printSeparator();
		GameStarter.setSpielStatus("Klicken Sie auf das Ziel!");

		// Einleseschleife
		while (invalidInput) {
			try {
				input = eingabe.getUserKoordinateInputFromGUI();
			} catch (Exception e) {
				e.printStackTrace();
			}

			Koordinate zielKoordinate = eingabe.string2Koord(input);
			if (!gegner.getSpielfeld().validKoordinaten(zielKoordinate)) {
				ausgabe.showFalscheEingabe();
				continue;
			}
			invalidInput = false;
			invalidInput = !gegner.getSpielfeld().shoot(zielKoordinate);
			if (invalidInput) {
				ausgabe.showFalscheEingabe();
			} else
				isGameOver();

		} // invalidInput

		if (!Client.getClient().getIsLocal())
			client.sendPlayerInput(input);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.WarMachineGame.SpielRaum.Spieler#isGameOver()
	 */
	@Override
	public boolean isGameOver() {
		boolean gameOver = true;
		for (WarMachine w : warMachine) {
			if (!w.isVersenkt())
				gameOver = false;
		}
		if (gameOver) {
			Regeln.setGameOver();
			return true;
		} else
			return false;

	}

	/**
	 * Printet den aktuellen Status des Spielers (verloren/gewonnen).
	 */
	public void printStatus() {
		boolean alleVersenkt = true;
		for (WarMachine w : warMachine) {
			if (!w.isVersenkt())
				alleVersenkt = false;
		}
		if (alleVersenkt)
			spielerstatus = new StatusVerloren();
		// ausgabe.printSeparator();
		ausgabe.showGameOverMessage("Game Over!",
				"Sie haben " + spielerstatus.getSpielerstatus());
	}

	/**
	 * Platziert die WarMachine und gibt diese wieder zurück;
	 * 
	 * @param WarMachine
	 * @return WarMachine
	 * @author Constantin
	 */
	private WarMachine platziereWarMachine(WarMachine newWarMachine) {

		boolean invalidInput = true;
		String input = null;
		Koordinate platzKoordinate = null;
		Ausrichtung platzAusrichtung = null;

		while (invalidInput) {
			try {
				input = eingabe.getUserInputFromDialog(
						newWarMachine.getBezeichnung(), this.getName()
								+ " bitte platzieren Sie ihr Schiff: "
								+ newWarMachine.getBezeichnung() + " ["
								+ newWarMachine.getLaenge() + ","
								+ newWarMachine.getBreite() + "]"
								+ "\nFormat: x,y,Richtung");
			} catch (Exception e) {
				e.printStackTrace();
			}
			String[] argumente = input.split(",");
			if (argumente.length < 3) {
				ausgabe.showFalscheEingabe();
				continue;
			}
			platzKoordinate = eingabe.string2Koord(argumente[0].toString()
					+ "," + argumente[1].toString());
			platzAusrichtung = eingabe.string2Ausrichtung(argumente[2]);
			if (!eingabe.validAusrichtung(platzAusrichtung)) {
				ausgabe.showFalscheEingabe();
				continue;
			}

			try {
				spielfeld.place(newWarMachine, platzKoordinate,
						platzAusrichtung);
				invalidInput = false;
			} catch (Exception e) {
				ausgabe.showFalscheEingabe();
				invalidInput = true;
			}

		} // while invalid Input

		if (!Client.getClient().getIsLocal())
			client.sendPlayerInput(input);
		return newWarMachine;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.WarMachineGame.SpielRaum.Spieler#getSpielfeld()
	 */
	@Override
	public SpielFeld getSpielfeld() {
		return spielfeld;
	}

	/**
	 * Gibt true zurück, falls der Spieler der Host ist.
	 * 
	 * @return boolean
	 * @author Constantin
	 */
	public boolean isHost() {
		return client.getIsHost();
	}

}
