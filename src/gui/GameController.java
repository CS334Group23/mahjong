package gui;

import java.awt.Container;
import javax.swing.*;

public class GameController extends JFrame{
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 1024;
	private static final int FRAME_HEIGHT = 768;
	
	private static GameController instance = new GameController();
	
	public static GameController getInstance() {return instance;}
	
	private GameController() {
		super("Mahjong");
		
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		init();
	}
	
	public void init() {
		this.add(new Home());
	}
}
