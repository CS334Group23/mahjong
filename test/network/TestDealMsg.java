package network;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class TestDealMsg {

	@Test
	void testOperationName() {
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,28,36,37,38,44,56,57,68,69,72,76,84));
		DealMsg msg = new DealMsg(a);
		assertEquals("DealOperation",msg.getOperationName());
	}
	
	@Test
	void testInitialCards() {
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,28,36,37,38,44,56,57,68,69,72,76,84));
		DealMsg msg = new DealMsg(a);
		assertEquals(a,msg.getInitCards());
	}

}
