/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: BidResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package server;

import network.BidMsg;

/**
 * The Interface BidResponser.
 */
public interface BidResponser {
	
	/**
	 * Response to a certain BidMsg to client.
	 *
	 * @param server the server
	 * @param msg the input BidMsg
	 */
	public void response(Server server, BidMsg msg);
}
