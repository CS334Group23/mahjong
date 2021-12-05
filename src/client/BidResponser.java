/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: BidResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import network.BidMsg;


/**
 * The Interface BidResponser handles bid operations with different types of bid.
 */
public interface BidResponser {
	
	/**
	 * Response the bid played by others according to the bid.
	 *
	 * @param client the client receives the bid message
	 * @param msg the bid message this client receives
	 */
	public void response(Client client, BidMsg msg);
}
