/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: InitOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import network.Message;

// TODO: Auto-generated Javadoc
/**
 * The Class InitOperation is the class deals the received init message.
 */
public class InitOperation implements ClientOperation{
	
	/**
	 * Operate the init message.
	 *
	 * @param client the client who operates the message
	 * @param msg the message the client receives
	 */
	@Override
	public void operate(Client client, Message msg) {
		client.getUi().init(client);
	}

}
