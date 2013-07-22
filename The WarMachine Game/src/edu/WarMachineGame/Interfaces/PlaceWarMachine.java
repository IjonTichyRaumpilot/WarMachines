package edu.WarMachineGame.Interfaces;

import edu.WarMachineGame.Enumerations.Ausrichtung;
import edu.WarMachineGame.Exceptions.InvalidPlacementException;
import edu.WarMachineGame.SpielRaum.Koordinate;
import edu.WarMachineGame.WarMachines.WarMachine;

public interface PlaceWarMachine {
	
	public void place(WarMachine warMachine, Koordinate koord,
			Ausrichtung ausrichtung) throws InvalidPlacementException;

}
