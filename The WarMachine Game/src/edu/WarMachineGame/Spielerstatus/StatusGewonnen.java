package edu.WarMachineGame.Spielerstatus;

import edu.WarMachineGame.Interfaces.Spielerstatus;

public class StatusGewonnen implements Spielerstatus {

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.WarMachineGame.Interfaces.Spielerstatus#getSpielerstatus()
	 */
	public String getSpielerstatus() {
		return "gewonnen";
	}

}
