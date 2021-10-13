package server;

import utils.BidMsg;

public class WinResponser implements BidResponser{

	@Override
	public void response(Server server, BidMsg msg) {
		server.setGameOver();
	}

}
