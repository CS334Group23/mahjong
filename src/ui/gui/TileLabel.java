/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: TileLabel.java </p> 
 * @author TeamCS3343 </a>
 */
package ui.gui;

import javax.swing.JLabel;

import utils.Tile;

// TODO: Auto-generated Javadoc
/**
 * The Class TileLabel.
 */
public class TileLabel extends JLabel{
	
	/** The is first click. */
	private boolean isFirstClick;
	
	/** The tile. */
	private Tile tile;
	
	/**
	 * Instantiates a new tile label.
	 *
	 * @param tile the tile
	 */
	public TileLabel(Tile tile) {
		super();
		isFirstClick = true;
		this.tile = tile;
	}
	
	/**
	 * Checks if is first click.
	 *
	 * @return true, if is first click
	 */
	public boolean isFirstClick() {
		return isFirstClick;
	}
	
	/**
	 * Sets the checks if is first click.
	 *
	 * @param bool the new checks if is first click
	 */
	public void setIsFirstClick(boolean bool) {
		isFirstClick = bool;
	}
	
	/**
	 * Gets the tile.
	 *
	 * @return the tile
	 */
	public Tile getTile() {
		return tile;
	}
}
