package edu.WarMachineGame.SpielRaum;

import edu.WarMachineGame.Enumerations.Ausrichtung;
import edu.WarMachineGame.Exceptions.InvalidPlacementException;
import edu.WarMachineGame.Interfaces.PlaceWarMachine;
import edu.WarMachineGame.Interfaces.ShootElement;
import edu.WarMachineGame.Visualisierung.SwingFenster;
import edu.WarMachineGame.WarMachines.WarMachine;

public class SpielFeld implements ShootElement, PlaceWarMachine {

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
		int laenge = warMachine.getLaenge();
		int breite = warMachine.getBreite();

		if (!validKoordinaten(koord))
			throw new InvalidPlacementException();

		switch (ausrichtung) {
		case KEINE:
			throw new InvalidPlacementException();
		case XPLUS:
			if (!validPlacementXPLUS(laenge, breite, koord))
				throw new InvalidPlacementException();
			break;
		case XMINUS:
			if (!validPlacementXMINUS(laenge, breite, koord))
				throw new InvalidPlacementException();
			break;
		case YPLUS:
			if (!validPlacementYPLUS(laenge, breite, koord))
				throw new InvalidPlacementException();
			break;
		case YMINUS:
			if (!validPlacementYMINUS(laenge, breite, koord))
				throw new InvalidPlacementException();
			break;
		}

		placeWarMachine(warMachine, koord, ausrichtung);

	}

	private boolean validPlacementXPLUS(int laenge, int breite, Koordinate koord) {
		if (koord.getX() + laenge - 1 <= Regeln.getSpielFeldGroesse().getX()
				&& koord.getY() + breite - 1 <= Regeln.getSpielFeldGroesse()
						.getY())
			return true;
		return false;
	}

	private boolean validPlacementXMINUS(int laenge, int breite,
			Koordinate koord) {
		if (koord.getX() - laenge + 1 >= 0 && koord.getY() - breite + 1 >= 0)
			return true;
		return false;
	}

	private boolean validPlacementYPLUS(int laenge, int breite, Koordinate koord) {
		if (koord.getX() - breite + 1 >= 0
				&& koord.getY() + laenge - 1 <= Regeln.getSpielFeldGroesse()
						.getY())
			return true;
		return false;
	}

	private boolean validPlacementYMINUS(int laenge, int breite,
			Koordinate koord) {
		if (koord.getX() + breite - 1 <= Regeln.getSpielFeldGroesse().getX()
				&& koord.getY() - laenge + 1 >= 0)
			return true;
		return false;
	}

	private void placeWarMachine(WarMachine warMachine, Koordinate koord,
			Ausrichtung ausrichtung) {
		Koordinate min = getMin(warMachine, koord, ausrichtung);
		Koordinate max = getMax(warMachine, koord, ausrichtung);

		for (int i = min.getY(); i <= max.getY(); i++) {
			for (int j = min.getX(); j <= max.getX(); j++) {
				elements[j][i].anmelden(warMachine);
			}
		}
	}

	private Koordinate getMin(WarMachine warMachine, Koordinate koord,
			Ausrichtung ausrichtung) {
		switch (ausrichtung) {
		case XPLUS:
			return koord;
		case XMINUS:
			return new Koordinate(koord.getX() - warMachine.getLaenge() + 1,
					koord.getY() - warMachine.getBreite() + 1);
		case YPLUS:
			return new Koordinate(koord.getX() - warMachine.getBreite() + 1,
					koord.getY());
		case YMINUS:
			return new Koordinate(koord.getX(), koord.getY()
					- warMachine.getLaenge() + 1);
		default:
			break;
		}
		return null;
	}

	private Koordinate getMax(WarMachine warMachine, Koordinate koord,
			Ausrichtung ausrichtung) {
		switch (ausrichtung) {
		case XPLUS:
			return new Koordinate(koord.getX() + warMachine.getLaenge() - 1,
					koord.getY() + warMachine.getBreite() - 1);
		case XMINUS:
			return koord;
		case YPLUS:
			return new Koordinate(koord.getX(), koord.getY()
					+ warMachine.getLaenge() - 1);
		case YMINUS:
			return new Koordinate(koord.getX() + warMachine.getBreite() - 1,
					koord.getY());
		default:
			break;
		}
		return null;
	}

	public boolean shoot(Koordinate koord) {
		return elements[koord.getX()][koord.getY()].shoot();
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
				&& (koord.getX() < Regeln.getSpielFeldGroesse().getX())
				&& (0 <= koord.getY())
				&& (koord.getY() < Regeln.getSpielFeldGroesse().getY())) {

			return true;
		}

		return false;
	}

	public void updateSpielFeld(String name) {

		SwingFenster visualize = new SwingFenster();

		StringBuffer out = new StringBuffer();

		for (int i = Regeln.getSpielFeldGroesse().getY() - 1; i >= 0; i--) {
			out.append(i + "| ");
			for (int j = 0; j < Regeln.getSpielFeldGroesse().getX(); j++) {
				out.append(elements[j][i].getElemenVisualizationAsString()
						+ " ");
			}
			out.append("\n");
		}
		out.append(" ---------------------\n");
		out.append("   0 1 2 3 4 5 6 7 8 9");

		System.out.println(out.toString());

		// visualize.visualize(out.toString(), name);

	}

}
