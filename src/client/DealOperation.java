package client;

import network.DealMsg;
import network.Message;

public class DealOperation implements ClientOperation{

	@Override
	public void operate(Client client, Message msg) {
		client.initWall(((DealMsg)msg).getInitCards());
//		System.out.printf("Client%d has cards: %s\n", client.getId(),client.printWall());
		client.getUi().infoDeal((DealMsg)msg);
	}

}
