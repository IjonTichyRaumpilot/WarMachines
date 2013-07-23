package edu.WarMachineGame.Visualisierung.GUI_Version1;

import edu.WarMachineGame.SpielRaum.Spieler;
import edu.WarMachineGame.Visualisierung.Visualisierbar;

public class GUI_Version1 implements Visualisierbar {

	private GuiV1Frame fenster;

	@Override
	public void zeigeSpielFeld(Spieler spieler, Spieler gegner) {
		if (fenster == null) {
			fenster = new GuiV1Frame(spieler, gegner);

		} else
			fenster.updateFenster();
	}
}
