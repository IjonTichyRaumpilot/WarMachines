package edu.WarMachineGame.SpielRaum;

public class Regeln {

	private static Regeln regeln;
	private static Koordinate groesse;
	private static boolean gameOver;

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
			setSpielFeldGroesse();
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
	
	public static boolean isGameOver()
	{
		return gameOver;
	}

}
