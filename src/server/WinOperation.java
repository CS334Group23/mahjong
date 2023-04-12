/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: WinOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package server;

import network.Message;
import network.WinMsg;

/**
 * The Class WinOperation.
 * WinOperation in server to deal with input WinMsg from client。
 */
public class WinOperation implements ServerOperation{
	
	/** The msg count. */
	private static int msgCount = 0;
	
	/** The static stored win msg. */
	private static WinMsg winMsg = null;
	
	/**
	 * WinOperation in server to deal with input WinMsg from client。
	 *
	 * @param server the server
	 * @param msg the input message
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
