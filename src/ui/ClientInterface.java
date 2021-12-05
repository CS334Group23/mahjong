/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: ClientInterface.java </p> 
 * @author TeamCS3343 </a>
 */
package ui;

import java.util.ArrayList;

import utils.Tile;

/**
 * The Interface ClientInterface.
 * The interface provided for Client to implement to realize some basic function 
 */
public interface ClientInterface {
	
	/**
	 * Gets the id of the client.
	 *
	 * @return the id
	 */
	public int getId();
	
	/**
	 * Gets the length of the Tile wall.
	 *
	 * @return the length
	 */
	public int getLength();

	/**
	 * Gets the wall Tile wall of the client.
	 *
	 * @return the wall
	 */
	public ArrayList<Tile> getWall();
	
	/**
	 * Renew the score of the client.
	 *
	 * @param gameScore a list of one round score of all the clients
	 */
	public void renewScore(ArrayList<Integer> gameScore);
	
	/**
	 * Gets the score of the round of the client
	 *
	 * @param clientId the client id to get the score
	 * @return the score of the client
	 */
	public int getScore(int clientId);
}
