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

// TODO: Auto-generated Javadoc
/**
 * The Class GameController.
 */
public class GameController extends JFrame implements Ui{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant FRAME_WIDTH. */
	public static final int FRAME_WIDTH = 1280; 
	
	/** The Constant FRAME_HEIGHT. */
	public static final int FRAME_HEIGHT = 800;  
	
	/** The home panel. */
	private HomePanel homePanel;
	
	/** The game panel. */
	private GamePanel gamePanel;
	
	/** The instance. */
	private static GameController instance = new GameController();
	
	/**
	 * Gets the single instance of GameController.
	 *
	 * @return single instance of GameController
	 */
	public static GameController getInstance() {return instance;}
	
	/**
	 * Instantiates a new game controller.
	 */
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
	 * Inits the.
	 *
	 * @param client the client
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
	 *
	 * @param dealMsg the deal msg
	 */
	@Override
	public void infoDeal(DealMsg dealMsg) {
		gamePanel.infoDeal(dealMsg);
	}
	
	/**
	 * Info draw.
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
	 *
	 * @return the op index
	 */
	@Override
	public int getOpIndex() {
		return gamePanel.getOpIndex();
	}
	
	/**
	 * Gets the discard.
	 *
	 * @return the discard
	 */
	@Override
	public int getDiscard() {
		return gamePanel.getDiscard();
	}
	
	/**
	 * Info discard.
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
	 *
	 * @param winMsg the win msg
	 */
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

	/**
	 * Info draw notice.
	 *
	 * @param drawNoticeMsg the draw notice msg
	 */
	@Override
	public void infoDrawNotice(DrawNoticeMsg drawNoticeMsg) {
		gamePanel.infoDrawNotice(drawNoticeMsg);
	}
}
