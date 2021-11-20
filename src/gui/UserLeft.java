package gui;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;

import utils.Meld;
import utils.Tile;

public class UserLeft extends User{

	public UserLeft(ArrayList<Tile> hand) {
		userId = User.USER_LEFT;
		tileOnBoard = 0;
		handDeck = new Deck(hand, new Point(GameController.FRAME_WIDTH*0.02, GameController.FRAME_HEIGHT*0.11), Tile.TILE_WIDTH_AI, Tile.TILE_HEIGHT_AI);
		meldDeck = new Deck(new Point(), Tile.TILE_WIDTH_MELD, Tile.TILE_HEIGHT_MELD);
		boardDeck = new Deck(new Point(GameController.FRAME_WIDTH*0.25, GameController.FRAME_HEIGHT*0.24), Tile.TILE_WIDTH_BOARD, Tile.TILE_HEIGHT_BOARD);
	}
	
	@Override
	public void handInit(GamePanel gamePanel) {
		ArrayList<Tile> hand = getHand();
		Point point = handDeck.getPoint();
		int tileWidth = handDeck.getTileWidth();
		int tileHeight = handDeck.getTileHeight();
		
		ArrayList<TileLabel> tileLabelList = getHandLabel();
		TileLabel label;
		for(Tile tile : hand) {
			label = ImageUtils.addTile(gamePanel, tile, tileWidth, tileHeight, point, userId);
			point.setY(point.y + 44); // set new coordinate for the next tile
			
			tileLabelList.add(label);
		}
		
		newTileShowPoint = new Point(point.x, point.y + tileWidth / 2);
	}
	
	@Override
	public TileLabel discardTile(GamePanel gamePanel, Tile tile) {
		// parameter to add tile to gamepanel
		int tileWidth = boardDeck.getTileWidth();
		int tileHeight = boardDeck.getTileHeight();
		Point coordinate = boardDeck.getPoint();
		
		// move the show tile coordinate to the START POINT of next line if applicable
		if(tileOnBoard != 0 && tileOnBoard % 8 == 0) {
			coordinate.setX(coordinate.x - tileHeight);
			coordinate.setY(coordinate.getInitialY());
		}
		
		// add tile to the board
		TileLabel label = ImageUtils.addTile(gamePanel, tile, tileWidth, tileHeight, coordinate, -userId);
		
		// move the show tile coordinate to the right
		coordinate.setY(coordinate.y + 38);

		// add tile to boardDeck, update the counter (indicate how many tiles on the same line)
		ArrayList<TileLabel> boardTileLabelList = getBoardLabel();
		ArrayList<Tile> boardTileList = getBoard();
		boardTileLabelList.add(label);
		boardTileList.add(tile);
		tileOnBoard++;

		// simply delete the last tile from the hand, because for AIs, their tile is fake
		ArrayList<TileLabel> handTileLabelList = getHandLabel();
		ArrayList<Tile> handTileList = getHand();
		if(!handTileLabelList.isEmpty()){
			gamePanel.removeTileLabelFromPanel(handTileLabelList.get(handTileLabelList.size() - 1));
			handTileLabelList.remove(handTileLabelList.size() - 1);
			handTileList.remove(handTileList.size() - 1);
		}
		return label;
	}
	
	@Override
	public void putMeldToRight(GamePanel gamePanel, Meld meld) {
		int tileWidth = getHandDeck().getTileWidth();
		int tileHeight = getHandDeck().getTileHeight();
		
		// 1. add tile to meld deck
		ArrayList<Tile> tileListFromMeld = addTileToMeldDeck(gamePanel, meld);
		
		// 2. remove all displayed tile labels from panel
		removeAllDisplayedTileLabelFromPanel(gamePanel);
		
		// 3. delete matched tile in the hand deck
		if(tileListFromMeld != null)
			deleteMatchTileFromHandDeck(gamePanel, tileListFromMeld);
		
		// 4. reset handStartPoint 
		Point handStartPoint = handDeck.getPoint();
		handStartPoint.resetCoordinate(0, -88); // reset it by moving up 88 pixel (y = initialY - 88)
		
		// 5. display tile label to panel
		ArrayList<TileLabel> handTileLabelList = getHandLabel();
		for(TileLabel handTileLabel : handTileLabelList) {
			handTileLabel.setBounds((int)handStartPoint.x, (int)handStartPoint.y, tileWidth, tileHeight);
			
			// display it to the panel
			gamePanel.add(handTileLabel);
			
			// move handStartPoint to right
			handStartPoint.setY(handStartPoint.y + 44);
		}
		
		// 6. move the newTileShowPoint to the right of handStartPoint
		newTileShowPoint.setY(handStartPoint.y + tileWidth / 2);
		
		// 7. move the meldStartPoint to the right of newTileShowPoint
		Point meldStartPoint = meldDeck.getPoint();
		meldStartPoint.setX(newTileShowPoint.x);
		meldStartPoint.setY(newTileShowPoint.y + 44 + tileWidth / 2);
		
		// 8. display meld in the meld deck, move the meldStartPoint to the right
		ArrayList<TileLabel> meldTileLabelList = getMeldLabel();
		for(TileLabel meldTileLabel : meldTileLabelList) {
			meldTileLabel.setBounds((int)meldStartPoint.x, (int)meldStartPoint.y, tileWidth, tileHeight);

			// display it to the panel
			gamePanel.add(meldTileLabel);
			
			// move meldStartPoint to the right
			meldStartPoint.setY(meldStartPoint.y + 44);
		}
		
	}
	
	@Override
	public void showBidInfo(GamePanel gamePanel,String bidResponser) {
		String filename = String.format("resource/static/others/%s.png",bidResponser);
		JLabel instruction = ImageUtils.getImageLabel(gamePanel, filename, (int)(GameController.FRAME_WIDTH*0.1), (int)(GameController.FRAME_HEIGHT*0.5), 80, 80);
		gamePanel.add(instruction);
		gamePanel.repaint();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gamePanel.remove(instruction);
		gamePanel.repaint();
	}
}
