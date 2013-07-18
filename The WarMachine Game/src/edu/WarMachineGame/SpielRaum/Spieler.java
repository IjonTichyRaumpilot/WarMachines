package edu.WarMachineGame.SpielRaum;

import edu.WarMachineGame.IO.Ausgabe;
import edu.WarMachineGame.IO.Eingabe;

public class Spieler {

	// --------- VARIABLES --------- //
	private String name;
	private SpielFeld spielfeld;
	private Eingabe eingabe;
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
		this.eingabe = new Eingabe();
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * Platziere die Schiffe auf dem Spielfeld
	 * @return
	 */
	public void place(){
		
		
	}
	
	/**
	 * Schieße auf ein Feld des Spielers
	 * @return
	 */
	public void shoot(){
		
		boolean invalidInput = true;
		String input = null;
		
		System.out.println(this.getName() +", geben sie das Ziel an: x,y\n");
		
		// Einleseschleife
		while(invalidInput){
			try {
				input = eingabe.UserInput();
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
			Koordinate zielKoordinate = eingabe.string2Koord(input);
			if(!eingabe.ValidKoordinaten(zielKoordinate, spielfeld)) {
				System.out.println("Falsche Eingabe, bitte nochmal.\n");
				continue;
			}
			invalidInput = false;
			
		}
		
		
		System.exit(0); // DebugEXIT

	}
	
}
