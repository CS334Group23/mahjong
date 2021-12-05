/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: TileLabel.java </p> 
 * @author TeamCS3343 </a>
 */
package ui.gui;

import javax.swing.JLabel;

import utils.Tile;

/**
 * The Class TileLabel.
 */
public class TileLabel extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
