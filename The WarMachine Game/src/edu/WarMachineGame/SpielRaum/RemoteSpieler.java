package edu.WarMachineGame.SpielRaum;

import java.util.ArrayList;
import java.util.List;

import edu.WarMachineGame.ClientConnection.Client;
import edu.WarMachineGame.Enumerations.Ausrichtung;
import edu.WarMachineGame.IO.*;
import edu.WarMachineGame.WarMachines.*;

public class RemoteSpieler implements Spieler {

	// --------- VARIABLES --------- //
	private String name;
	private Client client;
	private Eingabe eingabe;
	private Ausgabe ausgabe;
	private SpielFeld spielfeld;
	private List<WarMachine> warMachine = new ArrayList<WarMachine>();

	// ----------------------------- //

	/**
	 * Erstellt einen Spieler mit dem angegebenen Namen.
	 * 
	 * @param String
	 *            name
	 */
	public RemoteSpieler(String name) {
		this.name = name;
		this.client = Client.getClient();
		this.spielfeld = new SpielFeld();
		this.eingabe = Eingabe.getEingabe();
		this.ausgabe = Ausgabe.getAusgabe();
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
		System.out.println("Gegner platziert das erste Schiff.");
		warMachine.add(platziereWarMachine(new Schlauchboot()));
		System.out.println("Gegner platziert das zweite Schiff.");
		warMachine.add(platziereWarMachine(new Fregatte()));
		System.out.println("Gegner platziert das dritte Schiff.");
		warMachine.add(platziereWarMachine(new Kreuzer()));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.WarMachineGame.SpielRaum.Spieler#shoot(edu.WarMachineGame.SpielRaum
	 * .LokalerSpieler)
	 */
	@Override
	public void shoot(Spieler gegner) {

		boolean invalidInput = true;
		String input = null;

		ausgabe.printSeparator();

		// Einleseschleife
		while (invalidInput) {
			try {
				input = client.getPlayerInput();
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
	 * Platziert die WarMachine und gibt diese wieder zurück;
	 * 
	 * @param WarMachine
	 * @return WarMachine
	 */
	private WarMachine platziereWarMachine(WarMachine newWarMachine) {

		boolean invalidInput = true;
		String input = null;
		Koordinate platzKoordinate = null;
		Ausrichtung platzAusrichtung = null;

		while (invalidInput) {
			try {
				input = client.getPlayerInput();
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
				System.out.println("Exception: " + e);
				invalidInput = true;
			}

		} // while invalid Input

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

}
