package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

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
		
		users.add(user_bottom);
		users.add(user_right);
		users.add(user_top);
		users.add(user_left);
	}
	
	private void handInit() {
		for(User user : users) {
			user.handInit(this);
		}
	}

	public void addNewTile(int userId, Tile tile) {
		
		
	}

}
