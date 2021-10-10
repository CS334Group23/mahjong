package client;

import utils.DiscardMsg;
import utils.DrawMsg;
import utils.Message;
import utils.Tile;
import utils.CountDown;
import java.util.*;

public class DrawOperation implements ClientOperation{

	@Override
	public void operate(Client client, Message msg) {
		CountDown timer = new CountDown(10);
		timer.start();
		System.out.printf("Client%d draws card %s", client.getId(),Tile.idToName(((DrawMsg)msg).getTileId()));
		Scanner scan = new Scanner(System.in);
		int tileIndex=0;
        if (scan.hasNext()) {
            tileIndex = scan.nextInt();
        }
        scan.close();
		client.send(client.getServer(),new DiscardMsg(client.getId(),(client.getTile(tileIndex).getId())));
		//client.send(client.getServer(),new DiscardMsg(client.getId(),((DrawMsg)msg).getTileId()));

	}

}
