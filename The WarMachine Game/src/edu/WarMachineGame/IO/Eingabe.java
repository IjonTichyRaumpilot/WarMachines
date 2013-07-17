package edu.WarMachineGame.IO;

import java.io.*;

import edu.WarMachineGame.SpielRaum.Koordinate;
import edu.WarMachineGame.SpielRaum.SpielFeld;

public class Eingabe {

	/**
	 * Konvertiere einen String zB "4,5" in eine Koordinate.
	 * Gibt eine Koordinate mit -1,-1 zurück, falls
	 * eine fehlerhafte Eingabe vorhanden ist.
	 * @param String
	 * @return Koordinate
	 */
	public Koordinate string2Koord(String input) {
		
		// DefaultWerte falls falsche Eingabe
		int x=-1;
		int y=-1;

		String[] arguments =  input.split(",");
		
		// Check Input
		if(arguments.length < 2) {
			return null;
		}
		
		try {
			x = Integer.parseInt(arguments[0]);
			y = Integer.parseInt(arguments[1]);
		} catch (Exception e) {
			// Nothing
		}

		Koordinate koord = new Koordinate(x,y);
		
		return koord;
	}
	
	
	/**
	 * Diese Funktion liest den User-Input von der Eingabezeile
	 * @return String
	 * @throws IOException
	 */
	public String UserInput() throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		String input = bin.readLine();
		return input;
	}
	
	public boolean ValidKoordinaten(Koordinate koord, SpielFeld spielfeld){
		
		if(!((0 <= koord.getX())
			    &&(koord.getX() <= spielfeld.getDimensionX())
			    &&(0 <= koord.getY())
			    &&(koord.getY() <= spielfeld.getDimensionY()))) {
				System.out.println("valid");
				return true;
			}
		
		System.out.println("invalid");
		return false;
	}
	
}
