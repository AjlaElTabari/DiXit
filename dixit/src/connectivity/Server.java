package connectivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import obj.Deck;
import obj.Move;
import obj.Player;

import common.Constants;

/**
 * Represents a server that manage DiXit multiplayer game. Server is waiting for
 * minimum four players to connect, and will be responsible for cards dealing,
 * points scoring and transferring message between players.
 * 
 * @author ajla.eltabari
 *
 */
public class Server {
	// Server attributes
	private static ServerSocket server;
	public static ArrayList<Player> playerList;
	public static ArrayList<Move> moves;
	private static Deck deck;

	/**
	 * Initializing socket for client - server communication, deck for play and
	 * initializing array list of players. Starting server. Should be called
	 * from the main method.
	 * 
	 * @param deckFromMain
	 */
	public static void startServer(Deck deckFromMain) {
		try {
			server = new ServerSocket(Constants.SERVER_PORT);
			deck = deckFromMain;
		} catch (IOException e) {
			e.printStackTrace();
		}

		playerList = new ArrayList<>();
		System.out.println("Server started.");
	}

	/**
	 * Waiting for client to connect and starts a new thread for every player.
	 */
	public static void startLookingForClients() {
		try {
			while (true) {
				Socket client = server.accept();
				System.out.println("Client found!");

				ClientThread ct = new ClientThread(client);
				ct.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inner class that represents separate thread that will be given to every
	 * single player. When thread is initialized (when client/player is
	 * connected), server will send first HAND_SIZE cards, and receive players
	 * nickname from the login screen.
	 * 
	 * @author ajla
	 *
	 */
	static class ClientThread extends Thread {
		private Socket client;

		public ClientThread(Socket client) {
			this.client = client;
		}

		@Override
		public void run() {

			String nickname = "";

			try {

				// Dealing first HAND_SIZE cards to the player.
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(client.getOutputStream()));

				for (int i = Constants.FIRST_INDEX; i <= Constants.HAND_SIZE; i++) {
					int cardId = deck.dealACard();
					writer.write(cardId + "");
					writer.newLine();
					writer.flush();
				}

				// Connection shouldn't be closed, because there is need for
				// further communication. So after first HAND_SIZE cards, server
				// will send keyword "END" as sign that it is the end of
				// connections for now.
				writer.write("END");
				writer.newLine();
				writer.flush();

				// Reading nickname from the login screen.
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(client.getInputStream()));

				nickname = reader.readLine();
				System.out.println(nickname);
				
				// Checking if this is the first client/player
				Player player = null;
				if (playerList.size() > 0) {
					player = new Player(nickname, false, client);		
				} else {
					player = new Player(nickname, true, client);
				}
				playerList.add(player);
				
				

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
