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
		System.out.printf("receive bid msg from client%d\n", ((BidMsg)msg).getBidClient());
		if(((BidMsg)msg).isSelfDrawn() || msgQueue.size() >= Server.CLIENT_NUM) {
			try {
				BidMsg peek = msgQueue.peek();
				msgQueue.clear();
				Class c = Class.forName("server."+peek.getResponserName());
				Constructor constructor = c.getConstructor(); //this warning need to be solved later
				BidResponser re = (BidResponser)constructor.newInstance();
				re.response(server, peek);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	} 
}
