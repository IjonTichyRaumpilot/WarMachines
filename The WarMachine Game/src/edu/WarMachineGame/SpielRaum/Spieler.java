package edu.WarMachineGame.SpielRaum;

import edu.WarMachineGame.IO.Ausgabe;
import edu.WarMachineGame.IO.Eingabe;

public class Spieler {

	private String name;
	private SpielFeld spielfeld;
	private Eingabe eingabe;
	
	public Spieler(String name) {
		this.name = name;
		this.spielfeld = new SpielFeld(7,7);
		this.eingabe = new Eingabe();
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * Schieße auf ein Feld des Spielers
	 * @return
	 */
	public int shoot(){
		
		boolean invalidInput = true;
		String input = null;
		
		System.out.println(this.getName() +" ,geben sie das Ziel an: x,y\n");
		
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
			
			System.out.println(zielKoordinate.getX() + " und " + zielKoordinate.getY());
			
			System.exit(0); // DebugEXIT
		}
		return 0;
	}
	
}
