package login;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoginWindow extends JFrame {
	private static final long serialVersionUID = 7795405112731430434L;
	private static LoginWindow window = new LoginWindow();

	public static void startTheGame() {
        JPanel pnlBackground = new BackgroundPanel();
        pnlBackground.setLayout(new BorderLayout());
        pnlBackground.add(new LoginPanel(), BorderLayout.CENTER);

        window.add(pnlBackground);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setSize(800, 800);
        window.setVisible(true);
    }
	
	public static void close() {
		window.dispose();
	}
}
