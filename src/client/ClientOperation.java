/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: ClientOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import network.Message;

// TODO: Auto-generated Javadoc
/**
 * The Interface ClientOperation handles the message received by the client.
 */
public interface ClientOperation {
	
	/**
	 * Operate the message by the client.
	 *
	 * @param client the client who operates the message
	 * @param msg the message the client receives
	 */
	public void operate(Client client, Message msg);
}
