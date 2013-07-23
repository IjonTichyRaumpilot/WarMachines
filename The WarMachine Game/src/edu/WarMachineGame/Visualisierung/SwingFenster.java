package edu.WarMachineGame.Visualisierung;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.WarMachineGame.SpielRaum.Spieler;

public class SwingFenster implements Visualisierbar {

	private JFrame fenster;

	@Override
	public void zeigeSpielFeld(Spieler spieler) {
		if (fenster == null) {
			fenster = new JFrame("Spielfeld " + spieler.getName());
			fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fenster.setSize(800, 600);
			updateFenster(spieler);
		} else
			updateFenster(spieler);
		fenster.repaint();

	}

	public void updateFenster(Spieler spieler) {

		fenster.setContentPane(getPanel(spieler));
		if (!fenster.isVisible())
			fenster.setVisible(true);
		fenster.validate();
		fenster.repaint();

	}

	private JPanel getPanel(Spieler spieler) {
		JPanel panel = new JPanel();
		JPanel mainPanel = new JPanel(new GridLayout(11, 11, 20, 20));

		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < 10; j++) {

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
