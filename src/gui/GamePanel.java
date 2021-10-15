package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.html.ImageView;

import utils.Tile;

public class GamePanel extends JPanel{	
	private Image bgImage;
	private JPanel center, east, west, north, south;
	private JPanel center_east, center_west, center_north, center_south;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImage, 0, 0, GameController.FRAME_WIDTH, GameController.FRAME_HEIGHT, this);
	}
	
	public GamePanel(ArrayList<Tile> initialHand){
		try {
			bgImage = ImageIO.read(new File("resource/static/others/table.jpg"));
			setLayout(new BorderLayout());
			
			layoutInit();
			handInit(initialHand);
			
		} catch (IOException e) {
			System.out.println("Cannot set GamePanel's background");
		}
	}
	
	private void handInit(ArrayList<Tile> initialHand) {
		for(Tile tile : initialHand) {
			addNewTile(tile);
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
		
		center.setOpaque(false);
		east.setOpaque(false);
		west.setOpaque(false);
		north.setOpaque(false);
		south.setOpaque(false);
		center_east.setOpaque(false);
		center_west.setOpaque(false);
		center_north.setOpaque(false);
		center_south.setOpaque(false);
		
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
	
	public void addNewTile(Tile tile) {
		
		try {		
			Image tempTileImg = ImageIO.read(new File(tile.getUrl()));
			Image tileImg = tempTileImg.getScaledInstance(Tile.TILE_WIDTH, Tile.TILE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
			
			ImageIcon tileImgIcon = new ImageIcon(tileImg);
			JLabel jl = new JLabel(tileImgIcon);
			
			// TODO: fix the tile not move problem (could capture mouse click event but tile no movement)
			jl.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					System.out.println("tile is moving"); // to show this method is entered
					int originalX = jl.getX();
					int originalY = jl.getY();
					int afterY = originalY + 20;
					jl.setBounds(originalX, afterY, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
				}
			});
			
			south.add(jl);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
