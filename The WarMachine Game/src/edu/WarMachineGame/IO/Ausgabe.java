package edu.WarMachineGame.IO;

/**
 * 
 * @author Constantin
 * 
 */
public class Ausgabe {

	// --------- VARIABLES --------- //
	private static Ausgabe ausgabe;

	// ----------------------------- //

	/**
	 * Privater Konstruktor verhindert externe Erstellung (Singleton)
	 */
	private Ausgabe() {
	}

	/**
	 * Gibt einzige Instanz der Ausgabe zurück.
	 * 
	 * @return Ausgabe
	 * @author Constantin
	 */
	public static Ausgabe getAusgabe() {
		if (ausgabe == null) {
			ausgabe = new Ausgabe();
		}
		return ausgabe;
	}

	/**
	 * Mache eine Seperationszeile zwischen den Textausgaben.
	 * 
	 * @author Constantin
	 */
	public void printSeparator() {

		System.out.println("------------------------"
				+ "-------------------------------------");

	}

	/**
	 * Printet, dass die Eingabe Falsch war.
	 * 
	 * @author Constantin
	 */
	public void printFalscheEingabe() {
		System.out.println("Falsche Eingabe, bitte nochmal.");
	}

}
