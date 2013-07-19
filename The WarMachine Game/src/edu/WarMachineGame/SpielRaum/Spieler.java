package edu.WarMachineGame.SpielRaum;

import edu.WarMachineGame.IO.Ausgabe;
import edu.WarMachineGame.IO.Eingabe;

public class Spieler {

	// --------- VARIABLES --------- //
	private String name;
	private SpielFeld spielfeld;
	private Eingabe eingabe;
	private Ausgabe ausgabe;
	private final int SpielFeldDimX = 10;
	private final int SpielFeldDimY = 10;
	// ----------------------------- //
	
	
	/**
	 * Erstellt einen Spieler mit dem angegebenen Namen.
	 * @param String name
	 */
	public Spieler(String name) {
		this.name = name;
		this.spielfeld = new SpielFeld(SpielFeldDimX,SpielFeldDimY);
		this.eingabe = Eingabe.getEingabe();
		this.ausgabe = Ausgabe.getAusgabe();
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * Platziere die Schiffe auf dem Spielfeld
	 * @return
	 */
	public void place(){
		
		boolean invalidInput = true;
		String input = null;
		Koordinate platzKoordinate = null;
		Ausrichtung platzAusrichtung = null;
		
		ausgabe.printSeparator();
		System.out.println(this.getName() + ", platzieren sie ihre Schiffe(Laenge).\n"
		        + "Geben sie dazu zuerst die Koordinate(x,y) für das Schiff an\n"
		        + "und danach die Ausrichtung, wobei:\n"
				+ "nach rechts  =  1\n"
				+ "nach links   = -1\n"
				+ "nach oben    =  2\n"
				+ "nach unten   = -2");
		ausgabe.printSeparator();
		
		System.out.println(this.getName() +", platzieren sie das erste Schiff(1): x,y,Richtung");
		
		while(invalidInput) {
			try {
				input = eingabe.getUserInput();
			} catch (Exception e) {
				e.printStackTrace();
			}	
			String[] argumente = input.split(",");
			if(argumente.length < 3) {
				System.out.println("Falsche Eingabe, bitte nochmal.");
				continue;
			}
			platzKoordinate = eingabe.string2Koord(argumente[0].toString()+","+argumente[1].toString());
			platzAusrichtung = eingabe.string2Ausrichtung(argumente[2]);
			
			// invalidInput = !spielfeld.platziere(WarMachine schiff1, Koordinate koord, Ausrichtung ausrichtung);
			if(invalidInput) {
				System.out.println("Falsche Eingabe, bitte nochmal.");
			}
		}
		
		
	}
	
	/**
	 * Schieße auf ein Feld des Spielers.
	 * @return
	 */
	public void shoot(){
		
		boolean invalidInput = true;
		String input = null;
		
		System.out.println(this.getName() +", geben sie das Ziel an: x,y");
		
		// Einleseschleife
		while(invalidInput){
			try {
				input = eingabe.getUserInput();
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
			Koordinate zielKoordinate = eingabe.string2Koord(input);
			if(!spielfeld.validKoordinaten(zielKoordinate)) {
				System.out.println("Falsche Eingabe, bitte nochmal.");
				continue;
			}
			invalidInput = false;
		} // invalidInput
		
		System.out.println("DebugExit");
		System.exit(0); // DebugEXIT

	}
	
}
