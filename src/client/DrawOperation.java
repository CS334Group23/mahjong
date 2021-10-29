package client;

import utils.BidMsg;
import utils.BidType;
import utils.DiscardMsg;
import utils.DrawMsg;
import utils.Meld;
import utils.Message;
import utils.TerminalIOUtils;
import utils.Tile;
import java.util.*;

import sequence.FacadeChecker;
import sequence.KongChecker;
import sequence.Sequence;

public class DrawOperation implements ClientOperation{

	@Override
	public void operate(Client client, Message msg) {
		DrawMsg drawMsg = (DrawMsg)msg;
		System.out.printf("You are client%d\n", client.getId());
		TerminalIOUtils.printIndex(client.getLength());
		System.out.printf("Client%d has cards: %s\n", client.getId(),client.printWall());
		System.out.printf("Client%d draws card %s\n", client.getId(),Tile.idToChnName((drawMsg).getTileId()));
		Meld kong = KongChecker.checkKong(client.getWall(), new Tile(drawMsg.getTileId()));
		ArrayList<Sequence> possibleSequence = new ArrayList<>();
		FacadeChecker facadeChecker = new FacadeChecker(client.getWall(),client.getMeld(),new Tile(drawMsg.getTileId()));
		possibleSequence = facadeChecker.check_if_win();
		boolean isWin = possibleSequence.size()!=0;
		if(kong!=null || isWin) {
			ArrayList<BidMsg> possibleBid = new ArrayList<>();
			if(kong != null) {
				possibleBid.add(new BidMsg(client.getId(), BidType.KONG, "KongResponser", ((DrawMsg)msg).getTileId(),kong));
			}
			if(isWin) {
				possibleBid.add(new BidMsg(client.getId(), BidType.WIN, "WinResponser", ((DiscardMsg)msg).getTileId(),null));
			}
			possibleBid.add(new BidMsg(client.getId(), BidType.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null));
			TerminalIOUtils.printIndex(possibleBid.size());
			System.out.print("You have options:");
			BidMsg.printBid(possibleBid);
			System.out.print("Please input the index of the operation: ");
			Scanner scan = new Scanner(System.in);
			int opIndex=0;
	        if (scan.hasNext()) {
	            opIndex = scan.nextInt()-1;
	        }
	        if(opIndex<possibleBid.size()-1 && 0<=opIndex) {
	        	client.send(client.getServer(), possibleBid.get(opIndex));
				return;
	        }
		}
		client.addTile(((DrawMsg)msg).getTileId());
		System.out.printf("Please Input the index of the card you want to play (If you want to discard the card you draw, type %d):",client.getLength());
		boolean validInput = false;
		int tileIndex=client.getLength();
		while(!validInput) {
			Scanner scan = new Scanner(System.in);
	        if (scan.hasNext()) {
	            tileIndex = scan.nextInt();
	        }
	        if(1<=tileIndex && tileIndex<= client.getLength()) {
	        	validInput=true;
	        }
	        else {
	        	System.out.print("Invalid input. Please input again: ");
	        }
	        
		}
		int discardId = client.getTile(tileIndex-1).getId();
        client.discardTile(tileIndex-1);
		client.send(client.getServer(),new DiscardMsg(discardId,client.getId()));
	}
}