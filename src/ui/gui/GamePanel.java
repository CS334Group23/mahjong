/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: GamePanel.java </p> 
 * @author TeamCS3343 </a>
 */
package ui.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import network.BidMsg;
import network.DealMsg;
import network.DiscardMsg;
import network.DrawMsg;
import network.DrawNoticeMsg;
import network.WinMsg;
import server.Server;
import ui.ClientInterface;
import utils.Meld;
import utils.Tile;

/**
 * The Class GamePanel.
 */
public class GamePanel extends JPanel{	
	
	private static final long serialVersionUID = 1L;
	
	private Image bgImage;
	private ArrayList<User> users; // users list of current game
	private int opIndex;
	private int cardIndex; // store the discarded tile index of the user's tile list
	private Point operationButtonStartPoint; // the point to store the operation button Pong/Kong/Chow/Win/Skip
	private ArrayList<JButton> operationButtonList; // a list to store operation button
	private ClientInterface client;
	private TileLabel lastDiscardTileLabel; // to store the latest discarded tile label
	private int lastDiscardSenderId;
	private ArrayList<JLabel> indicators;
	private int lastNoticeId;
	
	/**
	 * draw the background
	 *
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImage, 0, 0, GameController.FRAME_WIDTH, GameController.FRAME_HEIGHT, this);
	}
	
	/**
	 * Constructor
	 *
	 * @param client the client
	 */
	public GamePanel(ClientInterface client){
		try {
			users = new ArrayList<>();
			opIndex = -1;
			operationButtonStartPoint = new Point(GameController.FRAME_WIDTH*0.815, GameController.FRAME_HEIGHT*0.6875);
			operationButtonList = new ArrayList<>();
			this.client = client;
			
			bgImage = ImageIO.read(new File("resource/static/others/table_new.jpg"));
			this.indicators = new ArrayList<>();
			for(int i=0;i<Server.CLIENT_NUM;i++) {
				String filename = String.format("resource/static/others/indicator%d.png",i+1);
				JLabel temp = ImageUtils.getImageLabel(this, filename, (int)(GameController.FRAME_WIDTH/2-40), (int)(GameController.FRAME_HEIGHT/2-80), 80, 80);
				indicators.add(temp);
			}
			setLayout(null);
			
		} catch (IOException e) {
			System.out.println("Cannot set GamePanel's background");
		}
	}

	/**
	 * Info deal.
	 * Api for game controller. This method is called in game start
	 *
	 * @param msg the msg
	 */
	public void infoDeal(DealMsg msg) {
		// list<tile> for the other three AIs
		ArrayList<ArrayList<Tile>> tileListForAI = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			ArrayList<Tile> tiles = new ArrayList<>();
			for(int j = 0; j < 13; j++) {
				tiles.add(new Tile(144)); // set fake tile list for AIs (tileId 144 = facedown)
			}
			tileListForAI.add(tiles);
		}
		
		User user_bottom = new UserBottom(client.getWall());
		User user_right = new UserRight(tileListForAI.get(0));
		User user_top = new UserTop(tileListForAI.get(1));
		User user_left = new UserLeft(tileListForAI.get(2));
		
		users.add(user_bottom); // index 0
		users.add(user_right); // index 1
		users.add(user_top); // index 2
		users.add(user_left); // index 3
		
		lastNoticeId = -1;
		handInit();
	}
	
	/**
	 * Hand init.
	 */
	private void handInit() {
		for(User user : users) {
			user.handInit(this);
		}
	}
	
	/**
	 * Info draw.
	 * Api for game controller. This method is called when the server give a tile to the real user
	 *
	 * @param msg the msg
	 * @param possibleBid the possible bid
	 * only for real user
	 */
	public void infoDraw(DrawMsg msg, ArrayList<BidMsg> possibleBid) {
		Tile tile = null;
		if(msg != null) {
			renewIndicator(0);
			tile = new Tile(msg.getTileId());
		}
		
		if(tile != null) {
			User user = users.get(0);
			// display tile to the gamePanel
			TileLabel tileLabel = addTileToPanel(user, tile); 
			
			// add tile and tile label to the user's hand deck list
			user.getHandDeck().getTiles().add(tile);
			user.getHandDeck().getTileLabels().add(tileLabel);
			handTileEventInit(tileLabel, user);
			if(possibleBid != null && possibleBid.size() != 0) {
				for(int i=0; i<possibleBid.size(); i++) {
					// button init
					operationButtonInit(possibleBid.get(i), i);
				}
			}
		}
		repaint();
	}

	/**
	 * Gets the op index.
	 * Api for game controller. This method is called when server need the last operation (e.g. Pong/Kong/Chow)
	 * @return the op index
	 */
	public int getOpIndex() {
		synchronized(this) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return opIndex;
	}

	/**
	 * Gets the discard.
	 *
	 * @return the discard
	 */
	public int getDiscard() {
		synchronized(this) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return cardIndex;
	}

	/**
	 * Info discard.
	 * Api for game controller. This method is called when user could discard a tile to the board
	 * @param msg the msg
	 * @param possibleBid the possible bid
	 */
	public void infoDiscard(DiscardMsg msg, ArrayList<BidMsg> possibleBid) {
		Tile tile = null;
		User sender = null;
		if(msg != null) {
			tile = new Tile(msg.getTileId());
			sender = users.get(msg.getSenderId());
		}

		lastDiscardTileLabel = sender.discardTile(this, tile);
		lastDiscardSenderId = sender.getUserId();

		for(int i=0; i<possibleBid.size(); i++) {
			if(possibleBid.get(i).getBidClient() == User.USER_BOTTOM) {
				// button init
				operationButtonInit(possibleBid.get(i), i);
			}
		}
		repaint();
	}
	
	/**
	 * Info bid.
	 * Api for game controller. This method is called when user form a sequence such as Pong/Kong/Chow
	 * @param bidMsg the bid msg
	 */
	public void infoBid(BidMsg bidMsg) {
		String currentInfo = bidMsg.getResponserName();

		// renew the indicator
		renewIndicator(bidMsg.getBidClient());
		
		// move the input meld to the user's right
		User user = users.get(bidMsg.getBidClient());
		user.showBidInfo(this, currentInfo);
		Meld meld = bidMsg.getMeld();
		if(user != null && meld != null) {
			this.remove(lastDiscardTileLabel);
			
			users.get(lastDiscardSenderId).returnBoardLabelToLastPosition();
			
			user.putMeldToRight(this, meld);
			repaint();
		}
	}
	
	/**
	 * Info win.
	 * Api for game controller. This method is called when some win the game
	 * @param winMsg the win msg
	 */
	public void infoWin(WinMsg winMsg) {
		ArrayList<ArrayList<Integer>> hands = winMsg.getHandsList();
		int winUserId = winMsg.getWinClientId();
		int winType = winMsg.getWinType();
		client.renewScore(winMsg.getScores());
		
		for(int i = 0; i < 4; i++) {
			User user = users.get(i);
			user.showAllTileLabel(this, hands.get(i), winUserId, winType, lastDiscardTileLabel);
			user.showScore(this, client.getScore(i));
		}
		
		repaint();
	}
	
	/**
	 * Adds the tile to panel.
	 *
	 * @param user the user
	 * @param tile the tile
	 * @return the tile label
	 */
	private TileLabel addTileToPanel(User user, Tile tile) {
		int tileWidth = user.getHandDeck().getTileWidth();
		int tileHeight = user.getHandDeck().getTileHeight();
		Point point = user.getNewTileShowPoint();
		int userId = user.getUserId();
		
		// change tile to face down img, if it is AI
		if(user.getUserId() != User.USER_BOTTOM) {
			ImageUtils.changeTileImgToFaceDown(tile);
			
			userId = -userId;
		}
		
		// remove the previous new tile from panel
		user.removeNewTile(this);
		// then display new tile in gamePanel, also record it
		TileLabel tileLabel = ImageUtils.addTile(this, tile, tileWidth, tileHeight, point, userId);
		
		// if user is AI, add new tile to his handDeck
		if(user.getUserId() != User.USER_BOTTOM) {
			user.getHand().add(tile);
			user.getHandLabel().add(tileLabel);
		}
		
		// bind new tile to user
		user.setNewTileFromServer(tileLabel);
		
		return tileLabel;
	}
	
	/**
	 * Operation button init.
	 * This method is called whenever the real user get a tile from server
	 * @param msg the msg
	 * @param opId the op id
	 */
	private void operationButtonInit(BidMsg msg, int opId) { //pass opId for later use
		// add button
		if(msg.getOperationName() != null) {
			String operationName = msg.getChnName();
			JButton btn = new JButton(operationName);
			btn.setBounds((int)operationButtonStartPoint.x, (int)operationButtonStartPoint.y
					, GameController.FRAME_WIDTH/16, GameController.FRAME_HEIGHT/16);
			
			// set button event
			operationButtonEventInit(btn, operationName, msg, opId);
			operationButtonList.add(btn);
			this.add(btn);
		}
		
		// move the button start point to the left
		operationButtonStartPoint.setX(operationButtonStartPoint.x - GameController.FRAME_WIDTH/16 - GameController.FRAME_WIDTH/50);
		operationButtonStartPoint.setY(operationButtonStartPoint.y);
	}
	
	/**
	 * Operation button event init.
	 * This method is called whenever the real user get a tile from server
	 * 
	 * @param btn the btn
	 * @param btnName the btn name
	 * @param msg the msg
	 * @param opId the op id
	 */
	private void operationButtonEventInit(JButton btn, String btnName, BidMsg msg, int opId) { //pass opId for later use, the tile may use the same methdo
		if(btnName.equals("过")) {
			btn.addActionListener((e) -> {
				for(JButton jbtn : operationButtonList)
					this.remove(jbtn);
				
				// update opIndex and repaint
				opIndex = opId;
				operationButtonStartPoint.resetCoordinate();
				repaint();
				
				synchronized(GamePanel.this) { //solve not in the get the current bug
					GamePanel.this.notifyAll();
				}
			});
		} else if(btnName.equals("杠")) {
			// when the mouse is hovering on JButton "kong"
			// move the corresponding meld to the top
			// to indicate which meld will be selected
			Meld meld = msg.getMeld();
			Tile tile1 = meld.getFirst(); 

			// get tileLabelList from user to compare
			UserBottom user = (UserBottom) users.get(User.USER_BOTTOM);
			ArrayList<TileLabel> tileLabelList = user.getHandDeck().getTileLabels();
			
			// an array to store all the matched tile
			// thus to reduce the searching time
			ArrayList<TileLabel> sameTileLabelList = new ArrayList<>();
			ArrayList<Tile> sameTileList = new ArrayList<>();
			for(TileLabel tileLabel : tileLabelList) {
				Tile tileFromHand = tileLabel.getTile();
				if(Tile.isSameTileFace(tile1, tileFromHand)) {
	    			sameTileLabelList.add(tileLabel);
	    			sameTileList.add(tileLabel.getTile());
	    		}
			}
			
			System.out.print("sameTileList: ");
			for(Tile tile : sameTileList) {
				System.out.print(tile.getId() + " ");
			}
			System.out.println();
			
			// bind to event
			btn.addMouseListener(new MouseAdapter(){
			    public void mouseEntered(MouseEvent e) {
			    	int originalX, originalY;
			    	for(TileLabel tileLabel : sameTileLabelList) {
			    		originalX = tileLabel.getX();
						originalY = tileLabel.getY();
			    		
						// move it up if they are the same type (e.g. bamboo1 = bamboo1)
			    		tileLabel.setBounds(originalX, originalY - 40, Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
			    	}
			    }

			    public void mouseExited(MouseEvent e) {
			    	int originalX, originalY;
			    	for(TileLabel tileLabel : sameTileLabelList) {
			    		originalX = tileLabel.getX();
						originalY = tileLabel.getY();
			    		
						// move it down when the cursor is left
			    		tileLabel.setBounds(originalX, originalY + 40, Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
			    	}
			    }
			    
			    public void mouseClicked(MouseEvent e) {
			    	for(JButton jbtn : operationButtonList)
						GamePanel.this.remove(jbtn);
			    	
			    	opIndex = opId;
			    	operationButtonStartPoint.resetCoordinate();
			    	
					synchronized(GamePanel.this) { //solve not in the get the current bug
						GamePanel.this.notifyAll();
					}
			    }
			});
		}
		else if(btnName.equals("碰")) {
			Meld meld = msg.getMeld();
			Tile tile1 = meld.getFirst();
			Tile tile2 = meld.getSecond();
			Tile tile3 = meld.getThird();
			
			UserBottom user = (UserBottom) users.get(User.USER_BOTTOM);
			ArrayList<TileLabel> tileLabelList = user.getHandDeck().getTileLabels();
			
			// an array to store all the matched tile
			// thus to reduce the searching time
			ArrayList<TileLabel> sameTileLabelList = new ArrayList<>();
			ArrayList<Tile> sameTileList = new ArrayList<>();
			for(TileLabel tileLabel : tileLabelList) {
				Tile tile = tileLabel.getTile();
				if(tile.compareTo(tile1) == 0 || tile.compareTo(tile2) == 0 || tile.compareTo(tile3) == 0) {
					sameTileLabelList.add(tileLabel);
					sameTileList.add(tile);
				}
				
			}
			
			btn.addMouseListener(new MouseAdapter() {
			    public void mouseEntered(MouseEvent e) {
			    	int originalX, originalY;
			    	for(TileLabel tileLabel : sameTileLabelList) {
			    		originalX = tileLabel.getX();
						originalY = tileLabel.getY();

			    		tileLabel.setBounds(originalX, originalY - 40, Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
			    	}
			    }
			    
			    public void mouseExited(MouseEvent e) {
			    	int originalX, originalY;
			    	for(TileLabel tileLabel : sameTileLabelList) {
			    		originalX = tileLabel.getX();
						originalY = tileLabel.getY();
			    		
						// move it down when the cursor is left
			    		tileLabel.setBounds(originalX, originalY + 40, Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
			    	}
			    }
			    
			    public void mouseClicked(MouseEvent e) {
			    	for(JButton jbtn : operationButtonList)
						GamePanel.this.remove(jbtn);
			    	
			    	opIndex = opId;
			    	operationButtonStartPoint.resetCoordinate();
			    	
					synchronized(GamePanel.this) { //solve not in the get the current bug
						GamePanel.this.notifyAll();
					}
			    }
			});
		} else if(btnName.equals("吃")) {
			Meld meld = msg.getMeld();
			Tile tile1 = meld.getFirst();
			Tile tile2 = meld.getSecond();
			Tile tile3 = meld.getThird();
			
			UserBottom user = (UserBottom) users.get(User.USER_BOTTOM);
			ArrayList<TileLabel> tileLabelList = user.getHandDeck().getTileLabels();
			
			// an array to store all the matched tile
			// thus to reduce the searching time
			ArrayList<TileLabel> sameTileLabelList = new ArrayList<>();
			ArrayList<Tile> sameTileList = new ArrayList<>();
			for(TileLabel tileLabel : tileLabelList) {
				Tile tile = tileLabel.getTile();
				if(tile.compareTo(tile1) == 0 || tile.compareTo(tile2) == 0 || tile.compareTo(tile3) == 0) {
					sameTileLabelList.add(tileLabel);
					sameTileList.add(tile);
				}
				
			}
			
			btn.addMouseListener(new MouseAdapter() {
			    public void mouseEntered(MouseEvent e) {
			    	int originalX, originalY;
			    	for(TileLabel tileLabel : sameTileLabelList) {
			    		originalX = tileLabel.getX();
						originalY = tileLabel.getY();

			    		tileLabel.setBounds(originalX, originalY - 40, Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
			    	}
			    }
			    
			    public void mouseExited(MouseEvent e) {
			    	int originalX, originalY;
			    	for(TileLabel tileLabel : sameTileLabelList) {
			    		originalX = tileLabel.getX();
						originalY = tileLabel.getY();
			    		
						// move it down when the cursor is left
			    		tileLabel.setBounds(originalX, originalY + 40, Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
			    	}
			    }
			    
			    public void mouseClicked(MouseEvent e) {
			    	for(JButton jbtn : operationButtonList)
						GamePanel.this.remove(jbtn);
			    	
			    	opIndex = opId;
					operationButtonStartPoint.resetCoordinate();
			    	
					synchronized(GamePanel.this) { //solve not in the get the current bug
						GamePanel.this.notifyAll();
					}
			    }
			});
		} else if(btnName.equals("胡")) {
			btn.addActionListener((e) -> {
				for(JButton jbtn : operationButtonList)
					this.remove(jbtn);
				
				opIndex = opId;
				operationButtonStartPoint.resetCoordinate();
				
				synchronized(GamePanel.this) { //solve not in the get the current bug
					GamePanel.this.notifyAll();
				}
			});
		}
	}
	
	/**
	 * Hand tile event init.
	 *
	 * @param tile the tile
	 * @param user the user
	 */
	public void handTileEventInit(TileLabel tile, User user) {
		tile.addMouseListener(new MouseAdapter() {
			Deck handDeck = user.getHandDeck();
			ArrayList<TileLabel> tileLabelList = handDeck.getTileLabels();
			
			public void mouseClicked(MouseEvent e) {			
				int originalX = tile.getX();
				int originalY = tile.getY();
				
				// if it is first click
				if(tile.isFirstClick()) {// use e.x and e.y to check
					//discard 
					if(e.getClickCount() == 2) {
						cardIndex = handDeck.getTileLabels().indexOf(tile)+1; //solve the discard wrong tile bug
						synchronized(GamePanel.this) { //solve not in the get the current bug
							GamePanel.this.notifyAll();
						}
						//here should remove all the listener to the card
						return;
					}
					
					// reset all tile to original position except clicked tile
					resetTilePosition();
					
					tile.setBounds(originalX, originalY - 40, Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
					tile.setIsFirstClick(false);					
					
				} else {
					tile.setBounds(originalX, originalY + 40, Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
					tile.setIsFirstClick(true);
				}
			}
			
			public void resetTilePosition() {
				for(TileLabel label : tileLabelList) {
					if(! label.isFirstClick()) {
						label.setBounds(label.getX(), label.getY() + 40, Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
						label.setIsFirstClick(true);
					}
				}
			}
		});
	}
	
	/**
	 * Removes the tile label from panel.
	 *
	 * @param tileLabel the tile label
	 */
	public void removeTileLabelFromPanel(TileLabel tileLabel) {
		if(tileLabel != null)
			this.remove(tileLabel);
	}

	/**
	 * Info draw notice.
	 *
	 * @param drawNoticeMsg the draw notice msg
	 */
	public void infoDrawNotice(DrawNoticeMsg drawNoticeMsg) {
		if(drawNoticeMsg.getClientId() != User.USER_BOTTOM) {
			renewIndicator(drawNoticeMsg.getClientId());
			User targetUser = users.get(drawNoticeMsg.getClientId());
			Tile tempTile = new Tile(144);
			this.addTileToPanel(targetUser, tempTile); //hard code to be changed later
			repaint();
		}
	}
	
	/**
	 * Renew indicator.
	 *
	 * @param clientId the client id
	 */
	public void renewIndicator(int clientId) {
		if(lastNoticeId != -1)
			this.remove(indicators.get(lastNoticeId));
		this.add(indicators.get(clientId));
		lastNoticeId = clientId;
	}

}
