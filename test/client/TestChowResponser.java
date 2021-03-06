/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: TestChowResponser.java </p> 
 * @author TeamCS3343 </a>
 */
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
import ui.textUi.TextUi;
import utils.BidType;
import utils.Meld;
import utils.Tile;

// TODO: Auto-generated Javadoc
/**
 * The Class TestChowResponser.
 */
class TestChowResponser {

	/**
	 * Test 1.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void test1() throws Exception {
		setInput("2");
		class StubClient extends Client{

			public StubClient(int aid, Peer server, String ui) {
				super(aid, server,ui);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(9,((DiscardMsg)msg).getTileId());
			}
		}
		ChowResponser chowResponser = new ChowResponser();
		StubClient client = new StubClient(1,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,8,9,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		Meld chow = new Meld(new Tile(0),new Tile(4),new Tile(8),null);
		chowResponser.response(client, new BidMsg(1,0, BidType.CHOW, "ChowResponser", 2,chow,null, false));
	}
	
	/**
	 * Test 2.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void test2() throws Exception {
		ChowResponser chowResponser = new ChowResponser();
		Client client1 = new Client(1,new Server(),"TEXT");
		client1.setUi(new TextUi(client1));
		Client client2 = new Client(2,new Server(),"TEXT");
		client2.setUi(new TextUi(client2));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,8,9,12,16,20,24,28,32,33,36,40));
		client1.initWall(a);
		ArrayList<Integer> b = new ArrayList<Integer> (Arrays.asList(3,4,10,11,13,17,21,25,29,34,35,45,50));
		client2.initWall(b);
		Meld chow = new Meld(new Tile(0),new Tile(4),new Tile(8),null);
		chowResponser.response(client2, new BidMsg(1,0, BidType.CHOW, "ChowResponser", 2,chow,null, false));
		ArrayList<Meld> client1Meld = client2.getOtherMeld(1);
		assertEquals(1,client1Meld.size());
		assertEquals("Chow",client1Meld.get(0).getName());
	}

	/** The bos. */
	ByteArrayInputStream bos;
	
	/**
	 * Sets the input.
	 *
	 * @param s the new input
	 * @throws Exception the exception
	 */
	private void setInput(String s) throws Exception {
		bos = new ByteArrayInputStream(s.getBytes());
		System.setIn(bos);
	}
}
