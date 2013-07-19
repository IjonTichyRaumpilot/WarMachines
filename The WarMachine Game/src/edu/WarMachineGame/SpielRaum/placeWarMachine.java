package edu.WarMachineGame.SpielRaum;

import edu.WarMachineGame.WarMachines.WarMachine;

public interface placeWarMachine {
	
	public void place(WarMachine warMachine, Koordinate koord,
			Ausrichtung ausrichtung) throws InvalidPlacementException;

}
