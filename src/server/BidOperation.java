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

/**
 * The Class BidOperation.
 * BidOperation in server to deal with input BidMsg from client。
 */
public class BidOperation implements ServerOperation{
	
	/** The static input BidMsg queue. */
	private static Queue<BidMsg> msgQueue = new PriorityQueue<>();
	
	/**
	 * BidOperation in server to deal with input BidMsg from client。
	 *
	 * @param server the server
	 * @param msg the input Message
	 */
	@Override
	public void operate(Server server, Message msg) {
		msgQueue.add((BidMsg)msg);
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
	
	public static void clean() {// for test reason only
		msgQueue.clear();
	}
}
