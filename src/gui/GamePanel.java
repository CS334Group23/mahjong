package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

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
	
	public GamePanel(ArrayList<User> users){
		try {
			this.users = users;
			bgImage = ImageIO.read(new File("resource/static/others/table.jpg"));
			setLayout(null);
		
			ImageUtils.handInit(this, users);
			
		} catch (IOException e) {
			System.out.println("Cannot set GamePanel's background");
		}
	}
}
