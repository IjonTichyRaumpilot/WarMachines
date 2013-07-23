package edu.WarMachineGame.Spielerstatus;

import edu.WarMachineGame.Interfaces.Spielerstatus;

public class StatusVerloren implements Spielerstatus {

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.WarMachineGame.Interfaces.Spielerstatus#getSpielerstatus()
	 */
	public String getSpielerstatus() {
		return "verloren";
	}

}
