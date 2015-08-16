package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import common.Constants;

/**
 * Helper class that contains methods that will be called from main methods from
 * server or client.
 * 
 * @author ajla.eltabari
 *
 */
public class HelperMethods {

	/**
	 * Fills HashMap with cards ids and images. Images are physically stored at
	 * the client side. They should be loaded at the beginning at the moment
	 * when client enters the game.
	 * 
	 * @param Empty Map that will store cards data.
	 */
	protected static void loadCardImages(Map<Integer, BufferedImage> cards) {
		try {
			for (int i = 1; i <= Constants.DECK_SIZE; i++) {
				BufferedImage cardImage = ImageIO.read(new File(
						Constants.CARDS_IMAGES_PATH + i + ".jpg"));
				cards.put(i, cardImage);
			}
		} catch (IOException e) {
			System.out.println("Image couldn't be read.");
			e.printStackTrace();
		}
	}
}