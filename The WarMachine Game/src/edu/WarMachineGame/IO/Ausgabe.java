package edu.WarMachineGame.IO;

public class Ausgabe {
	
	// --------- VARIABLES --------- //
	private static Ausgabe ausgabe;
	// ----------------------------- //
	
	
	/**
	 * Privater Konstruktor verhindert externe Erstellung
	 */
	private Ausgabe(){}

	/**
	 * Gibt einzige Instanz der Ausgabe zurück.
	 * @return Ausgabe
	 */
	public static Ausgabe getAusgabe() {
		if(ausgabe == null) {
			ausgabe = new Ausgabe();
		}
		return ausgabe;
	}
	
	public void printSeparator() {
		
		System.out.println("------------------------"
				+ "-------------------------------------");
		
	}
	
}
