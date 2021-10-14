package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	private Image bgImage;
	private JPanel center, east, west, north, south;
	private JPanel center_east, center_west, center_north, center_south;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImage, 0, 0, GameController.FRAME_WIDTH, GameController.FRAME_HEIGHT, this);
	}
	
	public GamePanel(){
		try {
			this.bgImage = ImageIO.read(new File("resource/static/others/table.jpg"));
			this.setLayout(new BorderLayout());
			// TODO: init layout, tile movement
			//layoutInit();
		} catch (IOException e) {
			System.out.println("Cannot set GamePanel's background");
		}
	}
	
	private void layoutInit() {
		center = new JPanel();
		east = new JPanel();
		west = new JPanel();
		north = new JPanel();
		south = new JPanel();
		
		center_east = new JPanel();
		center_west = new JPanel();
		center_north = new JPanel();
		center_south = new JPanel();
		
		center.setLayout(new BorderLayout());
		center.add(center_east, BorderLayout.EAST);
		center.add(center_west, BorderLayout.WEST);
		center.add(center_north, BorderLayout.NORTH);
		center.add(center_south, BorderLayout.SOUTH);
		
		this.add(center, BorderLayout.CENTER);
		this.add(east, BorderLayout.EAST);
		this.add(west, BorderLayout.WEST);
		this.add(north, BorderLayout.NORTH);
		this.add(south, BorderLayout.SOUTH);
	}
}
