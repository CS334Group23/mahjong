package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
		
		JLabel jl;
		for(Tile tile : hand) {
			jl = ImageUtils.addTile(gamePanel, tile, tileWidth, tileHeight, point, userId);
			tileEventInit(jl, gamePanel);
			
			point.setX(point.x + 76); // set new coordinate for the next tile
		}
	}
	
	private void tileEventInit(JLabel tile, GamePanel gamePanel) {
		tile.addMouseListener(new MouseAdapter() {
			boolean isFirstClick = true;
			
			public void mouseClicked(MouseEvent e) {
				int originalX = tile.getX();
				int originalY = tile.getY();
				
				int afterY = 0;
				if(isFirstClick) {
					afterY = originalY - 40;
				} else {
					afterY = originalY + 40;
				}
				isFirstClick = !isFirstClick;
				
				tile.setBounds(originalX, afterY, Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
			}
		});
	}
	
	
}
