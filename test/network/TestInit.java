package network;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestInit {

	@Test
	void test() {
		InitMsg msg = new InitMsg();
		assertEquals("InitOperation",msg.getOperationName());
	}

}
