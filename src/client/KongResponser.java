/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: KongResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import java.util.Scanner;

import network.BidMsg;
import network.DiscardMsg;

// TODO: Auto-generated Javadoc
/**
 * The Class KongResponser.
 */
public class KongResponser implements BidResponser{
	
	/**
	 * Response.
	 *
	 * @param client the client
	 * @param msg the msg
	 */
	@Override
	public void response(Client client, BidMsg msg) {
		BidMsg kongMsg = (BidMsg)msg;
//		System.out.printf("client%d plays the operation Kong\n", kongMsg.getBidClient());
		if(client.getId()== kongMsg.getBidClient()) {
			client.getUi().infoBid(msg);
			client.updateWall(kongMsg.getMeld());
		}
		else {
			client.getUi().infoBid(msg); //use this to solve the bug, may have problem
			client.addMeld(kongMsg.getBidClient(), kongMsg.getMeld());
		}
	}

}
