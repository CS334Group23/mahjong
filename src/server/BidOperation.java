package server;

import java.lang.reflect.Constructor;
import java.util.PriorityQueue;
import java.util.Queue;

import utils.BidMsg;
import utils.Message;

public class BidOperation implements ServerOperation{
	private static Queue<BidMsg> msgQueue = new PriorityQueue<>();
	
	@Override
	public void operate(Server server, Message msg) {
		msgQueue.add((BidMsg)msg);
		if(msgQueue.size() >= Server.CLIENT_NUM) {
			try {
				Class c = Class.forName("server."+msgQueue.peek().getResponserName());
				Constructor constructor = c.getConstructor(); //this warning need to be solved later
				BidResponser re = (BidResponser)constructor.newInstance();
				re.response(server, msgQueue.peek());
				msgQueue.clear();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	} 
}
