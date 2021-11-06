package server;

import utils.BidMsg;

public class KongResponser implements BidResponser{

	@Override
	public void response(Server server, BidMsg msg) {
		server.sendAll(msg, msg.getBidClient());
		server.setNextClient(msg.getBidClient());
		server.sendNextDraw(); //may be changed later to retrieve one from the queue tail
	}

}
