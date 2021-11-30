/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: ChowResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import network.BidMsg;
import network.DiscardMsg;

// TODO: Auto-generated Javadoc
/**
 * The Class ChowResponser.
 */
public class ChowResponser implements BidResponser{

	/**
	 * Response.
	 *
	 * @param client the client
	 * @param msg the msg
	 */
	@Override
	public void response(Client client, BidMsg msg) {
		BidMsg chowMsg = (BidMsg)msg; //here later need refactoring
		if(client.getId()== chowMsg.getBidClient()) { //here now omit this if in the text ui design
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
