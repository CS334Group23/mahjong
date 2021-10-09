package client;

import utils.BidMsg;
import utils.Message;

public class DiscardOperation implements ClientOperation{

	@Override
	public void operate(Client client, Message msg) {
		client.send(client.getServer(), new BidMsg(BidMsg.EMPTY, "EmptyResponser"));
	}

}
