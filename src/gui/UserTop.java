package gui;

import java.util.ArrayList;

import utils.Tile;

public class UserTop extends User{

	public UserTop(ArrayList<Tile> hand) {
		userId = User.USER_TOP;
		tileOnBoard = 0;
		changeTileImgToFaceDown(hand);
		handDeck = new Deck(hand, new Point(GameController.FRAME_WIDTH*0.25, GameController.FRAME_HEIGHT*0.03), Tile.TILE_WIDTH_AI, Tile.TILE_HEIGHT_AI);
		meldDeck = new Deck(new Point(), Tile.TILE_WIDTH_MELD, Tile.TILE_HEIGHT_MELD);
		boardDeck = new Deck(new Point(GameController.FRAME_WIDTH*0.578, GameController.FRAME_HEIGHT*0.3), Tile.TILE_WIDTH_BOARD, Tile.TILE_HEIGHT_BOARD);
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
	
	@Override
	public void discardTile(GamePanel gamePanel, Tile tile) {
		// parameter to add tile to gamepanel
		int tileWidth = boardDeck.getTileWidth();
		int tileHeight = boardDeck.getTileHeight();
		Point coordinate = boardDeck.getPoint();
		
		// move the show tile coordinate to the START POINT of next line if applicable
		if(tileOnBoard != 0 && tileOnBoard % 8 == 0) {
			coordinate.setX(coordinate.getInitialX());
			coordinate.setY(coordinate.y - tileHeight);
		}
		
		// add tile to the board
		TileLabel label = ImageUtils.addTile(gamePanel, tile, tileWidth, tileHeight, coordinate, userId);
		
		// move the show tile coordinate to the right
		coordinate.setX(coordinate.x - 38);

		// add tile to boardDeck, update the counter (indicate how many tiles on the same line)
		ArrayList<TileLabel> boardTileLabelList = boardDeck.getTileLabels();
		ArrayList<Tile> boardTileList = boardDeck.getTiles();
		boardTileLabelList.add(label);
		boardTileList.add(tile);
		tileOnBoard++;
		
		// simply delete the last tile from the hand, because for AIs, their tile is fake
		ArrayList<TileLabel> handTileLabelList = handDeck.getTileLabels();
		ArrayList<Tile> HandTileList = handDeck.getTiles();
		if(!handTileLabelList.isEmpty()){
			handTileLabelList.remove(handTileLabelList.size() - 1);
			HandTileList.remove(HandTileList.size() - 1);
		}
		
	}
}
