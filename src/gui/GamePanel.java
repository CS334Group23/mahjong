package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import ui.ClientInterface;
import utils.BidMsg;
import utils.DealMsg;
import utils.DiscardMsg;
import utils.DrawMsg;
import utils.Tile;

public class GamePanel extends JPanel{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Image bgImage;
	private ArrayList<User> users;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImage, 0, 0, GameController.FRAME_WIDTH, GameController.FRAME_HEIGHT, this);
	}
	
	public GamePanel(ArrayList<ArrayList<Tile>> hands){
		try {
			users = new ArrayList<>();
			
			userInit(hands);
			bgImage = ImageIO.read(new File("resource/static/others/table.jpg"));
			setLayout(null);
		
			handInit();
			
		} catch (IOException e) {
			System.out.println("Cannot set GamePanel's background");
		}
	}
	
	private void userInit(ArrayList<ArrayList<Tile>> hands){
		User user_bottom = new UserBottom(hands.get(User.USER_BOTTOM));
		User user_right = new UserRight(hands.get(User.USER_RIGHT));
		User user_top = new UserTop(hands.get(User.USER_TOP));
		User user_left = new UserLeft(hands.get(User.USER_LEFT));
		
		users.add(user_bottom); // index 0
		users.add(user_right); // index 1
		users.add(user_top); // index 2
		users.add(user_left); // index 3
	}
	
	private void handInit() {
		for(User user : users) {
			user.handInit(this);
		}
	}

	public void infoDeal(DealMsg dealMsg) {
		// TODO Auto-generated method stub
		
	}
	
	public void infoDraw(DrawMsg msg, ArrayList<BidMsg> possibleBid) {
		Tile tile = new Tile(msg.getTileId());
		
		// for testing, assume all draw request bind to user_bottom
		User user_bottom = users.get(User.USER_BOTTOM);
		int tileWidth = user_bottom.getHandDeck().getTileWidth();
		int tileHeight = user_bottom.getHandDeck().getTileHeight();
		Point point = user_bottom.getNewTileShowPoint();
		int userId = user_bottom.getUserId();
		TileLabel tileLabel = ImageUtils.addTile(this, tile, tileWidth, tileHeight, point, userId);
		
		// add tile and tile label to the user's hand deck list
		UserBottom user = (UserBottom)users.get(User.USER_BOTTOM);
		user.getHandDeck().getTiles().add(tile);
		user.getHandDeck().getTileLabels().add(tileLabel);
		
		// add event to the tile label
		user.tileEventInit(tileLabel, this);
	}

	public int getOpIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getDiscard() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void infoDiscard(DiscardMsg discardMsg, ArrayList<BidMsg> possibleBid) {
		// TODO Auto-generated method stub
		
	}
	
	public void infoBid(BidMsg bidMsg) {
		
	}
	
	public void infoWin(BidMsg bidMsg) {
		
	}

}
