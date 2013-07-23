package edu.WarMachineGame.SpielRaum.ElementZustaende;

import java.awt.Color;

import edu.WarMachineGame.Interfaces.ElementZustand;
import edu.WarMachineGame.SpielRaum.Element;

public class FreiZustand implements ElementZustand {

	Element element;

	public FreiZustand(Element element) {
		this.element = element;
	}

	@Override
	public boolean shoot() {
		element.setZustand(new FreiBereitsBeschossenZustand(element));
		System.out.println("Kein Schiff getroffen!");
		return true;
	}

	@Override
	public String getElementVisualizationAsString() {
		return "+";
	}

	@Override
	public Color getElementColor() {
		return Color.cyan;
	}

}
