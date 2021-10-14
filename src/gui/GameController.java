package gui;

import java.awt.Container;
import javax.swing.*;

public class GameController extends JFrame{
	private static final long serialVersionUID = 1L;
	public static final int FRAME_WIDTH = 1024;
	public static final int FRAME_HEIGHT = 768;
	
	private HomePanel homePanel;
	private GamePanel gamePanel;
	
	private static GameController instance = new GameController();
	
	public static GameController getInstance() {return instance;}
	
	private GameController() {
		super("Mahjong");
		homePanel = new HomePanel();
		gamePanel = new GamePanel();
		
		init();
		
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void init() {
		add(homePanel);
		
		// violate law of demeter, may need to change later
		homePanel.getGameStartButton().addActionListener((e) -> {
			remove(homePanel);
			add(gamePanel);
			repaint();
			validate();
		});
	}
}
