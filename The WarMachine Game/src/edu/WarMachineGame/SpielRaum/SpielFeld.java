package edu.WarMachineGame.SpielRaum;

import edu.WarMachineGame.WarMachines.WarMachine;

public class SpielFeld implements shootElement, placeWarMachine {

	private Element[][] elements;

	public SpielFeld() {
		elements = new Element[Regeln.getSpielFeldGroesse().getX()][Regeln
				.getSpielFeldGroesse().getY()];
		for (int i = 0; i < Regeln.getSpielFeldGroesse().getX(); i++) {
			for (int j = 0; j < Regeln.getSpielFeldGroesse().getY(); j++) {
				elements[i][j] = new Element(new Koordinate(i, j));
			}
		}
	}

	public void place(WarMachine warMachine, Koordinate koord,
			Ausrichtung ausrichtung) throws InvalidPlacementException {

	}

	public void shoot(Koordinate koord) {

	}

	/**
	 * Ueberprueft, ob die Koordinate auf dem Spielfeld liegt.
	 * 
	 * @param Koordinate
	 * @param SpielFeld
	 * @return boolean
	 */
	public boolean validKoordinaten(Koordinate koord) {

		if ((0 <= koord.getX())
				&& (koord.getX() <= Regeln.getSpielFeldGroesse()
						.getX())
				&& (0 <= koord.getY())
				&& (koord.getY() <= Regeln.getSpielFeldGroesse()
						.getY())) {

			return true;
		}

		return false;
	}

	public void updateSpielFeld() {
		System.out.println("BLABLA");
	}

}
