/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: ImageUtils.java </p> 
 * @author TeamCS3343 </a>
 */
package ui.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.Tile;

// TODO: Auto-generated Javadoc
/**
 * The Class ImageUtils.
 */
@SuppressWarnings("all")
public class ImageUtils {
	
	/**
	 * Adds the tile.
	 *
	 * @param panel the panel
	 * @param tile the tile
	 * @param tileWidth the tile width
	 * @param tileHeight the tile height
	 * @param point the point
	 * @param userId the user id
	 * @return the tile label
	 */
	public static TileLabel addTile(JPanel panel, Tile tile, int tileWidth, int tileHeight, Point point, int userId) {
		TileLabel jl = null;
		jl = getTileLabelBySize(tile, tileWidth, tileHeight, userId);
		jl.setBounds((int)point.x, (int)point.y, Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
		panel.add(jl);
		
		return jl;	
	}
	
	/**
	 * Gets the tile label by size.
	 *
	 * @param tile the tile
	 * @param width the width
	 * @param height the height
	 * @param orientation the orientation
	 * @return the tile label by size
	 */
	public static TileLabel getTileLabelBySize(Tile tile, int width, int height, int orientation){	
		Image tempTileImg = null;
		try {
			tempTileImg = ImageIO.read(new File(tile.getUrl()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image tileImg;
		
		tileImg = tempTileImg.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
	
		TileLabel jl = new TileLabel(tile) {
			@Override
			public Dimension getPreferredSize() {
                return new Dimension(width, height);
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.rotate(Math.PI*orientation / 2, width / 2, height / 2);
                g2.drawImage(tileImg, 0, 0, null);
            }
		};
		
		return jl;
	}

	/**
	 * Change tile img to face down.
	 *
	 * @param tile the tile
	 */
	public static void changeTileImgToFaceDown(Tile tile) {
		Tile faceDown = new Tile(144);
		String newUrl = faceDown.getUrl();
		tile.setUrl(newUrl);
	}
	
	/**
	 * Gets the image label.
	 *
	 * @param panel the panel
	 * @param url the url
	 * @param x the x
	 * @param y the y
	 * @param width the width
	 * @param height the height
	 * @return the image label
	 */
	public static JLabel getImageLabel(JPanel panel, String url, int x, int y, int width, int height) {
		JLabel imgLabel = null;
		try {
			Image tempImg = ImageIO.read(new File(url));
			Image img = tempImg.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
			
			
			imgLabel = new JLabel() {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2 = (Graphics2D) g;
					g2.drawImage(img, 0, 0, null);
				}
			};
			
			
			imgLabel.setBounds(x, y, width, height);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return imgLabel;
		
	}
}
