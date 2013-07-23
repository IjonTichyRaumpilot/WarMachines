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
import edu.WarMachineGame.WarMachines.Fregatte;
import edu.WarMachineGame.WarMachines.Kreuzer;
import edu.WarMachineGame.WarMachines.Schlauchboot;
import edu.WarMachineGame.WarMachines.WarMachine;

public class ComputerSpieler implements Spieler {

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
	public ComputerSpieler(String name) {
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

		// Einleseschleife
		while (invalidInput) {
			try {
				input = generateRandomKoordinate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			Koordinate zielKoordinate = eingabe.string2Koord(input);
			if (!gegner.getSpielfeld().validKoordinaten(zielKoordinate)) {
				continue;
			}
			invalidInput = false;
			invalidInput = !gegner.getSpielfeld().shoot(zielKoordinate);
			if (invalidInput) {
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
	 * @author Constantin
	 */
	private WarMachine platziereWarMachine(WarMachine newWarMachine) {

		boolean invalidInput = true;
		String input = null;
		Koordinate platzKoordinate = null;
		Ausrichtung platzAusrichtung = null;

		while (invalidInput) {
			try {
				input = generateRandomKoordinate() + ","
						+ generateRandomAusrichtung();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String[] argumente = input.split(",");
			if (argumente.length < 3) {
				continue;
			}
			platzKoordinate = eingabe.string2Koord(argumente[0].toString()
					+ "," + argumente[1].toString());
			platzAusrichtung = eingabe.string2Ausrichtung(argumente[2]);
			if (!eingabe.validAusrichtung(platzAusrichtung)) {
				continue;
			}

			try {
				spielfeld.place(newWarMachine, platzKoordinate,
						platzAusrichtung);
				invalidInput = false;
			} catch (Exception e) {
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

	private String generateRandomKoordinate() {

		int maxX = Regeln.getRegeln().getSpielFeldGroesse().getX();
		int maxY = Regeln.getRegeln().getSpielFeldGroesse().getY();

		// Min + (int)(Math.random() * ((Max - Min) + 1))
		maxX = (int) (Math.random() * (maxX + 1));
		maxY = (int) (Math.random() * (maxY + 1));

		return (Integer.toString(maxX) + "," + Integer.toString(maxY));
	}

	private String generateRandomAusrichtung() {

		// Min + (int)(Math.random() * ((Max - Min) + 1))
		int ausrichtung = -2 + (int) (Math.random() * 5);

		return (Integer.toString(ausrichtung));
	}

}
