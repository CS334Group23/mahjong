/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: TestBidOperation.java </p> 
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
 * The Class TestBidOperation.
 */
class TestBidOperation {

	/**
	 * Test chow 1.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testChow1() throws Exception {
		setInput("2");
		class StubClient extends Client{

			public StubClient(int aid, Peer server, String ui) {
				super(aid, server,ui);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(9,((DiscardMsg)msg).getTileId());
			}
		}
		BidOperation bid = new BidOperation();
		StubClient client = new StubClient(1,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,8,9,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		Meld chow = new Meld(new Tile(0),new Tile(4),new Tile(8),null);
		bid.operate(client, new BidMsg(1,0, BidType.CHOW, "ChowResponser", 2,chow,null, false));
	}
	
	/**
	 * Test pong 1.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testPong1() throws Exception {
		setInput("1");
		class StubClient extends Client{

			public StubClient(int aid, Peer server, String ui) {
				super(aid, server,ui);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(8, ((DiscardMsg)msg).getTileId());
			}
		}
		BidOperation bid = new BidOperation();
		StubClient client = new StubClient(1,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,8,9,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		Meld pong = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		bid.operate(client, new BidMsg(1,3, BidType.PONG, "PongResponser", 2,pong,null, false));
	}
	
	/**
	 * Test kong 1.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testKong1() throws Exception {
		BidOperation bid = new BidOperation();
		Client client = new Client(1,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,9,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		Meld kong = new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
		bid.operate(client, new BidMsg(1,0, BidType.KONG, "KongResponser", 3,kong,null, false));
		assertEquals(1,client.getMeld().size());
		assertEquals("Kong",client.getMeld().get(0).getName());
	}
	
//	@Test
//	void testException() throws Exception {
//		BidOperation bid = new BidOperation();
//		Client client = new Client(1,new Server());
//		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,9,12,16,20,24,28,32,33,36,40));
//		client.initWall(a);
//		Meld kong = new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
//		bid.operate(client, new BidMsg(1, BidType.KONG, "KongResponser", 3,kong,null, false));
//		ClassNotFoundException thrown = assertThrows(ClassNotFoundException.class, () -> {
//			bid.operate(client, new BidMsg(1, BidType.KONG, "FakeResponser", 3,kong,null, false));
//		});
//	}
	
	
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
