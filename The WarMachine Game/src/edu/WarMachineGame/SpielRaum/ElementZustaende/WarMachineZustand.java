package edu.WarMachineGame.SpielRaum.ElementZustaende;

import edu.WarMachineGame.Interfaces.ElementZustand;
import edu.WarMachineGame.SpielRaum.Element;

public class WarMachineZustand implements ElementZustand {

	Element element;

	public WarMachineZustand(Element element) {
		this.element = element;
	}

	@Override
	public boolean shoot() {
		element.getWarMachine().hit();
		element.setZustand(new WarMachineGetroffenZustand(element));
		if (element.getWarMachine().isVersenkt())
			System.out.println("Versenkt!!!");
		else
			System.out.println("Getroffen!!!");
		return true;
	}

	@Override
	public String getElementVisualizationAsString() {
		return "O";
	}

}
