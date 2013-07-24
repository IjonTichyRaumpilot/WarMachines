package edu.WarMachineGame.SpielRaum.ElementZustaende;

import java.awt.Color;

import edu.WarMachineGame.Interfaces.ElementZustand;
import edu.WarMachineGame.SpielRaum.Element;
import edu.WarMachineGame.TestDrive.GameStarter;

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
			GameStarter.setSpielStatus("Versenkt!!!");
		else
			GameStarter.setSpielStatus("Getroffen!!!");
		return true;
	}

	@Override
	public String getElementVisualizationAsString() {
		return "O";
	}

	@Override
	public Color getElementColor() {
		return Color.green;
	}

	@Override
	public int getZustandsIndex() {
		return 2;
	}

}
