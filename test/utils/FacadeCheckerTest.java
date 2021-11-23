package utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import checker.FacadeChecker;
import checker.sequence.Sequence;

public class FacadeCheckerTest {
	@Test
	public void testFacadeChecker() {
		//check Kong
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(0));
		arr.add(new Tile(1));
		arr.add(new Tile(2));
		arr.add(new Tile(3));
		arr.add(new Tile(4));
		arr.add(new Tile(5));
		arr.add(new Tile(6));
		arr.add(new Tile(7));
		arr.add(new Tile(8));
		arr.add(new Tile(9));
		arr.add(new Tile(10));
		arr.add(new Tile(12));
		arr.add(new Tile(13));
		
		FacadeChecker checker = new FacadeChecker(arr,new ArrayList<Meld>(), new Tile(11));
		ArrayList<Meld> result = checker.check_if_kong();
		System.out.printf("size:%d\n",result.size());
		assertEquals(3,result.size());
	}
	
	@Test
	public void testFacadeChecker2() {
		//check PPH
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(0));
		arr.add(new Tile(1));
		arr.add(new Tile(2));
		arr.add(new Tile(17));
		arr.add(new Tile(18));
		arr.add(new Tile(19));
		arr.add(new Tile(41));
		arr.add(new Tile(42));
		arr.add(new Tile(62));
		arr.add(new Tile(63));
		arr.add(new Tile(112));
		arr.add(new Tile(113));
		arr.add(new Tile(114));
		
		FacadeChecker checker = new FacadeChecker(arr,null, new Tile(61));
		ArrayList<Sequence> possibleSequence = checker.check_if_win();
		System.out.printf("size:%d\n",possibleSequence.size());
		assertEquals(1,possibleSequence.size());
	}
	
	@Test
	public void testFacadeChecker3() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(0));
		arr.add(new Tile(1));
		arr.add(new Tile(2));
		arr.add(new Tile(17));
		arr.add(new Tile(20));
		arr.add(new Tile(24));
		arr.add(new Tile(41));
		arr.add(new Tile(42));
		arr.add(new Tile(62));
		arr.add(new Tile(63));
		arr.add(new Tile(112));
		arr.add(new Tile(113));
		arr.add(new Tile(114));
		
		FacadeChecker checker = new FacadeChecker(arr,null, new Tile(61));
		ArrayList<Sequence> possibleSequence = checker.check_if_win();
		System.out.printf("size:%d\n",possibleSequence.size());
		assertEquals(1,possibleSequence.size());
	}
	
	@Test
	public void testFacadeChecker4() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(0));
		arr.add(new Tile(4));
		arr.add(new Tile(8));
		arr.add(new Tile(9));
		arr.add(new Tile(10));
		arr.add(new Tile(40));
		arr.add(new Tile(41));
		arr.add(new Tile(42));
		arr.add(new Tile(62));
		arr.add(new Tile(63));
		arr.add(new Tile(112));
		arr.add(new Tile(113));
		arr.add(new Tile(114));
		
		FacadeChecker checker = new FacadeChecker(arr,null, new Tile(61));
		ArrayList<Sequence> possibleSequence = checker.check_if_win();
		System.out.printf("size:%d\n",possibleSequence.size());
		assertEquals(1,possibleSequence.size());
	}
	
	@Test
	public void testFacadeChecker5() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(0));   
		arr.add(new Tile(4)); 
		arr.add(new Tile(5));
		arr.add(new Tile(8));
		arr.add(new Tile(9));
		arr.add(new Tile(12));
		arr.add(new Tile(13));
		arr.add(new Tile(14));
		arr.add(new Tile(15));
		arr.add(new Tile(16));
		arr.add(new Tile(92));
		arr.add(new Tile(93));
		arr.add(new Tile(94));
		
		FacadeChecker checker = new FacadeChecker(arr,null, new Tile(17));
		ArrayList<Sequence> possibleSequence = checker.check_if_win();
		System.out.printf("size:%d\n",possibleSequence.size());
		assertEquals(1,possibleSequence.size());
	}
	
	@Test
	public void testFacadeChecker6() {
		ArrayList<Tile> arr = new ArrayList<>();
		arr.add(new Tile(64));
		arr.add(new Tile(65));
		arr.add(new Tile(73));
		arr.add(new Tile(77));
		arr.add(new Tile(81));
		arr.add(new Tile(104));
		arr.add(new Tile(105));
		arr.add(new Tile(108));
		arr.add(new Tile(109));
		arr.add(new Tile(110));
		arr.add(new Tile(112));
		arr.add(new Tile(113));
		arr.add(new Tile(114));
		
		FacadeChecker checker = new FacadeChecker(arr,null, new Tile(105));
		ArrayList<Sequence> possibleSequence = checker.check_if_win();
		System.out.printf("size:%d\n",possibleSequence.size());
		assertEquals(1,possibleSequence.size());
	}
}
