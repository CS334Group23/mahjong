package server;

import java.util.ArrayList;
import java.util.Collections;

import network.BidMsg;

public interface BidResponser {
	public void response(Server server, BidMsg msg);
}
