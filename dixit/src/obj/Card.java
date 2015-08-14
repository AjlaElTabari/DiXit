package obj;

import java.awt.image.BufferedImage;

/**
 * Represents a card for DiXit board game
 * 
 * @author ajla.eltabari
 *
 */
public class Card {
	// Card attributes
	private int id;
	private BufferedImage image;
	private boolean used;

	/**
	 * Constructor that makes a card with id, and without any image.
	 * 
	 * @param id
	 */
	public Card(int id) {
		this.id = id;
		this.image = null;
		this.used = false;
	}
	
	/**
	 * Constructor that makes a card with id, and image.
	 * 
	 * @param id
	 */
	public Card(int id, BufferedImage image) {
		this.id = id;
		this.image = image;
	}
	
	
	// Getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Card [\nid = " + id + ", image=" + image + "used: " + "\n]";
	}
}