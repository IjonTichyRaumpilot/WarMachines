package edu.WarMachineGame.ClientConnection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SpielerThread extends Thread {
	// the socket where to listen/talk
	Socket socket;
	ObjectInputStream Sinput;
	ObjectOutputStream Soutput;

	public SpielerThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		/* Creating both Data Stream */
		System.out.println("Thread versucht I/O-Stream zu erstelllen ...");
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
		System.out.println("Thread wartet auf Antwort.");
		// read a String (which is an object)
		try {
			String str = (String) Sinput.readObject();
			Soutput.writeObject("OUTPUT MESSAGE");
			Soutput.flush();
		} catch (IOException e) {
			System.out
					.println("Exception beim Erstellen des I/O-Streams: " + e);
			return;
		} catch (ClassNotFoundException o) {
		} finally {
			try {
				Soutput.close();
				Sinput.close();
			} catch (Exception e) {
			}
		}
	}
}
