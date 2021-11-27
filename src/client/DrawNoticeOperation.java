/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: DrawNoticeOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import network.DrawNoticeMsg;
import network.Message;

// TODO: Auto-generated Javadoc
/**
 * The Class DrawNoticeOperation.
 */
public class DrawNoticeOperation implements ClientOperation{

	/**
	 * Operate.
	 *
	 * @param client the client
	 * @param msg the msg
	 */
	@Override
	public void operate(Client client, Message msg) {
		client.getUi().infoDrawNotice((DrawNoticeMsg)msg);
	}

}
