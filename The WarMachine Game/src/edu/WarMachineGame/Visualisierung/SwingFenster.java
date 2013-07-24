package edu.WarMachineGame.Visualisierung;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.WarMachineGame.SpielRaum.Regeln;
import edu.WarMachineGame.SpielRaum.Spieler;

public class SwingFenster implements Visualisierbar {

	private JFrame fenster;

	@Override
	public void zeigeSpielFeld(Spieler spieler, Spieler gegner) {
		if (fenster == null) {
			fenster = new JFrame("Spielfeld " + spieler.getName());
			fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			updateFenster(spieler);
		} else
			updateFenster(spieler);
		fenster.pack();
		fenster.validate();
	}

	public void updateFenster(Spieler spieler) {

		fenster.setContentPane(getPanel(spieler));
		if (!fenster.isVisible())
			fenster.setVisible(true);
	}

	private JPanel getPanel(Spieler spieler) {
		JPanel panel = new JPanel();
		JPanel mainPanel = new JPanel(new GridLayout(11, 11, 20, 20));

		for (int i = Regeln.getSpielFeldGroesse().getY() - 1; i >= 0; i--) {
			for (int j = 0; j < Regeln.getSpielFeldGroesse().getX(); j++) {

				JButton button = new JButton(j + " - " + i);
				button.setBackground(spieler.getSpielfeld().getElements()[j][i]
						.getElementColor());
				mainPanel.add(button);

			}

		}

		panel.add(mainPanel);
		panel.setOpaque(true);
		return panel;
	}
}
