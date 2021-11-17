package utils;
import static org.junit.Assert.*;
import org.junit.Test;

import sequence.GenerateWinningHand;
import utils.*;
import java.util.*;

public class TestFindTilePosition {
	@Test
	public void UnitTestFindPositionv1() { //test lower bound
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(1,2,3,4,5 ));
		Tile t1= new Tile(a.get(0));
		hand.add(t1);
		Tile t2= new Tile(a.get(1));
		hand.add(t2);
		Tile t3= new Tile(a.get(2));
		hand.add(t3);
		Tile t4= new Tile(a.get(3));
		hand.add(t4);
		Tile t5= new Tile(a.get(4));
		hand.add(t5);
		
		int result=FindTilePosition.FindPosition(hand,t1);
		assertEquals(0,result);
	}
	@Test
	public void UnitTestFindPositionv2() { //test upper bound
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(1,2,3,4,5 ));
		Tile t1= new Tile(a.get(0));
		hand.add(t1);
		Tile t2= new Tile(a.get(1));
		hand.add(t2);
		Tile t3= new Tile(a.get(2));
		hand.add(t3);
		Tile t4= new Tile(a.get(3));
		hand.add(t4);
		Tile t5= new Tile(a.get(4));
		hand.add(t5);
		
		int result=FindTilePosition.FindPosition(hand,t5);
		assertEquals(4,result);
	}
	@Test
	public void UnitTestFindPositionv3() { //test between lower and upper bound 
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(1,2,3,4,5 ));
		Tile t1= new Tile(a.get(0));
		hand.add(t1);
		Tile t2= new Tile(a.get(1));
		hand.add(t2);
		Tile t3= new Tile(a.get(2));
		hand.add(t3);
		Tile t4= new Tile(a.get(3));
		hand.add(t4);
		Tile t5= new Tile(a.get(4));
		hand.add(t5);
		
		int result=FindTilePosition.FindPosition(hand,t2);
		assertEquals(1,result);
	}
	@Test
	public void UnitTestFindPositionv4() { //test without tile, should return position p than tile number >= x[p-1] 
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(1,2,3,4,5 ));
		Tile t1= new Tile(a.get(0));
		hand.add(t1);
		Tile t2= new Tile(a.get(1));
		hand.add(t2);
		Tile t3= new Tile(a.get(2));
		//hand.add(t3);
		Tile t4= new Tile(a.get(3));
		hand.add(t4);
		Tile t5= new Tile(a.get(4));
		hand.add(t5);
		
		int result=FindTilePosition.FindPosition(hand,t3);
		assertEquals(2,result);
	}
	@Test 
	public void UnitTestNextDifferentTilev1() { //test has next different
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(1,2,3,4,5 ));
		Tile t1= new Tile(a.get(0));
		hand.add(t1);
		Tile t2= new Tile(a.get(1));
		hand.add(t2);
		Tile t3= new Tile(a.get(2));
		hand.add(t3);
		Tile t4= new Tile(a.get(3));
		hand.add(t4);
		Tile t5= new Tile(a.get(4));
		hand.add(t5);
		
		int result=FindTilePosition.NextDifferentTile(hand,t3);
		assertEquals(3,result);
		
		
	}
	@Test 
	public void UnitTestNextDifferentTilev2() { //test hasn't next different
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(1,2,3,4,5 ));
		Tile t1= new Tile(a.get(0));
		hand.add(t1);
		Tile t2= new Tile(a.get(1));
		hand.add(t2);
		Tile t3= new Tile(a.get(2));
		hand.add(t3);
		Tile t4= new Tile(a.get(3));
		hand.add(t4);
		Tile t5= new Tile(a.get(4));
		hand.add(t5);
		
		int result=FindTilePosition.NextDifferentTile(hand,t4);
		assertEquals(-1,result);
		
		
	}
	@Test 
	public void UnitTestPreviousDifferentTilev1() { //test hasn't next different
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(1,2,3,4,5 ));
		Tile t1= new Tile(a.get(0));
		hand.add(t1);
		Tile t2= new Tile(a.get(1));
		hand.add(t2);
		Tile t3= new Tile(a.get(2));
		hand.add(t3);
		Tile t4= new Tile(a.get(3));
		hand.add(t4);
		Tile t5= new Tile(a.get(4));
		hand.add(t5);
		
		int result=FindTilePosition.PreviousDifferentTile(hand,t4);
		assertEquals(2,result);
		
		
	}
	@Test 
	public void UnitTestPreviousDifferentTilev2() { //test hasn't next different
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(1,2,3,4,5 ));
		Tile t1= new Tile(a.get(0));
		hand.add(t1);
		Tile t2= new Tile(a.get(1));
		hand.add(t2);
		Tile t3= new Tile(a.get(2));
		hand.add(t3);
		Tile t4= new Tile(a.get(3));
		hand.add(t4);
		Tile t5= new Tile(a.get(4));
		hand.add(t5);
		
		int result=FindTilePosition.PreviousDifferentTile(hand,t3);
		assertEquals(-1,result);
		
		
	}
}
