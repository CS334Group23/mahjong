package client;

import utils.DrawNoticeMsg;
import utils.Message;

public class DrawNoticeOperation implements ClientOperation{

	@Override
	public void operate(Client client, Message msg) {
		client.getUi().infoDrawNotice((DrawNoticeMsg)msg);
	}

}
