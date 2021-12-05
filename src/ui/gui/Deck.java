/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: Deck.java </p> 
 * @author TeamCS3343 </a>
 */
package ui.gui;

import java.util.ArrayList;

import utils.Tile;

/**
 * The Class Deck.
 * This class is to store the tile, tile label and the current coordinate of the tile in this deck
 */
public class Deck {
	
	private ArrayList<Tile> tiles;
	private ArrayList<TileLabel> tileLabels;
	private Point point;
	private int tileWidth, tileHeight;

	public Deck(Point point, int tileWidth, int tileHeight) {
		this.tiles = new ArrayList<>();
		this.tileLabels = new ArrayList<>();
		this.point = point;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
	}

	public Deck(ArrayList<Tile> tiles, Point point, int tileWidth, int tileHeight) {
		this.tiles = new ArrayList<>(tiles);
		this.tileLabels = new ArrayList<>();
		this.point = point;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
	}

	public ArrayList<Tile> getTiles() {
		return tiles;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public int getTileWidth() {
		return tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}

	public ArrayList<TileLabel> getTileLabels() {
		return tileLabels;
	}
	
}
