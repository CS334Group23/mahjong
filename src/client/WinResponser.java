/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: WinResponser.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import java.util.ArrayList;
import java.util.Arrays;

import checker.FacadeChecker;
import network.BidMsg;
import network.WinMsg;
import server.Server;
import utils.Tile;

// TODO: Auto-generated Javadoc
/**
 * The Class WinResponser.
 */
public class WinResponser implements BidResponser{

	/**
	 * Response.
	 *
	 * @param client the client
	 * @param msg the msg
	 */
	@Override
	public void response(Client client, BidMsg msg) {
		if(client.getId() == msg.getBidClient()){
			ArrayList<Integer> scores = new ArrayList<Integer> (Arrays.asList(0,0,0,0));
			FacadeChecker facadeChecker = new FacadeChecker(client.getWall(),client.getMeld(),new Tile(msg.getTileId()));
			int base = facadeChecker.getScore();
			if(msg.isSelfDrawn()) {
				for(int i=0;i<Server.CLIENT_NUM;i++) {
					if(i == client.getId())
						scores.set(i, 3*(base+1));
					else
						scores.set(i, -(base+1));
				}
				client.send(client.getServer(), new WinMsg(client.getId(), msg.getBidClient(), Tile.tileToIdList(client.getWall()),scores,WinMsg.SELFDRAWN));
			}
			else {
				for(int i=0;i<Server.CLIENT_NUM;i++) {
					if(i == client.getId()) {
						scores.set(i, base);
					}
					if(i == msg.getPreviousClient()) {
						scores.set(i, -base);
					}
				}
				client.send(client.getServer(), new WinMsg(client.getId(), msg.getBidClient(), Tile.tileToIdList(client.getWall()),scores,WinMsg.WINBYDISCARD));
			}
		}
		else {
			client.send(client.getServer(), new WinMsg(client.getId(), msg.getBidClient(), Tile.tileToIdList(client.getWall()),new ArrayList<Integer> (Arrays.asList(0,0,0,0)),WinMsg.TIE));
		}
	}
}
