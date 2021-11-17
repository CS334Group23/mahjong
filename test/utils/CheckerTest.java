package utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class CheckerTest {
	
	@Test
	public void testCheckChow1() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(0));
		arr.add(new Tile(1));
		arr.add(new Tile(4));
		arr.add(new Tile(8));
		arr.add(new Tile(12));
		arr.add(new Tile(16));
		arr.add(new Tile(20));
		arr.add(new Tile(60));
		arr.add(new Tile(62));
		arr.add(new Tile(67));
		arr.add(new Tile(69));
		arr.add(new Tile(90));
		arr.add(new Tile(91));
	
		int result = Checker.checkChow(arr, new Tile(10)).size();
		assertEquals(3,result);
	}
	
	@Test
	public void testCheckChow2() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(0));
		arr.add(new Tile(1));
		arr.add(new Tile(4));
		arr.add(new Tile(8));
		arr.add(new Tile(12));
		arr.add(new Tile(16));
		arr.add(new Tile(20));
		arr.add(new Tile(60));
		arr.add(new Tile(62));
		arr.add(new Tile(67));
		arr.add(new Tile(108));
		arr.add(new Tile(112));
		arr.add(new Tile(116));
	
		int result = Checker.checkChow(arr, new Tile(115)).size();
		assertEquals(0,result);
	}
	
	@Test
	public void testCheckChow3() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(0));
		arr.add(new Tile(1));
		arr.add(new Tile(4));
		arr.add(new Tile(8));
		arr.add(new Tile(12));
		arr.add(new Tile(30));
		arr.add(new Tile(32));
		arr.add(new Tile(60));
		arr.add(new Tile(62));
		arr.add(new Tile(67));
		arr.add(new Tile(108));
		arr.add(new Tile(112));
		arr.add(new Tile(116));
	
		int result = Checker.checkChow(arr, new Tile(36)).size();
		assertEquals(0,result);
	}
	
	
	@Test
	public void testCheckChow4() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(0));
		arr.add(new Tile(1));
		arr.add(new Tile(4));
		arr.add(new Tile(8));
		arr.add(new Tile(12));
		arr.add(new Tile(30));
		arr.add(new Tile(32));
		arr.add(new Tile(72));
		arr.add(new Tile(76));
		arr.add(new Tile(80));
		arr.add(new Tile(108));
		arr.add(new Tile(112));
		arr.add(new Tile(116));
	
		int result = Checker.checkChow(arr, new Tile(77)).size();
		assertEquals(1,result);
	}
	
	@Test
	public void testCheckChow5() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(0));
		arr.add(new Tile(1));
		arr.add(new Tile(4));
		arr.add(new Tile(8));
		arr.add(new Tile(12));
		arr.add(new Tile(30));
		arr.add(new Tile(32));
		arr.add(new Tile(72));
		arr.add(new Tile(76));
		arr.add(new Tile(84));
		arr.add(new Tile(108));
		arr.add(new Tile(112));
		arr.add(new Tile(116));
	
		int result = Checker.checkChow(arr, new Tile(77)).size();
		assertEquals(0,result);
	}
	
	@Test
	public void testCheckPong1() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(4));
		arr.add(new Tile(8));
		arr.add(new Tile(10));
		arr.add(new Tile(12));
		arr.add(new Tile(20));
		arr.add(new Tile(30));
		arr.add(new Tile(32));
		arr.add(new Tile(72));
		arr.add(new Tile(76));
		arr.add(new Tile(84));
		arr.add(new Tile(108));
		arr.add(new Tile(112));
		arr.add(new Tile(116));
	
		Meld result = Checker.checkPong(arr, new Tile(0));
		assertEquals(null, result);
	}
	
	@Test
	public void testCheckPong2() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(4));
		arr.add(new Tile(8));
		arr.add(new Tile(10));
		arr.add(new Tile(12));
		arr.add(new Tile(20));
		arr.add(new Tile(30));
		arr.add(new Tile(32));
		arr.add(new Tile(72));
		arr.add(new Tile(76));
		arr.add(new Tile(84));
		arr.add(new Tile(108));
		arr.add(new Tile(112));
		arr.add(new Tile(116));
	
		Meld result = Checker.checkPong(arr, new Tile(120));
		assertEquals(null, result);
	}
	
	@Test
	public void testCheckPong3() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(4));
		arr.add(new Tile(8));
		arr.add(new Tile(10));
		arr.add(new Tile(12));
		arr.add(new Tile(20));
		arr.add(new Tile(30));
		arr.add(new Tile(32));
		arr.add(new Tile(72));
		arr.add(new Tile(76));
		arr.add(new Tile(84));
		arr.add(new Tile(108));
		arr.add(new Tile(112));
		arr.add(new Tile(116));
	
		String result = Checker.checkPong(arr, new Tile(11)).getName();
		assertEquals("Pong", result);
	}
	
	@Test
	public void testCheckPong4() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(4));
		arr.add(new Tile(8));
		arr.add(new Tile(12));
		arr.add(new Tile(13));
		arr.add(new Tile(20));
		arr.add(new Tile(30));
		arr.add(new Tile(33));
		arr.add(new Tile(72));
		arr.add(new Tile(76));
		arr.add(new Tile(84));
		arr.add(new Tile(108));
		arr.add(new Tile(112));
		arr.add(new Tile(116));
	
		Meld result = Checker.checkPong(arr, new Tile(34));
		assertEquals(null, result);
	}
	
	@Test
	public void testCheckPong5() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(4));
		arr.add(new Tile(8));
		arr.add(new Tile(12));
		arr.add(new Tile(13));
		arr.add(new Tile(20));
		arr.add(new Tile(28));
		arr.add(new Tile(33));
		arr.add(new Tile(72));
		arr.add(new Tile(76));
		arr.add(new Tile(84));
		arr.add(new Tile(108));
		arr.add(new Tile(112));
		arr.add(new Tile(116));
	
		Meld result = Checker.checkPong(arr, new Tile(29));
		assertEquals(null, result);
	}
	
	@Test
	public void testCheckKong1() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(4));
		arr.add(new Tile(8));
		arr.add(new Tile(12));
		arr.add(new Tile(13));
		arr.add(new Tile(20));
		arr.add(new Tile(28));
		arr.add(new Tile(33));
		arr.add(new Tile(72));
		arr.add(new Tile(76));
		arr.add(new Tile(84));
		arr.add(new Tile(108));
		arr.add(new Tile(112));
		arr.add(new Tile(116));
	
		Meld result = Checker.checkKong(arr, new Tile(125));
		assertEquals(null, result);
	}
	
	@Test
	public void testCheckKong2() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(4));
		arr.add(new Tile(8));
		arr.add(new Tile(12));
		arr.add(new Tile(13));
		arr.add(new Tile(20));
		arr.add(new Tile(28));
		arr.add(new Tile(33));
		arr.add(new Tile(72));
		arr.add(new Tile(76));
		arr.add(new Tile(84));
		arr.add(new Tile(108));
		arr.add(new Tile(112));
		arr.add(new Tile(116));
	
		Meld result = Checker.checkKong(arr, new Tile(5));
		assertEquals(null, result);
	}
	
	@Test
	public void testCheckKong3() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(4));
		arr.add(new Tile(8));
		arr.add(new Tile(12));
		arr.add(new Tile(13));
		arr.add(new Tile(20));
		arr.add(new Tile(28));
		arr.add(new Tile(33));
		arr.add(new Tile(72));
		arr.add(new Tile(76));
		arr.add(new Tile(84));
		arr.add(new Tile(112));
		arr.add(new Tile(114));
		arr.add(new Tile(115));
	
		String result = Checker.checkKong(arr, new Tile(113)).getName();
		assertEquals("Kong", result);
	}
	
	@Test
	public void testCheckKong4() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(4));
		arr.add(new Tile(8));
		arr.add(new Tile(12));
		arr.add(new Tile(13));
		arr.add(new Tile(20));
		arr.add(new Tile(28));
		arr.add(new Tile(31));
		arr.add(new Tile(32));
		arr.add(new Tile(76));
		arr.add(new Tile(84));
		arr.add(new Tile(112));
		arr.add(new Tile(114));
		arr.add(new Tile(115));
	
		Meld result = Checker.checkKong(arr, new Tile(29));
		assertEquals(null, result);
	}
}
