package gui;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.*;

import utils.Tile;

public class GameController extends JFrame{
	private static final long serialVersionUID = 1L;
	public static final int FRAME_WIDTH = 1280;
	public static final int FRAME_HEIGHT = 1024;
	
	private HomePanel homePanel;
	private GamePanel gamePanel;
	
	private static GameController instance = new GameController();
	
	public static GameController getInstance() {return instance;}
	
	private GameController() {
		super("Mahjong");
		
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	// get initial hand from server, show homePanel
	public void init(ArrayList<Tile> hand) {
		homePanel = new HomePanel();
		gamePanel = new GamePanel(hand);
		
		add(homePanel);
		
		// violate law of demeter, may need to change later
		homePanel.getGameStartButton().addActionListener((e) -> {
			remove(homePanel);
			add(gamePanel);
			repaint();
			validate();
		});
	}

	public void addNewTile(Tile tile) {
		gamePanel.addNewTile(tile);
	}
}
