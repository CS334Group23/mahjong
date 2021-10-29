package client;

import java.util.ArrayList;
import java.util.Scanner;

import sequence.KongChecker;
import sequence.PongChecker;
import sequence.Sequence;
import sequence.ChowChecker;
import sequence.FacadeChecker;
import utils.BidMsg;
import utils.BidType;
import utils.DiscardMsg;
import utils.Meld;
import utils.Message;
import utils.Tile;
import utils.TerminalIOUtils;

public class DiscardOperation implements ClientOperation{

	@Override
	public void operate(Client client, Message msg) {
		DiscardMsg discardMsg = ((DiscardMsg)msg);
		FacadeChecker facadeChecker = new FacadeChecker(client.getWall(),client.getMeld(),new Tile(discardMsg.getTileId()));
		System.out.printf("You are client%d\n", client.getId());
		System.out.printf("Client%d discards %s\n", discardMsg.getSenderId(),Tile.idToChnName(discardMsg.getTileId()));
		ArrayList<BidMsg> possibleBid = new ArrayList<>();
		if(discardMsg.getSenderId()==client.getId()) {
			client.send(client.getServer(), new BidMsg(client.getId(), BidType.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null));
			return;
		}
		else if(discardMsg.getSenderId()==(client.getId()+3)%4) {
			ArrayList<Meld> possibleMeld = ChowChecker.checkChow(client.getWall(), new Tile(discardMsg.getTileId()));
			for(Meld m:possibleMeld) {
				possibleBid.add(new BidMsg(client.getId(), BidType.CHOW, "ChowResponser", ((DiscardMsg)msg).getTileId(),m));
			}
		}
		ArrayList<Sequence> possibleSequence = facadeChecker.check_if_win();
		Meld pong = PongChecker.checkPong(client.getWall(), new Tile(discardMsg.getTileId()));
		Meld kong = KongChecker.checkKong(client.getWall(), new Tile(discardMsg.getTileId()));
		if(pong != null) {
			possibleBid.add(new BidMsg(client.getId(), BidType.PONG, "PongResponser", ((DiscardMsg)msg).getTileId(),pong));
		}
		if(kong != null) {
			possibleBid.add(new BidMsg(client.getId(), BidType.KONG, "KongResponser", ((DiscardMsg)msg).getTileId(),kong));
		}
		if(possibleSequence.size()!=0) {
			possibleBid.add(new BidMsg(client.getId(), BidType.WIN, "WinResponser", ((DiscardMsg)msg).getTileId(),null));
		}
		if(possibleBid.size()==0) {
			client.send(client.getServer(), new BidMsg(client.getId(), BidType.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null));
			return;
		}
		else {
			possibleBid.add(new BidMsg(client.getId(), BidType.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null));
			TerminalIOUtils.printIndex(possibleBid.size());
			System.out.print("You have options:");
			BidMsg.printBid(possibleBid);
			System.out.printf("Client%d has cards: %s\n", client.getId(),client.printWall());
			System.out.print("Please input the index of the operation: ");
			Scanner scan = new Scanner(System.in);
			int opIndex=0;
	        if (scan.hasNext()) {
	            opIndex = scan.nextInt()-1;
	        }
	        if(opIndex<possibleBid.size() && 0<=opIndex) {
	        	client.send(client.getServer(), possibleBid.get(opIndex));
	        }
	        else {
	        	System.out.println("Invalid operation. Automatically execute the default operation.");
	        	client.send(client.getServer(), new BidMsg(client.getId(), BidType.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null));
	    		return;
	        }
	        
		}
		client.send(client.getServer(), new BidMsg(client.getId(), BidType.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null));
		return;
	}
}
