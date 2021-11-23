package server;

import network.BidMsg;
import network.DrawNoticeMsg;

public class KongResponser implements BidResponser{

	@Override
	public void response(Server server, BidMsg msg) {
		server.sendAll(msg, msg.getBidClient());

		server.sendAll(new DrawNoticeMsg(server.getNextClient()), 0); //here pay attention
		server.setNextClient(msg.getBidClient());
		server.sendNextDraw(); //may be changed later to retrieve one from the queue tail
	}

}
