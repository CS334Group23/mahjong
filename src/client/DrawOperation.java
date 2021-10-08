package client;

import utils.DiscardMsg;
import utils.DrawMsg;
import utils.Message;
import utils.Tile;

public class DrawOperation implements ClientOperation{

	@Override
	public void operate(Client client, Message msg) {
		// TODO Auto-generated method stub
		System.out.printf("Client%d draws card %s", client.getId(),Tile.idToName(((DrawMsg)msg).getTileId()));
		client.send(client.getServer(),new DiscardMsg(client.getId(),((DrawMsg)msg).getTileId()));
	}

}
