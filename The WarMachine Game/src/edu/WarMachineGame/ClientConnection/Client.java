package edu.WarMachineGame.ClientConnection;

import java.net.*;
import java.io.*;

import edu.WarMachineGame.IO.Ausgabe;
import edu.WarMachineGame.IO.Eingabe;

/**
 * 
 * @author Constantin
 * 
 */
public class Client {

	private static Client client;
	private boolean isHost = false;
	private boolean isLocal = false;
	private ObjectInputStream Sinput; // Socket lesen
	private ObjectOutputStream Soutput; // Socket schreiben

	/**
	 * @return gibt den einzigen Spielclienten zurück.
	 * @author Constantin
	 */
	public static Client getClient() {
		if (client == null) {
			client = new Client(1400);
			return client;
		}
		return client;
	}

	private void setIsLocal(boolean isLocal) {
		this.isLocal = isLocal;
	}

	public boolean getIsLocal() {
		return this.isLocal;
	}

	/**
	 * Erstellt den Spielclienten mit dem entsprechenden Port
	 * 
	 * @param int port
	 * @author Constantin
	 */
	private Client(int port) {

		String input = null;
		int inputOption = 0;
		boolean validInput = false;

		System.out
				.println("Wählen sie zwischen Host(1), Verbindung(2) oder Computergegner(3).");

		while (!validInput) {
			try {
				input = Eingabe.getEingabe().getUserInput();
			} catch (Exception e) {
				// Nothing
			}

			try {
				inputOption = Integer.parseInt(input);
			} catch (Exception e) {
				Ausgabe.getAusgabe().printFalscheEingabe();
				continue;
			}

			switch (inputOption) {
			case 1:
				beTheHost(port);
				setIsHost(true);
				validInput = true;
				break;

			case 2:
				connectToHost(port);
				validInput = true;
				break;
			case 3:
				setIsLocal(true);
				setIsHost(true);
				validInput = true;
				break;

			default:
				Ausgabe.getAusgabe().printFalscheEingabe();
				break;
			}

		}

	}

	/**
	 * Setzt den Status isHost;
	 * 
	 * @param boolean isHost
	 * @author Constantin
	 */
	private void setIsHost(boolean isHost) {
		this.isHost = isHost;
	}

	/**
	 * Gibt zurück, ob der Spielclient der Host ist.
	 * 
	 * @return boolean
	 * @author Constantin
	 */
	public boolean getIsHost() {
		return this.isHost;
	}

	/**
	 * Verbinde zu einem Host-Server.
	 * 
	 * @param int port
	 * @author Constantin
	 */
	private void connectToHost(int port) {

		Socket socket = new Socket();
		String ip = "noIP";
		boolean validIP = false;

		// Lesen der IP
		while (!validIP) {
			try {
				System.out.println("Geben sie die IP des Gegners an: ");
				ip = Eingabe.getEingabe().getUserInput();
			} catch (Exception e) {
				System.out.println("Fehler beim Lesen der Userdaten.");
				continue;
			}

			try {
				socket = new Socket(ip, port);
				validIP = true;
			} catch (Exception e) {
				System.out.println("Fehler bei der Serververbindung:" + e);
				validIP = false;
				continue;
			}
		}

		System.out.println("Verbindung akzeptiert " + socket.getInetAddress()
				+ ":" + socket.getPort() + "\n");

		// Erstellung der IO-Stroeme
		try {
			Sinput = new ObjectInputStream(socket.getInputStream());
			Soutput = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out
					.println("Exception beim Erstellen des I/O-Streams: " + e);
		}
	}

	/**
	 * Aktiviert den Spielclienten als Host.
	 * 
	 * @param int port
	 * @author Constantin
	 */
	private void beTheHost(int port) {

		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Host wartet auf anderen Spieler ...");

			while (true) {
				socket = serverSocket.accept(); // accept connection
				if (socket.isConnected())
					break;
			}

		} catch (IOException e) {
			System.out.println("Exception beim Erstellen des Socket: " + e);
		}

		System.out.println("Versuche I/O-Stream zu erstelllen ...");
		try {
			// create output
			Soutput = new ObjectOutputStream(socket.getOutputStream());
			Soutput.flush();
			Sinput = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out
					.println("Exception beim Erstellen des I/O-Streams: " + e);
			return;
		}
		System.out.println("Verbindung hergestellt.");
	}

	/**
	 * Schickt den String an den anderen Spielclienten.
	 * 
	 * @param String
	 * @author Constantin
	 */
	public void sendPlayerInput(String input) {

		try {
			Soutput.writeObject(input);
			Soutput.flush();
		} catch (IOException e) {
			System.out.println("Fehler beim Schreiben zum Socket: " + e);
		}
	}

	/**
	 * Holt eine Nachricht vom anderen Clienten ab. Falls der Gegner noch nicht
	 * getippt hat, muss der Spieler warten.
	 * 
	 * @author Constantin
	 * 
	 */
	public String getPlayerInput() {
		String response = "invalid";
		System.out.println("Warte auf Gegner ...");
		try {
			response = (String) Sinput.readObject();
		} catch (Exception e) {
			System.out.println("Problem bei der Spielerabfrage: " + e);
			closeConnection();
		}
		return response;
	}

	/**
	 * Schließe die Verbindung.
	 * 
	 * @author Constantin
	 */
	public void closeConnection() {

		try {
			Sinput.close();
			Soutput.close();
		} catch (Exception e) {
			System.out.println("Fehler beim Schliessen der Verbindung: " + e);
		}
	}

}
