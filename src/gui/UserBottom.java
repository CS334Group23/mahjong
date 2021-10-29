package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import utils.Tile;

public class UserBottom extends User{

	public UserBottom(ArrayList<Tile> hand) {
		userId = User.USER_BOTTOM;
		handDeck = new Deck(hand, new Point(90, 800), Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
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
			tileEventInit(label, gamePanel);
			
			point.setX(point.x + 64); // set new coordinate for the next tile
			
			tileLabelList.add(label);
		}
		
		// init the coordiante of the new tile sent by server
		// coordiante = (the x of the last hand mile + some distance, the y of the last hand mile)
		newTileShowPoint = new Point(point.x + Tile.TILE_WIDTH_USER / 2, point.y);
	}
	
	public void tileEventInit(TileLabel tile, GamePanel gamePanel) {
		tile.addMouseListener(new MouseAdapter() {
			ArrayList<TileLabel> tileLabelList = handDeck.getTileLabels();
			
			public void mouseClicked(MouseEvent e) {			
				int originalX = tile.getX();
				int originalY = tile.getY();
				
				// if it is first click
				if(tile.isFirstClick()) {
					// reset all tile to original position except clicked tile
					resetTilePosition();
					
					tile.setBounds(originalX, originalY - 40, Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
					tile.setIsFirstClick(false);
				} else {
					tile.setBounds(originalX, originalY + 40, Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
					tile.setIsFirstClick(true);
				}
			}
			
			public void resetTilePosition() {
				for(TileLabel label : tileLabelList) {
					if(! label.isFirstClick()) {
						label.setBounds(label.getX(), label.getY() + 40, Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
						label.setIsFirstClick(true);
					}
				}
			}
		});
	}
	
	
}
