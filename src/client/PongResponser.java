/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: PongResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import network.BidMsg;
import network.DiscardMsg;

/**
 * The Class PongResponser handles when some players play the Pong bid.
 */
public class PongResponser implements BidResponser{

	/**
	 * Response when some players play the Pong bid.
	 *
	 * @param client the client receives the bid message
	 * @param msg the bid message this client receives
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
