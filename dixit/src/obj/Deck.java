package obj;

import java.util.ArrayList;
import java.util.Collections;

import common.Constants;

/**
 * Represents a deck for DiXit board game.
 * DiXit board game deck contains 84 pictured images.
 * 
 * @author ajla.eltabari
 *
 */
public class Deck {
	private static int card_id = 1;
	private ArrayList<Card> deck = new ArrayList<>();
	
	public Deck() {
		for (int i = Constants.DECK_STARTING_ID; i <= Constants.DECK_SIZE; i++) {
			Card card =  new Card(card_id);
			deck.add(card);
			card_id++;
		}
	}
	
	/**
	 * Shuffles deck. 
	 * @param deck
	 */
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	/**
	 * Deals a card from the deck
	 */
	public void dealACard() {
		deck.remove(deck.size() - 1);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Deck [deck=" + deck + "]";
	}
	

}