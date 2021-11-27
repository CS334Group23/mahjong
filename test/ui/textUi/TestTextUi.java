/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: TestTextUi.java </p> 
 * @author TeamCS3343 </a>
 */
package ui.textUi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import client.Client;
import network.BidMsg;
import network.DealMsg;
import network.DiscardMsg;
import network.DrawMsg;
import network.DrawNoticeMsg;
import network.WinMsg;
import server.Server;
import utils.BidType;
import utils.Meld;
import utils.Tile;


// TODO: Auto-generated Javadoc
/**
 * The Class TestTextUi.
 */
class TestTextUi {

	/**
	 * Test info draw.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testInfoDraw() throws Exception {
		setOutput();
		Client client = new Client(1,new Server(),"TEXT");
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,28,36,37,40,44,56,57,68,69,72,76,84));
		client.initWall(a);
		TextUi textui = new TextUi(client);
		textui.infoDraw(new DrawMsg(0),null);
		assertEquals("You are client1\n"
				+ "                    1    2    3    4    5    6    7    8    9    10    11    12    13\n"
				+ "Client1 has cards: 六条 /八条 /一万 /一万 /二万 /三万 /六万 /六万 /九万 /九万 /一筒 /二筒 /四筒 /\n"
				+ "Client1 draws card 幺鸡\n",getOutput());
	}
	
	/**
	 * Test info draw kong.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testInfoDrawKong() throws Exception {
		setOutput();
		Client client = new Client(1,new Server(),"TEXT");
		ArrayList<BidMsg> possibleBid = new ArrayList<>();
		Meld kong =new Meld(new Tile(36),new Tile(37),new Tile(38),new Tile(39));
		possibleBid.add(new BidMsg(client.getId(),client.getId(), BidType.KONG, "KongResponser", 39,kong, null, true));
		possibleBid.add(new BidMsg(client.getId(),client.getId(), BidType.EMPTY, "EmptyResponser", 39,null, null, true));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,28,36,37,38,44,56,57,68,69,72,76,84));
		client.initWall(a);
		TextUi textui = new TextUi(client);
		textui.infoDraw(new DrawMsg(39),possibleBid);
		assertEquals("You are client1\n"
				+ "                    1    2    3    4    5    6    7    8    9    10    11    12    13\n"
				+ "Client1 has cards: 六条 /八条 /一万 /一万 /一万 /三万 /六万 /六万 /九万 /九万 /一筒 /二筒 /四筒 /\n"
				+ "Client1 draws card 一万\n"
				+ "                    1    2\n"
				+"You have options:杠 一万 一万 一万 一万 /过 /\n",getOutput());
	}
	
	/**
	 * Test info draw win.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testInfoDrawWin() throws Exception {
		setOutput();
		Client client = new Client(1,new Server(),"TEXT");
		ArrayList<BidMsg> possibleBid = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,24,28,37,38,56,57,58,68,69,72,76,80));
		client.initWall(a);
		possibleBid.add(new BidMsg(client.getId(),client.getId(), BidType.WIN, "WinResponser", 39,null, Tile.tileToIdList(client.getWall()), true));
		possibleBid.add(new BidMsg(client.getId(),client.getId(), BidType.EMPTY, "EmptyResponser", 39,null, null, true));
		TextUi textui = new TextUi(client);
		textui.infoDraw(new DrawMsg(39),possibleBid);
		assertEquals("You are client1\n"
				+ "                    1    2    3    4    5    6    7    8    9    10    11    12    13\n"
				+ "Client1 has cards: 六条 /七条 /八条 /一万 /一万 /六万 /六万 /六万 /九万 /九万 /一筒 /二筒 /三筒 /\n"
				+ "Client1 draws card 一万\n"
				+ "                    1    2\n"
				+"You have options:胡 /过 /\n",getOutput());
	}
	
	/**
	 * Test info draw kong win.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testInfoDrawKongWin() throws Exception {
		setOutput();
		Client client = new Client(1,new Server(),"TEXT");
		ArrayList<BidMsg> possibleBid = new ArrayList<>();
		Meld kong =new Meld(new Tile(36),new Tile(37),new Tile(38),new Tile(39));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,24,28,36,37,38,40,44,68,69,72,76,80));
		client.initWall(a);
		possibleBid.add(new BidMsg(client.getId(),client.getId(), BidType.KONG, "KongResponser", 39,kong, null, true));
		possibleBid.add(new BidMsg(client.getId(),client.getId(), BidType.WIN, "WinResponser", 39,null, Tile.tileToIdList(client.getWall()), true));
		possibleBid.add(new BidMsg(client.getId(),client.getId(), BidType.EMPTY, "EmptyResponser", 39,null, null, true));
		TextUi textui = new TextUi(client);
		textui.infoDraw(new DrawMsg(39),possibleBid);
		assertEquals("You are client1\n"
				+ "                    1    2    3    4    5    6    7    8    9    10    11    12    13\n"
				+ "Client1 has cards: 六条 /七条 /八条 /一万 /一万 /一万 /二万 /三万 /九万 /九万 /一筒 /二筒 /三筒 /\n"
				+ "Client1 draws card 一万\n"
				+ "                    1    2    3\n"
				+"You have options:杠 一万 一万 一万 一万 /胡 /过 /\n",getOutput());
	}
	
	/**
	 * Test info draw empty.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testInfoDrawEmpty() throws Exception {
		setOutput();
		Client client = new Client(1,new Server(),"TEXT");
		ArrayList<BidMsg> possibleBid = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,28,36,37,40,44,56,57,68,69,72,76,84));
		client.initWall(a);
		TextUi textui = new TextUi(client);
		textui.infoDraw(new DrawMsg(0),possibleBid);
		assertEquals("You are client1\n"
				+ "                    1    2    3    4    5    6    7    8    9    10    11    12    13\n"
				+ "Client1 has cards: 六条 /八条 /一万 /一万 /二万 /三万 /六万 /六万 /九万 /九万 /一筒 /二筒 /四筒 /\n"
				+ "Client1 draws card 幺鸡\n",getOutput());
	}
	
	/**
	 * Test get op index.
	 *
	 * @throws Exception the exception
	 */
	@Test 
	void testGetOpIndex() throws Exception{
		setOutput();
		setInput("1");
		Client client = new Client(1,new Server(),"TEXT");
		TextUi textui = new TextUi(client);
		int result = textui.getOpIndex();
		assertEquals("Please input the index of the operation: ",getOutput());
		assertEquals(0,result);
	}
	
	/**
	 * Test get op index 2.
	 *
	 * @throws Exception the exception
	 */
	@Test 
	void testGetOpIndex2() throws Exception{
		setOutput();
		setInput("\n");
		Client client = new Client(1,new Server(),"TEXT");
		TextUi textui = new TextUi(client);
		int result = textui.getOpIndex();
		assertEquals("Please input the index of the operation: ",getOutput());
		assertEquals(-1,result);
	}
	
	/**
	 * Test get discard 1.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testGetDiscard1() throws Exception {
		setOutput();
		setInput("1");
		Client client = new Client(1,new Server(),"TEXT");
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,24,28,36,37,38,40,44,68,69,72,76,80));
		client.initWall(a);
		client.addTile(30);
		TextUi textui = new TextUi(client);
		int result = textui.getDiscard();
		assertEquals("Please Input the index of the card you want to play (If you want to discard the card you draw, type 14):",getOutput());
		assertEquals(1,result);
	}
	
	/**
	 * Test get discard 2.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testGetDiscard2() throws Exception {
		setOutput();
		setInput("\n");
		Client client = new Client(1,new Server(),"TEXT");
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,24,28,36,37,38,40,44,68,69,72,76,80));
		client.initWall(a);
		client.addTile(30);
		TextUi textui = new TextUi(client);
		int result = textui.getDiscard();
		assertEquals("Please Input the index of the card you want to play (If you want to discard the card you draw, type 14):",getOutput());
		assertEquals(14,result);
	}
	
	/**
	 * Test get discard 3.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testGetDiscard3() throws Exception {
		setOutput();
		setInput("-1\n1");
		Client client = new Client(1,new Server(),"TEXT");
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,24,28,36,37,38,40,44,68,69,72,76,80));
		client.initWall(a);
		client.addTile(30);
		TextUi textui = new TextUi(client);
		int result = textui.getDiscard();
		assertEquals("Please Input the index of the card you want to play (If you want to discard the card you draw, type 14):"
					+"Invalid input. Please input again: ",getOutput());
		assertEquals(1,result);
	}
	
	/**
	 * Test get discard 4.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testGetDiscard4() throws Exception {
		setOutput();
		setInput("15\n1");
		Client client = new Client(1,new Server(),"TEXT");
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,24,28,36,37,38,40,44,68,69,72,76,80));
		client.initWall(a);
		client.addTile(30);
		TextUi textui = new TextUi(client);
		int result = textui.getDiscard();
		assertEquals("Please Input the index of the card you want to play (If you want to discard the card you draw, type 14):"
					+"Invalid input. Please input again: ",getOutput());
		assertEquals(1,result);
	}
	
	/**
	 * Test info discard.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testInfoDiscard() throws Exception {
		setOutput();
		Client client = new Client(1,new Server(),"TEXT");
		ArrayList<BidMsg> possibleBid = new ArrayList<>();
		Meld kong =new Meld(new Tile(36),new Tile(37),new Tile(38),new Tile(39));
		possibleBid.add(new BidMsg(client.getId(),3, BidType.KONG, "KongResponser", 39,kong, null, true));
		possibleBid.add(new BidMsg(client.getId(),3, BidType.EMPTY, "EmptyResponser", 39,null, null, true));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,28,36,37,38,44,56,57,68,69,72,76,84));
		client.initWall(a);
		TextUi textui = new TextUi(client);
		textui.infoDiscard(new DiscardMsg(39,3),possibleBid);
		assertEquals("You are client1\n"
				+ "Client3 discards 一万\n"
				+ "                    1    2\n"
				+"You have options:杠 一万 一万 一万 一万 /过 /\n"
				+"Client1 has cards: 六条 /八条 /一万 /一万 /一万 /三万 /六万 /六万 /九万 /九万 /一筒 /二筒 /四筒 /\n",getOutput());
	}
	
	/**
	 * Test info discard null.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testInfoDiscardNull() throws Exception {
		setOutput();
		Client client = new Client(1,new Server(),"TEXT");
		ArrayList<BidMsg> possibleBid = new ArrayList<>();
		Meld kong =new Meld(new Tile(36),new Tile(37),new Tile(38),new Tile(39));
		possibleBid.add(new BidMsg(client.getId(),3, BidType.KONG, "KongResponser", 39,kong, null, true));
		possibleBid.add(new BidMsg(client.getId(),3, BidType.EMPTY, "EmptyResponser", 39,null, null, true));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,28,36,37,38,44,56,57,68,69,72,76,84));
		client.initWall(a);
		TextUi textui = new TextUi(client);
		textui.infoDiscard(new DiscardMsg(39,3),null);
		assertEquals("You are client1\n"
				+ "Client3 discards 一万\n",getOutput());
	}
	
	/**
	 * Test info discard empty.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testInfoDiscardEmpty() throws Exception {
		setOutput();
		Client client = new Client(1,new Server(),"TEXT");
		ArrayList<BidMsg> possibleBid = new ArrayList<>();
		Meld kong =new Meld(new Tile(36),new Tile(37),new Tile(38),new Tile(39));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,28,36,37,38,44,56,57,68,69,72,76,84));
		client.initWall(a);
		TextUi textui = new TextUi(client);
		textui.infoDiscard(new DiscardMsg(39,3),possibleBid);
		assertEquals("You are client1\n"
				+ "Client3 discards 一万\n",getOutput());
	}
	
	/**
	 * Test info bid 1.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testInfoBid1() throws Exception {
		setOutput();
		Client client = new Client(1,new Server(),"TEXT");
		Meld pong =new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		BidMsg bidMsg = new BidMsg(0,3, BidType.PONG, "PongResponser", 2,pong,null, false);
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,28,36,37,38,44,56,57,68,69,72,76,84));
		client.initWall(a);
		TextUi textui = new TextUi(client);
		textui.infoBid(bidMsg);
		assertEquals("client0 plays the operation 碰\n"
				    +"                    1    2    3    4    5    6    7    8    9    10    11    12    13\n"
					+ "Client1 has cards: 六条 /八条 /一万 /一万 /一万 /三万 /六万 /六万 /九万 /九万 /一筒 /二筒 /四筒 /\n",getOutput());
	}
	
	/**
	 * Test info bid 2.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testInfoBid2() throws Exception {
		setOutput();
		Client client = new Client(1,new Server(),"TEXT");
		Meld kong =new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
		BidMsg bidMsg = new BidMsg(0,3, BidType.KONG, "KongResponser", 2,kong,null, false);
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,28,36,37,38,44,56,57,68,69,72,76,84));
		client.initWall(a);
		TextUi textui = new TextUi(client);
		textui.infoBid(bidMsg);
		assertEquals("client0 plays the operation 杠\n",getOutput());
	}
	
	/**
	 * Test info bid 3.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testInfoBid3() throws Exception {
		setOutput();
		Client client = new Client(1,new Server(),"TEXT");
		Meld chow =new Meld(new Tile(0),new Tile(4),new Tile(8),null);
		BidMsg bidMsg = new BidMsg(0,3, BidType.CHOW, "ChowResponser", 8,chow,null, false);
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,28,36,37,38,44,56,57,68,69,72,76,84));
		client.initWall(a);
		TextUi textui = new TextUi(client);
		textui.infoBid(bidMsg);
		assertEquals("client0 plays the operation 吃\n"
				    +"                    1    2    3    4    5    6    7    8    9    10    11    12    13\n"
					+ "Client1 has cards: 六条 /八条 /一万 /一万 /一万 /三万 /六万 /六万 /九万 /九万 /一筒 /二筒 /四筒 /\n",getOutput());
	}
	
	/**
	 * Test info deal.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testInfoDeal() throws Exception {
		setOutput();
		Client client = new Client(1,new Server(),"TEXT");
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,28,36,37,38,44,56,57,68,69,72,76,84));
		client.initWall(a);
		TextUi textui = new TextUi(client);
		textui.infoDeal(new DealMsg(a));
		assertEquals("Client1 has cards: 六条 /八条 /一万 /一万 /一万 /三万 /六万 /六万 /九万 /九万 /一筒 /二筒 /四筒 /\n",getOutput());
	}
	
	/**
	 * Test info win.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testInfoWin() throws Exception {
		setOutput();
		ArrayList<ArrayList<Integer>> hands = new ArrayList<>();
		ArrayList<Integer> a1 = new ArrayList<Integer> (Arrays.asList(4,8,36,37,56,60,64));
		ArrayList<Integer> a2 = new ArrayList<Integer> (Arrays.asList(0,5,16,65,84,88,108,116,132,133));
		ArrayList<Integer> a3 = new ArrayList<Integer> (Arrays.asList(61,66,80,85,89,90,92,93,109,134));
		ArrayList<Integer> a4 = new ArrayList<Integer> (Arrays.asList(6,7,17,38,39,62,63,68,81,94,110,111,117));
		ArrayList<Integer> scores = new ArrayList<Integer> (Arrays.asList(1,-1,0,0));
		WinMsg msg = new WinMsg(0,0,null,scores,WinMsg.WINBYDISCARD);
		msg.addHand(0, a1);
		msg.addHand(1, a2);
		msg.addHand(2, a3);
		msg.addHand(3, a4);
		Client client = new Client(0,new Server(),"TEXT");
		TextUi textui = new TextUi(client);
		textui.infoWin(msg);
		assertEquals("client0 wins\n"
				+ "The hand of client 0 is 二条 /三条 /一万 /一万 /六万 /七万 /八万 /\n"
				+ "The hand of client 1 is 幺鸡 /二条 /五条 /八万 /四筒 /五筒 /红中 /白板 /北风 /北风 /\n"
				+ "The hand of client 2 is 七万 /八万 /三筒 /四筒 /五筒 /五筒 /六筒 /六筒 /红中 /北风 /\n"
				+ "The hand of client 3 is 二条 /二条 /五条 /一万 /一万 /七万 /七万 /九万 /三筒 /六筒 /红中 /红中 /白板 /\n",getOutput());
	}
	
	/**
	 * Test infor draw notice.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testInforDrawNotice() throws Exception {
		setOutput();
		Client client = new Client(1,new Server(),"TEXT");
		DrawNoticeMsg msg = new DrawNoticeMsg(2);
		TextUi textui = new TextUi(client);
		textui.infoDrawNotice(msg);
		assertEquals("server will send a draw to client: 2\n",getOutput());
	}
	
	/**
	 * Test init.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testInit() throws Exception {
		setOutput();
		Client client = new Client(1,new Server(),"TEXT");
		TextUi textui = new TextUi(client);
		textui.init(client);
		assertEquals("text ui init\n",getOutput());
	}
	
	
	
	
	
	/** ************************************ Note: Do not modify the following part *************************************. */
	PrintStream oldPrintStream;
	
	/** The bos. */
	ByteArrayOutputStream bos;

	/**
	 * Sets the output.
	 *
	 * @throws Exception the exception
	 */
	private void setOutput() throws Exception {
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
	}

	/**
	 * Gets the output.
	 *
	 * @return the output
	 */
	private String getOutput() { // throws Exception
		System.setOut(oldPrintStream);
		return bos.toString();
	}
	
	/** The input. */
	ByteArrayInputStream input;
	
	/**
	 * Sets the input.
	 *
	 * @param s the new input
	 * @throws Exception the exception
	 */
	private void setInput(String s) throws Exception {
		input = new ByteArrayInputStream(s.getBytes());
		System.setIn(input);
	}

}
