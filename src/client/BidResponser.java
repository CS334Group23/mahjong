/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: BidResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import java.util.ArrayList;
import java.util.Collections;

import network.BidMsg;


/**
 * The Interface BidResponser.
 */
public interface BidResponser {
	
	/**
	 * Response.
	 *
	 * @param client the client
	 * @param msg the msg
	 */
	public void response(Client client, BidMsg msg);
}
