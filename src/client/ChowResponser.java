/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: ChowResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import network.BidMsg;
import network.DiscardMsg;

/**
 * The Class ChowResponser handles when some players play the Chow bid.
 */
public class ChowResponser implements BidResponser{

	/**
	 * Response when some players play the Chow bid.
	 *
	 * @param client the client receives the bid message
	 * @param msg the bid message this client receives
	 */
	@Override
	public void response(Client client, BidMsg msg) {
		BidMsg chowMsg = msg;
		if(client.getId()== chowMsg.getBidClient()) {
			client.updateWall(chowMsg.getMeld());
			client.getUi().infoBid(msg);
			int tileIndex = client.getUi().getDiscard();
	        int discardId = client.getTile(tileIndex-1).getId();
	        client.discardTile(tileIndex-1);
			client.send(client.getServer(),new DiscardMsg(discardId,client.getId()));
		}
		else {
			client.getUi().infoBid(msg);
			client.addMeld(chowMsg.getBidClient(), chowMsg.getMeld());
		}
	}
	
}
