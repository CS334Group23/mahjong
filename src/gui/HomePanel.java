package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HomePanel extends JPanel {
	private Image bgImage;
	private JButton gameStart;
	private JButton exit;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImage, 0, 0, this);
	}

	public HomePanel(){
		try {
			this.bgImage = ImageIO.read(new File("resource/static/others/home.jpg"));
			this.setLayout(null);
			
			// TODO: set button image
			gameStart = new JButton("Game Start");
			exit = new JButton("Exit");
			gameStart.setBounds(250, 500, 150, 30);
			exit.setBounds(600, 500, 150, 30);
			
			exit.addActionListener((e) -> {
				System.exit(0);
			});
			
			this.add(gameStart);
			this.add(exit);
		} catch (IOException e) {
			System.out.println("Cannot set HomePanel's background");
		}
	}
	
	public JButton getGameStartButton() {
		return gameStart;
	}
}
