package ui.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import network.BidMsg;
import network.DealMsg;
import network.DiscardMsg;
import network.DrawMsg;
import network.DrawNoticeMsg;
import network.WinMsg;
import ui.ClientInterface;
import ui.Ui;
import utils.Tile;

public class GameController extends JFrame implements Ui{
	private static final long serialVersionUID = 1L;
	public static final int FRAME_WIDTH = 1280; 
	public static final int FRAME_HEIGHT = 800;  
	
	private HomePanel homePanel;
	private GamePanel gamePanel;
	
	private static GameController instance = new GameController();
	
	public static GameController getInstance() {return instance;}
	
	private GameController() {
		super("Mahjong Legend");
		
		pack();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	// get 4 sets of hands from server, initialize
	public void init(ClientInterface client) {
		homePanel = new HomePanel();
		gamePanel = new GamePanel(client);
		
		add(homePanel);
		
		// violate law of demeter, may need to change later
		homePanel.getGameStartButton().addActionListener((e) -> {
			remove(homePanel);
			add(gamePanel);
			repaint();
			validate();
			synchronized(this) { //solve not in the get the current bug
				this.notifyAll();
			}
		});
		
		// for testing coordinate, will be deleted later
		gamePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getX() + "," + e.getY());
			}
		});
		setVisible(true); //solve not seen bug
		synchronized(this) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void infoDeal(DealMsg dealMsg) {
		gamePanel.infoDeal(dealMsg);
	}
	
	@Override
	public void infoDraw(DrawMsg msg, ArrayList<BidMsg> possibleBid) {
		gamePanel.infoDraw(msg, possibleBid);
	}
	
	@Override
	public int getOpIndex() {
		return gamePanel.getOpIndex();
	}
	
	@Override
	public int getDiscard() {
		return gamePanel.getDiscard();
	}
	
	@Override
	public void infoDiscard(DiscardMsg discardMsg, ArrayList<BidMsg> possibleBid) {
		gamePanel.infoDiscard(discardMsg, possibleBid);
	}
	
	@Override
	public void infoBid(BidMsg bidMsg) {
		gamePanel.infoBid(bidMsg);
	}
	
	@Override
	public void infoWin(WinMsg winMsg) {
		gamePanel.infoWin(winMsg);
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		remove(gamePanel);
	}
	
	public void printUserDecks() {
		gamePanel.printUserDecks();
	}

	@Override
	public void infoDrawNotice(DrawNoticeMsg drawNoticeMsg) {
		gamePanel.infoDrawNotice(drawNoticeMsg);
	}
}