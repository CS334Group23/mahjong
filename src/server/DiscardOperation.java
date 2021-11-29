/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: DiscardOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package server;

import network.Message;

// TODO: Auto-generated Javadoc
/**
 * The Class DiscardOperation.
 */
public class DiscardOperation implements ServerOperation{

	/**
	 * Operate.
	 *
	 * @param server the server
	 * @param msg the msg
	 */
	@Override
	public void operate(Server server, Message msg) {
		server.sendAll(msg, 0);
	}

}
