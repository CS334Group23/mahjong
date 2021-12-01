package network;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDiscardMsg {

	@Test
	void testOperationName() {
		DiscardMsg msg = new DiscardMsg(40,2);
		assertEquals("DiscardOperation",msg.getOperationName());
	}
	
	@Test
	void testSenderId() {
		DiscardMsg msg = new DiscardMsg(40,2);
		assertEquals(2,msg.getSenderId());
	}

	@Test
	void testTileId() {
		DiscardMsg msg = new DiscardMsg(40,2);
		assertEquals(40,msg.getTileId());
	}
}
