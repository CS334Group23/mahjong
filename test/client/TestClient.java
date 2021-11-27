package client;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import network.BidMsg;
import network.DiscardMsg;
import network.Message;
import network.Peer;
import network.WinMsg;
import server.Server;
import ui.Ui;
import utils.BidType;
import utils.Meld;
import utils.Tile;

class TestClient {
	
	@Test
	public void testConstructor() {
		Client client = new Client(0, null,"TEXT");
		assertEquals(client.getId(), 0);
		assertEquals(client.getServer(), null);
	}

	@Test
	void testInitWall() {
		Client client = new Client(1,new Server(),"TEXT");
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,34));
		client.initWall(a);
		String result = Tile.tileListToString(client.getWall());
		String s = "幺鸡 /幺鸡 /幺鸡 /二条 /三条 /四条 /五条 /六条 /七条 /八条 /九条 /九条 /九条 /";
		assertEquals(s,result);
	}
	
	@Test
	void testOnRecv() {
		Client client = new Client(0,new Server(),"TEXT");
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,9,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		Meld kong = new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
		client.onRecv(new BidMsg(0,3, BidType.KONG, "KongResponser", 3,kong,null, false));
		assertEquals(1,client.getMeld().size());
		assertEquals("Kong",client.getMeld().get(0).getName());
	}
	
	@Test
	void testSetUi1() {
		Client client = new Client(0,new Server(),"AI");
		Ui ui = client.getUi();
		assertEquals("class ui.aiUi.AiUi",ui.getClass().toString());
	}
	
	@Test
	void testSetUi2() {
		Client client = new Client(0,new Server(),"GUI");
		Ui ui = client.getUi();
		assertEquals("class ui.gui.GameController",ui.getClass().toString());
	}
	
	@Test
	void testRenewScore() {
		Client client = new Client(0,new Server(),"TEXT");
		ArrayList<Integer> scores = new ArrayList<Integer> (Arrays.asList(1,-1,0,0));
		client.renewScore(scores);
		int result1 = client.getScore(0);
		int result2 = client.getScore(1);
		int result3 = client.getScore(2);
		int result4 = client.getScore(3);
		assertEquals(1,result1);
		assertEquals(-1,result2);
		assertEquals(0,result3);
		assertEquals(0,result4);
	}
	
	@Test
	void testSend() {
		class StubServer extends Server{

			public StubServer() {
				super();
			}
			
			public void onRecv(Message msg) {
				assertEquals(((DiscardMsg)msg).getTileId(), 8);
				assertEquals("DiscardOperation",((DiscardMsg)msg).getOperationName());
			}
		}
		StubServer server = new StubServer();
		Client client = new Client(0,server,"TEXT");
		client.send(server, new DiscardMsg(8,client.getId()));
	}

}

