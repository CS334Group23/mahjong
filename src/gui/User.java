package gui;

import java.util.ArrayList;

import utils.Tile;

public class User {
	private int userId;
	private boolean isRealUser;
	
	private Deck handDeck;
	private Deck meldDeck;
	private Deck boardDeck;
	
	public User(int id, ArrayList<Tile> hand) {
		userId = id;
		isRealUser = false;
		
		switch (id) {
		case 0 : // real user
			isRealUser = true;
			handDeck = new Deck(hand, new Point(90, 800), Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
			meldDeck = new Deck(new Point(), Tile.TILE_WIDTH_MELD, Tile.TILE_HEIGHT_MELD);
			boardDeck = new Deck(new Point(), Tile.TILE_WIDTH_BOARD, Tile.TILE_HEIGHT_BOARD);
			break;
		case 1 : // AI 1
			changeTileImgToFaceDown(hand); // AI's tile show facedown only
			handDeck = new Deck(hand, new Point(1100, 60), Tile.TILE_WIDTH_AI, Tile.TILE_HEIGHT_AI);
			meldDeck = new Deck(new Point(), Tile.TILE_WIDTH_MELD, Tile.TILE_HEIGHT_MELD);
			boardDeck = new Deck(new Point(), Tile.TILE_WIDTH_BOARD, Tile.TILE_HEIGHT_BOARD);
			break;
		case 2 : // AI 2
			changeTileImgToFaceDown(hand);
			handDeck = new Deck(hand, new Point(250, 50), Tile.TILE_WIDTH_AI, Tile.TILE_HEIGHT_AI);
			meldDeck = new Deck(new Point(), Tile.TILE_WIDTH_MELD, Tile.TILE_HEIGHT_MELD);
			boardDeck = new Deck(new Point(), Tile.TILE_WIDTH_BOARD, Tile.TILE_HEIGHT_BOARD);
			break;
		case 3 : // AI 3
			changeTileImgToFaceDown(hand); 
			handDeck = new Deck(hand, new Point(20, 60), Tile.TILE_WIDTH_AI, Tile.TILE_HEIGHT_AI);
			meldDeck = new Deck(new Point(), Tile.TILE_WIDTH_MELD, Tile.TILE_HEIGHT_MELD);
			boardDeck = new Deck(new Point(), Tile.TILE_WIDTH_BOARD, Tile.TILE_HEIGHT_BOARD);
		}
	}
	
	private void changeTileImgToFaceDown(ArrayList<Tile> hand) {
		for(Tile tile : hand) 
			ImageUtils.changeTileImgToFaceDown(tile);
	}

	public boolean isRealUser() {
		return isRealUser;
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
}
