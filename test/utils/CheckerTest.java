package utils;

import java.util.ArrayList;

import org.junit.Test;

public class CheckerTest {
	@Test
	public void testCheckChow() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(0));
		arr.add(new Tile(1));
		arr.add(new Tile(2));
		arr.add(new Tile(3));
		arr.add(new Tile(4));
		arr.add(new Tile(16));
		arr.add(new Tile(20));
		arr.add(new Tile(60));
		arr.add(new Tile(62));
		arr.add(new Tile(67));
		arr.add(new Tile(69));
		arr.add(new Tile(90));
		arr.add(new Tile(91));
	
		Checker.checkChow(arr, new Tile(14));
	}
}
