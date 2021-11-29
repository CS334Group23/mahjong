/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: BidOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package server;

import java.lang.reflect.Constructor;
import java.util.PriorityQueue;
import java.util.Queue;

import network.BidMsg;
import network.Message;

// TODO: Auto-generated Javadoc
/**
 * The Class BidOperation.
 */
public class BidOperation implements ServerOperation{
	
	/** The msg queue. */
	private static Queue<BidMsg> msgQueue = new PriorityQueue<>();
	
	/**
	 * Operate.
	 *
	 * @param server the server
	 * @param msg the msg
	 */
	@Override
	public void operate(Server server, Message msg) {
		msgQueue.add((BidMsg)msg);
		System.out.printf("receive bid msg from client%d\n", ((BidMsg)msg).getBidClient());
		if(((BidMsg)msg).isSelfDrawn() || msgQueue.size() >= Server.CLIENT_NUM) {
			try {
				BidMsg peek = msgQueue.peek();
				msgQueue.clear();
				Class<?> c = Class.forName("server."+peek.getResponserName());
				Constructor<?> constructor = c.getConstructor();
				BidResponser re = (BidResponser)constructor.newInstance();
				re.response(server, peek);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	} 
}
