package gui;

import java.util.ArrayList;

import utils.Tile;

public class UserRight extends User{

	public UserRight(ArrayList<Tile> hand) {
		userId = User.USER_RIGHT;
		tileOnBoard = 0;
		changeTileImgToFaceDown(hand); // AI's tile show facedown only
		handDeck = new Deck(hand, new Point(GameController.FRAME_WIDTH*0.9, GameController.FRAME_HEIGHT*0.1), Tile.TILE_WIDTH_AI, Tile.TILE_HEIGHT_AI);
		meldDeck = new Deck(new Point(), Tile.TILE_WIDTH_MELD, Tile.TILE_HEIGHT_MELD);
		boardDeck = new Deck(new Point(GameController.FRAME_WIDTH*0.696, GameController.FRAME_HEIGHT*0.57), Tile.TILE_WIDTH_BOARD, Tile.TILE_HEIGHT_BOARD);
	}
	
	@Override
	public void handInit(GamePanel gamePanel) {
		ArrayList<Tile> hand = handDeck.getTiles();
		Point point = handDeck.getPoint();
		int tileWidth = handDeck.getTileWidth();
		int tileHeight = handDeck.getTileHeight();
		
		for(Tile tile : hand) {
			ImageUtils.addTile(gamePanel, tile, tileWidth, tileHeight, point, userId);
			point.setY(point.y + 44); // set new coordinate for the next tile
		}
		
		newTileShowPoint = new Point(point.x, point.y - 14*44 - Tile.TILE_HEIGHT_AI / 2);
	}
	
	@Override
	public void discardTile(GamePanel gamePanel, Tile tile) {
		// parameter to add tile to gamepanel
		int tileWidth = boardDeck.getTileWidth();
		int tileHeight = boardDeck.getTileHeight();
		Point coordinate = boardDeck.getPoint();
		
		// move the show tile coordinate to the START POINT of next line if applicable
		if(tileOnBoard != 0 && tileOnBoard % 8 == 0) {
			coordinate.setX(coordinate.x + tileHeight);
			coordinate.setY(coordinate.getInitialY());
		}
		
		// add tile to the board
		TileLabel label = ImageUtils.addTile(gamePanel, tile, tileWidth, tileHeight, coordinate, userId);
		
		// move the show tile coordinate to the right
		coordinate.setY(coordinate.y - 38);

		// add tile to boardDeck, update the counter (indicate how many tiles on the same line)
		ArrayList<TileLabel> boardTileLabelList = boardDeck.getTileLabels();
		ArrayList<Tile> boardTileList = boardDeck.getTiles();
		boardTileLabelList.add(label);
		boardTileList.add(tile);
		tileOnBoard++;
		
		// delete the tile from handDeck
		// compare by tile Id
		// premise: tile in both array should be arranged in the same position
		ArrayList<TileLabel> handTileLabelList = handDeck.getTileLabels();
		ArrayList<Tile> HandTileList = handDeck.getTiles();
		for(int i = 0; i < HandTileList.size(); i++)
			if(HandTileList.get(i).getId() == tile.getId()) {
				HandTileList.remove(i);
				handTileLabelList.remove(i);
				break;
			}
		
	}
	
}
