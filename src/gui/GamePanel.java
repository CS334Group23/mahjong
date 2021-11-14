package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import ui.ClientInterface;
import utils.BidMsg;
import utils.BidType;
import utils.DealMsg;
import utils.DiscardMsg;
import utils.DrawMsg;
import utils.Meld;
import utils.Tile;

public class GamePanel extends JPanel{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Image bgImage;
	private ArrayList<User> users;
	
	private int opIndex;
	private Point operationButtonStartPoint;
	private ArrayList<JButton> operationButtonList;
	
	private ClientInterface client;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImage, 0, 0, GameController.FRAME_WIDTH, GameController.FRAME_HEIGHT, this);
	}
	
	public GamePanel(ClientInterface client){
		try {
			users = new ArrayList<>();
			opIndex = -1;
			operationButtonStartPoint = new Point(GameController.FRAME_WIDTH*0.815, GameController.FRAME_HEIGHT*0.6875);
			operationButtonList = new ArrayList<>();
			this.client = client;
			
			bgImage = ImageIO.read(new File("resource/static/others/table_new.jpg"));
			setLayout(null);
			
		} catch (IOException e) {
			System.out.println("Cannot set GamePanel's background");
		}
	}

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
		
		handInit();
	}
	
	private void handInit() {
		for(User user : users) {
			user.handInit(this);
		}
	}
	
	public void infoDraw(DrawMsg msg, ArrayList<BidMsg> possibleBid) {
		Tile tile = null;
		if(msg != null) {
			tile = new Tile(msg.getTileId());
		}
		
		if(possibleBid != null && tile != null) {
			int userId = possibleBid.get(0).getBidClient();
			User user = users.get(userId);
			
			// display tile to the gamePanel
			TileLabel tileLabel = addTileToPanel(user, tile); 
			
			// add tile and tile label to the user's hand deck list
			user.getHandDeck().getTiles().add(tile);
			user.getHandDeck().getTileLabels().add(tileLabel);
			
			
			for(BidMsg bidMsg : possibleBid) {
				// add event to the tile label, if the tile is for real user
				// also display relative button(s), e.g. kong, skip
				if(userId == User.USER_BOTTOM) {
					handTileEventInit(tileLabel, user);
					
					// button init
					operationButtonInit(bidMsg);
				}
			}
		}
	}

	public int getOpIndex() {
		return opIndex;
	}

	public int getDiscard() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void infoDiscard(DiscardMsg msg, ArrayList<BidMsg> possibleBid) {
		Tile tile = null;
		User sender = null;
		if(msg != null) {
			tile = new Tile(msg.getTileId());
			sender = users.get(msg.getSenderId());
		}
		
		// possibleBid == null means no other option could do
		// only show the tile to the user's board deck
		if(possibleBid == null) {
			sender.discardTile(this, tile);
		}
		else { // not null, means need to deal with all possibleBid option
			for(BidMsg bidMsg : possibleBid) {
				if(bidMsg.getBidClient() == User.USER_BOTTOM) {
					// button init
					operationButtonInit(bidMsg);
				}
			}
		}
		
	}
	
	public void infoBid(BidMsg bidMsg) {
		// clear the new tile label
		
		// move the input meld to the user's right
		User user = users.get(bidMsg.getBidClient());
		Meld meld = bidMsg.getMeld();
		
		if(user != null && meld != null) {
			user.putMeldToRight(this, meld);
			repaint();
		}
	}
	
	public void infoWin(BidMsg bidMsg) {
		
	}
	
	private TileLabel addTileToPanel(User user, Tile tile) {
		int tileWidth = user.getHandDeck().getTileWidth();
		int tileHeight = user.getHandDeck().getTileHeight();
		Point point = user.getNewTileShowPoint();
		int userId = user.getUserId();
		
		// change tile to face down img, if it is AI
		if(user.getUserId() != User.USER_BOTTOM)
			ImageUtils.changeTileImgToFaceDown(tile);
		
		// remove the previous new tile from panel
		user.removeNewTile(this);
		
		// then display new tile in gamePanel, also record it
		TileLabel tileLabel = ImageUtils.addTile(this, tile, tileWidth, tileHeight, point, userId);
		
		// bind new tile to user
		user.setNewTileFromServer(tileLabel);
		
		return tileLabel;
	}
	
	private void operationButtonInit(BidMsg msg) {
		// add button
		if(msg.getOperationName() != null) {
			String operationName = msg.getChnName();
			JButton btn = new JButton(operationName);
			btn.setBounds((int)operationButtonStartPoint.x, (int)operationButtonStartPoint.y
					, GameController.FRAME_WIDTH/16, GameController.FRAME_HEIGHT/16);
			
			// set button event
			operationButtonEventInit(btn, operationName, msg);
			operationButtonList.add(btn);
			this.add(btn);
		}
		
		// move the button start point to the left
		operationButtonStartPoint.setX(operationButtonStartPoint.x - GameController.FRAME_WIDTH/16 - GameController.FRAME_WIDTH/50);
		operationButtonStartPoint.setY(operationButtonStartPoint.y);
	}
	
	private void operationButtonEventInit(JButton btn, String btnName, BidMsg msg) {
		if(btnName.equals("过")) {
			btn.addActionListener((e) -> {
				for(JButton jbtn : operationButtonList)
					this.remove(jbtn);
				
				// update opIndex and repaint
				opIndex = BidType.EMPTY.getBidType();
				repaint();
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
				if(Tile.isSameType(tile1, tileFromHand)) {
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
			    	opIndex = BidType.KONG.getBidType();
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
			    	opIndex = BidType.PONG.getBidType();
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
			    	opIndex = BidType.CHOW.getBidType();
			    }
			});
		} else if(btnName.equals("胡")) {
			btn.addActionListener((e) -> {
				opIndex = BidType.WIN.getBidType();
			});
		}
	}
	
	public void handTileEventInit(TileLabel tile, User user) {
		tile.addMouseListener(new MouseAdapter() {
			Deck handDeck = user.getHandDeck();
			ArrayList<TileLabel> tileLabelList = handDeck.getTileLabels();
			
			public void mouseClicked(MouseEvent e) {			
				int originalX = tile.getX();
				int originalY = tile.getY();
				
				// if it is first click
				if(tile.isFirstClick()) {// use e.x and e.y to check
					// reset all tile to original position except clicked tile
					resetTilePosition();
					
					tile.setBounds(originalX, originalY - 40, Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
					tile.setIsFirstClick(false);
					
					// TODO: add "discard" button if clicked
					
					
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
	
	// for testing
	public void printUserDecks() {
		User user = users.get(2);
		Deck handDeck = user.getHandDeck();
		Deck meldDeck = user.getMeldDeck();
		Deck boardDeck = user.getBoardDeck();
		ArrayList<Tile> hand = handDeck.getTiles();
		ArrayList<TileLabel> handLabel = handDeck.getTileLabels();
		ArrayList<Tile> meld = meldDeck.getTiles();
		ArrayList<TileLabel> meldLabel = meldDeck.getTileLabels();
		ArrayList<Tile> borad = boardDeck.getTiles();
		ArrayList<TileLabel> boradLabel = boardDeck.getTileLabels();
		
		System.out.println("--------------------------------------------------------------");
		
		System.out.print("User hand: ");
		for(Tile tile : hand) {
			System.out.print(tile.getChnName() + "(" + tile.getId() + ") ");
		}
		System.out.println();
		
		System.out.print("User handLabel: ");
		for(TileLabel tile : handLabel) {
			System.out.print(tile.getTile().getChnName() + "(" + tile.getTile().getId() + ") ");
		}
		System.out.println();
		
		System.out.print("User meld: ");
		for(Tile tile : meld) {
			System.out.print(tile.getChnName() + "(" + tile.getId() + ") ");
		}
		System.out.println();
		
		System.out.print("User meldLabel: ");
		for(TileLabel tile : meldLabel) {
			System.out.print(tile.getTile().getChnName() + "(" + tile.getTile().getId() + ") ");
		}
		System.out.println();
		
//		System.out.print("User borad: ");
//		for(Tile tile : borad) {
//			System.out.print(tile.getChnName() + "(" + tile.getId() + ") ");
//		}
//		System.out.println();
//		
//		System.out.print("User boradLabel: ");
//		for(TileLabel tile : boradLabel) {
//			System.out.print(tile.getTile().getChnName() + "(" + tile.getTile().getId() + ") ");
//		}
//		System.out.println();
		System.out.println(opIndex);
	}
	
	public void removeTileLabelFromPanel(TileLabel tileLabel) {
		if(tileLabel != null)
			this.remove(tileLabel);
	}

}
