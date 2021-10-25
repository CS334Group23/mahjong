package client;

import utils.BidMsg;
import utils.DiscardMsg;
import utils.Meld;
import utils.Message;

public class DiscardOperation implements ClientOperation{

	@Override
	public void operate(Client client, Message msg) {
		client.send(client.getServer(), new BidMsg(client.getId(), BidMsg.EMPTY, "EmptyResponser", ((DiscardMsg)msg).getTileId(),null));
	}
}
