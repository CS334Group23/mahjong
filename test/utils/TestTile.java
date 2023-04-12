/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: TileTest.java </p> 
 * @author TeamCS3343 </a>
 */
package utils;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class TileTest.
 */
class TestTile {

	/**
	 * Test id to rank index.
	 */
	@Test
	void testIdToRankIndex() {
		Tile t = new Tile(1);
		int idx = t.getRankIndex();
		//System.out.println(idx);
		assertEquals(0,idx);
	}
	
	/**
	 * Test id to type.
	 */
	@Test
	void testIdToType1() {
		Tile t = new Tile(1);
		Type type = t.getType();
		//System.out.println(type);
		assertEquals(Type.BAMBOO,type);
	}
	
	@Test
	void testIdToType2() {
		Tile t = new Tile(108);
		Type type = t.getType();
		//System.out.println(type);
		assertEquals(Type.DRAGON,type);
	}
	
	@Test
	void testIdToType3() {
		Tile t = new Tile(128);
		Type type = t.getType();
		//System.out.println(type);
		assertEquals(Type.WIND,type);
	}

	/**
	 * Test id to name.
	 */
	@Test
	void testIdToName() {
		Tile t = new Tile(138);
		String name = t.getName();
		//System.out.println(name);
		assertEquals("Autumn",name);
		
	}
	
	/**
	 * Test get url.
	 */
	@Test
	void testSetUrl() {
		Tile t = new Tile(143);
		t.setUrl("resource/static/tiles/facedown-1.png");
		String url = t.getUrl();
		assertEquals("resource/static/tiles/facedown-1.png", url);
	}
	
	@Test
	void testGetUrl() {
		Tile t = new Tile(144);
		String url = t.getUrl();
		assertEquals("resource/static/tiles/facedown-1.png", url);
	}
	/**
	 * Test tile to id list.
	 */
	@Test
	void testTileToIdList() {
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,34,70));
		for(Integer i:a) {
			hand.add(new Tile(i));
		}
		ArrayList<Integer> result;
		result = Tile.tileToIdList(hand);
		assertEquals(a, result);
	}
	
	/**
	 * Test tile list to string.
	 */
	@Test 
	void testTileListToString(){
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,34));
		String s = "幺鸡 /幺鸡 /幺鸡 /二条 /三条 /四条 /五条 /六条 /七条 /八条 /九条 /九条 /九条 /";
		ArrayList<Tile> wall = Tile.idToTileList(a);
		String result = Tile.tileListToString(wall);
		assertEquals(s,result);
	}
	
	/**
	 * Test is same type 1.
	 */
	@Test
	void testIsSameType1() {
		Tile tile1 = new Tile(0);
		Tile tile2 = new Tile(1);
		boolean result = Tile.isSameTileFace(tile1, tile2);
		assertEquals(true, result);
	}
	
	/**
	 * Test is same type 2.
	 */
	@Test
	void testIsSameType2() {
		Tile tile1 = new Tile(0);
		Tile tile2 = new Tile(4);
		boolean result = Tile.isSameTileFace(tile1, tile2);
		assertEquals(false, result);
	}
	
	/**
	 * Test is same type 3.
	 */
	@Test
	void testIsSameType3() {
		Tile tile1 = new Tile(0);
		Tile tile2 = new Tile(36);
		boolean result = Tile.isSameTileFace(tile1, tile2);
		assertEquals(false,result);
	}
	
	@Test
	void testCompareTo() {
		Tile tile1 = new Tile(0);
		Tile tile2 = new Tile(0);
		int result = tile1.compareTo(tile2);
		assertEquals(0,result);
	}

}
