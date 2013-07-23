package edu.WarMachineGame.SpielRaum.ElementZustaende;

import java.awt.Color;

import edu.WarMachineGame.Interfaces.ElementZustand;
import edu.WarMachineGame.SpielRaum.Element;

public class WarMachineGetroffenZustand implements ElementZustand {

	Element element;

	public WarMachineGetroffenZustand(Element element) {
		this.element = element;
	}

	@Override
	public boolean shoot() {
		return false;
	}

	@Override
	public String getElementVisualizationAsString() {
		return "#";
	}

	@Override
	public Color getElementColor() {
		return Color.red;
	}

	@Override
	public int getZustandsIndex() {
		return 3;
	}

}
