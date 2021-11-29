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
 * The Class WinOperation.
 */
public class WinOperation implements ClientOperation{

	/**
	 * Operate.
	 *
	 * @param client the client
	 * @param msg the msg
	 */
	@Override
	public void operate(Client client, Message msg) {
		client.getUi().infoWin((WinMsg)msg);
	}
	
}
