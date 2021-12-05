/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: PongResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package server;

import network.BidMsg;

/**
 * The Class PongResponser.
 */
public class PongResponser implements BidResponser{

	/**
	 * Response to Pong Message to client。
	 *
	 * @param server the server
	 * @param msg the input message
	 */
	@Override
	public void response(Server server, BidMsg msg) {
		server.setNextClient((msg.getBidClient()+1)%Server.CLIENT_NUM);
		server.sendAll(msg, msg.getBidClient());
	}

}
