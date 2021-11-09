package gui;

import javax.swing.JLabel;

import utils.Tile;

public class TileLabel extends JLabel{
	private boolean isFirstClick;
	private Tile tile;
	
	public TileLabel(Tile tile) {
		super();
		isFirstClick = true;
		this.tile = tile;
	}
	
	public boolean isFirstClick() {
		return isFirstClick;
	}
	
	public void setIsFirstClick(boolean bool) {
		isFirstClick = bool;
	}
	
	public Tile getTile() {
		return tile;
	}
}
