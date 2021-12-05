/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: DrawNoticeOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import network.DrawNoticeMsg;
import network.Message;

/**
 * The Class DrawNoticeOperation is the class deals the received draw notice message.
 */
public class DrawNoticeOperation implements ClientOperation{

	/**
	 * Operate the drawNotice message.
	 *
	 * @param client the client who operates the message
	 * @param msg the message the client receives
	 */
	@Override
	public void operate(Client client, Message msg) {
		client.getUi().infoDrawNotice((DrawNoticeMsg)msg);
	}

}
