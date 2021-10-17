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

import gui.Point;
import gui.User;

public class ImageUtils {
	
	public static void handInit(JPanel panel, ArrayList<User> users){
		
		JLabel jl;
		try {
			for(User user : users) {
				ArrayList<Tile> hand = user.getHand();
				Point point = user.getHandPoint();
				
				if(user.isRealUser()) {
					for(Tile tile : hand) {
						jl = getTileLabel(tile, user.isRealUser());
						
						final JLabel tileLabel = jl;
						jl.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								int originalX = tileLabel.getX();
								int originalY = tileLabel.getY();
								int afterY = originalY - 40;
								tileLabel.setBounds(originalX, afterY, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
							}
						});
						
						jl.setBounds(point.x, point.y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
						panel.add(jl);
						
						point.setX(point.x + 76);
					}
				} else {
					for(Tile tile : hand) {
						jl = getTileLabel(tile, user.isRealUser());
						
						jl.setBounds(point.x, point.y, Tile.TILE_WIDTH_OTHERS, Tile.TILE_HEIGHT_OTHERS);
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
	
	private static JLabel getTileLabel(Tile tile, boolean isRealUser) throws IOException {	
		Image tempTileImg = ImageIO.read(new File(tile.getUrl()));
		Image tileImg;
		if(isRealUser) {
			tileImg = tempTileImg.getScaledInstance(Tile.TILE_WIDTH, Tile.TILE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
		} else {
			tileImg = tempTileImg.getScaledInstance(Tile.TILE_WIDTH_OTHERS, Tile.TILE_HEIGHT_OTHERS, java.awt.Image.SCALE_SMOOTH);
		}
		
		ImageIcon tileImgIcon = new ImageIcon(tileImg);
		JLabel jl = new JLabel(tileImgIcon);
		
		return jl;
	}

}
