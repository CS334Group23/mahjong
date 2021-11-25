package server;

import network.BidMsg;

public interface BidResponser {
	public void response(Server server, BidMsg msg);
}
