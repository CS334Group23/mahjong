/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: TestDiscardOperation.java </p> 
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
import network.DrawMsg;
import network.Message;
import network.Peer;
import server.Server;
import ui.textUi.TextUi;

// TODO: Auto-generated Javadoc
/**
 * The Class TestDiscardOperation.
 */
class TestDiscardOperation {

	/**
	 * Test 1.
	 */
	@Test
	//No condition, send Empty
	void test1() {
		class StubClient extends Client{

			public StubClient(int aid, Peer server, String ui) {
				super(aid, server,ui);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(0, ((BidMsg)msg).getBidType());
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,4,8,12,16,20,24,28,32,33,34,36));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(40,2));
	}
	
	/**
	 * Test 2.
	 *
	 * @throws Exception the exception
	 */
	@Test
	//Condition Chow, Choose Chow
	void test2() throws Exception {
		setInput("1");
		class StubClient extends Client{

			public StubClient(int aid, Peer server, String ui) {
				super(aid, server,ui);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(1,((BidMsg)msg).getBidType());
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,4,8,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(44,0));
	}
	
	/**
	 * Test 3.
	 *
	 * @throws Exception the exception
	 */
	@Test
	//Condition Chow, Choose pass
	void test3() throws Exception {
		setInput("2");
		class StubClient extends Client{

			public StubClient(int aid, Peer server, String ui) {
				super(aid, server, ui);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(0,((BidMsg)msg).getBidType());
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,4,8,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(44,0));
	}
	
	/**
	 * Test 4.
	 *
	 * @throws Exception the exception
	 */
	@Test
	//Condition Pong, Choose Pong
	void test4() throws Exception {
		setInput("1");
		class StubClient extends Client{

			public StubClient(int aid, Peer server, String ui) {
				super(aid, server,ui);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(2,((BidMsg)msg).getBidType());
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,8,9,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(2,2));
	}
	
	/**
	 * Test 5.
	 *
	 * @throws Exception the exception
	 */
	@Test
	//Condition Pong, Choose Pass
	void test5() throws Exception {
		setInput("2");
		class StubClient extends Client{

			public StubClient(int aid, Peer server, String ui) {
				super(aid, server,ui);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(0,((BidMsg)msg).getBidType());
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,8,9,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(2,2));
	}
	
	/**
	 * Test 6.
	 *
	 * @throws Exception the exception
	 */
	@Test
	//Condition Kong, Pong, Choose Kong
	void test6() throws Exception {
		setInput("2");
		class StubClient extends Client{

			public StubClient(int aid, Peer server, String ui) {
				super(aid, server,ui);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(3,((BidMsg)msg).getBidType());
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,8,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(3,2));
	}
	
	/**
	 * Test 7.
	 *
	 * @throws Exception the exception
	 */
	@Test
	//Condition Kong, Pong, Choose Pong
	void test7() throws Exception {
		setInput("1");
		class StubClient extends Client{

			public StubClient(int aid, Peer server, String ui) {
				super(aid, server,ui);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(2,((BidMsg)msg).getBidType());
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,8,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(3,2));
	}
	
	/**
	 * Test 8.
	 *
	 * @throws Exception the exception
	 */
	@Test
	//Condition Kong, Pong, Choose Pass
	void test8() throws Exception {
		setInput("3");
		class StubClient extends Client{

			public StubClient(int aid, Peer server, String ui) {
				super(aid, server,ui);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(0,((BidMsg)msg).getBidType());
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,8,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(3,2));
	}
	
	/**
	 * Test 9.
	 *
	 * @throws Exception the exception
	 */
	@Test
	//Condition Win,Pong,Kong, Choose Win
	void test9() throws Exception {
		setInput("3");
		class StubClient extends Client{

			public StubClient(int aid, Peer server, String ui) {
				super(aid, server, ui);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(4,((BidMsg)msg).getBidType());
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,34));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(3,2));
	}
	
	/**
	 * Test 10.
	 *
	 * @throws Exception the exception
	 */
	@Test
	//Condition Win,Pong,Kong, Invalid Operation
	void test10() throws Exception {
		setInput("8");
		class StubClient extends Client{

			public StubClient(int aid, Peer server, String ui) {
				super(aid, server,ui);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(0,((BidMsg)msg).getBidType());
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,34));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(3,2));
	}
	
	/**
	 * Test 11.
	 *
	 * @throws Exception the exception
	 */
	@Test
	//Condition Win,Pong,Kong, Invalid Operation
	void test11() throws Exception {
		setInput("-3");
		class StubClient extends Client{

			public StubClient(int aid, Peer server, String ui) {
				super(aid, server,ui);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(0,((BidMsg)msg).getBidType());
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,34));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(3,2));
	}
	
	
	/**
	 * Test 12.
	 */
	@Test
	//Condition the client is the message sender, default send empty
	void test12() {
		class StubClient extends Client{

			public StubClient(int aid, Peer server, String ui) {
				super(aid, server,ui);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(0,((BidMsg)msg).getBidType());
			}
		}
		DiscardOperation discardOp = new DiscardOperation();
		StubClient client = new StubClient(1,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,34));
		client.initWall(a);
		discardOp.operate(client,new DiscardMsg(3,1));
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
