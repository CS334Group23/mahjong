package network;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDrawMsg {

	@Test
	void testOperationName() {
		DrawMsg msg = new DrawMsg(10);
		assertEquals("DrawOperation",msg.getOperationName());
	}
	
	
	@Test
	void testTileId() {
		DrawMsg msg = new DrawMsg(10);
		assertEquals(10,msg.getTileId());
	}
}
