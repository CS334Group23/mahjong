package utils;

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
						jl = getTileLabelBySize(tile, tileWidth, tileHeight);
						
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
						jl = getTileLabelBySize(tile, tileWidth, tileHeight);
						
						jl.setBounds(point.x, point.y, Tile.TILE_WIDTH_AI, Tile.TILE_HEIGHT_AI);
						panel.add(jl);
						
						if(user.getUserId()%2 == 1) {
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
	
	private static JLabel getTileLabelBySize(Tile tile, int width, int height) throws IOException {	
		Image tempTileImg = ImageIO.read(new File(tile.getUrl()));
		Image tileImg;
		
		tileImg = tempTileImg.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
	
		ImageIcon tileImgIcon = new ImageIcon(tileImg);
		JLabel jl = new JLabel(tileImgIcon);
		
		return jl;
	}

	public static void changeTileImgToFaceDown(Tile tile) {
		Tile faceDown = new Tile(144);
		String newUrl = faceDown.getUrl();
		tile.setUrl(newUrl);
	}

}
