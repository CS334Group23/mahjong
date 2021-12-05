/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: DrawOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import utils.BidType;
import utils.Meld;
import utils.Tile;
import java.util.*;

import checker.FacadeChecker;
import network.BidMsg;
import network.DiscardMsg;
import network.DrawMsg;
import network.Message;

// TODO: Auto-generated Javadoc
/**
 * The Class DrawOperation is the class deals the received draw message.
 */
public class DrawOperation implements ClientOperation{

	/**
	 * Operate the draw message.
	 *
	 * @param client the client who operates the message
	 * @param msg the message the client receives
	 */
	@Override
	public void operate(Client client, Message msg) {
		DrawMsg drawMsg = (DrawMsg)msg;
		FacadeChecker facadeChecker = new FacadeChecker(client.getWall(),client.getMeld(),new Tile(drawMsg.getTileId()));
		Meld kong = facadeChecker.check_if_kong();
		boolean isWin = facadeChecker.checkWhetherWin();
		if(kong!=null || isWin) {
			ArrayList<BidMsg> possibleBid = new ArrayList<>();
			if(kong != null) {
				possibleBid.add(new BidMsg(client.getId(),client.getId(), BidType.KONG, "KongResponser", drawMsg.getTileId(),kong, null, true));
			}
			if(isWin) {
				possibleBid.add(new BidMsg(client.getId(),client.getId(), BidType.WIN, "WinResponser", (drawMsg).getTileId(),null, Tile.tileToIdList(client.getWall()), true));
			}
			possibleBid.add(new BidMsg(client.getId(),client.getId(), BidType.EMPTY, "EmptyResponser", (drawMsg).getTileId(),null, null, true));//here pay attention
			client.getUi().infoDraw(drawMsg, possibleBid);
			int opIndex = client.getUi().getOpIndex();
	        if(opIndex<possibleBid.size()-1 && 0<=opIndex) {
	        	client.send(client.getServer(), possibleBid.get(opIndex));
				return;
	        }
		}
		else {
			client.getUi().infoDraw(drawMsg, null);
		}
		client.addTile(((DrawMsg)msg).getTileId());
		int tileIndex = client.getUi().getDiscard();
		int discardId = client.getTile(tileIndex-1).getId();
        client.discardTile(tileIndex-1);
		client.send(client.getServer(),new DiscardMsg(discardId,client.getId()));
	}
}