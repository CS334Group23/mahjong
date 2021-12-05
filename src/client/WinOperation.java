/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: WinOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import network.Message;
import network.WinMsg;

// TODO: Auto-generated Javadoc
/**
 * The Class WinOperation is the class deals the received winning message.
 */
public class WinOperation implements ClientOperation{

	/**
	 * Operate the winning message.
	 *
	 * @param client the client who operates the message
	 * @param msg the message the client receives
	 */
	@Override
	public void operate(Client client, Message msg) {
		client.getUi().infoWin((WinMsg)msg);
	}
	
}
