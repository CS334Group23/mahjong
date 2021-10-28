package client;

import java.util.ArrayList;
import java.util.Scanner;

import sequence.KongChecker;
import sequence.PongChecker;
import sequence.Sequence;
import sequence.ChowChecker;
import sequence.FacadeChecker;
import utils.BidMsg;
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
		ArrayList<Meld> possibleMeld = new ArrayList<>();
		ArrayList<Sequence> possibleSequence = new ArrayList<>();
		if(discardMsg.getSenderId()==client.getId()) {
			client.send(client.getServer(), new BidMsg(client.getId(), BidMsg.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null));
			return;
		}
		else if(discardMsg.getSenderId()==(client.getId()+3)%4) {
			possibleMeld = ChowChecker.checkChow(client.getWall(), new Tile(discardMsg.getTileId()));
		}
		possibleSequence = facadeChecker.check_if_win();
		Meld pong = PongChecker.checkPong(client.getWall(), new Tile(discardMsg.getTileId()));
		Meld kong = KongChecker.checkKong(client.getWall(), new Tile(discardMsg.getTileId()));
		if(pong != null) {
			possibleMeld.add(pong);
		}
		if(kong != null) {
			possibleMeld.add(kong);
		}
		if(possibleMeld.size()==0 && possibleSequence.size()==0) {
			client.send(client.getServer(), new BidMsg(client.getId(), BidMsg.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null));
			return;
		}
		else {
			boolean isWin = possibleSequence.size()!=0;
			if(isWin) {
				TerminalIOUtils.printIndex(possibleMeld.size()+2);
				System.out.print("You have options:");
				for(Meld m:possibleMeld) {
					System.out.printf("%s %s   /",m.getChnName(),m.printMeld());
					
				}
				System.out.print("胡   /");
				System.out.println("过");
			}
			else {
				TerminalIOUtils.printIndex(possibleMeld.size()+1);
				System.out.print("You have options:");
				for(Meld m:possibleMeld) {
					System.out.printf("%s %s   /",m.getChnName(),m.printMeld());
					
				}
				System.out.println("过");
			}
			System.out.printf("Client%d has cards: %s\n", client.getId(),client.printWall());
			System.out.print("Please input the index of the operation: ");
			Scanner scan = new Scanner(System.in);
			int opIndex=0;
	        if (scan.hasNext()) {
	            opIndex = scan.nextInt()-1;
	        }
	        if(opIndex<possibleMeld.size() && 0<=opIndex) {
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
	        else if(opIndex==possibleMeld.size()){
	        	if(isWin) {
	        		client.send(client.getServer(), new BidMsg(client.getId(), BidMsg.WIN, "WinResponser", ((DiscardMsg)msg).getTileId(),null));
					return;
	        	}
	        	else {
	        		client.send(client.getServer(), new BidMsg(client.getId(), BidMsg.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null));
		        	return;
	        	}
	        }
	        else {
	        	System.out.println("Invalid operation. Automatically execute the default operation.");
	        	client.send(client.getServer(), new BidMsg(client.getId(), BidMsg.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null));
	    		return;
	        }
	        
		}
		client.send(client.getServer(), new BidMsg(client.getId(), BidMsg.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null));
		return;
	}
}
