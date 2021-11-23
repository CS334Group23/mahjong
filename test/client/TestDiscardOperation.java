package client;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import network.BidMsg;
import network.DiscardMsg;
import network.DrawMsg;
import network.Message;
import network.Peer;
import server.Server;
import ui.textUi.TextUi;

class TestDiscardOperation {

	@Test
	//No condition, send Empty
	void test1() {
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((BidMsg)msg).getBidType(), 0);
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,4,8,12,16,20,24,28,32,33,34,36));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(40,2));
	}
	
	@Test
	//Condition Chow, Choose Chow
	void test2() throws Exception {
		setInput("1");
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((BidMsg)msg).getBidType(), 1);
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,4,8,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(44,0));
	}
	
	@Test
	//Condition Chow, Choose pass
	void test3() throws Exception {
		setInput("2");
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((BidMsg)msg).getBidType(), 0);
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,4,8,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(44,0));
	}
	
	@Test
	//Condition Pong, Choose Pong
	void test4() throws Exception {
		setInput("1");
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((BidMsg)msg).getBidType(), 2);
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,8,9,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(2,2));
	}
	
	@Test
	//Condition Pong, Choose Pass
	void test5() throws Exception {
		setInput("2");
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((BidMsg)msg).getBidType(), 0);
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,8,9,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(2,2));
	}
	
	@Test
	//Condition Kong, Pong, Choose Kong
	void test6() throws Exception {
		setInput("2");
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((BidMsg)msg).getBidType(), 3);
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,8,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(3,2));
	}
	
	@Test
	//Condition Kong, Pong, Choose Pong
	void test7() throws Exception {
		setInput("1");
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((BidMsg)msg).getBidType(), 2);
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,8,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(3,2));
	}
	
	@Test
	//Condition Kong, Pong, Choose Pass
	void test8() throws Exception {
		setInput("3");
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((BidMsg)msg).getBidType(), 0);
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,8,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(3,2));
	}
	
	@Test
	//Condition Win,Pong,Kong, Choose Win
	void test9() throws Exception {
		setInput("3");
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((BidMsg)msg).getBidType(), 4);
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,34));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(3,2));
	}
	
	@Test
	//Condition Win,Pong,Kong, Invalid Operation
	void test10() throws Exception {
		setInput("8");
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((BidMsg)msg).getBidType(), 0);
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,34));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(3,2));
	}
	
	@Test
	//Condition Win,Pong,Kong, Invalid Operation
	void test11() throws Exception {
		setInput("-3");
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((BidMsg)msg).getBidType(), 0);
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,34));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(3,2));
	}
	
	
	@Test
	//Condition the client is the message sender, default send empty
	void test12() {
		class StubClient extends Client{

			public StubClient(int aid, Peer server) {
				super(aid, server);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((BidMsg)msg).getBidType(), 0);
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server());
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,34));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(3,1));
	}
	
	ByteArrayInputStream bos;
	
	private void setInput(String s) throws Exception {
		bos = new ByteArrayInputStream(s.getBytes());
		System.setIn(bos);
	}
}
