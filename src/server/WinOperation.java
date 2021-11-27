/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: WinOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package server;

import network.Message;
import network.WinMsg;

// TODO: Auto-generated Javadoc
/**
 * The Class WinOperation.
 */
public class WinOperation implements ServerOperation{
	
	/** The msg count. */
	private static int msgCount = 0;
	
	/** The win msg. */
	private static WinMsg winMsg = null;
	
	/**
	 * Operate.
	 *
	 * @param server the server
	 * @param msg the msg
	 */
	@Override
	public void operate(Server server, Message msg) {
		WinMsg temp = (WinMsg)msg;
		if(msgCount == 0) {
			winMsg = new WinMsg(temp.getWinClientId(), temp.getWinClientId(), null,temp.getScores(),temp.getWinType());
			winMsg.addHand(temp.getClientId(), temp.getHandList());
			msgCount++;
		}
		else if(msgCount < Server.CLIENT_NUM-1) {
			if(temp.getClientId()==temp.getWinClientId()) {
				winMsg.setScores(temp.getScores());
				winMsg.setWinType(temp.getWinType());
			}
			winMsg.addHand(temp.getClientId(), temp.getHandList());
			msgCount++;
		}
		else {
			if(temp.getClientId()==temp.getWinClientId()) {
				winMsg.setScores(temp.getScores());
				winMsg.setWinType(temp.getWinType());
			}
			winMsg.addHand(temp.getClientId(), temp.getHandList());
			msgCount = 0;
			server.sendAll(winMsg, temp.getWinClientId());
			server.setGameOver();
		}
	}

}
