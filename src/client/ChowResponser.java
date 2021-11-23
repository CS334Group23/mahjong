package client;

import java.util.Scanner;

import network.BidMsg;
import network.DiscardMsg;

public class ChowResponser implements BidResponser{

	@Override
	public void response(Client client, BidMsg msg) {
		BidMsg chowMsg = (BidMsg)msg; //here later need refactoring
//		System.out.printf("client%d plays the operation Chow\n", chowMsg.getBidClient());
		if(client.getId()== chowMsg.getBidClient()) { //here now omit this if in the text ui design
			client.updateWall(chowMsg.getMeld());
//			TerminalIOUtils.printIndex(client.getLength());
//			System.out.printf("Client%d has cards: %s\n", client.getId(),client.printWall());
//			System.out.print("Please Input the index of the card you want to play:");
//			Scanner scan = new Scanner(System.in);
//			int tileIndex=0;
//	        if (scan.hasNext()) {
//	            tileIndex = scan.nextInt();
//	        }
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
