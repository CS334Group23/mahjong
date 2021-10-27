package client;

import utils.BidMsg;
import utils.Checker;
import utils.DiscardMsg;
import utils.DrawMsg;
import utils.Meld;
import utils.Message;
import utils.TerminalIOUtils;
import utils.Tile;
import java.util.*;

public class DrawOperation implements ClientOperation{

	@Override
	public void operate(Client client, Message msg) {
		DrawMsg drawMsg = (DrawMsg)msg;
		System.out.printf("You are client%d\n", client.getId());
		TerminalIOUtils.printIndex(client.getLength());
		System.out.printf("Client%d has cards: %s\n", client.getId(),client.printWall());
		System.out.printf("Client%d draws card %s\n", client.getId(),Tile.idToChnName((drawMsg).getTileId()));
		Meld kong = Checker.checkKong(client.getWall(), new Tile(drawMsg.getTileId()));
		if(kong!=null) {
			TerminalIOUtils.printIndex(2);
			System.out.print("You have options:");
			System.out.printf("%s %s   /",kong.getChnName(),kong.printMeld());
			System.out.println("过");
			System.out.print("Please input the index of the operation: ");
			Scanner scan = new Scanner(System.in);
			int opIndex=0;
	        if (scan.hasNext()) {
	            opIndex = scan.nextInt()-1;
	        }
	        if(opIndex<2 && 0<=opIndex) {
	        	if(opIndex == 0) {
	        		client.send(client.getServer(), new BidMsg(client.getId(), BidMsg.KONG, "KongResponser", ((DrawMsg)msg).getTileId(),kong));
					return;
	        	}
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
