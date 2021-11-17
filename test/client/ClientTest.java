package client;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import server.Server;
import utils.BidMsg;
import utils.BidType;
import utils.DiscardMsg;
import utils.Meld;
import utils.Message;
import utils.Peer;
import utils.Tile;

class ClientTest {

	@Test
	void testInitWall() {
		Client client = new Client(1,new Server());
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,34));
		client.initWall(a);
		String result = Tile.tileListToString(client.getWall());
		String s = "幺鸡 /幺鸡 /幺鸡 /二条 /三条 /四条 /五条 /六条 /七条 /八条 /九条 /九条 /九条 /";
		assertEquals(s,result);
	}
	
	@Test
	void testOnRecv() {
		Client client = new Client(1,new Server());
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,9,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		Meld kong = new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
		client.onRecv(new BidMsg(1, BidType.KONG, "KongResponser", 3,kong,null, false));
		assertEquals(1,client.getMeld().size());
		assertEquals("Kong",client.getMeld().get(0).getName());
	}

}
