package client;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import network.BidMsg;
import network.DiscardMsg;
import network.Message;
import network.Peer;
import server.Server;
import ui.TextUi;
import utils.BidType;
import utils.Meld;
import utils.Tile;

class TestKongResponser {

	@Test
	void test1() throws Exception {
		KongResponser kongResponser = new KongResponser();
		Client client = new Client(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,9,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		Meld kong = new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
		kongResponser.response(client, new BidMsg(1, BidType.KONG, "KongResponser", 3,kong,null, false));
		assertEquals(1,client.getMeld().size());
		assertEquals("Kong",client.getMeld().get(0).getName());
	}
	
	@Test
	void test2() throws Exception {
		KongResponser kongResponser = new KongResponser();
		Client client1 = new Client(1,new Server());
		client1.setUi(new TextUi(client1));
		Client client2 = new Client(2,new Server());
		client2.setUi(new TextUi(client2));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,9,12,16,20,24,28,32,33,36,40));
		client1.initWall(a);
		ArrayList<Integer> b = new ArrayList<Integer> (Arrays.asList(4,5,10,11,13,17,21,25,29,34,35,45,50));
		client2.initWall(b);
		Meld kong = new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
		kongResponser.response(client2, new BidMsg(1, BidType.KONG, "KongResponser", 3,kong,null, false));
		ArrayList<Meld> client1Meld = client2.getOtherMeld(1);
		assertEquals(1,client1Meld.size());
		assertEquals("Kong",client1Meld.get(0).getName());
	}


}
