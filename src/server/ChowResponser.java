/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: ChowResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package server;

import network.BidMsg;

/**
 * The Class ChowResponser.
 */
public class ChowResponser implements BidResponser{

	/**
	 * Response to Chow Message to client。
	 *
	 * @param server the server
	 * @param msg the input Bid Message.
	 */
	@Override
	public void response(Server server, BidMsg msg) {
		server.setNextClient((msg.getBidClient()+1)%Server.CLIENT_NUM);
		server.sendAll(msg, msg.getBidClient());
	}
	
}
