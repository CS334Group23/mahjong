package client;

import java.util.ArrayList;
import java.util.Arrays;

import sequence.FacadeChecker;
import server.Server;
import utils.BidMsg;
import utils.Tile;
import utils.WinMsg;

public class WinResponser implements BidResponser{

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
		client.send(client.getServer(), new WinMsg(client.getId(), msg.getBidClient(), Tile.tileToIdList(client.getWall()),new ArrayList<Integer> (Arrays.asList(0,0,0,0)),WinMsg.TIE));
	}
}
