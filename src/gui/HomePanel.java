package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HomePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image bgImage;
	private JButton gameStart;
	private JButton exit;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImage, 0, 0, GameController.FRAME_WIDTH, GameController.FRAME_HEIGHT, this);
	}

	public HomePanel(){
		try {
			bgImage = ImageIO.read(new File("resource/static/others/background.jpg"));
			
			setLayout(null);
			
			setScene();
	
		} catch (IOException e) {
			System.out.println("Cannot set HomePanel's background");
		}
	}
	
	private void setScene() {
		// TODO: set button image, add game logo
		gameStart = new JButton("Game Start");
		exit = new JButton("Exit");
		
		gameStart.setBounds(350, 750, 150, 75);
		exit.setBounds(750, 750, 150, 75);
		
		exit.addActionListener((e) -> {
			System.exit(0);
		});
		
		this.add(gameStart);
		this.add(exit);
	}
	
	public JButton getGameStartButton() {
		return gameStart;
	}
}
