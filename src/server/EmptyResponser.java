package server;

import utils.BidMsg;
import utils.DrawNoticeMsg;

public class EmptyResponser implements BidResponser{

	@Override
	public void response(Server server, BidMsg msg) {
		server.sendAll(new DrawNoticeMsg(server.getNextClient()), 0);
		server.sendNextDraw();
	}

}
