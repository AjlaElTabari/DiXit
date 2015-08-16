package main;

import obj.Deck;
import connectivity.Server;

public class ServerMain {
	private static Deck deck = new Deck();

	public static void main(String[] args) {
		deck.shuffle();
		System.out.println(deck);
		
		Server.startServer();
		Server.startLookingForClients();

	}

}
