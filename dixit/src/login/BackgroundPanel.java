package login;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.Constants;

import connectivity.Client;

class BackgroundPanel extends JPanel {

	private static final long serialVersionUID = -7107974006273581347L;
	Image imgBackground = new ImageIcon(Constants.LOGIN_BACKGROUND_IMAGE)
			.getImage();

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(imgBackground, 0, 0, getWidth(), getHeight(), this);
	}
}

class LoginPanel extends JPanel {
	private static final long serialVersionUID = -4550434916034393583L;
	private JLabel lblNickname = new JLabel("nickname: ");
	private JTextField txtNickname = new JTextField(20);
	private JButton btnEnterTheGame = new JButton("Enter the game");

	LoginPanel() {
		setOpaque(false);
		setLayout(new FlowLayout());

		btnEnterTheGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Client.connect(txtNickname.getText());
				LoginWindow.close();
			}
		});

		add(lblNickname);
		add(txtNickname);
		add(btnEnterTheGame);

	}

}
