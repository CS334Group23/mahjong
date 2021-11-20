package client;

import utils.BidMsg;
import utils.Tile;
import utils.WinMsg;

public class WinResponser implements BidResponser{

	@Override
	public void response(Client client, BidMsg msg) {
//		client.getUi().infoWin(msg);
		client.send(client.getServer(), new WinMsg(client.getId(), msg.getBidClient(), Tile.tileToIdList(client.getWall())));
	}

}
