package client;

import network.DrawNoticeMsg;
import network.Message;

public class DrawNoticeOperation implements ClientOperation{

	@Override
	public void operate(Client client, Message msg) {
		client.getUi().infoDrawNotice((DrawNoticeMsg)msg);
	}

}
