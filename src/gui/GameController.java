package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

import utils.BidMsg;
import utils.DrawMsg;
import utils.Tile;

public class GameController extends JFrame{
	private static final long serialVersionUID = 1L;
	public static final int FRAME_WIDTH = 1280; 
	public static final int FRAME_HEIGHT = 800;  
	
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
	
	// get 4 sets of hands from server, initialize
	public void init(ArrayList<ArrayList<Tile>> hands) {
		homePanel = new HomePanel();
		gamePanel = new GamePanel(hands);
		
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
	

	public void infoDraw(DrawMsg msg, ArrayList<BidMsg> possibleBid) {
		gamePanel.infoDraw(msg, possibleBid);
	}
}
