package edu.WarMachineGame.SpielRaum;

public class Regeln {

	private static Regeln regeln;
	private static Koordinate groesse;
	private static boolean gameOver;
	private static int anzahlWarMachine;

	private Regeln() {
	}

	/**
	 * Gibt einzige Instanz der Regeln zurueck.
	 * 
	 * @return Regeln
	 */
	public static Regeln getRegeln() {
		if (regeln == null) {
			regeln = new Regeln();
			groesse = new Koordinate(-1, -1);
			gameOver = false;
			setSpielFeldGroesse();
			setAnzahlWarMachines();
		}
		return regeln;
	}

	public static Koordinate getSpielFeldGroesse() {
		return groesse;
	}

	private static void setSpielFeldGroesse() {
		groesse.setX(10);
		groesse.setY(10);
	}

	private static void setAnzahlWarMachines() {
		anzahlWarMachine = 3;
	}

	public static int getAnzahlWarMachines() {
		return anzahlWarMachine;
	}

	public static boolean isGameOver() {
		return gameOver;
	}

	public static void setGameOver() {
		gameOver = true;
	}

}
