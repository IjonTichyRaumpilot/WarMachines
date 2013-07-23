package edu.WarMachineGame.SpielRaum.ElementZustaende;

import java.awt.Color;

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

	@Override
	public Color getElementColor() {
		return Color.black;
	}

	@Override
	public int getZustandsIndex() {
		return 1;
	}
}