/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: KongResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import network.BidMsg;

// TODO: Auto-generated Javadoc
/**
 * The Class KongResponser handles when some players play the Kong bid.
 */
public class KongResponser implements BidResponser{
	
	/**
	 * Response when some players play the Kong bid.
	 *
	 * @param client the client receives the bid message
	 * @param msg the bid message this client receives
	 */
	@Override
	public void response(Client client, BidMsg msg) {
		BidMsg kongMsg = (BidMsg)msg;
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
