package edu.WarMachineGame.SpielRaum.ElementZustaende;

import edu.WarMachineGame.Interfaces.ElementZustand;
import edu.WarMachineGame.SpielRaum.Element;

public class FreiBereitsBeschossenZustand implements ElementZustand {

	Element element;

	public FreiBereitsBeschossenZustand(Element element) {
		this.element = element;
	}

	@Override
	public boolean shoot() {
		return false;
	}

	@Override
	public String getElementVisualizationAsString() {
		return "X";
	}
}