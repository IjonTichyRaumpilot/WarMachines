package edu.WarMachineGame.SpielRaum;

import java.util.Observable;

import edu.WarMachineGame.WarMachines.WarMachine;

public class Element extends Observable {

	private boolean beschossen;

	private Koordinate koord;

	private WarMachine warMachine;

	public Element(Koordinate koord) {
		this.koord = koord;
		this.beschossen = false;
	}

	public boolean isBeschossen() {
		return beschossen;
	}

	public void setBeschossen(boolean beschossen) {
		this.beschossen = beschossen;
	}

	public WarMachine getWarMachine() {
		return warMachine;
	}

	public void setWarMachine(WarMachine warMachine) {
		this.warMachine = warMachine;
	}

}
