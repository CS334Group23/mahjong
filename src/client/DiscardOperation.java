/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: DiscardOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import java.util.ArrayList;

import checker.ChowChecker;
import checker.FacadeChecker;
import checker.KongChecker;
import checker.PongChecker;
import checker.sequence.Sequence;
import network.BidMsg;
import network.DiscardMsg;
import network.Message;
import utils.BidType;
import utils.Meld;
import utils.Tile;

// TODO: Auto-generated Javadoc
/**
 * The Class DiscardOperation.
 */
public class DiscardOperation implements ClientOperation{

	/**
	 * Operate.
	 *
	 * @param client the client
	 * @param msg the msg
	 */
	@Override
	public void operate(Client client, Message msg) {
		DiscardMsg discardMsg = ((DiscardMsg)msg);
		FacadeChecker facadeChecker = new FacadeChecker(client.getWall(),client.getMeld(),new Tile(discardMsg.getTileId()));
		ArrayList<BidMsg> possibleBid = new ArrayList<>();
		if(discardMsg.getSenderId()==client.getId()) {
			client.getUi().infoDiscard(discardMsg, possibleBid);
			client.send(client.getServer(), new BidMsg(client.getId(),discardMsg.getSenderId(), BidType.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null, null, false));
			return;
		}
		else if(discardMsg.getSenderId()==(client.getId()+3)%4) {
//			ArrayList<Meld> possibleMeld = ChowChecker.checkChow(client.getWall(), new Tile(discardMsg.getTileId()));
			ArrayList<Meld> possibleMeld = facadeChecker.check_if_chow();
			for(Meld m:possibleMeld) {
				possibleBid.add(new BidMsg(client.getId(),discardMsg.getSenderId(), BidType.CHOW, "ChowResponser", ((DiscardMsg)msg).getTileId(),m, null, false));
			}
		}
//		ArrayList<Sequence> possibleSequence = facadeChecker.check_if_win(); //change here
		boolean win = facadeChecker.checkWhetherWin();
//		Meld pong = Checker.checkPong(client.getWall(), new Tile(discardMsg.getTileId()));
		Meld pong = facadeChecker.check_if_pong();
//		Meld kong = KongChecker.checkKong(client.getWall(), new Tile(discardMsg.getTileId()));
		Meld kong = facadeChecker.check_if_kong();
		if(pong != null) {
			possibleBid.add(new BidMsg(client.getId(),discardMsg.getSenderId(), BidType.PONG, "PongResponser", ((DiscardMsg)msg).getTileId(),pong,null, false));
		}
		if(kong != null) {
			possibleBid.add(new BidMsg(client.getId(),discardMsg.getSenderId(), BidType.KONG, "KongResponser", ((DiscardMsg)msg).getTileId(),kong, null, false));
		}
//		if(possibleSequence.size()!=0) { //change here
		if(win) {
			possibleBid.add(new BidMsg(client.getId(),discardMsg.getSenderId(), BidType.WIN, "WinResponser", ((DiscardMsg)msg).getTileId(),null, Tile.tileToIdList(client.getWall()), false));
		}
		if(possibleBid.size()==0) {
			client.getUi().infoDiscard(discardMsg, possibleBid);
			client.send(client.getServer(), new BidMsg(client.getId(),discardMsg.getSenderId(), BidType.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null, null, false));
			return;
		}
		else {
			possibleBid.add(new BidMsg(client.getId(),discardMsg.getSenderId(), BidType.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null, null, false));
			client.getUi().infoDiscard(discardMsg, possibleBid);
			int opIndex = client.getUi().getOpIndex();
	        if(opIndex<possibleBid.size() && 0<=opIndex) {
	        	client.send(client.getServer(), possibleBid.get(opIndex));
	        	return;
	        }
	        else {// this print need later try to remove from this logical part.
	        	System.out.println("Invalid operation. Automatically execute the default operation.");
	        	client.send(client.getServer(), new BidMsg(client.getId(),discardMsg.getSenderId(), BidType.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null, null, false));
	    		return;
	        }
	        
		}
	}
}
