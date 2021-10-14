package utils;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TileTest {

	@Test
	void testIdToRankIndex() {
		Tile t = new Tile(1);
		int idx = t.getRankIndex();
		//System.out.println(idx);
		assertEquals(0,idx);
	}
	
	@Test
	void testIdToType() {
		Tile t = new Tile(1);
		Type type = t.getType();
		//System.out.println(type);
		assertEquals(Type.BAMBOO,type);
	}

	@Test
	void testIdToName() {
		Tile t = new Tile(138);
		String name = t.getName();
		//System.out.println(name);
		assertEquals("Autumn",name);
		
	}
	
	@Test
	void testGetUrl() {
		Tile t = new Tile(0);
		String url = t.getUrl();
		String name = t.getName();
		System.out.println(name);
		System.out.println(url);
		assertEquals("resource/static/tiles/bamboo-1.png", url);
	}
}
