package client;

import network.Message;

public interface ClientOperation {
	public void operate(Client client, Message msg);
}
