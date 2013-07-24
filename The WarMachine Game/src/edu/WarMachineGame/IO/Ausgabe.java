package edu.WarMachineGame.IO;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @author Constantin
 * 
 */
public class Ausgabe {

	// --------- VARIABLES --------- //
	private static Ausgabe ausgabe;

	// ----------------------------- //

	/**
	 * Privater Konstruktor verhindert externe Erstellung (Singleton)
	 */
	private Ausgabe() {
	}

	/**
	 * Gibt einzige Instanz der Ausgabe zurück.
	 * 
	 * @return Ausgabe
	 * @author Constantin
	 */
	public static Ausgabe getAusgabe() {
		if (ausgabe == null) {
			ausgabe = new Ausgabe();
		}
		return ausgabe;
	}

	/**
	 * Mache eine Seperationszeile zwischen den Textausgaben.
	 * 
	 * @author Constantin
	 */
	public void printSeparator() {

		System.out.println("------------------------"
				+ "-------------------------------------");

	}

	/**
	 * Zeige eine einfache Textnachricht.
	 * 
	 * @param titel
	 * @param message
	 * @author Arthur
	 */
	public void showMessage(String titel, String message) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(frame, message, titel,
				JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * Zeige eine einfache Textnachricht.
	 * 
	 * @param titel
	 * @param message
	 * @author Arthur
	 */
	public void showGameOverMessage(String titel, String message) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(frame, message, titel,
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Zeige eine Warnung.
	 * 
	 * @param titel
	 * @param message
	 * @author Arthur
	 */
	public void showWarning(String titel, String message) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(frame, message, titel,
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Printet, dass die Eingabe Falsch war.
	 * 
	 * @author Constantin
	 */
	public void printFalscheEingabe() {
		System.out.println("Falsche Eingabe, bitte nochmal.");
	}

	public void showFalscheEingabe() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(frame, "Falsche Eingabe, bitte nochmal.",
				"Falsche Eingabe", JOptionPane.ERROR_MESSAGE);
	}

}
