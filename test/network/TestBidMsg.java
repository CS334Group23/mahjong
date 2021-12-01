package network;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import utils.BidType;
import utils.Meld;
import utils.Tile;

class TestBidMsg {

	@Test
	void testName() {
		Meld pong = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		BidMsg msg = new BidMsg(1,3, BidType.PONG, "PongResponser", 2,pong,null, false);
		assertEquals("BidOperation",msg.getOperationName());
	}
	
	@Test
	void testCompare() {
		Meld chow = new Meld(new Tile(0),new Tile(4),new Tile(8),null);
		BidMsg msg1 = new BidMsg(1,0, BidType.CHOW, "ChowResponser", 2,chow,null, false);
		Meld pong = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		BidMsg msg2 = new BidMsg(1,3, BidType.PONG, "PongResponser", 2,pong,null, false);
		assertEquals(1,msg1.compareTo(msg2));
	}
	
	@Test
	void testResponser() {
		Meld pong = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		BidMsg msg = new BidMsg(1,3, BidType.PONG, "PongResponser", 2,pong,null, false);
		assertEquals("PongResponser",msg.getResponserName());
	}
	
	@Test
	void testBidClient() {
		Meld pong = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		BidMsg msg = new BidMsg(1,3, BidType.PONG, "PongResponser", 2,pong,null, false);
		assertEquals(1,msg.getBidClient());
	}
	
	@Test
	void testMeld() {
		Meld pong = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		BidMsg msg = new BidMsg(1,3, BidType.PONG, "PongResponser", 2,pong,null, false);
		assertEquals(2,msg.getMeld().getcomb_type());
	}
	
	@Test
	void testBidType() {
		Meld pong = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		BidMsg msg = new BidMsg(1,3, BidType.PONG, "PongResponser", 2,pong,null, false);
		assertEquals(BidType.PONG.getBidType(),msg.getBidType());
	}
	
	@Test
	void testChnName() {
		Meld pong = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		BidMsg msg = new BidMsg(1,3, BidType.PONG, "PongResponser", 2,pong,null, false);
		assertEquals("碰",msg.getChnName());
	}
	
	@Test
	void testWinHand() {
		Meld pong = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		BidMsg msg = new BidMsg(1,3, BidType.PONG, "PongResponser", 2,pong,null, false);
		assertEquals(null,msg.getWinHand());
	}
	
	@Test
	void testSelfDrawn() {
		Meld pong = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		BidMsg msg = new BidMsg(1,3, BidType.PONG, "PongResponser", 2,pong,null, false);
		assertEquals(false,msg.isSelfDrawn());
	}
	
	@Test
	void testTileId() {
		Meld pong = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		BidMsg msg = new BidMsg(1,3, BidType.PONG, "PongResponser", 2,pong,null, false);
		assertEquals(2,msg.getTileId());
	}
	
	@Test
	void testPreviousClient() {
		Meld pong = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		BidMsg msg = new BidMsg(1,3, BidType.PONG, "PongResponser", 2,pong,null, false);
		assertEquals(3,msg.getPreviousClient());
	}
	
	@Test
	void testPrintBid1()throws Exception {
		setOutput();
		Meld pong = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		ArrayList<BidMsg> msgs = new ArrayList<>();
		msgs.add(new BidMsg(1,3, BidType.PONG, "PongResponser", 2,pong,null, false));
		msgs.add(new BidMsg(1,3, BidType.EMPTY, "EmptyResponser", 39,null, null, true));
		BidMsg.printBid(msgs);
		assertEquals("碰 幺鸡 幺鸡 幺鸡 /过 /\n",getOutput());
	}
	
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

}
