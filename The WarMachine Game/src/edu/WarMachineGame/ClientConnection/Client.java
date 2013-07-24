package edu.WarMachineGame.ClientConnection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import edu.WarMachineGame.IO.Ausgabe;
import edu.WarMachineGame.IO.Eingabe;
import edu.WarMachineGame.TestDrive.GameStarter;

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

		int inputOption = 0;
		boolean validInput = false;
		while (!validInput) {
			try {
				String[] options = new String[3];
				options[0] = "Host";
				options[1] = "Client";
				options[2] = "Computergegner";
				inputOption = Eingabe
						.getEingabe()
						.askOpstionsAsString(
								"Initialisierung",
								"Sind Sie Host oder Client oder wollen Sie nur gegen den Computer spielen?",
								options);
			} catch (Exception e) {
				// Nothing
			}

			switch (inputOption) {
			case 0:
				beTheHost(port);
				setIsHost(true);
				validInput = true;
				break;

			case 1:
				connectToHost(port);
				validInput = true;
				break;
			case 2:
				setIsLocal(true);
				setIsHost(true);
				validInput = true;
				break;

			default:
				Ausgabe.getAusgabe().showFalscheEingabe();
				;
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
				ip = Eingabe.getEingabe().getUserInputFromDialog("IP-Adresse",
						"Geben sie die IP des Gegners an");
			} catch (Exception e) {
				Ausgabe.getAusgabe().showWarning("Fehler",
						"Fehler beim Lesen der Userdaten.");
				continue;
			}

			try {
				GameStarter
						.setIniStatus("Es wird versucht eine Verbindung herzustellen...");
				socket = new Socket(ip, port);
				validIP = true;
			} catch (Exception e) {
				Ausgabe.getAusgabe().showWarning("Fehler",
						"Fehler bei der Serververbindung:" + e);
				validIP = false;
				continue;
			}
		}

		GameStarter.setIniStatus("Verbindung akzeptiert "
				+ socket.getInetAddress() + ":" + socket.getPort());

		// Erstellung der IO-Stroeme
		try {
			Sinput = new ObjectInputStream(socket.getInputStream());
			Soutput = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			Ausgabe.getAusgabe().showWarning("Fehler",
					"Exception beim Erstellen des I/O-Streams: " + e);
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
			GameStarter.setIniStatus("Warte auf andere Spieler...");
			while (true) {
				socket = serverSocket.accept(); // accept connection
				if (socket.isConnected())
					break;
			}

		} catch (IOException e) {
			Ausgabe.getAusgabe().showWarning("Fehler",
					"Exception beim Erstellen des Socket: " + e);
		}

		GameStarter.setIniStatus("Versuche I/O-Stream zu erstelllen ...");
		try {
			// create output
			Soutput = new ObjectOutputStream(socket.getOutputStream());
			Soutput.flush();
			Sinput = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			Ausgabe.getAusgabe().showWarning("Fehler",
					"Exception beim Erstellen des I/O-Streams: " + e);
			return;
		}
		GameStarter.setIniStatus("Erfolgreich Verbindung hergestellt.");
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
			Ausgabe.getAusgabe().showWarning("Fehler",
					"Fehler beim Schreiben zum Socket: " + e);
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
		try {
			response = (String) Sinput.readObject();
		} catch (Exception e) {
			Ausgabe.getAusgabe().showWarning("Fehler",
					"Problem bei der Spielerabfrage: " + e);
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
			Ausgabe.getAusgabe().showWarning("Fehler",
					"Fehler beim Schliessen der Verbindung: " + e);
		}
	}

}
