package client;

import java.util.Scanner;

import utils.BidMsg;
import utils.DiscardMsg;
import utils.TerminalIOUtils;

public class ChowResponser implements BidResponser{

	@Override
	public void response(Client client, BidMsg msg) {
		BidMsg chowMsg = (BidMsg)msg;
		System.out.printf("client%d plays the operation Chow\n", chowMsg.getBidClient());
		if(client.getId()== chowMsg.getBidClient()) {
			client.updateWall(chowMsg.getMeld());
			TerminalIOUtils.printIndex(client.getLength());
			System.out.printf("Client%d has cards: %s\n", client.getId(),client.printWall());
			System.out.printf("Please Input the index of the card you want to play (If you want to discard the card you draw, type %d):",client.getLength());
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
			client.addMeld(chowMsg.getBidClient(), chowMsg.getMeld());
		}
	}
	
}
