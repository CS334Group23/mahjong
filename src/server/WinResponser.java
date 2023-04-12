/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: WinResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package server;

import network.BidMsg;

/**
 * The Class WinResponser.
 */
public class WinResponser implements BidResponser{

	/**
	 * Response to Win Message to client。
	 *
	 * @param server the server
	 * @param msg the input message
	 */
	@Override
	public void response(Server server, BidMsg msg) {
		server.sendAll(msg, msg.getBidClient());
	}

}
