/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: BidOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import java.lang.reflect.Constructor;

import network.BidMsg;
import network.Message;
/**
 * The Class BidOperation is the class deals the received bid message.
 */
public class BidOperation implements ClientOperation{
	
	/**
	 * Operate the bid message.
	 * Creates the corresponding responser class according to message information
	 *
	 * @param client the client who operates the message
	 * @param msg the message the client receives
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
