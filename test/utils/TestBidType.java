package utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBidType {

	@Test
	void testBidType() {
		BidType bid = BidType.CHOW;
		assertEquals(1,bid.getBidType());
	}
	@Test
	void testChnName() {
		BidType bid = BidType.CHOW;
		assertEquals("吃",bid.getChnName());
	}
}
