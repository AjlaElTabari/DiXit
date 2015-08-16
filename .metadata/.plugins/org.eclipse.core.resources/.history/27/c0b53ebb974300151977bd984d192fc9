package client;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import obj.Card;

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
	private static ArrayList<Card> hand = new ArrayList<>();

	public static void main(String[] args) {

		try {
			// Declaring and initializing socket to be able to connect to the server.
			Socket client = new Socket(Constants.SERVER_IP, Constants.SERVER_PORT);
			
			// Declaring and initializing Buffered reader to be able to read data from the server.
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String line = "";
			
			// Expecting first dealing of HAND_SIZE cards from the server.
			while (reader.ready()) {
				line = reader.readLine();
				cardsIds.add(Integer.parseInt(line));
			}
			
			for (int i = Constants.FIRST_INDEX; i <= Constants.HAND_SIZE; i++) {
				JButton btnCard = new JButton();
				BufferedImage buttonIcon;
				btnCard.setBorder(BorderFactory.createEmptyBorder());
				btnCard.setContentAreaFilled(false);
				
				
				buttonIcon = cards.get(i);
				btnCard = new JButton(new ImageIcon(buttonIcon));
				pnlHand.add(btnCard);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
