package edu.WarMachineGame.SpielRaum;

import java.util.ArrayList;
import java.util.List;

import edu.WarMachineGame.ClientConnection.Client;
import edu.WarMachineGame.Enumerations.Ausrichtung;
import edu.WarMachineGame.IO.*;
import edu.WarMachineGame.Interfaces.Spielerstatus;
import edu.WarMachineGame.Spielerstatus.*;
import edu.WarMachineGame.WarMachines.*;

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

		ausgabe.printSeparator();
		System.out
				.println("Platzieren sie ihre Schiffe(Laenge).\n"
						+ "Geben sie dazu zuerst die Koordinate(x,y) für das Schiff an\n"
						+ "und danach die Ausrichtung, wobei:\n"
						+ "nach rechts  =  1\n" + "nach links   = -1\n"
						+ "nach oben    =  2\n" + "nach unten   = -2");
		ausgabe.printSeparator();

		System.out.println(this.getName()
				+ ", platzieren sie das erste Schiff(1): x,y,Richtung");
		warMachine.add(platziereWarMachine(new Schlauchboot()));
		System.out.println(this.getName()
				+ ", platzieren sie das zweite Schiff(2): x,y,Richtung");
		warMachine.add(platziereWarMachine(new Fregatte()));
		System.out.println(this.getName()
				+ ", platzieren sie das dritte Schiff(3): x,y,Richtung");
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

		ausgabe.printSeparator();
		System.out.println("Geben sie das Ziel an: x,y");

		// Einleseschleife
		while (invalidInput) {
			try {
				input = eingabe.getUserInput();
			} catch (Exception e) {
				e.printStackTrace();
			}

			Koordinate zielKoordinate = eingabe.string2Koord(input);
			if (!gegner.getSpielfeld().validKoordinaten(zielKoordinate)) {
				ausgabe.printFalscheEingabe();
				continue;
			}
			invalidInput = false;
			invalidInput = !gegner.getSpielfeld().shoot(zielKoordinate);
			if (invalidInput) {
				ausgabe.printFalscheEingabe();
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
		ausgabe.printSeparator();
		System.out.println("Sie haben " + spielerstatus.getSpielerstatus());
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
				input = eingabe.getUserInput();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String[] argumente = input.split(",");
			if (argumente.length < 3) {
				ausgabe.printFalscheEingabe();
				continue;
			}
			platzKoordinate = eingabe.string2Koord(argumente[0].toString()
					+ "," + argumente[1].toString());
			platzAusrichtung = eingabe.string2Ausrichtung(argumente[2]);
			if (!eingabe.validAusrichtung(platzAusrichtung)) {
				ausgabe.printFalscheEingabe();
				continue;
			}

			try {
				spielfeld.place(newWarMachine, platzKoordinate,
						platzAusrichtung);
				invalidInput = false;
			} catch (Exception e) {
				ausgabe.printFalscheEingabe();
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
