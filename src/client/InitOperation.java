package client;

import network.DealMsg;
import network.Message;

public class InitOperation implements ClientOperation{
	@Override
	public void operate(Client client, Message msg) {
		client.getUi().init(client);
	}

}
