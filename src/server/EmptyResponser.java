package server;

import network.BidMsg;
import network.DrawNoticeMsg;

public class EmptyResponser implements BidResponser{

	@Override
	public void response(Server server, BidMsg msg) {
		server.sendAll(new DrawNoticeMsg(server.getNextClient()), 0);
		server.sendNextDraw();
	}

}
