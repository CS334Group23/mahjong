/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: ServerOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package server;

import network.Message;

// TODO: Auto-generated Javadoc
/**
 * The Interface ServerOperation.
 */
public interface ServerOperation {
	
	/**
	 * Operate.
	 *
	 * @param server the server
	 * @param msg the msg
	 */
	public void operate(Server server, Message msg);
}
