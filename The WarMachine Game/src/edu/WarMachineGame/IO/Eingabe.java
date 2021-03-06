package edu.WarMachineGame.IO;

import java.io.*;

import edu.WarMachineGame.Enumerations.Ausrichtung;
import edu.WarMachineGame.SpielRaum.Koordinate;
import edu.WarMachineGame.SpielRaum.SpielFeld;

/**
 * 
 * @author Constantin
 * 
 */
public class Eingabe {

	// --------- VARIABLES --------- //
	private static Eingabe eingabe;

	// ----------------------------- //

	/**
	 * Privater Konstruktor verhindert externe Erstellung ... wiedermal
	 * 
	 * @author Constantin
	 */
	private Eingabe() {
	}

	/**
	 * Gibt einzige Instanz der Eingabe zurück.
	 * 
	 * @return Eingabe
	 * @author Constantin
	 */
	public static Eingabe getEingabe() {
		if (eingabe == null) {
			eingabe = new Eingabe();
		}
		return eingabe;
	}

	/**
	 * Konvertiere einen String zB "4,5" in eine Koordinate. Gibt eine
	 * Koordinate mit -1,-1 zurück, falls eine fehlerhafte Eingabe vorhanden
	 * ist.
	 * 
	 * @param String
	 *            koordinate
	 * @return Koordinate
	 * @author Constantin
	 */
	public Koordinate string2Koord(String input) {

		// DefaultWerte falls falsche Eingabe
		int x = -1;
		int y = -1;

		String[] arguments = input.split(",");

		try {
			x = Integer.parseInt(arguments[0]);
			y = Integer.parseInt(arguments[1]);
		} catch (Exception e) {
			// Sieht doppelt gemoppelt aus,
			// ist es aber nicht.
			x = -1;
			y = -1;
		}

		Koordinate koord = new Koordinate(x, y);

		return koord;
	}

	/**
	 * Konvertiert einen String in eine Ausrichtung, wobei "1"=XPLUS,
	 * "-1"=XMINUS, "2"=YPLUS, "-2"=-YMINUS, KEINE=sonst.
	 * 
	 * @param String
	 *            ausrichtung
	 * @return Ausrichtung
	 * @author Constantin
	 */
	public Ausrichtung string2Ausrichtung(String input) {

		int richtung = 0; // -1,1,-2,2 == -x,x,y,-y
		Ausrichtung ausrichtung = null;

		try {
			richtung = Integer.parseInt(input);
		} catch (Exception e) {
			// Nothing
		}

		switch (richtung) {
		case 1:
			ausrichtung = Ausrichtung.XPLUS;
			break;
		case -1:
			ausrichtung = Ausrichtung.XMINUS;
			break;
		case 2:
			ausrichtung = Ausrichtung.YPLUS;
			break;
		case -2:
			ausrichtung = Ausrichtung.YMINUS;
			break;
		default:
			ausrichtung = Ausrichtung.KEINE;
			break;
		}

		return ausrichtung;
	}

	/**
	 * Diese Funktion liest den User-Input von der Eingabezeile.
	 * 
	 * @return String
	 * @throws IOException
	 * @author Constantin
	 */
	public String getUserInput() throws IOException {
		BufferedReader bin = new BufferedReader(
				new InputStreamReader(System.in));
		String input = bin.readLine();
		return input;
	}

	/**
	 * Ueberprueft, ob die Ausrichtung valide ist. Gibt True für OK und False,
	 * falls die Instanz null ist, zurück.
	 * 
	 * @param Ausrichtung
	 * @return boolean
	 * @author Constantin
	 */
	public boolean validAusrichtung(Ausrichtung ausrichtung) {
		if (ausrichtung == Ausrichtung.KEINE) {
			return false;
		}
		return true;
	}

}
