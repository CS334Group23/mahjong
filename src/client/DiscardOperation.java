package client;

import java.util.ArrayList;
import java.util.Scanner;

import utils.BidMsg;
import utils.Checker;
import utils.DiscardMsg;
import utils.Meld;
import utils.Message;
import utils.Tile;
import utils.TerminalIOUtils;

public class DiscardOperation implements ClientOperation{

	@Override
	public void operate(Client client, Message msg) {
		DiscardMsg discardMsg = ((DiscardMsg)msg);
		System.out.printf("You are client%d\n", client.getId());
		System.out.printf("Client%d discards %s\n", discardMsg.getSenderId(),Tile.idToChnName(discardMsg.getTileId()));
		ArrayList<Meld> possibleMeld = new ArrayList<>();
		if(discardMsg.getSenderId()==client.getId()) {
			client.send(client.getServer(), new BidMsg(client.getId(), BidMsg.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null));
			return;
		}
		else if(discardMsg.getSenderId()==(client.getId()+3)%4) {
			possibleMeld = Checker.checkChow(client.getWall(), new Tile(discardMsg.getTileId()));
		}
		Meld pong = Checker.checkPong(client.getWall(), new Tile(discardMsg.getTileId()));
		Meld kong = Checker.checkKong(client.getWall(), new Tile(discardMsg.getTileId()));
		if(pong != null) {
			possibleMeld.add(pong);
		}
		if(kong != null) {
			possibleMeld.add(kong);
		}
		if(possibleMeld.size()==0) {
			client.send(client.getServer(), new BidMsg(client.getId(), BidMsg.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null));
			return;
		}
		else {
			TerminalIOUtils.printIndex(possibleMeld.size()+1);
			System.out.print("You have options:");
			for(Meld m:possibleMeld) {
				System.out.printf("%s %s   /",m.getChnName(),m.printMeld());
				
			}
			System.out.println("过");
			Scanner scan = new Scanner(System.in);
			int opIndex=0;
	        if (scan.hasNext()) {
	            opIndex = scan.nextInt()-1;
	        }
	        if(opIndex<possibleMeld.size()) {
	        	switch(possibleMeld.get(opIndex).getcomb_type()) {
				case 1:
					client.send(client.getServer(), new BidMsg(client.getId(), BidMsg.CHOW, "ChowResponser", ((DiscardMsg)msg).getTileId(),possibleMeld.get(opIndex)));
					return;
				case 2:
					client.send(client.getServer(), new BidMsg(client.getId(), BidMsg.PONG, "PongResponser", ((DiscardMsg)msg).getTileId(),possibleMeld.get(opIndex)));
					return;
				case 3:
					client.send(client.getServer(), new BidMsg(client.getId(), BidMsg.KONG, "KongResponser", ((DiscardMsg)msg).getTileId(),possibleMeld.get(opIndex)));
					return;
	        	}
	        }
	        
		}
		client.send(client.getServer(), new BidMsg(client.getId(), BidMsg.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null));
		return;
	}
}
