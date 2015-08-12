package obj;

/**
 * Represents relation between players and cards.
 * 
 * @author ajla.eltabari
 *
 */
public class Move {
	// Move attributes
	private Card playedCard;
	private Player player;

	/**
	 * Constructor that makes move object. Stores data about player and card
	 * that has been played.
	 * 
	 * @param playedCard
	 * @param player
	 */
	public Move(Card playedCard, Player player) {
		this.playedCard = playedCard;
		this.player = player;
	}

	/**
	 * @return the playedCard
	 */
	public Card getPlayedCard() {
		return playedCard;
	}

	/**
	 * @param playedCard the playedCard to set
	 */
	public void setPlayedCard(Card playedCard) {
		this.playedCard = playedCard;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

}