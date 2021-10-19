package utils;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.Deck;
import gui.Point;
import gui.User;

public class ImageUtils {
	
	public static void handInit(JPanel panel, ArrayList<User> users){
		
		JLabel jl;
		try {
			for(User user : users) {
				Deck handDeck = user.getHandDeck();
				ArrayList<Tile> hand = handDeck.getTiles();
				Point point = handDeck.getPoint();
				int tileWidth = handDeck.getTileWidth();
				int tileHeight = handDeck.getTileHeight();
				
	
				if(user.isRealUser()) { // user
					for(Tile tile : hand) {
						jl = getTileLabelBySize(tile, tileWidth, tileHeight, user.getUserId());
						
						final JLabel tileLabel = jl;
						jl.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								int originalX = tileLabel.getX();
								int originalY = tileLabel.getY();
								int afterY = originalY - 40;
								tileLabel.setBounds(originalX, afterY, Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
							}
						});
						
						jl.setBounds(point.x, point.y, Tile.TILE_WIDTH_USER, Tile.TILE_HEIGHT_USER);
						panel.add(jl);
						
						point.setX(point.x + 76);
					}
				} else { // AI
					for(Tile tile : hand) {
						jl = getTileLabelBySize(tile, tileWidth, tileHeight, user.getUserId());
						
						jl.setBounds(point.x, point.y, Tile.TILE_WIDTH_AI, Tile.TILE_HEIGHT_AI);
						panel.add(jl);
						
						if(user.getUserId()%2 == 0) {
							point.setX(point.x + 56);
						} else {
							point.setY(point.y + 56);
						}
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	private static JLabel getTileLabelBySize(Tile tile, int width, int height, int orientation) throws IOException {	
		Image tempTileImg = ImageIO.read(new File(tile.getUrl()));
		Image tileImg;
		
		tileImg = tempTileImg.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
	
		ImageIcon tileImgIcon = new ImageIcon(tileImg);
		JLabel jl = new JLabel() {
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

	public static void changeTileImgToFaceDown(Tile tile) {
		Tile faceDown = new Tile(144);
		String newUrl = faceDown.getUrl();
		tile.setUrl(newUrl);
	}

}
