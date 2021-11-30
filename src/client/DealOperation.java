/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: DealOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import network.DealMsg;
import network.Message;

// TODO: Auto-generated Javadoc
/**
 * The Class DealOperation.
 */
public class DealOperation implements ClientOperation{

	/**
	 * Operate.
	 *
	 * @param client the client
	 * @param msg the msg
	 */
	@Override
	public void operate(Client client, Message msg) {
		client.initWall(((DealMsg)msg).getInitCards());
		client.getUi().infoDeal((DealMsg)msg);
	}

}
