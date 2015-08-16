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
	private static ArrayList<Player> playerList;
	private static Deck deck;

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
				
				writer.write("END");
				writer.newLine();
				writer.flush();
				
				// Reading nickname from the login screen.
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(client.getInputStream()));

				nickname = reader.readLine();
				System.out.println(nickname);
				Player player = new Player(nickname, false, client);
				playerList.add(player);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
