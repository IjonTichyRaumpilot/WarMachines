package edu.WarMachineGame.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import edu.WarMachineGame.Enumerations.Ausrichtung;
import edu.WarMachineGame.SpielRaum.Koordinate;
import edu.WarMachineGame.TestDrive.GameStarter;

/**
 * 
 * @author Constantin
 * 
 */
public class Eingabe {

	// --------- VARIABLES --------- //
	private static Eingabe eingabe;

	// ----------------------------- //

	/**
	 * Privater Konstruktor verhindert externe Erstellung ... wiedermal
	 * 
	 * @author Constantin
	 */
	private Eingabe() {
	}

	/**
	 * Gibt einzige Instanz der Eingabe zurück.
	 * 
	 * @return Eingabe
	 * @author Constantin
	 */
	public static Eingabe getEingabe() {
		if (eingabe == null) {
			eingabe = new Eingabe();
		}
		return eingabe;
	}

	/**
	 * Konvertiere einen String zB "4,5" in eine Koordinate. Gibt eine
	 * Koordinate mit -1,-1 zurück, falls eine fehlerhafte Eingabe vorhanden
	 * ist.
	 * 
	 * @param String
	 *            koordinate
	 * @return Koordinate
	 * @author Constantin
	 */
	public Koordinate string2Koord(String input) {

		// DefaultWerte falls falsche Eingabe
		int x = -1;
		int y = -1;

		String[] arguments = input.split(",");

		try {
			x = Integer.parseInt(arguments[0]);
			y = Integer.parseInt(arguments[1]);
		} catch (Exception e) {
			// Sieht doppelt gemoppelt aus,
			// ist es aber nicht.
			x = -1;
			y = -1;
		}

		Koordinate koord = new Koordinate(x, y);

		return koord;
	}

	/**
	 * Konvertiert einen String in eine Ausrichtung, wobei "1"=XPLUS,
	 * "-1"=XMINUS, "2"=YPLUS, "-2"=-YMINUS, KEINE=sonst.
	 * 
	 * @param String
	 *            ausrichtung
	 * @return Ausrichtung
	 * @author Constantin
	 */
	public Ausrichtung string2Ausrichtung(String input) {

		int richtung = 0; // -1,1,-2,2 == -x,x,y,-y
		Ausrichtung ausrichtung = null;

		try {
			richtung = Integer.parseInt(input);
		} catch (Exception e) {
			// Nothing
		}

		switch (richtung) {
		case 1:
			ausrichtung = Ausrichtung.XPLUS;
			break;
		case -1:
			ausrichtung = Ausrichtung.XMINUS;
			break;
		case 2:
			ausrichtung = Ausrichtung.YPLUS;
			break;
		case -2:
			ausrichtung = Ausrichtung.YMINUS;
			break;
		default:
			ausrichtung = Ausrichtung.KEINE;
			break;
		}

		return ausrichtung;
	}

	/**
	 * Diese Funktion liest den User-Input von der Eingabezeile.
	 * 
	 * @return String
	 * @throws IOException
	 * @author Constantin
	 */
	public String getUserInput() throws IOException {
		BufferedReader bin = new BufferedReader(
				new InputStreamReader(System.in));
		String input = bin.readLine();
		return input;
	}

	/**
	 * Diese Methode liest den User-Input aus einem Dialog.
	 * 
	 * @param titel
	 * @param message
	 * @return
	 * @author Arthur
	 */
	public String getUserInputFromDialog(String titel, String message) {
		JFrame frame = new JFrame(titel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String s = (String) JOptionPane.showInputDialog(frame, message);
		return s;
	}

	/**
	 * Diese Methode gibt dem User mittels eines Dialogs entsprechende
	 * Auswahlm�glichkeiten.
	 * 
	 * @param titel
	 *            Dialogtitel
	 * @param message
	 *            Nachricht an den User
	 * @param options
	 *            Beschriftung der Buttons. Der Integer-Wert des Arrays ist der
	 *            return-Wert der Funktion
	 * @return Index
	 */
	public int askOpstionsAsString(String titel, String message,
			String[] options) {
		JFrame frame = new JFrame(titel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int n = JOptionPane.showOptionDialog(frame, message, titel,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				options, null);
		return n;
	}

	/**
	 * Diese Funktion wartet auf eine neue Koordinate auf der GUI vom User.
	 * 
	 * @return String
	 * @author Arthur
	 */
	public String getUserKoordinateInputFromGUI() {
		String temp = GameStarter.getInput();
		String neu = temp;
		while (temp.contentEquals(neu)) {
			neu = GameStarter.getInput();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
		}
		return neu;

	}

	/**
	 * Ueberprueft, ob die Ausrichtung valide ist. Gibt True für OK und False,
	 * falls die Instanz null ist, zurück.
	 * 
	 * @param Ausrichtung
	 * @return boolean
	 * @author Constantin
	 */
	public boolean validAusrichtung(Ausrichtung ausrichtung) {
		if (ausrichtung == Ausrichtung.KEINE) {
			return false;
		}
		return true;
	}

}
