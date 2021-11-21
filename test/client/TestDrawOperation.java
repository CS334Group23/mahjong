package client;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import server.Server;
import ui.ClientInterface;
import ui.TextUi;
import utils.BidMsg;
import utils.BidType;
import utils.DiscardMsg;
import utils.DrawMsg;
import utils.Meld;
import utils.Message;
import utils.Peer;
import utils.Tile;

class TestDrawOperation {

	@Test
	//Condition Kong and Win, Choose Kong
	void test1() throws Exception {
		
		setInput("1");
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((BidMsg)msg).getBidType(), 3);
			}
		}
		DrawOperation drawOp = new DrawOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,34));
		client.initWall(a);
		drawOp.operate(client,new DrawMsg(3));
		
	}
	
	@Test
	//Condition Kong and Win, Choose Win
	void test2() throws Exception {
		setInput("2");
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((BidMsg)msg).getBidType(), 4);
			}
		}
		DrawOperation drawOp = new DrawOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,34));
		client.initWall(a);
		drawOp.operate(client,new DrawMsg(3));
	}
	
	@Test
	//Condition Kong, Choose Kong
	void test3() throws Exception {
		setInput("1");
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((BidMsg)msg).getBidType(), 3);
			}
		}
		DrawOperation drawOp = new DrawOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,36));
		client.initWall(a);
		drawOp.operate(client,new DrawMsg(3));
	}
	
	@Test
	//Condition Win, Choose Win
	void test4() throws Exception {
		setInput("1");
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((BidMsg)msg).getBidType(), 4);
			}
		}
		DrawOperation drawOp = new DrawOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,34));
		client.initWall(a);
		drawOp.operate(client,new DrawMsg(5));
	}
	
	@Test
	//Condition Kong, Choose Pass, discard 36
	void test5() throws Exception {
		setInput("2\n"+"13\n");
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((DiscardMsg)msg).getTileId(), 36);
			}
		}
		DrawOperation drawOp = new DrawOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,36));
		client.initWall(a);
		drawOp.operate(client,new DrawMsg(3));
	}
	
	@Test
	//No special condition, discard 36
	void test6() throws Exception {
		setInput("13");
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((DiscardMsg)msg).getTileId(), 36);
			}
		}
		DrawOperation drawOp = new DrawOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,36));
		client.initWall(a);
		drawOp.operate(client,new DrawMsg(25));
	}
	
	@Test
	//Condition Kong, Invalid operation, default choose pass, discard 36
	void test7() throws Exception {
		setInput("-1\n"+"13");
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((DiscardMsg)msg).getTileId(), 36);
			}
		}
		DrawOperation drawOp = new DrawOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,36));
		client.initWall(a);
		drawOp.operate(client,new DrawMsg(3));
	}
	
	ByteArrayInputStream bos;
	
	private void setInput(String s) throws Exception {
		bos = new ByteArrayInputStream(s.getBytes());
		System.setIn(bos);
	}


}
