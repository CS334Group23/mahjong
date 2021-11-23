package gui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import utils.Meld;
import utils.Tile;
import utils.WinMsg;

public class User {
	public static final int USER_BOTTOM = 0;
	public static final int USER_RIGHT = 1;
	public static final int USER_TOP = 2;
	public static final int USER_LEFT = 3;
	
	protected int userId;
	protected Deck handDeck;
	protected Deck meldDeck;
	protected Deck boardDeck;
	protected Point newTileShowPoint;
	// count how many tiles are discarded by user, also is a line indicator to show which line should the discarded tile be placed
	protected int tileOnBoard;
	protected TileLabel newTileFromServer;
	protected boolean boardTileIsReturnedToLastPosition;
	
	protected void changeTileImgToFaceDown(ArrayList<Tile> hand) {
		for(Tile tile : hand) 
			ImageUtils.changeTileImgToFaceDown(tile);
	}

	public Deck getHandDeck() {
		return handDeck;
	}

	public Deck getMeldDeck() {
		return meldDeck;
	}

	public Deck getBoardDeck() {
		return boardDeck;
	}
	
	public ArrayList<Tile> getHand() {
		return handDeck.getTiles();
	}
	
	public ArrayList<Tile> getMeld() {
		return meldDeck.getTiles();
	}
	
	public ArrayList<Tile> getBoard() {
		return boardDeck.getTiles();
	}
	
	public int getUserId() {
		return userId;
	}
	
	public Point getNewTileShowPoint() {
		return newTileShowPoint;
	}

	public void handInit(GamePanel gamePanel) {
		
	}
	
	public TileLabel discardTile(GamePanel gamePanel, Tile tile) {
		
		return null;
	}
	
	public void putMeldToRight(GamePanel gamePanel, Meld meld) {
		
	}
	
	public ArrayList<TileLabel> getHandLabel() {
		return handDeck.getTileLabels();
	}
	
	public ArrayList<TileLabel> getMeldLabel() {
		return meldDeck.getTileLabels();
	}
	
	public ArrayList<TileLabel> getBoardLabel() {
		return boardDeck.getTileLabels();
	}
	
	public int getHandTileWidth() {
		return handDeck.getTileWidth();
	}
	
	public int getHandTileHeight() {
		return handDeck.getTileHeight();
	}
	
	public void setNewTileFromServer(TileLabel tileLabel) {
		this.newTileFromServer = tileLabel;
	}
	
	public void removeNewTile(GamePanel gamePanel) {
		if(newTileFromServer != null)
			gamePanel.removeTileLabelFromPanel(newTileFromServer);
	}
	
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
	
	public void returnBoardLabelToLastPosition() {
		System.out.println("User " +userId + " tileOnBoard before:" + tileOnBoard);
		tileOnBoard--;
		boardTileIsReturnedToLastPosition = true;
		System.out.println("User " +userId + " tileOnBoard after:" + tileOnBoard);
		getBoardDeck().getPoint().returnToLastPosition();
	}
	
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
