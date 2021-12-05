/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: GameController.java </p> 
 * @author TeamCS3343 </a>
 */
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
	
	/**
	 * Init method. Called by server
	 * initialization: set home page as the default panel
	 *
	 * @param client 
	 */
	// get 4 sets of hands from server, initialize
	public void init(ClientInterface client) {
		homePanel = new HomePanel();
		gamePanel = new GamePanel(client);
		
		add(homePanel);
		
		homePanel.getGameStartButton().addActionListener((e) -> {
			remove(homePanel);
			add(gamePanel);
			repaint();
			validate();
			synchronized(this) {
				this.notifyAll();
			}
		});

		setVisible(true); 
		synchronized(this) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Info deal.
	 * Api for server to start the game, initialize the tiles for 4 users
	 *
	 * @param dealMsg: object with the tile id list for the real user
	 */
	@Override
	public void infoDeal(DealMsg dealMsg) {
		gamePanel.infoDeal(dealMsg);
	}
	
	/**
	 * Info draw.
	 * Api for server to send a tile to the user, only for real user
	 * 
	 * @param msg the msg
	 * @param possibleBid the possible bid
	 */
	@Override
	public void infoDraw(DrawMsg msg, ArrayList<BidMsg> possibleBid) {
		gamePanel.infoDraw(msg, possibleBid);
	}
	
	/**
	 * Gets the op index.
	 * Api for server to get the operation index. When Pong/Kong/Chow/Win/Skip button is clicked,
	 * the op index would change
	 *
	 * @return the operation index
	 */
	@Override
	public int getOpIndex() {
		return gamePanel.getOpIndex();
	}
	
	/**
	 * Gets the discard.
	 * Api for server
	 * @return the discarded tile index of the user's tile list
	 */
	@Override
	public int getDiscard() {
		return gamePanel.getDiscard();
	}
	
	/**
	 * Info discard.
	 * Api for server. This method is called when the user could really discard a tile to the board
	 * 
	 * @param discardMsg the discard msg
	 * @param possibleBid the possible bid
	 */
	@Override
	public void infoDiscard(DiscardMsg discardMsg, ArrayList<BidMsg> possibleBid) {
		gamePanel.infoDiscard(discardMsg, possibleBid);
	}
	
	/**
	 * Info bid.
	 *
	 * @param bidMsg the bid msg
	 */
	@Override
	public void infoBid(BidMsg bidMsg) {
		gamePanel.infoBid(bidMsg);
	}
	
	/**
	 * Info win.
	 * Api for server. This method is called when someone win the game
	 * @param winMsg the win msg
	 */
	@Override
	public void infoWin(WinMsg winMsg) {
		gamePanel.infoWin(winMsg);
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		remove(gamePanel);
	}

	/**
	 * Info draw notice.
	 * Api for server. This method is called when no one win
	 * 
	 * @param drawNoticeMsg the draw notice msg
	 */
	@Override
	public void infoDrawNotice(DrawNoticeMsg drawNoticeMsg) {
		gamePanel.infoDrawNotice(drawNoticeMsg);
	}
}
