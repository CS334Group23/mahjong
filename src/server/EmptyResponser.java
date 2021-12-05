/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: EmptyResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package server;

import network.BidMsg;
import network.DrawNoticeMsg;

/**
 * The Class EmptyResponser.
 */
public class EmptyResponser implements BidResponser{

	/**
	 * Response to Empty Message to client。
	 *
	 * @param server the server
	 * @param msg the input message
	 */
	@Override
	public void response(Server server, BidMsg msg) {
		server.sendAll(new DrawNoticeMsg(server.getNextClient()), 0);
		server.sendNextDraw();
	}

}
