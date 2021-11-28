/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: BidResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package server;

import network.BidMsg;

// TODO: Auto-generated Javadoc
/**
 * The Interface BidResponser.
 */
public interface BidResponser {
	
	/**
	 * Response.
	 *
	 * @param server the server
	 * @param msg the msg
	 */
	public void response(Server server, BidMsg msg);
}
