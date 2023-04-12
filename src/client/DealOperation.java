/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: DealOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import network.DealMsg;
import network.Message;

/**
 * The Class DealOperation is the class deals the received deal message.
 */
public class DealOperation implements ClientOperation{

	/**
	 * Operate the deal message.
	 *
	 * @param client the client who operates the message
	 * @param msg the message the client receives
	 */
	@Override
	public void operate(Client client, Message msg) {
		client.initWall(((DealMsg)msg).getInitCards());
		client.getUi().infoDeal((DealMsg)msg);
	}

}
