package client;

import java.util.Scanner;

import utils.BidMsg;
import utils.DiscardMsg;
import utils.TerminalIOUtils;

public class PongResponser implements BidResponser{

	@Override
	public void response(Client client, BidMsg msg) {
		BidMsg pongMsg = (BidMsg)msg;
		if(client.getId()== pongMsg.getBidClient()) {
			client.updateWall(pongMsg.getMeld());
			TerminalIOUtils.printIndex(client.getLength());
			System.out.print("Please Input the index of the card you want to play (If you want to discard the card you draw, type 14):");
			Scanner scan = new Scanner(System.in);
			int tileIndex=0;
	        if (scan.hasNext()) {
	            tileIndex = scan.nextInt();
	        }
	        int discardId = client.getTile(tileIndex-1).getId();
	        client.discardTile(tileIndex-1);
			client.send(client.getServer(),new DiscardMsg(discardId,client.getId()));
		}
		else {
			client.addMeld(pongMsg.getBidClient(), pongMsg.getMeld());
		}
	}

}
