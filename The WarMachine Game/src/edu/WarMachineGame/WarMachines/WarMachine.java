package edu.WarMachineGame.WarMachines;

import java.awt.geom.IllegalPathStateException;
import java.util.Observable;
import java.util.Observer;

import edu.WarMachineGame.SpielRaum.Ausrichtung;
import edu.WarMachineGame.SpielRaum.InvalidPlacementException;
import edu.WarMachineGame.SpielRaum.Koordinate;
import edu.WarMachineGame.SpielRaum.SpielFeld;

public abstract class WarMachine implements Observer {

	private int laenge;
	private int breite;
	private Koordinate koord;
	private int hitCounter;
	private boolean versenkt;

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}

	public WarMachine(Koordinate koord, Ausrichtung ausrichtung) {
		
	}

	public void setWarmachineElements(SpielFeld spielFeld) throws InvalidPlacementException {
		
	}

}
