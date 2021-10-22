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
		printIndex();
		System.out.printf("Client%d has cards: %s\n", client.getId(),client.printWall());
		System.out.printf("Client%d draws card %s\n", client.getId(),Tile.idToChnName(((DrawMsg)msg).getTileId()));
		client.addTile(((DrawMsg)msg).getTileId());
		//client.send(client.getServer(),new DiscardMsg(client.getId(),((DrawMsg)msg).getTileId()));
		System.out.print("Please Input the index of the card you want to play (If you want to discard the card you draw, type 14):");
		Scanner scan = new Scanner(System.in);
		int tileIndex=0;
        if (scan.hasNext()) {
            tileIndex = scan.nextInt();
        }
        int discardId = client.getTile(tileIndex-1).getId();
        client.discardTile(tileIndex-1);
		client.send(client.getServer(),new DiscardMsg(discardId,client.getId()));
	}
	
	private void printIndex() {
		System.out.printf("%21d%6d%5d%6d%5d%6d%5d%6d%5d%5d%5d%5d%5d\n", 1,2,3,4,5,6,7,8,9,10,11,12,13);
	}

}
