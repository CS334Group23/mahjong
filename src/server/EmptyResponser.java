package server;

import utils.BidMsg;

public class EmptyResponser implements BidResponser{

	@Override
	public void response(Server server, BidMsg msg) {
		server.sendNextDraw();
	}

}
