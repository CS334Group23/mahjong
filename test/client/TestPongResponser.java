package client;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
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

class TestPongResponser {

	@Test
	void test1() throws Exception {
		setInput("1");
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((DiscardMsg)msg).getTileId(), 8);
			}
		}
		PongResponser pongResponser = new PongResponser();
		StubClient client = new StubClient(1,new Server());
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,8,9,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		Meld pong = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		pongResponser.response(client, new BidMsg(1, BidType.PONG, "PongResponser", 2,pong,null, false));
	}
	
	@Test
	void test2() throws Exception {
		PongResponser pongResponser = new PongResponser();
		Client client1 = new Client(1,new Server());
		Client client2 = new Client(2,new Server());
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,8,9,12,16,20,24,28,32,33,36,40));
		client1.initWall(a);
		ArrayList<Integer> b = new ArrayList<Integer> (Arrays.asList(3,4,10,11,13,17,21,25,29,34,35,45,50));
		client2.initWall(b);
		Meld pong = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		pongResponser.response(client2, new BidMsg(1, BidType.PONG, "PongResponser", 2,pong,null, false));
		ArrayList<Meld> client1Meld = client2.getOtherMeld(1);
		assertEquals(1,client1Meld.size());
		assertEquals("Pong",client1Meld.get(0).getName());
	}

	ByteArrayInputStream bos;
	
	private void setInput(String s) throws Exception {
		bos = new ByteArrayInputStream(s.getBytes());
		System.setIn(bos);
	}
}
