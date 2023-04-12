package utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestType {

	@Test
	void testGetType() {
		assertEquals(Type.BAMBOO,Type.getType(0));
	}
	
	@Test
	void testGetTypeIndex() {
		Type type = Type.CHARACTER;
		assertEquals(1,type.getTypeIndex());
	}
	
	@Test
	void testGetStartId() {
		Type type = Type.DRAGON;
		assertEquals(108,type.getStartId());
	}
	
	@Test
	void testIsSameType1() {
		Type type = Type.FLOWER;
		assertEquals(true,type.isSameType(Type.FLOWER));
	}
	
	@Test
	void testIsSameType2() {
		Type type = Type.DOT;
		assertEquals(false,type.isSameType(Type.FLOWER));
	}

}
