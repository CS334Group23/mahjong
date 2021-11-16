package utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMeld {

	@Test
	void testName1() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		String result = meld.getName();
		assertEquals("Pong",result);
	}
	
	@Test
	void testName2() {
		Meld meld = new Meld(new Tile(0),new Tile(4),new Tile(8),null);
		String result = meld.getName();
		assertEquals("Chow",result);
	}
	
	@Test
	void testName3() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
		String result = meld.getName();
		assertEquals("Kong",result);
	}
	
	@Test
	void testName4() {
		Meld meld = new Meld(new Tile(0),new Tile(1),null,null);
		String result = meld.getName();
		assertEquals("Eye",result);
	}
	
	@Test
	void testChnName1() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		String result = meld.getChnName();
		assertEquals("碰",result);
	}
	
	@Test
	void testChnName2() {
		Meld meld = new Meld(new Tile(0),new Tile(4),new Tile(8),null);
		String result = meld.getChnName();
		assertEquals("吃",result);
	}
	
	@Test
	void testChnName3() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
		String result = meld.getChnName();
		assertEquals("槓",result);
	}
	
	@Test
	void testChnName4() {
		Meld meld = new Meld(new Tile(0),new Tile(1),null,null);
		String result = meld.getChnName();
		assertEquals("眼",result);
	}
	
	@Test
	void testMeldName1() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		String result = meld.printMeld();
		assertEquals("幺鸡 幺鸡 幺鸡",result);
	}
	
	@Test
	void testMeldName2() {
		Meld meld = new Meld(new Tile(0),new Tile(4),new Tile(8),null);
		String result = meld.printMeld();
		assertEquals("幺鸡 二条 三条",result);
	}
	
	@Test
	void testMeldName3() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
		String result = meld.printMeld();
		assertEquals("幺鸡 幺鸡 幺鸡 幺鸡",result);
	}
	
	@Test
	void testMeldName4() {
		Meld meld = new Meld(new Tile(0),new Tile(1),null,null);
		String result = meld.printMeld();
		assertEquals("幺鸡 幺鸡",result);
	}
	
	@Test
	void testLength1() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		int result = meld.getMeldLength();
		assertEquals(3,result);
	}
	
	@Test
	void testLength2() {
		Meld meld = new Meld(new Tile(0),new Tile(4),new Tile(8),null);
		int result = meld.getMeldLength();
		assertEquals(3,result);
	}
	
	@Test
	void testLength3() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
		int result = meld.getMeldLength();
		assertEquals(4,result);
	}
	
	@Test
	void testLength4() {
		Meld meld = new Meld(new Tile(0),new Tile(1),null,null);
		int result = meld.getMeldLength();
		assertEquals(2,result);
	}

}
