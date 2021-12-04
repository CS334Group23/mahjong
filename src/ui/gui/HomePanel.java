/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: HomePanel.java </p> 
 * @author TeamCS3343 </a>
 */
package ui.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class HomePanel.
 */
public class HomePanel extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The bg image. */
	private Image bgImage;
	
	/** The game start. */
	private JButton gameStart;
	
	/** The exit. */
	private JButton exit;
	
	/**
	 * Paint component.
	 *
	 * @param g the g
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImage, 0, 0, GameController.FRAME_WIDTH, GameController.FRAME_HEIGHT, this);
	}

	/**
	 * Instantiates a new home panel.
	 */
	public HomePanel(){
		try {
			bgImage = ImageIO.read(new File("resource/static/others/background.jpg"));
			
			setLayout(null);
			
			setScene();
	
		} catch (IOException e) {
			System.out.println("Cannot set HomePanel's background");
		}
	}
	
	/**
	 * Sets the scene.
	 */
	private void setScene() {
		gameStart = new JButton();
		exit = new JButton();
		
		gameStart.setBounds(GameController.FRAME_WIDTH/22*7, GameController.FRAME_HEIGHT/4*3, GameController.FRAME_WIDTH/11, GameController.FRAME_HEIGHT/12);
		exit.setBounds(GameController.FRAME_WIDTH/22*13, GameController.FRAME_HEIGHT/4*3, GameController.FRAME_WIDTH/11, GameController.FRAME_HEIGHT/12);
		
		ImageIcon icon1 = new ImageIcon("resource/static/others/gameStart.png");
		icon1.getImage();
		Image temp1 = icon1.getImage().getScaledInstance(gameStart.getWidth(), gameStart.getHeight(), Image.SCALE_DEFAULT);
		icon1 = new ImageIcon(temp1);
		
		ImageIcon icon2 = new ImageIcon("resource/static/others/exit.png");
		icon2.getImage();
		Image temp2 = icon2.getImage().getScaledInstance(gameStart.getWidth(), gameStart.getHeight(), Image.SCALE_DEFAULT);
		icon2 = new ImageIcon(temp2);
		
		
		gameStart.setIcon(icon1);
		exit.setIcon(icon2);
		exit.addActionListener((e) -> {
			System.exit(0);
		});
		
		this.add(gameStart);
		this.add(exit);
	}
	
	/**
	 * Gets the game start button.
	 *
	 * @return the game start button
	 */
	public JButton getGameStartButton() {
		return gameStart;
	}
}
