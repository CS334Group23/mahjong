/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: ClientInterface.java </p> 
 * @author TeamCS3343 </a>
 */
package ui;

import java.util.ArrayList;

import utils.Tile;

// TODO: Auto-generated Javadoc
/**
 * The Interface ClientInterface.
 */
public interface ClientInterface {
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId();
	
	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	public int getLength();

/**
 * Gets the wall.
 *
 * @return the wall
 */
//	public String printWall(); //this may later need to change name
	public ArrayList<Tile> getWall();
	
	/**
	 * Renew score.
	 *
	 * @param gameScore the game score
	 */
	public void renewScore(ArrayList<Integer> gameScore);
	
	/**
	 * Gets the score.
	 *
	 * @param clientId the client id
	 * @return the score
	 */
	public int getScore(int clientId);
}
