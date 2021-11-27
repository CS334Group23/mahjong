/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: KongResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package server;

import network.BidMsg;
import network.DrawNoticeMsg;

// TODO: Auto-generated Javadoc
/**
 * The Class KongResponser.
 */
public class KongResponser implements BidResponser{

	/**
	 * Response.
	 *
	 * @param server the server
	 * @param msg the msg
	 */
	@Override
	public void response(Server server, BidMsg msg) {
		server.sendAll(msg, msg.getBidClient());

		server.sendAll(new DrawNoticeMsg(server.getNextClient()), 0);
		server.setNextClient(msg.getBidClient());
		server.sendNextDraw();
	}

}
