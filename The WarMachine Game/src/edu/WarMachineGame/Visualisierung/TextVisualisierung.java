package edu.WarMachineGame.Visualisierung;

import edu.WarMachineGame.SpielRaum.Regeln;
import edu.WarMachineGame.SpielRaum.Spieler;
import edu.WarMachineGame.SpielRaum.ElementZustaende.FreiZustand;
import edu.WarMachineGame.SpielRaum.ElementZustaende.WarMachineZustand;

public class TextVisualisierung implements Visualisierbar {

	@Override
	public void zeigeSpielFeld(Spieler spieler, Spieler gegner) {

		System.out.println(erzeugeEigenesFeld(spieler));
		System.out.println(erzeugeGegnerFeld(gegner));

	}

	private String erzeugeEigenesFeld(Spieler spieler) {
		StringBuffer out = new StringBuffer();

		out.append("EIGENES SPIELFELD\n");

		for (int i = Regeln.getSpielFeldGroesse().getY() - 1; i >= 0; i--) {
			out.append(i + "| ");
			for (int j = 0; j < Regeln.getSpielFeldGroesse().getX(); j++) {
				out.append(spieler.getSpielfeld().getElements()[j][i]
						.getElemenVisualizationAsString() + " ");
			}
			out.append("\n");
		}
		out.append(" ---------------------\n");
		out.append("   0 1 2 3 4 5 6 7 8 9\n\n");

		return out.toString();
	}

	private String erzeugeGegnerFeld(Spieler gegner) {
		StringBuffer out = new StringBuffer();

		out.append("GEGNER SPIELFELD\n");

		for (int i = Regeln.getSpielFeldGroesse().getY() - 1; i >= 0; i--) {
			out.append(i + "| ");
			for (int j = 0; j < Regeln.getSpielFeldGroesse().getX(); j++) {
				if (gegner.getSpielfeld().getElements()[j][i]
						.getElemenVisualizationAsString().equals(
								new WarMachineZustand(null)
										.getElementVisualizationAsString())) {
					out.append(new FreiZustand(null)
							.getElementVisualizationAsString());
					continue;
				}
				out.append(gegner.getSpielfeld().getElements()[j][i]
						.getElemenVisualizationAsString() + " ");
			}
			out.append("\n");
		}
		out.append(" ---------------------\n");
		out.append("   0 1 2 3 4 5 6 7 8 9\n\n");

		return out.toString();
	}

}
