package edu.WarMachineGame.SpielRaum;

import edu.WarMachineGame.WarMachines.WarMachine;

public abstract class Spieler {

	public abstract String getName();

	/**
	 * Platziere die Schiffe auf dem Spielfeld
	 * 
	 * @return
	 */
	public abstract void place();

	/**
	 * Schieße auf ein Feld des Spielers.
	 * 
	 * @return
	 */
	public abstract void shoot(LokalerSpieler gegner);

	/**
	 * Checke, ob das Spiel GameOver ist
	 */
	protected abstract void isGameOver();

	/**
	 * Gib das Spiefeld aus
	 */
	public abstract void printSpielFeld();

	/**
	 * Gibt den Spielerstatus nach dem Spiel aus. Der Spielerstatus variiert, je
	 * nachdem ob er verloren oder gewonnen hat (Strategiemuster).
	 */
	public abstract void printStatus();

	/**
	 * Platziert eine WarMachine auf dem Spielfeld. Gibt diese WarMachine dann
	 * wieder zurück.
	 * 
	 * @param WarMachine
	 * @return WarMachine
	 */
	protected abstract WarMachine platziereWarMachine(WarMachine newWarMachine);

	/**
	 * Gib das Spielfeld zurueck.
	 * 
	 * @return Spielfeld
	 */
	public abstract SpielFeld getSpielfeld();

}
