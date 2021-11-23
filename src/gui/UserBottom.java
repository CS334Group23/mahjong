package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;

import utils.Meld;
import utils.Tile;
import utils.sorting;

public class UserBottom extends User{

	public UserBottom(ArrayList<Tile> hand) {
		userId = User.USER_BOTTOM;
		tileOnBoard = 0;
		boardTileIsReturnedToLastPosition = false;
		newTileFromServer = null;
		handDeck = new Deck(hand, new Point(GameController.FRAME_WIDTH*0.11, GameController.FRAME_HEIGHT*0.8), Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
		meldDeck = new Deck(new Point(), Tile.TILE_WIDTH_MELD, Tile.TILE_HEIGHT_MELD);
		boardDeck = new Deck(new Point(GameController.FRAME_WIDTH*0.37, GameController.FRAME_HEIGHT*0.52), Tile.TILE_WIDTH_BOARD, Tile.TILE_HEIGHT_BOARD);
	}
	
	@Override
	public void handInit(GamePanel gamePanel) {
		ArrayList<Tile> hand = getHand();
		Point point = handDeck.getPoint();
		int tileWidth = handDeck.getTileWidth();
		int tileHeight = handDeck.getTileHeight();
		
		TileLabel label;
		ArrayList<TileLabel> tileLabelList = getHandLabel();
		for(Tile tile : hand) {
			label = ImageUtils.addTile(gamePanel, tile, tileWidth, tileHeight, point, userId);
			gamePanel.handTileEventInit(label, this);
			
			point.setX(point.x + 57); // set new boardStartPoint for the next tile
			
			tileLabelList.add(label); // add tileLabel to the handDeck: tileLabelList
		}
		
		// init the boardStartPoint of the new tile
		// boardStartPoint = (the x of the last hand mile + some distance, the y of the last hand mile)
		newTileShowPoint = new Point(point.x + tileWidth / 2, point.y);
	}
	
	@Override
	public TileLabel discardTile(GamePanel gamePanel, Tile tile) {
		// parameter to add tile to gamepanel
		int tileWidth = boardDeck.getTileWidth();
		int tileHeight = boardDeck.getTileHeight();
		Point boardStartPoint = boardDeck.getPoint();
		
		// move the show tile boardStartPoint to the START POINT of next line if applicable
		if(tileOnBoard != 0 && tileOnBoard % 8 == 0 && !boardTileIsReturnedToLastPosition) {
			boardStartPoint.setX(boardStartPoint.getInitialX());
			boardStartPoint.setY(boardStartPoint.y + tileHeight);
		}
		
		// add tile to the board
		TileLabel label = ImageUtils.addTile(gamePanel, tile, tileWidth, tileHeight, boardStartPoint, userId);
		
		// move the show tile boardStartPoint to the right
		boardStartPoint.setX(boardStartPoint.x + 38);
		boardStartPoint.setY(boardStartPoint.y);

		// add tile to boardDeck, update the counter (indicate how many tiles on the same line)
		ArrayList<TileLabel> boardTileLabelList = getBoardLabel();
		ArrayList<Tile> boardTileList = getBoard();
		boardTileLabelList.add(label);
		boardTileList.add(tile);
		tileOnBoard++;
		
		System.out.println("User " +userId + " tileOnBoard:" + tileOnBoard);
		
		// delete the tile from handDeck
		// compare by tile Id
		// premise: tile in both array should be arranged in the same position
		ArrayList<TileLabel> handTileLabelList = getHandLabel();
		ArrayList<Tile> HandTileList = getHand();
		for(int i = 0; i < HandTileList.size(); i++) {
			if(HandTileList.get(i).getId() == tile.getId()) {
				HandTileList.remove(i);
				gamePanel.removeTileLabelFromPanel(handTileLabelList.get(i));
				handTileLabelList.remove(i);
				break;
			}
		}
		
		//here is the solve to the not display of draw card, use renew method, may be later changed to remove method
		for(int i = 0; i < HandTileList.size(); i++) {
			gamePanel.removeTileLabelFromPanel(handTileLabelList.get(i));
		}
		handTileLabelList.clear();
//		sorting.sortTile(HandTileList);
		Collections.sort(HandTileList);
		Point handStartPoint = handDeck.getPoint();
		handStartPoint.resetCoordinate();
		handInit(gamePanel);
		
		boardTileIsReturnedToLastPosition = false;
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
		handStartPoint.resetCoordinate();
		
		// 5. display tile label to panel
		ArrayList<TileLabel> handTileLabelList = getHandLabel();
		for(TileLabel handTileLabel : handTileLabelList) {
			handTileLabel.setBounds((int)handStartPoint.x, (int)handStartPoint.y, tileWidth, tileHeight);
			
			// display it to the panel
			gamePanel.add(handTileLabel);
			
			// move handStartPoint to right
			handStartPoint.setX(handStartPoint.x + 57);
		}
		
		// 6. move the newTileShowPoint to the right of handStartPoint
		newTileShowPoint.setX(handStartPoint.x + tileWidth / 2);
		
		// 7. move the meldStartPoint to the right of newTileShowPoint
		Point meldStartPoint = meldDeck.getPoint();
		meldStartPoint.setX(newTileShowPoint.x + 57 + tileWidth / 2);
		meldStartPoint.setY(newTileShowPoint.y);
		
		// 8. display meld in the meld deck, move the meldStartPoint to the right
		ArrayList<TileLabel> meldTileLabelList = getMeldLabel();
		for(TileLabel meldTileLabel : meldTileLabelList) {
			meldTileLabel.setBounds((int)meldStartPoint.x, (int)meldStartPoint.y, tileWidth, tileHeight);

			// display it to the panel
			gamePanel.add(meldTileLabel);
			
			// move meldStartPoint to the right
			meldStartPoint.setX(meldStartPoint.x + 57);
		}
	}
	
	@Override
	public void showBidInfo(GamePanel gamePanel,String bidResponser) {
		String filename = String.format("resource/static/others/%s.png",bidResponser);
		JLabel instruction = ImageUtils.getImageLabel(gamePanel, filename, (int)(GameController.FRAME_WIDTH*0.5-40), (int)(GameController.FRAME_HEIGHT*0.7), 80, 80);
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
	
	@Override
	public void showScore(GamePanel gamePanel, int score) {
		JLabel scoreLabel = new JLabel();
		String text = String.format("<html><font color='white'>&nbsp;Client %d</font><br><font color='red'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;%d</font></html>", userId,score);
		scoreLabel.setOpaque(true);
//		Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
//		scoreLabel.setBorder(blackLine);
		scoreLabel.setText(text);
		scoreLabel.setBounds(180,570,60,50);
		scoreLabel.setBackground(Color.DARK_GRAY);
		gamePanel.add(scoreLabel);
	}
}
