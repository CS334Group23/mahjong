/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: TestMeld.java </p> 
 * @author TeamCS3343 </a>
 */
package utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class TestMeld.
 */
class TestMeld {

	/**
	 * Test name 1.
	 */
	@Test
	void testName1() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		String result = meld.getName();
		assertEquals("Pong",result);
	}
	
	/**
	 * Test name 2.
	 */
	@Test
	void testName2() {
		Meld meld = new Meld(new Tile(0),new Tile(4),new Tile(8),null);
		String result = meld.getName();
		assertEquals("Chow",result);
	}
	
	/**
	 * Test name 3.
	 */
	@Test
	void testName3() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
		String result = meld.getName();
		assertEquals("Kong",result);
	}
	
	/**
	 * Test name 4.
	 */
	@Test
	void testName4() {
		Meld meld = new Meld(new Tile(0),new Tile(1),null,null);
		String result = meld.getName();
		assertEquals("Eye",result);
	}
	
	/**
	 * Test chn name 1.
	 */
	@Test
	void testChnName1() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		String result = meld.getChnName();
		assertEquals("碰",result);
	}
	
	/**
	 * Test chn name 2.
	 */
	@Test
	void testChnName2() {
		Meld meld = new Meld(new Tile(0),new Tile(4),new Tile(8),null);
		String result = meld.getChnName();
		assertEquals("吃",result);
	}
	
	/**
	 * Test chn name 3.
	 */
	@Test
	void testChnName3() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
		String result = meld.getChnName();
		assertEquals("槓",result);
	}
	
	/**
	 * Test chn name 4.
	 */
	@Test
	void testChnName4() {
		Meld meld = new Meld(new Tile(0),new Tile(1),null,null);
		String result = meld.getChnName();
		assertEquals("眼",result);
	}
	
	/**
	 * Test meld name 1.
	 */
	@Test
	void testMeldName1() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		String result = meld.printMeld();
		assertEquals("幺鸡 幺鸡 幺鸡",result);
	}
	
	/**
	 * Test meld name 2.
	 */
	@Test
	void testMeldName2() {
		Meld meld = new Meld(new Tile(0),new Tile(4),new Tile(8),null);
		String result = meld.printMeld();
		assertEquals("幺鸡 二条 三条",result);
	}
	
	/**
	 * Test meld name 3.
	 */
	@Test
	void testMeldName3() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
		String result = meld.printMeld();
		assertEquals("幺鸡 幺鸡 幺鸡 幺鸡",result);
	}
	
	/**
	 * Test meld name 4.
	 */
	@Test
	void testMeldName4() {
		Meld meld = new Meld(new Tile(0),new Tile(1),null,null);
		String result = meld.printMeld();
		assertEquals("幺鸡 幺鸡",result);
	}
	
	/**
	 * Test length 1.
	 */
	@Test
	void testLength1() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),null);
		int result = meld.getMeldLength();
		assertEquals(3,result);
	}
	
	/**
	 * Test length 2.
	 */
	@Test
	void testLength2() {
		Meld meld = new Meld(new Tile(0),new Tile(4),new Tile(8),null);
		int result = meld.getMeldLength();
		assertEquals(3,result);
	}
	
	/**
	 * Test length 3.
	 */
	@Test
	void testLength3() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
		int result = meld.getMeldLength();
		assertEquals(4,result);
	}
	
	/**
	 * Test length 4.
	 */
	@Test
	void testLength4() {
		Meld meld = new Meld(new Tile(0),new Tile(1),null,null);
		int result = meld.getMeldLength();
		assertEquals(2,result);
	}
	
	@Test
	void testgetFirst() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
		int result = meld.getFirst().getId();
		assertEquals(0,result);
	}
	
	@Test
	void testgetSecond() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
		int result = meld.getSecond().getId();
		assertEquals(1,result);
	}
	
	@Test
	void testgetThird() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
		int result = meld.getThird().getId();
		assertEquals(2,result);
	}
	
	@Test
	void testgetFourth() {
		Meld meld = new Meld(new Tile(0),new Tile(1),new Tile(2),new Tile(3));
		int result = meld.getForth().getId();
		assertEquals(3,result);
	}

}
