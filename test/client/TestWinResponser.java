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
import ui.textUi.TextUi;
import utils.BidType;
import utils.Meld;
import utils.Tile;

class TestWinResponser {

	@Test
	//self drawn win
	void test1() {
		class StubClient extends Client{

			public StubClient(int aid, Peer server, String ui) {
				super(aid, server,ui);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((WinMsg)msg).getScores().get(1), 6);
			}
		}
		WinResponser winResponser = new WinResponser();
		StubClient client = new StubClient(1,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,9,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		winResponser.response(client, new BidMsg(1,1, BidType.WIN, "WinResponser", 44,null,Tile.tileToIdList(client.getWall()), true));
	}
	
	@Test
	//win by discard
	void test2() {
		class StubClient extends Client{

			public StubClient(int aid, Peer server, String ui) {
				super(aid, server,ui);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((WinMsg)msg).getScores().get(1), 1);
			}
		}
		WinResponser winResponser = new WinResponser();
		StubClient client = new StubClient(1,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,9,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		winResponser.response(client, new BidMsg(1,0, BidType.WIN, "WinResponser", 44,null,Tile.tileToIdList(client.getWall()), false));
	}
	
	@Test
	//not win
	void test3() {
		class StubClient extends Client{

			public StubClient(int aid, Peer server, String ui) {
				super(aid, server,ui);
			}
			
			public void send(Peer target, Message msg) {
				assertEquals(((WinMsg)msg).getScores().get(1), 0);
			}
		}
		WinResponser winResponser = new WinResponser();
		StubClient client = new StubClient(2,new Server(),"TEXT");
		client.setUi(new TextUi(client));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,9,12,16,20,24,28,32,33,36,40));
		client.initWall(a);
		winResponser.response(client, new BidMsg(1,0, BidType.WIN, "WinResponser", 44,null,Tile.tileToIdList(client.getWall()), false));
	}

}
