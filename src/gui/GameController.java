package gui;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
		
		pack();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	// get initial hand from server, show homePanel
	public void init(ArrayList<Tile> hand) {
		ArrayList<User> users = userInit(hand);
		homePanel = new HomePanel();
		gamePanel = new GamePanel(users);
		
		add(homePanel);
		
		// violate law of demeter, may need to change later
		homePanel.getGameStartButton().addActionListener((e) -> {
			remove(homePanel);
			add(gamePanel);
			repaint();
			validate();
		});
		
		// for testing coordinate, will be deleted later
		gamePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getX() + "," + e.getY());
			}
		});
	}
	
	private ArrayList<User> userInit(ArrayList<Tile> hand){
		ArrayList<User> users = new ArrayList<>();
		users.add(new User(1, hand));
		users.add(new User(2, null));
		users.add(new User(3, null));
		users.add(new User(4, null));
		return users;
	}
}
