package gui;

import java.io.IOException;
import java.util.ArrayList;

import utils.Meld;
import utils.Tile;

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
	
	public void discardTile(GamePanel gamePanel, Tile tile) {
		
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
			if(meldSize == 3) { // for chow, pong, simply delete 2 tiles from AI's hand deck
				for(int i = 0; i < 2; i++) {
					handTileList.remove(i);
					handTileLabelList.remove(i);
				}
			} else { // kong, remove 3 tiles
				for(int i = 0; i < 3; i++) {
					handTileList.remove(i);
					handTileLabelList.remove(i);
				}
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
}
