package edu.WarMachineGame.WarMachines;

import java.awt.geom.IllegalPathStateException;
import java.util.Observable;
import java.util.Observer;

import edu.WarMachineGame.SpielRaum.Ausrichtung;
import edu.WarMachineGame.SpielRaum.InvalidPlacementException;
import edu.WarMachineGame.SpielRaum.Koordinate;
import edu.WarMachineGame.SpielRaum.SpielFeld;

public abstract class WarMachine extends Observable {

	private int laenge;
	private int breite;
	private Koordinate koord;
	private int hitCounter;
	private boolean versenkt;


	public WarMachine() {
		
	}

	public void setWarmachineElements(SpielFeld spielFeld) throws InvalidPlacementException {
		
	}

}
