package edu.WarMachineGame.SpielRaum;

public interface Spieler {

	/**
	 * Gibt Name des Spielers zurück.
	 * 
	 * @return String
	 */
	public String getName();

	/**
	 * Platziere die Schiffe des Spielers
	 */
	public void place();

	/**
	 * Checkt, ob das Spiel vorbei ist.
	 * 
	 * @return boolean
	 */
	public boolean isGameOver();

	/**
	 * Holt das Spielfeld des Spielers.
	 * 
	 * @return SpielFeld
	 */
	public SpielFeld getSpielfeld();

	/**
	 * Schießt auf einen Spieler.
	 * 
	 * @param Spieler
	 */
	void shoot(Spieler gegner);

}
