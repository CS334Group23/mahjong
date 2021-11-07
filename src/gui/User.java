package gui;

import java.util.ArrayList;

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
	
	public ArrayList<TileLabel> getHandLabel() {
		return handDeck.getTileLabels();
	}
	
	public ArrayList<TileLabel> getMeldLabel() {
		return meldDeck.getTileLabels();
	}
	
	public ArrayList<TileLabel> getBoardLabel() {
		return boardDeck.getTileLabels();
	}
}
