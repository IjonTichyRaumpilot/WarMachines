package edu.WarMachineGame.SpielRaum;

import java.util.ArrayList;
import java.util.List;

import edu.WarMachineGame.IO.Ausgabe;
import edu.WarMachineGame.IO.Eingabe;
import edu.WarMachineGame.WarMachines.Fregatte;
import edu.WarMachineGame.WarMachines.Kreuzer;
import edu.WarMachineGame.WarMachines.Schlauchboot;
import edu.WarMachineGame.WarMachines.WarMachine;

public class Spieler {

	// --------- VARIABLES --------- //
	private String name;
	private Eingabe eingabe;
	private Ausgabe ausgabe;
	private SpielFeld spielfeld;
	private Spielerstatus spielerstatus;
	private List<WarMachine> warMachine = new ArrayList<WarMachine>();
	// ----------------------------- //

	/**
	 * Erstellt einen Spieler mit dem angegebenen Namen.
	 * 
	 * @param String
	 *            name
	 */
	public Spieler(String name) {
		this.name = name;
		this.spielfeld = new SpielFeld();
		this.eingabe = Eingabe.getEingabe();
		this.ausgabe = Ausgabe.getAusgabe();
		this.spielerstatus = new StatusGewonnen();
	}

	public String getName() {
		return name;
	}

	/**
	 * Platziere die Schiffe auf dem Spielfeld
	 * 
	 * @return
	 */
	public void place() {

		ausgabe.printSeparator();
		System.out
				.println(this.getName()
						+ ", platzieren sie ihre Schiffe(Laenge).\n"
						+ "Geben sie dazu zuerst die Koordinate(x,y) für das Schiff an\n"
						+ "und danach die Ausrichtung, wobei:\n"
						+ "nach rechts  =  1\n" + "nach links   = -1\n"
						+ "nach oben    =  2\n" + "nach unten   = -2");
		ausgabe.printSeparator();

		System.out.println(this.getName()+ ", platzieren sie das erste Schiff(1): x,y,Richtung");
		warMachine.add(platziereWarMachine(new Schlauchboot()));
		System.out.println(this.getName()+ ", platzieren sie das zweite Schiff(2): x,y,Richtung");
		warMachine.add(platziereWarMachine(new Fregatte()));
		System.out.println(this.getName()+ ", platzieren sie das dritte Schiff(3): x,y,Richtung");
		warMachine.add(platziereWarMachine(new Kreuzer()));
		
		
	}

	/**
	 * Schieße auf ein Feld des Spielers.
	 * 
	 * @return
	 */
	public void shoot() {

		boolean invalidInput = true;
		String input = null;

		System.out.println(this.getName() + ", geben sie das Ziel an: x,y");

		// Einleseschleife
		while (invalidInput) {
			try {
				input = eingabe.getUserInput();
			} catch (Exception e) {
				e.printStackTrace();
			}

			Koordinate zielKoordinate = eingabe.string2Koord(input);
			if (!spielfeld.validKoordinaten(zielKoordinate)) {
				ausgabe.printFalscheEingabe();
				continue;
			}
			invalidInput = false;
			// invalidInput = !spielfeld.shoot(zielKoordinate);
			if(invalidInput) {
				ausgabe.printFalscheEingabe();
			}
			
		} // invalidInput

		

	}

	public void printSpielFeld() {
		this.spielfeld.updateSpielFeld();
	}

	/**
	 * Gibt den Spielerstatus nach dem Spiel aus. Der Spielerstatus
	 * variiert, je nachdem ob er verloren oder gewonnen hat (Strategiemuster).
	 */
	public void printStatus() {
		for (WarMachine w : warMachine) {
			// w.istVersenkt -> spielerstatus = new StatusVerloren();
		}
		System.out.println(this.getName() + " hat " + spielerstatus.getSpielerstatus()); 
		}
	
	/**
	 * Platziert eine WarMachine auf dem Spielfeld. Gibt diese
	 * WarMachine dann wieder zurück.
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
				spielfeld.place(newWarMachine, platzKoordinate, platzAusrichtung);
				invalidInput = false;
			} catch (Exception e) {
				ausgabe.printFalscheEingabe();
				invalidInput = true;
			}
			
		} // while invalid Input
		
		return newWarMachine;
	}

}
