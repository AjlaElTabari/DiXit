package obj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

import common.Constants;

/**
 * Represents the player of the game. Stores data related to the player.
 * 
 * @author ajla.eltabari
 *
 */
public class Player {

	// Player attributes
	private String nickname;
	private boolean isCurrentPlayer;
	private int score;
	private Socket socket;
	private BufferedWriter writer;

	/**
	 * Constructor that makes player. Requires nickname and isStartingPlayer
	 * flag, and socket for connection to the server.
	 * 
	 * @param nickname
	 */
	public Player(String nickname, boolean isCurrentPlayer, Socket socket) {
		this.nickname = nickname;
		this.isCurrentPlayer = isCurrentPlayer;
		this.score = Constants.STARTING_POINTS;
		this.socket = socket;

		// Buffered writer initialization, so player can be able to send message
		// to the server. Server will distribute that message to all other
		// players.
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			writer = null;
		}
	}
	
	public void sendMessage(String msg) {
		try {
			writer.write(msg);
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Getters and setters
	public boolean isCurrentPlayer() {
		return isCurrentPlayer;
	}

	public void setCurrentPlayer(boolean isCurrentPlayer) {
		this.isCurrentPlayer = isCurrentPlayer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getNickname() {
		return nickname;
	}	
	
}
