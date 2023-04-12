/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: KongResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package server;

import network.BidMsg;
import network.DrawNoticeMsg;

/**
 * The Class KongResponser.
 */
public class KongResponser implements BidResponser{

	/**
	 * Response to Kong Message to client。
	 *
	 * @param server the server
	 * @param msg the input message
	 */
	@Override
	public void response(Server server, BidMsg msg) {
		server.sendAll(msg, msg.getBidClient());

		server.sendAll(new DrawNoticeMsg(server.getNextClient()), 0);
		server.setNextClient(msg.getBidClient());
		server.sendNextDraw();
	}

}
