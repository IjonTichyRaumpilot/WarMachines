package edu.WarMachineGame.SpielRaum;

import java.awt.Color;

import edu.WarMachineGame.Interfaces.ElementZustand;
import edu.WarMachineGame.SpielRaum.ElementZustaende.FreiZustand;
import edu.WarMachineGame.SpielRaum.ElementZustaende.WarMachineZustand;
import edu.WarMachineGame.WarMachines.WarMachine;

/**
 * Diese Klasse benutzt ein Zustandsmuster.
 * 
 * @author Arthur
 * 
 */
public class Element {

	private ElementZustand zustand;

	private Koordinate koord;

	private WarMachine warMachine;

	public Element(Koordinate koord) {
		this.koord = koord;
		this.zustand = new FreiZustand(this);
	}

	public boolean shoot() {
		return zustand.shoot();
	}

	public void anmelden(WarMachine warMachine) {
		this.warMachine = warMachine;
		this.zustand = new WarMachineZustand(this);
	}

	public void setZustand(ElementZustand zustand) {
		this.zustand = zustand;
	}

	public int getZustandsIndex() {
		return this.zustand.getZustandsIndex();
	}

	public WarMachine getWarMachine() {
		return warMachine;
	}

	public String getElemenVisualizationAsString() {
		return zustand.getElementVisualizationAsString();
	}

	public Color getElementColor() {
		return zustand.getElementColor();
	}

}
