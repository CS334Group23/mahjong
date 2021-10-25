package gui;

import java.util.ArrayList;

import utils.Tile;

public class UserRight extends User{

	public UserRight(ArrayList<Tile> hand) {
		userId = User.USER_RIGHT;
		changeTileImgToFaceDown(hand); // AI's tile show facedown only
		handDeck = new Deck(hand, new Point(1100, 60), Tile.TILE_WIDTH_AI, Tile.TILE_HEIGHT_AI);
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
