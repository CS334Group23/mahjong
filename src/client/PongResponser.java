/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: PongResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import network.BidMsg;
import network.DiscardMsg;

// TODO: Auto-generated Javadoc
/**
 * The Class PongResponser.
 */
public class PongResponser implements BidResponser{

	/**
	 * Response.
	 *
	 * @param client the client
	 * @param msg the msg
	 */
	@Override
	public void response(Client client, BidMsg msg) {
		BidMsg pongMsg = (BidMsg)msg;
		if(client.getId()== pongMsg.getBidClient()) {
			client.updateWall(pongMsg.getMeld());
			client.getUi().infoBid(msg);
			int tileIndex = client.getUi().getDiscard();
	        int discardId = client.getTile(tileIndex-1).getId();
	        client.discardTile(tileIndex-1);
			client.send(client.getServer(),new DiscardMsg(discardId,client.getId()));
		}
		else {
			client.getUi().infoBid(msg); //solve the 
			client.addMeld(pongMsg.getBidClient(), pongMsg.getMeld());
		}
	}

}
