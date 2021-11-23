package client;

import java.util.ArrayList;
import java.util.Collections;

import network.BidMsg;

public interface BidResponser {
	public void response(Client client, BidMsg msg);
}
