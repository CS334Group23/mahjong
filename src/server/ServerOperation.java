package server;

import network.Message;

public interface ServerOperation {
	public void operate(Server server, Message msg);
}
