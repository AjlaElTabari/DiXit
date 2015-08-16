package gui;

import gui.PlayerWindow.ImagePanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.Constants;

/**
 * Represents a window that will contain only one text box. Current player will
 * have to choose a card from his/her hand and to enter association for that
 * card in this text box. When association is sent to the server, server will
 * distribute the message to all other players.
 * 
 * @author ajla
 *
 */
public class Association extends JFrame {

	private static final long serialVersionUID = -9175086981558840577L;
	private JPanel pnlMain = new JPanel();
	private ImagePanel imgPnlBunny = new ImagePanel();
	private JTextField txtAssociation = new JTextField();
	private JButton btnSend = new JButton("Send");	// BufferedImage
	private BufferedImage imgBunny;
	
	public Association () {
		// Panels
		pnlMain.setLayout(new BorderLayout());
		pnlMain.add(imgPnlBunny, BorderLayout.WEST);
		pnlMain.add(txtAssociation, BorderLayout.CENTER);
		pnlMain.add(btnSend, BorderLayout.EAST);
		
		imgPnlBunny.setPreferredSize(new Dimension(50, 68));
		
		// Frame visual settings
		add(pnlMain);
		setTitle("Enter your association");
		setSize(500, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public class ImagePanel extends JPanel {
		private static final long serialVersionUID = 221227307122900452L;

		public ImagePanel() {
			try {
				imgBunny = ImageIO.read(new File(Constants.BUNNY_PATH));
			} catch (IOException ex) {
				JOptionPane error = new JOptionPane(
						"Could not find or open desired file.",
						JOptionPane.ERROR_MESSAGE);
				error.createDialog("Error").setVisible(true);
			}
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(imgBunny, 0, 0, null);
		}

	}

	public static void main(String[] args) {
		new Association();

	}

}
