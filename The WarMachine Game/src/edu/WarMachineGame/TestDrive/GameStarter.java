package edu.WarMachineGame.TestDrive;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

import edu.WarMachineGame.ClientConnection.Client;
import edu.WarMachineGame.SpielRaum.ComputerSpieler;
import edu.WarMachineGame.SpielRaum.LokalerSpieler;
import edu.WarMachineGame.SpielRaum.Regeln;
import edu.WarMachineGame.SpielRaum.RemoteSpieler;
import edu.WarMachineGame.SpielRaum.Spieler;
import edu.WarMachineGame.Visualisierung.StartBildschirm;
import edu.WarMachineGame.Visualisierung.Visualisierbar;
import edu.WarMachineGame.Visualisierung.GUI_Version1.GUI_Version1;

/**
 * 
 * Dieses Spiel ist ein Angriffssimulator für einen realgetreuen Flottenkampf.
 * Kann auch zur strategischen Angriffsplanung auf westliche Mächte verwendet
 * werden.
 * 
 * @author Arthur und Constantin
 * 
 */
public class GameStarter {

	private static String spielerInput = "";
	private static String spielStatus = "";
	private static JLabel iniLabel;
	private static JFrame startBildschirm;

	private static JTextArea textArea;
	private static JScrollBar scrollBar;
	private static JFrame gui;

	private static JPanel spielFeld_Spieler;
	private static JPanel spielFeld_Gegner;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		startBildschirm = new StartBildschirm();
		startBildschirm.setVisible(true);
		setIniStatus("Bei einem Netzwerkspiel muss der Host zuerst starten.");
		// Init Regeln
		Regeln regeln = Regeln.getRegeln();

		// Init Players
		LokalerSpieler spieler1 = new LokalerSpieler("Spieler1");
		Spieler spieler2 = null;

		if (Client.getClient().getIsLocal()) {
			spieler2 = new ComputerSpieler("Spieler2");
		} else {
			spieler2 = new RemoteSpieler("Spieler2");
		}

		// Platziere Schiffe (Host zuerst)
		if (Client.getClient().getIsHost()) {
			spieler1.place();
			spieler2.place();
		} else {
			spieler2.place();
			spieler1.place();
		}

		Visualisierbar visualisierungSpieler1 = new GUI_Version1();
		visualisierungSpieler1.zeigeSpielFeld(spieler1, spieler2);

		startBildschirm.setVisible(false);

		// Spielschleife (Host fängt an)
		if (spieler1.isHost()) {
			spieler1.shoot(spieler2);
			disableField(spielFeld_Spieler);
			visualisierungSpieler1.zeigeSpielFeld(spieler1, spieler2);
			spieler2.shoot(spieler1);
			visualisierungSpieler1.zeigeSpielFeld(spieler1, spieler2);
		} else {
			spieler2.shoot(spieler1);
			enableField(spielFeld_Spieler);
			visualisierungSpieler1.zeigeSpielFeld(spieler1, spieler2);
		}

		while (!regeln.isGameOver()) {
			spieler1.shoot(spieler2);
			disableField(spielFeld_Spieler);
			visualisierungSpieler1.zeigeSpielFeld(spieler1, spieler2);
			if (spieler2.isGameOver())
				break;
			spieler2.shoot(spieler1);
			enableField(spielFeld_Spieler);
			visualisierungSpieler1.zeigeSpielFeld(spieler1, spieler2);
			if (spieler1.isGameOver())
				break;
		}

		spieler1.printStatus();
		if (!Client.getClient().getIsLocal())
			Client.getClient().closeConnection();
	}

	public static void setInput(String input) {
		spielerInput = input;
	}

	public static String getInput() {
		return spielerInput;
	}

	public static void setSpielStatus(String status) {
		spielStatus = spielStatus + "\n" + status;
		textArea.setText(spielStatus);
		gui.revalidate();
		scrollBar.setValue(scrollBar.getMaximum());
	}

	public static void setIniStatus(String status) {
		iniLabel.setText(status);
		startBildschirm.revalidate();

	}

	public static String getSpielStatus() {
		return spielStatus;
	}

	public static void setGUI(JFrame frame) {
		gui = frame;
	}

	public static void setTextArea(JTextArea tArea) {
		textArea = tArea;
	}

	public static void setScrollBar(JScrollBar scrollBarVertical) {
		scrollBar = scrollBarVertical;
	}

	public static void setIniLabel(JLabel label) {
		iniLabel = label;
	}

	public static void setSpielFeld_Spieler(JPanel spielFeld_Spieler) {
		GameStarter.spielFeld_Spieler = spielFeld_Spieler;
	}

	public static void setSpielFeld_Gegner(JPanel spielFeld_Gegner) {
		GameStarter.spielFeld_Gegner = spielFeld_Gegner;
	}

	private static void disableField(JPanel panel) {
		Component[] com = panel.getComponents();
		for (int i = 0; i < com.length; i++) {
			com[i].setEnabled(false);
		}
	}

	private static void enableField(JPanel panel) {
		Component[] com = panel.getComponents();
		for (int i = 0; i < com.length; i++) {
			com[i].setEnabled(true);
		}
	}
}
