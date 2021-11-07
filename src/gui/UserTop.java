package gui;

import java.util.ArrayList;

import utils.Tile;

public class UserTop extends User{

	public UserTop(ArrayList<Tile> hand) {
		userId = User.USER_TOP;
		changeTileImgToFaceDown(hand);
		handDeck = new Deck(hand, new Point(GameController.FRAME_WIDTH*0.25, GameController.FRAME_HEIGHT*0.03), Tile.TILE_WIDTH_AI, Tile.TILE_HEIGHT_AI);
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
			point.setX(point.x + 44); // set new coordinate for the next tile
		}
		
		newTileShowPoint = new Point(point.x - 14*44 - Tile.TILE_WIDTH_AI/ 2, point.y);
	}
	
}
