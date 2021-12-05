package server;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import client.Client;
import network.BidMsg;
import network.Message;
import network.Peer;
import network.WinMsg;
import utils.Tile;

class TestWinOperation {

	@Test
	void test1() {
		class StubServer extends Server{

			public StubServer() {
				super();
			}
			
			public void sendAll(Message msg, int endClient) {
				assertEquals(1,((WinMsg)msg).getScores().get(0));
			}
		}
		ArrayList<Integer> a1 = new ArrayList<Integer> (Arrays.asList(4,8,36,37,56,60,64));
		ArrayList<Integer> a2 = new ArrayList<Integer> (Arrays.asList(0,5,16,65,84,88,108,116,132,133));
		ArrayList<Integer> a3 = new ArrayList<Integer> (Arrays.asList(61,66,80,85,89,90,92,93,109,134));
		ArrayList<Integer> a4 = new ArrayList<Integer> (Arrays.asList(6,7,17,38,39,62,63,68,81,94,110,111,117));
		ArrayList<Integer> scores = new ArrayList<Integer> (Arrays.asList(1,-1,0,0));
		WinMsg msg1 = new WinMsg(0,0,a1,scores,WinMsg.WINBYDISCARD);
		WinMsg msg2 = new WinMsg(1,0,a2,new ArrayList<Integer> (Arrays.asList(0,0,0,0)),WinMsg.TIE);
		WinMsg msg3 = new WinMsg(2,0,a3,new ArrayList<Integer> (Arrays.asList(0,0,0,0)),WinMsg.TIE);
		WinMsg msg4 = new WinMsg(3,0,a4,new ArrayList<Integer> (Arrays.asList(0,0,0,0)),WinMsg.TIE);
		StubServer server = new StubServer();
		WinOperation op = new WinOperation();
		op.operate(server, msg1);
		op.operate(server, msg2);
		op.operate(server, msg3);
		op.operate(server, msg4);
	}
	
	@Test
	void test2() {
		class StubServer extends Server{

			public StubServer() {
				super();
			}
			
			public void sendAll(Message msg, int endClient) {
				assertEquals(1,((WinMsg)msg).getScores().get(0));
			}
		}
		ArrayList<Integer> a1 = new ArrayList<Integer> (Arrays.asList(4,8,36,37,56,60,64));
		ArrayList<Integer> a2 = new ArrayList<Integer> (Arrays.asList(0,5,16,65,84,88,108,116,132,133));
		ArrayList<Integer> a3 = new ArrayList<Integer> (Arrays.asList(61,66,80,85,89,90,92,93,109,134));
		ArrayList<Integer> a4 = new ArrayList<Integer> (Arrays.asList(6,7,17,38,39,62,63,68,81,94,110,111,117));
		ArrayList<Integer> scores = new ArrayList<Integer> (Arrays.asList(1,-1,0,0));
		WinMsg msg1 = new WinMsg(0,0,a1,scores,WinMsg.WINBYDISCARD);
		WinMsg msg2 = new WinMsg(1,0,a2,new ArrayList<Integer> (Arrays.asList(0,0,0,0)),WinMsg.TIE);
		WinMsg msg3 = new WinMsg(2,0,a3,new ArrayList<Integer> (Arrays.asList(0,0,0,0)),WinMsg.TIE);
		WinMsg msg4 = new WinMsg(3,0,a4,new ArrayList<Integer> (Arrays.asList(0,0,0,0)),WinMsg.TIE);
		StubServer server = new StubServer();
		WinOperation op = new WinOperation();
		op.operate(server, msg2);
		op.operate(server, msg1);
		op.operate(server, msg3);
		op.operate(server, msg4);
	}
	
	@Test
	void test3() {
		class StubServer extends Server{

			public StubServer() {
				super();
			}
			
			public void sendAll(Message msg, int endClient) {
				assertEquals(1,((WinMsg)msg).getScores().get(0));
			}
		}
		ArrayList<Integer> a1 = new ArrayList<Integer> (Arrays.asList(4,8,36,37,56,60,64));
		ArrayList<Integer> a2 = new ArrayList<Integer> (Arrays.asList(0,5,16,65,84,88,108,116,132,133));
		ArrayList<Integer> a3 = new ArrayList<Integer> (Arrays.asList(61,66,80,85,89,90,92,93,109,134));
		ArrayList<Integer> a4 = new ArrayList<Integer> (Arrays.asList(6,7,17,38,39,62,63,68,81,94,110,111,117));
		ArrayList<Integer> scores = new ArrayList<Integer> (Arrays.asList(1,-1,0,0));
		WinMsg msg1 = new WinMsg(0,0,a1,scores,WinMsg.WINBYDISCARD);
		WinMsg msg2 = new WinMsg(1,0,a2,new ArrayList<Integer> (Arrays.asList(0,0,0,0)),WinMsg.TIE);
		WinMsg msg3 = new WinMsg(2,0,a3,new ArrayList<Integer> (Arrays.asList(0,0,0,0)),WinMsg.TIE);
		WinMsg msg4 = new WinMsg(3,0,a4,new ArrayList<Integer> (Arrays.asList(0,0,0,0)),WinMsg.TIE);
		StubServer server = new StubServer();
		WinOperation op = new WinOperation();
		op.operate(server, msg4);
		op.operate(server, msg2);
		op.operate(server, msg3);
		op.operate(server, msg1);
	}

}
