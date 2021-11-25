package server;

import network.BidMsg;
import network.DrawNoticeMsg;

public class KongResponser implements BidResponser{

	@Override
	public void response(Server server, BidMsg msg) {
		server.sendAll(msg, msg.getBidClient());

		server.sendAll(new DrawNoticeMsg(server.getNextClient()), 0);
		server.setNextClient(msg.getBidClient());
		server.sendNextDraw();
	}

}
