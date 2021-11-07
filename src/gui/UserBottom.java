package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import utils.Tile;

public class UserBottom extends User{

	public UserBottom(ArrayList<Tile> hand) {
		userId = User.USER_BOTTOM;
		handDeck = new Deck(hand, new Point(GameController.FRAME_WIDTH*0.11, GameController.FRAME_HEIGHT*0.8), Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
		meldDeck = new Deck(new Point(), Tile.TILE_WIDTH_MELD, Tile.TILE_HEIGHT_MELD);
		boardDeck = new Deck(new Point(), Tile.TILE_WIDTH_BOARD, Tile.TILE_HEIGHT_BOARD);
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
			
			tileLabelList.add(label);
		}
		
		// init the coordinate of the new tile sent by server
		// Coordinate = (the x of the last hand mile + some distance, the y of the last hand mile)
		newTileShowPoint = new Point(point.x + Tile.TILE_WIDTH_USER / 2, point.y);
	}
}
