/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: ServerOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package server;

import network.Message;

/**
 * The Interface ServerOperation.
 */
public interface ServerOperation {
	
	/**
	 * Operate function to deal with input message in server.
	 *
	 * @param server the server
	 * @param msg the msg
	 */
	public void operate(Server server, Message msg);
}
