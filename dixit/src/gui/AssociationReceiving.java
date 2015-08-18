package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.Constants;

/**
 * Represents a window that will contain only one text box. This box will appear
 * on all clients, once server distributes association from the current player.
 * 
 * @author ajla
 *
 */
public class AssociationReceiving extends JFrame {

	private static final long serialVersionUID = -7884276712420578256L;
	private JPanel pnlMain = new JPanel();
	private ImagePanel imgPnlBunny = new ImagePanel();
	private JTextField txtAssociation = new JTextField();
	private JButton btnOK = new JButton("OK"); // BufferedImage
	private BufferedImage imgBunny;
	private BufferedWriter reader = null;

	public AssociationReceiving() {
		// Panels
		pnlMain.setLayout(new BorderLayout());
		pnlMain.add(imgPnlBunny, BorderLayout.WEST);
		pnlMain.add(txtAssociation, BorderLayout.CENTER);
		pnlMain.add(btnOK, BorderLayout.EAST);

		imgPnlBunny.setPreferredSize(new Dimension(50, 68));

		try {
			// Declaring and initializing socket to be able to connect to the
			// server.
			@SuppressWarnings("resource")
			Socket client = new Socket(Constants.SERVER_IP,
					Constants.SERVER_PORT);
			// Declaring and initializing Buffered reader to be able to read
			// data from the server.
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			String line = reader.readLine();

			System.out.println("Iz primajuceg rpozora" + line);
			txtAssociation.setText(line);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
			}

		});

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
}
