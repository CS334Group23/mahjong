/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: ChowResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package server;

import network.BidMsg;

// TODO: Auto-generated Javadoc
/**
 * The Class ChowResponser.
 */
public class ChowResponser implements BidResponser{

	/**
	 * Response.
	 *
	 * @param server the server
	 * @param msg the msg
	 */
	@Override
	public void response(Server server, BidMsg msg) {
		server.setNextClient((msg.getBidClient()+1)%Server.CLIENT_NUM);
		server.sendAll(msg, msg.getBidClient());
	}
	
}
