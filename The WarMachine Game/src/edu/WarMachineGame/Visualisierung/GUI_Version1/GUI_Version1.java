package edu.WarMachineGame.Visualisierung.GUI_Version1;

import javax.swing.JFrame;

import edu.WarMachineGame.SpielRaum.Spieler;
import edu.WarMachineGame.TestDrive.GameStarter;
import edu.WarMachineGame.Visualisierung.Visualisierbar;

public class GUI_Version1 implements Visualisierbar {

	private GuiV1Frame fenster;

	@Override
	public void zeigeSpielFeld(Spieler spieler, Spieler gegner) {
		if (fenster == null) {
			fenster = new GuiV1Frame(spieler, gegner);
			GameStarter.setGUI(fenster);
			fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fenster.updateFenster();
		} else
			fenster.updateFenster();
		fenster.updateFenster();
	}
}
