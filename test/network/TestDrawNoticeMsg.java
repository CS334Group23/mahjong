package network;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDrawNoticeMsg {

	@Test
	void testOperationName() {
		DrawNoticeMsg msg = new DrawNoticeMsg(0);
		assertEquals("DrawNoticeOperation",msg.getOperationName());
	}
	
	@Test
	void testClientId() {
		DrawNoticeMsg msg = new DrawNoticeMsg(0);
		assertEquals(0,msg.getClientId());
	}

}
