/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: BidOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import java.lang.reflect.Constructor;
import java.util.PriorityQueue;
import java.util.Queue;

import network.BidMsg;
import network.Message;
import server.Server;
import server.ServerOperation;

public class BidOperation implements ClientOperation{
	
	/**
	 * Operate.
	 *
	 * @param client the client
	 * @param msg the msg
	 */
	@Override
	public void operate(Client client, Message msg) {
		try {
			Class<?> c = Class.forName("client."+((BidMsg)msg).getResponserName());
			Constructor<?> constructor = c.getConstructor();
			BidResponser re = (BidResponser)constructor.newInstance();
			re.response(client, ((BidMsg)msg));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	} 
}
