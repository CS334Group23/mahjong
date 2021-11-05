package gui;

import java.util.ArrayList;

import utils.Tile;

public class UserLeft extends User{

	public UserLeft(ArrayList<Tile> hand) {
		userId = User.USER_LEFT;
		changeTileImgToFaceDown(hand); 
		handDeck = new Deck(hand, new Point(GameController.FRAME_WIDTH*0.02, GameController.FRAME_HEIGHT*0.015), Tile.TILE_WIDTH_AI, Tile.TILE_HEIGHT_AI);
		meldDeck = new Deck(new Point(), Tile.TILE_WIDTH_MELD, Tile.TILE_HEIGHT_MELD);
		boardDeck = new Deck(new Point(), Tile.TILE_WIDTH_BOARD, Tile.TILE_HEIGHT_BOARD);
	}
	
	@Override
	public void handInit(GamePanel gamePanel) {
		ArrayList<Tile> hand = handDeck.getTiles();
		Point point = handDeck.getPoint();
		int tileWidth = handDeck.getTileWidth();
		int tileHeight = handDeck.getTileHeight();
		
		for(Tile tile : hand) {
			ImageUtils.addTile(gamePanel, tile, tileWidth, tileHeight, point, userId);
			point.setY(point.y + 56); // set new coordinate for the next tile
		}
	}
	
}
