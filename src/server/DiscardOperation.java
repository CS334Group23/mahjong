/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: DiscardOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package server;

import network.Message;

/**
 * The Class DiscardOperation.
 * DiscardOperation in server to deal with input DiscardMsg from client。
 */
public class DiscardOperation implements ServerOperation{

	/**
	 *DiscardOperation in server to deal with input DiscardMsg from client。
	 *
	 * @param server the server
	 * @param msg the input message
	 */
	@Override
	public void operate(Server server, Message msg) {
		server.sendAll(msg, 0);
	}

}
