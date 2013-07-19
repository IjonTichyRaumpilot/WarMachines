package edu.WarMachineGame.SpielRaum;

import edu.WarMachineGame.WarMachines.WarMachine;

public class SpielFeld implements shootElement, placeWarMachine{

	private int dimensionX;
	private int dimensionY;
	private Element[][] elements;

	public SpielFeld(int dimensionX, int dimensionY) {
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionY;
		elements = new Element[dimensionX][dimensionY];
		for (int i = 0; i < dimensionX; i++) {
			for (int j = 0; j < dimensionY; j++) {
				elements[i][j]= new Element(new Koordinate(i,j));
			}
		}
	}

	public int getDimensionX() {
		return dimensionX;
	}

	public int getDimensionY() {
		return dimensionY;
	}

	public void place(WarMachine warMachine, Koordinate koord,
			Ausrichtung ausrichtung) throws InvalidPlacementException {

	}
	
	public void shoot(Koordinate koord) {
		
	}
	
	/**
	 * Ueberprueft, ob die Koordinate auf dem Spielfeld liegt.
	 * @param Koordinate
	 * @param SpielFeld
	 * @return boolean
	 */
	public boolean validKoordinaten(Koordinate koord){
		
		if((0 <= koord.getX())
			    &&(koord.getX() <= this.getDimensionX())
			    &&(0 <= koord.getY())
			    &&(koord.getY() <= this.getDimensionY())) {
			
				return true;
			}
		
		return false;
	}

}
