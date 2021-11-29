/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: ClientOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import network.Message;

// TODO: Auto-generated Javadoc
/**
 * The Interface ClientOperation.
 */
public interface ClientOperation {
	
	/**
	 * Operate.
	 *
	 * @param client the client
	 * @param msg the msg
	 */
	public void operate(Client client, Message msg);
}
