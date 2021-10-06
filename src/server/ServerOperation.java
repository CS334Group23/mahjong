package server;

import utils.Message;

public interface ServerOperation {
	public void operate(Server server, Message msg);
}
