package client;

import utils.DealMsg;
import utils.Message;

public class InitOperation implements ClientOperation{
	@Override
	public void operate(Client client, Message msg) {
		client.getUi().init(client);
	}

}
