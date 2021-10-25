package server;

import utils.BidMsg;

public class ChowResponser implements BidResponser{

	@Override
	public void response(Server server, BidMsg msg) {
		server.setNextCLient((msg.getBidClient()+1)%Server.CLIENT_NUM);
		server.sendAll(msg, msg.getBidClient());
	}
	
}
