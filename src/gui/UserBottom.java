package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import utils.Tile;

public class UserBottom extends User{

	public UserBottom(ArrayList<Tile> hand) {
		userId = User.USER_BOTTOM;
		tileOnBoard = 0;
		handDeck = new Deck(hand, new Point(GameController.FRAME_WIDTH*0.11, GameController.FRAME_HEIGHT*0.8), Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
		meldDeck = new Deck(new Point(), Tile.TILE_WIDTH_MELD, Tile.TILE_HEIGHT_MELD);
		boardDeck = new Deck(new Point(GameController.FRAME_WIDTH*0.37, GameController.FRAME_HEIGHT*0.55), Tile.TILE_WIDTH_BOARD, Tile.TILE_HEIGHT_BOARD);
	}
	
	@Override
	public void handInit(GamePanel gamePanel) {
		ArrayList<Tile> hand = handDeck.getTiles();
		Point point = handDeck.getPoint();
		int tileWidth = handDeck.getTileWidth();
		int tileHeight = handDeck.getTileHeight();
		
		TileLabel label;
		ArrayList<TileLabel> tileLabelList = handDeck.getTileLabels();
		for(Tile tile : hand) {
			label = ImageUtils.addTile(gamePanel, tile, tileWidth, tileHeight, point, userId);
			gamePanel.handTileEventInit(label, this);
			
			point.setX(point.x + 64); // set new coordinate for the next tile
			
			tileLabelList.add(label); // add tileLabel to the handDeck: tileLabelList
		}
		
		// init the coordinate of the new tile sent by server
		// Coordinate = (the x of the last hand mile + some distance, the y of the last hand mile)
		newTileShowPoint = new Point(point.x + Tile.TILE_WIDTH_USER / 2, point.y);
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
			coordinate.setY(coordinate.y + tileHeight);
		}
		
		// add tile to the board
		TileLabel label = ImageUtils.addTile(gamePanel, tile, tileWidth, tileHeight, coordinate, userId);
		
		// move the show tile coordinate to the right
		coordinate.setX(coordinate.x + 38);

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
