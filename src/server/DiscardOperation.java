package server;

import utils.Message;

public class DiscardOperation implements ServerOperation{

	@Override
	public void operate(Server server, Message msg) {
		server.sendAll(msg);
	}

}
