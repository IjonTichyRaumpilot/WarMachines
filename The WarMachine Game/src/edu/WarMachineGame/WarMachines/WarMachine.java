package edu.WarMachineGame.WarMachines;

import edu.WarMachineGame.Exceptions.InvalidPlacementException;
import edu.WarMachineGame.SpielRaum.SpielFeld;

public abstract class WarMachine {

	protected int laenge;
	protected int breite;
	protected int maxHits;
	protected int hitCounter = 0;

	public WarMachine() {

	}

	public void setWarmachineElements(SpielFeld spielFeld)
			throws InvalidPlacementException {

	}

	public int getLaenge() {
		return laenge;
	}

	public void setLaenge(int laenge) {
		this.laenge = laenge;
	}

	public int getBreite() {
		return breite;
	}

	public void setBreite(int breite) {
		this.breite = breite;
	}

	public boolean isVersenkt() {
		if (hitCounter < maxHits)
			return false;
		return true;
	}

	public void hit() {
		hitCounter++;
	}

}
