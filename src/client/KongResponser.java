package client;

import java.util.Scanner;

import network.BidMsg;
import network.DiscardMsg;

public class KongResponser implements BidResponser{
	
	@Override
	public void response(Client client, BidMsg msg) {
		BidMsg kongMsg = (BidMsg)msg;
//		System.out.printf("client%d plays the operation Kong\n", kongMsg.getBidClient());
		if(client.getId()== kongMsg.getBidClient()) {
			client.getUi().infoBid(msg);
			client.updateWall(kongMsg.getMeld());
		}
		else {
			client.getUi().infoBid(msg); //use this to solve the bug, may have problem
			client.addMeld(kongMsg.getBidClient(), kongMsg.getMeld());
		}
	}

}
