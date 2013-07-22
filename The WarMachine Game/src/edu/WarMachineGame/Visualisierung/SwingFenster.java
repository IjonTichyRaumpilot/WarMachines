package edu.WarMachineGame.Visualisierung;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingFenster {

	private JFrame fenster;

	private JLabel text;

	public void visualize(String spielFeld, String name) {

		fenster = new JFrame("Spielfeld " + name);
		fenster.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// neues objekt "label" von der klasse JLabel erstellen (der anzeigetext
		// wird
		// gleich mit �bergeben)
		text = new JLabel(spielFeld, JLabel.CENTER);

		// dem fenster das label hinzuf�gen
		fenster.getContentPane().add(text);

		// fesntergr��e festlegen
		fenster.setSize(800, 600);

		// fenster anzeigen
		fenster.setVisible(true);

	}

}
