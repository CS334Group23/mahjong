/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: InitOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import network.DealMsg;
import network.Message;

// TODO: Auto-generated Javadoc
/**
 * The Class InitOperation.
 */
public class InitOperation implements ClientOperation{
	
	/**
	 * Operate.
	 *
	 * @param client the client
	 * @param msg the msg
	 */
	@Override
	public void operate(Client client, Message msg) {
		client.getUi().init(client);
	}

}
