package server;

import utils.Message;

public interface Operation {
	public void operate(Server server, Message msg);
}
