package client;

import network.Message;
import network.WinMsg;

public class WinOperation implements ClientOperation{

	@Override
	public void operate(Client client, Message msg) {
		client.getUi().infoWin((WinMsg)msg);
	}
	
}
