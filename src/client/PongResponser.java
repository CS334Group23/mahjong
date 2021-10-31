package client;

import java.util.Scanner;

import utils.BidMsg;
import utils.DiscardMsg;
import utils.TerminalIOUtils;

public class PongResponser implements BidResponser{

	@Override
	public void response(Client client, BidMsg msg) {
		BidMsg pongMsg = (BidMsg)msg;
//		System.out.printf("client%d plays the operation Pong\n", pongMsg.getBidClient());
		if(client.getId()== pongMsg.getBidClient()) {
			client.updateWall(pongMsg.getMeld());
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
			client.addMeld(pongMsg.getBidClient(), pongMsg.getMeld());
		}
	}

}
