package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.Constants;

public class PlayerWindow extends JFrame {
	private static final long serialVersionUID = -3135347825165707732L;
	private static Map<Integer, BufferedImage> cards = new HashMap<>();

	// Panels
	private JPanel pnlMain = new JPanel();
	private JPanel pnlHeader = new JPanel();
	private JPanel pnlHand = new JPanel();
	private JPanel pnlScores = new JPanel();

	// Buttons
	private JButton btnDice = new JButton("Roll");
	private JButton btnDraw = new JButton("Draw");
	
	/**
	 * Constructor that makes Players window for DiXit game. 
	 */
	public PlayerWindow() {
		// Buttons settings
		btnDice.setPreferredSize(new Dimension(120, 60));
		btnDraw.setPreferredSize(new Dimension(120, 60));
		// Panels Layouts
		pnlMain.setLayout(new BorderLayout());
		pnlHeader.setLayout(new BorderLayout());
		pnlHand.setLayout(new FlowLayout());

		// Main panel
		pnlMain.add(pnlHeader, BorderLayout.NORTH);
		pnlMain.add(pnlHand, BorderLayout.SOUTH);
		pnlMain.add(pnlScores, BorderLayout.CENTER);
		pnlMain.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		// Header panel
		pnlHeader.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnlHeader.add(btnDice, BorderLayout.WEST);
		pnlHeader.add(btnDraw, BorderLayout.EAST);

		// Hand panel
		pnlHand.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		for (int i = 1; i <= Constants.HAND_SIZE; i++) {
			JButton btnCard = new JButton();
			BufferedImage buttonIcon;
			btnCard.setBorder(BorderFactory.createEmptyBorder());
			btnCard.setContentAreaFilled(false);
			// src/client/images/
			System.out.println("/src/client/images/" + i + ".jpg");
			
			buttonIcon = cards.get(i);
			btnCard = new JButton(new ImageIcon(buttonIcon));
			pnlHand.add(btnCard);
		}
		
		// Scores panel
		pnlScores.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		// Main panel visual settings
		add(pnlMain);
		setTitle("DiXit");
		setSize(1024, 960);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		// filling map with cards ids and images
		HelperMethods.loadCardImages(cards);
		new PlayerWindow();
	}
}