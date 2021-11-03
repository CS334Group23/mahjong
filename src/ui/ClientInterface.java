package ui;

import java.util.ArrayList;

import utils.Tile;

public interface ClientInterface {
	public int getId();
	public int getLength();
//	public String printWall(); //this may later need to change name
	public ArrayList<Tile> getWall();
}
