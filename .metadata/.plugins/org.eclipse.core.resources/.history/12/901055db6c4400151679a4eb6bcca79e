package connectivity;

import gui.PlayerWindow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

import common.Constants;

/**
 * Represents a client in the client-server architecture of DiXit card game.
 * Connects to the server, and creates a new player. Receives from the server
 * first dealing of HAND_SIZE cards.
 * 
 * @author ajla.eltabari
 *
 */
public class Client {

	// Client attributes
	private static ArrayList<Integer> cardsIds = new ArrayList<>();

	/**
	 * Connects client to the server, opens new player window, and deals first
	 * HAND_SIZE cards to the player.
	 */
	public static void connect(String nickname) {
		try {
			// Declaring and initializing socket to be able to connect to the
			// server.
			Socket client = new Socket(Constants.SERVER_IP,
					Constants.SERVER_PORT);
			// Declaring and initializing Buffered reader to be able to read
			// data from the server.
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			String line = "";

			// Expecting first dealing of HAND_SIZE cards from the server.
			while (!(line = reader.readLine()).equals("END")) {
				cardsIds.add(Integer.parseInt(line));
			}
			
			// Declaring and initializing Buffered writer to be able to send 
			// data to the server.
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					client.getOutputStream()));
			
			writer.write(nickname);
			writer.newLine();
			writer.flush();

			System.out.println(cardsIds);
			new PlayerWindow(cardsIds, nickname);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
