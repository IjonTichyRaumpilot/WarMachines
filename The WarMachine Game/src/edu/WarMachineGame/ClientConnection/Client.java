package edu.WarMachineGame.ClientConnection;

import java.net.*;
import java.io.*;

import edu.WarMachineGame.IO.Ausgabe;
import edu.WarMachineGame.IO.Eingabe;

public class Client {

	private ObjectInputStream Sinput; // to read the socket
	private ObjectOutputStream Soutput; // towrite on the socket

	public Client(int port) {

		String input = null;
		int inputOption = 0;
		boolean validInput = false;

		System.out.println("Wählen sie zwischen Host(1) oder Verbindung(2).");

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
				validInput = true;
				break;

			case 2:
				connectToHost(port);
				validInput = true;
				break;

			default:
				Ausgabe.getAusgabe().printFalscheEingabe();
				break;
			}

		}

	}

	/**
	 * Verbinde zu einem Host-Server.
	 * 
	 * @param port
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

	private void beTheHost(int port) {

		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server waiting for client on port "
					+ serverSocket.getLocalPort());

			while (true) {
				Socket socket = serverSocket.accept(); // accept connection
				System.out.println("New client asked for a connection");
				SpielerThread t = new SpielerThread(socket); // make a thread
				System.out.println("Starting a thread for a new Client");
				t.start();
			}
		} catch (IOException e) {
			System.out.println("Exception on new ServerSocket: " + e);
		}
	}

	public void sendPlayerInput(String input) {

		try {
			Soutput.writeObject(input);
			Soutput.flush();
		} catch (IOException e) {
			System.out.println("Fehler beim Schreiben zum Socket: " + e);
		}
	}

	public String getPlayerInput() {
		String response = "";
		try {
			response = (String) Sinput.readObject();
		} catch (Exception e) {
			System.out.println("Problem bei der Spielerabfrage: " + e);
		}
		return response;
	}

	public void closeConnection() {

		try {
			Sinput.close();
			Soutput.close();
		} catch (Exception e) {
			System.out.println("Fehler beim Schliessen der Verbindung: " + e);
		}
	}

}
