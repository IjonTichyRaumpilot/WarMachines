package edu.WarMachineGame.SpielRaum;

public interface Spieler {

	/**
	 * Gibt Name des Spielers zurück.
	 * 
	 * @return String
	 * @author Constantin
	 */
	public String getName();

	/**
	 * Platziere die Schiffe des Spielers
	 * 
	 * @author Constantin
	 */
	public void place();

	/**
	 * Checkt, ob das Spiel vorbei ist.
	 * 
	 * @return boolean
	 * @author Constantin
	 */
	public boolean isGameOver();

	/**
	 * Holt das Spielfeld des Spielers.
	 * 
	 * @return SpielFeld
	 * @author Constantin
	 */
	public SpielFeld getSpielfeld();

	/**
	 * Schießt auf einen Spieler.
	 * 
	 * @param Spieler
	 * @author Constantin
	 */
	void shoot(Spieler gegner);

}
