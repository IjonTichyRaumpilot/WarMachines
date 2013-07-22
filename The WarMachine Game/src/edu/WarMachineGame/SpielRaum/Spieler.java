package edu.WarMachineGame.SpielRaum;

import edu.WarMachineGame.WarMachines.*;

public interface Spieler {

	public String getName();

	public void place();

	public void isGameOver();

	public void printSpielFeld();

	public void printStatus();

	public WarMachine platziereWarMachine(WarMachine newWarMachine);

	public SpielFeld getSpielfeld();

	void shoot(Spieler gegner);

}
