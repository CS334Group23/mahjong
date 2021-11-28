/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: Deck.java </p> 
 * @author TeamCS3343 </a>
 */
package ui.gui;

import java.util.ArrayList;

import utils.Tile;

// TODO: Auto-generated Javadoc
/**
 * The Class Deck.
 */
public class Deck {
	
	/** The tiles. */
	private ArrayList<Tile> tiles;
	
	/** The tile labels. */
	private ArrayList<TileLabel> tileLabels;
	
	/** The point. */
	private Point point;
	
	/** The tile height. */
	private int tileWidth, tileHeight;
	
	/**
	 * Instantiates a new deck.
	 *
	 * @param point the point
	 * @param tileWidth the tile width
	 * @param tileHeight the tile height
	 */
	public Deck(Point point, int tileWidth, int tileHeight) {
		this.tiles = new ArrayList<>();
		this.tileLabels = new ArrayList<>();
		this.point = point;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
	}
	
	/**
	 * Instantiates a new deck.
	 *
	 * @param tiles the tiles
	 * @param point the point
	 * @param tileWidth the tile width
	 * @param tileHeight the tile height
	 */
	public Deck(ArrayList<Tile> tiles, Point point, int tileWidth, int tileHeight) {
		this.tiles = new ArrayList<>();
		this.tileLabels = new ArrayList<>();
//		this.tiles = tiles; //here directly use the client's wall has some problem
		for(Tile t : tiles) {
			this.tiles.add(t);
		}
		this.point = point;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
	}

	/**
	 * Gets the tiles.
	 *
	 * @return the tiles
	 */
	public ArrayList<Tile> getTiles() {
		return tiles;
	}

	/**
	 * Gets the point.
	 *
	 * @return the point
	 */
	public Point getPoint() {
		return point;
	}

	/**
	 * Sets the point.
	 *
	 * @param point the new point
	 */
	public void setPoint(Point point) {
		this.point = point;
	}

	/**
	 * Gets the tile width.
	 *
	 * @return the tile width
	 */
	public int getTileWidth() {
		return tileWidth;
	}

	/**
	 * Gets the tile height.
	 *
	 * @return the tile height
	 */
	public int getTileHeight() {
		return tileHeight;
	}
	
	/**
	 * Gets the tile labels.
	 *
	 * @return the tile labels
	 */
	public ArrayList<TileLabel> getTileLabels() {
		return tileLabels;
	}
	
}
