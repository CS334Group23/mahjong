package client;

import utils.DiscardMsg;
import utils.DrawMsg;
import utils.Message;
import utils.Tile;
import java.util.*;

public class DrawOperation implements ClientOperation{

	@Override
	public void operate(Client client, Message msg) {
		// TODO Auto-generated method stub
		System.out.printf("Client%d has cards: %s\n", client.getId(),client.printWall());
		System.out.printf("Client%d draws card %s\n", client.getId(),Tile.idToChnName(((DrawMsg)msg).getTileId()));
		client.addTile(((DrawMsg)msg).getTileId());
		//client.send(client.getServer(),new DiscardMsg(client.getId(),((DrawMsg)msg).getTileId()));
		Scanner scan = new Scanner(System.in);
		int tileIndex=0;
        if (scan.hasNext()) {
            tileIndex = scan.nextInt();
        }
        int discardId = client.getTile(tileIndex).getId();
        client.discardTile(tileIndex);
		client.send(client.getServer(),new DiscardMsg(discardId,client.getId()));
	}

}
