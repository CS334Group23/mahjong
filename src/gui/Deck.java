package gui;

import java.util.ArrayList;

import utils.Tile;

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
		this.tiles = new ArrayList<>();
		this.tileLabels = new ArrayList<>();
		this.tiles = tiles;
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
