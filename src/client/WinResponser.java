package client;

import utils.BidMsg;

public class WinResponser implements BidResponser{

	@Override
	public void response(Client client, BidMsg msg) {
		client.getUi().infoWin(msg);
	}

}
