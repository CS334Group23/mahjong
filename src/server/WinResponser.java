/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: WinResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package server;

import network.BidMsg;

// TODO: Auto-generated Javadoc
/**
 * The Class WinResponser.
 */
public class WinResponser implements BidResponser{

	/**
	 * Response.
	 *
	 * @param server the server
	 * @param msg the msg
	 */
	@Override
	public void response(Server server, BidMsg msg) {
		server.sendAll(msg, msg.getBidClient());
	}

}
