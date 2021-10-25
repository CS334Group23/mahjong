package client;

import java.util.Scanner;

import utils.BidMsg;
import utils.DiscardMsg;
import utils.TerminalIOUtils;

public class KongResponser implements BidResponser{
	
	@Override
	public void response(Client client, BidMsg msg) {
		BidMsg kongMsg = (BidMsg)msg;
		if(client.getId()== kongMsg.getBidClient()) {
			client.updateWall(kongMsg.getMeld());
		}
		else {
			client.addMeld(kongMsg.getBidClient(), kongMsg.getMeld());
		}
	}

}
