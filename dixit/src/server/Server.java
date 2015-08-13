package server;

import obj.Deck;

/**
 * Represents a server that manage DiXit multiplayer game. Server is waiting for
 * minimum four players to connect, and will be responsible for cards dealing,
 * points scoring and transferring message between players.
 * 
 * @author ajla.eltabari
 *
 */
public class Server {
	private static Deck deck = new Deck();

	public static void main(String[] args) {
		
		deck.shuffle();
		System.out.println(deck);
		
	}

}
