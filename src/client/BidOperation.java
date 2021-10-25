package client;

import java.lang.reflect.Constructor;
import java.util.PriorityQueue;
import java.util.Queue;

import server.BidResponser;
import server.Server;
import server.ServerOperation;
import utils.BidMsg;
import utils.Message;

public class BidOperation implements ServerOperation{
	
	@Override
	public void operate(Server server, Message msg) {
		try {
			Class c = Class.forName("client."+((BidMsg)msg).getResponserName());
			Constructor constructor = c.getConstructor(); //this warning need to be solved later
			BidResponser re = (BidResponser)constructor.newInstance();
			re.response(server, ((BidMsg)msg));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	} 
}
