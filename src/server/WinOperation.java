package server;

import utils.Message;
import utils.WinMsg;

public class WinOperation implements ServerOperation{
	private static int msgCount = 0;
	private static WinMsg winMsg = null;
	
	@Override
	public void operate(Server server, Message msg) {
		WinMsg temp = (WinMsg)msg;
		if(msgCount == 0) {
			winMsg = new WinMsg(temp.getWinClientId(), temp.getWinClientId(), null);
			winMsg.addHand(temp.getClientId(), temp.getHandList());
			msgCount++;
		}
		else if(msgCount < Server.CLIENT_NUM-1) {
			winMsg.addHand(temp.getClientId(), temp.getHandList());
			msgCount++;
		}
		else {
			winMsg.addHand(temp.getClientId(), temp.getHandList());
			msgCount = 0;
			server.sendAll(winMsg, temp.getWinClientId());
			server.setGameOver();
		}
	}

}
