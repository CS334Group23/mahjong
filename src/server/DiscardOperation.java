package server;

import utils.DiscardMsg;
import utils.Message;

public class DiscardOperation implements ServerOperation{

	@Override
	public void operate(Server server, Message msg) {
		server.sendAll(msg, 0); //here may later have some problems
	}

}
