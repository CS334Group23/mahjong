/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: User.java </p> 
 * @author TeamCS3343 </a>
 */
package ui.gui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import utils.Meld;
import utils.Tile;
import network.WinMsg;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
public class User {
	
	/** The Constant USER_BOTTOM. */
	public static final int USER_BOTTOM = 0;
	
	/** The Constant USER_RIGHT. */
	public static final int USER_RIGHT = 1;
	
	/** The Constant USER_TOP. */
	public static final int USER_TOP = 2;
	
	/** The Constant USER_LEFT. */
	public static final int USER_LEFT = 3;
	
	/** The user id. */
	protected int userId;
	
	/** The hand deck. */
	protected Deck handDeck;
	
	/** The meld deck. */
	protected Deck meldDeck;
	
	/** The board deck. */
	protected Deck boardDeck;
	
	/** The new tile show point. */
	protected Point newTileShowPoint;
	
	/** The tile on board. */
	// count how many tiles are discarded by user, also is a line indicator to show which line should the discarded tile be placed
	protected int tileOnBoard;
	
	/** The new tile from server. */
	protected TileLabel newTileFromServer;
	
	/** The board tile is returned to last position. */
	protected boolean boardTileIsReturnedToLastPosition;
	
	/**
	 * Change tile img to face down.
	 *
	 * @param hand the hand
	 */
	protected void changeTileImgToFaceDown(ArrayList<Tile> hand) {
		for(Tile tile : hand) 
			ImageUtils.changeTileImgToFaceDown(tile);
	}

	/**
	 * Gets the hand deck.
	 *
	 * @return the hand deck
	 */
	public Deck getHandDeck() {
		return handDeck;
	}

	/**
	 * Gets the meld deck.
	 *
	 * @return the meld deck
	 */
	public Deck getMeldDeck() {
		return meldDeck;
	}

	/**
	 * Gets the board deck.
	 *
	 * @return the board deck
	 */
	public Deck getBoardDeck() {
		return boardDeck;
	}
	
	/**
	 * Gets the hand.
	 *
	 * @return the hand
	 */
	public ArrayList<Tile> getHand() {
		return handDeck.getTiles();
	}
	
	/**
	 * Gets the meld.
	 *
	 * @return the meld
	 */
	public ArrayList<Tile> getMeld() {
		return meldDeck.getTiles();
	}
	
	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	public ArrayList<Tile> getBoard() {
		return boardDeck.getTiles();
	}
	
	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * Gets the new tile show point.
	 *
	 * @return the new tile show point
	 */
	public Point getNewTileShowPoint() {
		return newTileShowPoint;
	}

	/**
	 * Hand init.
	 *
	 * @param gamePanel the game panel
	 */
	public void handInit(GamePanel gamePanel) {
		
	}
	
	/**
	 * Discard tile.
	 *
	 * @param gamePanel the game panel
	 * @param tile the tile
	 * @return the tile label
	 */
	public TileLabel discardTile(GamePanel gamePanel, Tile tile) {
		
		return null;
	}
	
	/**
	 * Put meld to right.
	 *
	 * @param gamePanel the game panel
	 * @param meld the meld
	 */
	public void putMeldToRight(GamePanel gamePanel, Meld meld) {
		
	}
	
	/**
	 * Gets the hand label.
	 *
	 * @return the hand label
	 */
	public ArrayList<TileLabel> getHandLabel() {
		return handDeck.getTileLabels();
	}
	
	/**
	 * Gets the meld label.
	 *
	 * @return the meld label
	 */
	public ArrayList<TileLabel> getMeldLabel() {
		return meldDeck.getTileLabels();
	}
	
	/**
	 * Gets the board label.
	 *
	 * @return the board label
	 */
	public ArrayList<TileLabel> getBoardLabel() {
		return boardDeck.getTileLabels();
	}
	
	/**
	 * Gets the hand tile width.
	 *
	 * @return the hand tile width
	 */
	public int getHandTileWidth() {
		return handDeck.getTileWidth();
	}
	
	/**
	 * Gets the hand tile height.
	 *
	 * @return the hand tile height
	 */
	public int getHandTileHeight() {
		return handDeck.getTileHeight();
	}
	
	/**
	 * Sets the new tile from server.
	 *
	 * @param tileLabel the new new tile from server
	 */
	public void setNewTileFromServer(TileLabel tileLabel) {
		this.newTileFromServer = tileLabel;
	}
	
	/**
	 * Removes the new tile.
	 *
	 * @param gamePanel the game panel
	 */
	public void removeNewTile(GamePanel gamePanel) {
		if(newTileFromServer != null)
			gamePanel.removeTileLabelFromPanel(newTileFromServer);
	}
	
	/**
	 * Adds the tile to meld deck.
	 *
	 * @param gamePanel the game panel
	 * @param meld the meld
	 * @return the array list
	 */
	protected ArrayList<Tile> addTileToMeldDeck(GamePanel gamePanel, Meld meld) {	
		try {
			// for rotation in ImageUtils.getTileLabelBySize()
			int tempUserIdForGetTileLabel = userId % 2 == 0 ? userId : -userId;
			
			ArrayList<Tile> meldTileList = this.getMeld();
			ArrayList<TileLabel> meldTileLabelList = this.getMeldLabel();
			
			Tile tile1 = meld.getFirst();
			Tile tile2 = meld.getSecond();
			Tile tile3 = meld.getThird();
			Tile tile4 = meld.getForth();
			
			int tileWidth = this.getHandTileWidth();
			int tileHeight = this.getHandTileHeight();
			
			TileLabel tileLabel1 = ImageUtils.getTileLabelBySize(tile1, tileWidth, tileHeight, tempUserIdForGetTileLabel);
			TileLabel tileLabel2 = ImageUtils.getTileLabelBySize(tile2, tileWidth, tileHeight, tempUserIdForGetTileLabel);
			TileLabel tileLabel3 = ImageUtils.getTileLabelBySize(tile3, tileWidth, tileHeight, tempUserIdForGetTileLabel);
			
			// put tile and tile label to meld deck (tile list and tileLabelList)
			meldTileList.add(tile1);
			meldTileList.add(tile2);
			meldTileList.add(tile3);
			
			meldTileLabelList.add(tileLabel1);
			meldTileLabelList.add(tileLabel2);
			meldTileLabelList.add(tileLabel3);
			
			// put the tile to a arrayList, as return value
			ArrayList<Tile> tileListFromMeld = new ArrayList<>();
			tileListFromMeld.add(tile1);
			tileListFromMeld.add(tile2);
			tileListFromMeld.add(tile3);
			
			if(tile4 != null) { // kong
				TileLabel tileLabel4 = ImageUtils.getTileLabelBySize(tile4, tileWidth, tileHeight, userId);
				meldTileList.add(tile4);
				meldTileLabelList.add(tileLabel4);
				tileListFromMeld.add(tile4);
			}
			
			return tileListFromMeld;		
		} catch (Exception e) {
			
		}
		return null;
	}
	
	/**
	 * Delete match tile from hand deck.
	 *
	 * @param gamePanel the game panel
	 * @param tileListFromMeld the tile list from meld
	 */
	protected void deleteMatchTileFromHandDeck(GamePanel gamePanel, ArrayList<Tile> tileListFromMeld) {
		ArrayList<Tile> handTileList = this.getHand();
		ArrayList<TileLabel> handTileLabelList = this.getHandLabel();
		
		// for user
		if(this.userId == USER_BOTTOM) {
			// if tile id sent from meld match tile id in handTileList, delete it from hand deck
			// for each tile in hand tile list, check if it is match with each tile in tileListFromMeld
			for(int i = 0; i < handTileList.size(); i++) {
				Tile tileFromHand = handTileList.get(i);
				TileLabel tileLabelFromHand = handTileLabelList.get(i);
				
				for(int j = 0; j < tileListFromMeld.size(); j++) {
					Tile tileFromMeld = tileListFromMeld.get(j);
					if(tileFromHand.compareTo(tileFromMeld) == 0) {
						// remove tile label from panel
						gamePanel.removeTileLabelFromPanel(tileLabelFromHand);
						
						// remove tile / tile label from user's hand deck
						handTileList.remove(tileFromHand);
						handTileLabelList.remove(tileLabelFromHand);
						
						// go back 1 index, since 1 tile is removed
						// otherwise it would skip 1 tile
						i--;
					}
				}
			}
		} else { // for AI
			int meldSize = tileListFromMeld.size();
			//to be refactoring later
			if(meldSize == 3) { // for chow, pong, simply delete 2 tiles from AI's hand deck
				handTileList.remove(tileListFromMeld.size()-1);
				handTileList.remove(tileListFromMeld.size()-1);
				handTileLabelList.remove(handTileLabelList.size()-1);
				handTileLabelList.remove(handTileLabelList.size()-1);
			} else { // kong, remove 3 tiles
				handTileList.remove(tileListFromMeld.size()-1);
				handTileList.remove(tileListFromMeld.size()-1);
				handTileList.remove(tileListFromMeld.size()-1);
				handTileLabelList.remove(handTileLabelList.size()-1);
				handTileLabelList.remove(handTileLabelList.size()-1);
				handTileLabelList.remove(handTileLabelList.size()-1);
			}
		}
	}
	
	/**
	 * Removes the all displayed tile label from panel.
	 *
	 * @param gamePanel the game panel
	 */
	protected void removeAllDisplayedTileLabelFromPanel(GamePanel gamePanel) {
		// remove newTileFrom server
		gamePanel.removeTileLabelFromPanel(newTileFromServer);
		
		// remove handTileLabelList
		ArrayList<TileLabel> handTileLabelList = getHandLabel();
		for(TileLabel tileLabel : handTileLabelList)
			gamePanel.removeTileLabelFromPanel(tileLabel);
		
		// remove meldTileLabelList
		ArrayList<TileLabel> meldTileLabelList = getMeldLabel();
		for(TileLabel tileLabel : meldTileLabelList)
			gamePanel.removeTileLabelFromPanel(tileLabel);
 	}
	
	/**
	 * Return board label to last position.
	 */
	public void returnBoardLabelToLastPosition() {
		System.out.println("User " +userId + " tileOnBoard before:" + tileOnBoard);
		tileOnBoard--;
		boardTileIsReturnedToLastPosition = true;
		System.out.println("User " +userId + " tileOnBoard after:" + tileOnBoard);
		getBoardDeck().getPoint().returnToLastPosition();
	}
	
	/**
	 * Show bid info.
	 *
	 * @param gamePanel the game panel
	 * @param bidResponser the bid responser
	 */
	public void showBidInfo(GamePanel gamePanel,String bidResponser) {
		JLabel instruction = ImageUtils.getImageLabel(gamePanel, bidResponser, (int)(GameController.FRAME_WIDTH*0.5-40), (int)(GameController.FRAME_HEIGHT*0.8-40), 80, 80);
		gamePanel.add(instruction);
		gamePanel.repaint();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gamePanel.remove(instruction);
		gamePanel.repaint();
	}
	
	/**
	 * Show all tile label.
	 *
	 * @param gamePanel the game panel
	 * @param tileIdList the tile id list
	 * @param winUserId the win user id
	 * @param winType the win type
	 * @param lastDiscardTileLabel the last discard tile label
	 */
	public void showAllTileLabel(GamePanel gamePanel, ArrayList<Integer> tileIdList, int winUserId, int winType, TileLabel lastDiscardTileLabel) {
		ArrayList<TileLabel> handTileLabelList = getHandLabel();
		for(TileLabel tileLabel : handTileLabelList)
			gamePanel.removeTileLabelFromPanel(tileLabel);
		
		// clear tile list and tile label list of the user
		ArrayList<Tile> handTileList = getHand();
		handTileList.clear();
		handTileLabelList.clear();
		
		// reset display coordinate of hand label
		if(userId == User.USER_LEFT)
			getHandDeck().getPoint().resetCoordinate(0, -44);
		else if(userId == User.USER_RIGHT)
			getHandDeck().getPoint().resetCoordinate(0, 44); 
		else 
			getHandDeck().getPoint().resetCoordinate();
		
		// add tiles to users' tile arrayList 
		for(Integer tileId : tileIdList) {
			handTileList.add(new Tile(tileId));
		}
		
		// if it is win user
		// add the lastDiscardTile to users' hand list if win by getting other players' tile
		if(userId == winUserId && winType == WinMsg.WINBYDISCARD) {
			Tile lastDiscardTile = lastDiscardTileLabel.getTile();
			handTileList.add(lastDiscardTile);
		}
		// hand init for users, display tile label to panel
		this.handInit(gamePanel);
	}
	
	/**
	 * Show score.
	 *
	 * @param gamePanel the game panel
	 * @param score the score
	 */
	public void showScore(GamePanel gamePanel, int score) {
		JLabel scoreLabel = new JLabel();
		String text = String.format("<html>Client %d<br><font color='red'>%d</font></html>", userId,score);
		scoreLabel.setOpaque(true);
		Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
		scoreLabel.setBorder(blackLine);
		scoreLabel.setText(text);
		scoreLabel.setBounds(0,0,500,500);
		scoreLabel.setBackground(Color.GRAY);
		gamePanel.add(scoreLabel);
	}
}
