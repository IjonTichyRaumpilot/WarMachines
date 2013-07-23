package edu.WarMachineGame.SpielRaum;

import edu.WarMachineGame.WarMachines.WarMachine;

public interface Spieler {

	public String getName();

	public void place();

	public boolean isGameOver();

	public void printStatus();

	public WarMachine platziereWarMachine(WarMachine newWarMachine);

	public SpielFeld getSpielfeld();

	void shoot(Spieler gegner);

}
