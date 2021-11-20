package server;

import utils.BidMsg;

public class WinResponser implements BidResponser{

	@Override
	public void response(Server server, BidMsg msg) {
		server.sendAll(msg, msg.getBidClient());
//		server.setGameOver();
	}

}
