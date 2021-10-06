package client;

import utils.Message;

public interface ClientOperation {
	public void operate(Client client, Message msg);
}
