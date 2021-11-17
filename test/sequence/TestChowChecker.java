package sequence;
import static org.junit.Assert.*;
import org.junit.Test;

import sequence.CheckWin;
import sequence.GenerateWinningHand;
import utils.*;
import java.util.*;
public class TestChowChecker {
	@Test
	public void UnitTestcheckChowv1() {//sorted list to test if can't Chow with different type
	ArrayList<Tile> hand = new ArrayList<>();
	ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,3,4,5,6,7,8,9,40,48,30,35,55 ));
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
	Tile t6= new Tile(a.get(5));
	hand.add(t6);
	Tile t7= new Tile(a.get(6));
	hand.add(t7);
	Tile t8= new Tile(a.get(7));
    hand.add(t8);
	Tile t9= new Tile(a.get(8));
	hand.add(t9);
	Tile t10= new Tile(a.get(9));
	hand.add(t10);
	Tile t11= new Tile(a.get(10));
	hand.add(t11);
	Tile t12= new Tile(a.get(11));
	
	hand.add(t12);
	Tile t13= new Tile(a.get(12));
	hand.add(t13);
	Tile t14= new Tile(a.get(13));
	ArrayList<Meld> result = (new ChowChecker()).checkChow(hand,t14);
	assertEquals(true,result.isEmpty());
	}
	@Test
	public void UnitTestcheckChowv2() {//sorted list to test if can't Chow with dragon/wind
	ArrayList<Tile> hand = new ArrayList<>();
	ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,3,4,5,6,7,8,9,23,27,30,35,109 ));
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
	Tile t6= new Tile(a.get(5));
	hand.add(t6);
	Tile t7= new Tile(a.get(6));
	hand.add(t7);
	Tile t8= new Tile(a.get(7));
    hand.add(t8);
	Tile t9= new Tile(a.get(8));
	hand.add(t9);
	Tile t10= new Tile(a.get(9));
	hand.add(t10);
	Tile t11= new Tile(a.get(10));
	hand.add(t11);
	Tile t12= new Tile(a.get(11));
	
	hand.add(t12);
	Tile t13= new Tile(a.get(12));
	hand.add(t13);
	Tile t14= new Tile(a.get(13));
	ArrayList<Meld> result = ChowChecker.checkChow(hand,t14);
	assertEquals(true,result.isEmpty());
	result = ChowChecker.checkChow(hand,new Tile(120));
	assertEquals(true,result.isEmpty());
	}
	@Test
	public void UnitTestcheckChowv3() {//sorted list to test if can't Chow with same type
	ArrayList<Tile> hand = new ArrayList<>();
	ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,3,4,5,6,7,8,9,10,29,30,34,35 ));
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
	Tile t6= new Tile(a.get(5));
	hand.add(t6);
	Tile t7= new Tile(a.get(6));
	hand.add(t7);
	Tile t8= new Tile(a.get(7));
    hand.add(t8);
	Tile t9= new Tile(a.get(8));
	hand.add(t9);
	Tile t10= new Tile(a.get(9));
	hand.add(t10);
	Tile t11= new Tile(a.get(10));
	hand.add(t11);
	Tile t12= new Tile(a.get(11));
	
	hand.add(t12);
	Tile t13= new Tile(a.get(12));
	hand.add(t13);
	Tile t14= new Tile(a.get(13));
	ArrayList<Meld> result = ChowChecker.checkChow(hand,t14);
	assertEquals(true,result.isEmpty());
	}
	@Test
	public void UnitTestcheckChowv4() { //sorted list to test if can Chow as A _ _
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,3,4,5,6,7,8,9,10,11,12,13,2 ));
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
		Tile t6= new Tile(a.get(5));
		hand.add(t6);
		Tile t7= new Tile(a.get(6));
		hand.add(t7);
		Tile t8= new Tile(a.get(7));
	    hand.add(t8);
		Tile t9= new Tile(a.get(8));
		hand.add(t9);
		Tile t10= new Tile(a.get(9));
		hand.add(t10);
		Tile t11= new Tile(a.get(10));
		hand.add(t11);
		Tile t12= new Tile(a.get(11));
		
		hand.add(t12);
		Tile t13= new Tile(a.get(12));
		hand.add(t13);
		Tile t14= new Tile(a.get(13));
		ArrayList<Meld> result = ChowChecker.checkChow(hand,t14);
		assertEquals(1,result.size());
	}
	@Test
	public void UnitTestcheckChowv5() { //sorted list to test if can Chow as  _ A _
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(4,5,6,7,8,9,10,12,13,36,37,38,39,11 ));
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
		Tile t6= new Tile(a.get(5));
		hand.add(t6);
		Tile t7= new Tile(a.get(6));
		hand.add(t7);
		Tile t8= new Tile(a.get(7));
	    hand.add(t8);
		Tile t9= new Tile(a.get(8));
		hand.add(t9);
		Tile t10= new Tile(a.get(9));
		hand.add(t10);
		Tile t11= new Tile(a.get(10));
		hand.add(t11);
		Tile t12= new Tile(a.get(11));
		
		hand.add(t12);
		Tile t13= new Tile(a.get(12));
		hand.add(t13);
		Tile t14= new Tile(a.get(13));
		ArrayList<Meld> result = ChowChecker.checkChow(hand,t14);
		assertEquals(1,result.size());
	}
	@Test
	public void UnitTestcheckChowv6() { //sorted list to test if can Chow as  _  _ A
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,3,4,5,6,7,8,9,10,11,12,13,16 ));
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
		Tile t6= new Tile(a.get(5));
		hand.add(t6);
		Tile t7= new Tile(a.get(6));
		hand.add(t7);
		Tile t8= new Tile(a.get(7));
	    hand.add(t8);
		Tile t9= new Tile(a.get(8));
		hand.add(t9);
		Tile t10= new Tile(a.get(9));
		hand.add(t10);
		Tile t11= new Tile(a.get(10));
		hand.add(t11);
		Tile t12= new Tile(a.get(11));
		
		hand.add(t12);
		Tile t13= new Tile(a.get(12));
		hand.add(t13);
		Tile t14= new Tile(a.get(13));
		ArrayList<Meld> result = ChowChecker.checkChow(hand,t14);
		assertEquals(1,result.size());
	}
	@Test
	public void UnitTestcheckChowv7() { //sorted list to test if can Chow as  _  _ A + _ A _
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,3,4,5,6,7,8,9,10,11,12,16,13 ));
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
		Tile t6= new Tile(a.get(5));
		hand.add(t6);
		Tile t7= new Tile(a.get(6));
		hand.add(t7);
		Tile t8= new Tile(a.get(7));
	    hand.add(t8);
		Tile t9= new Tile(a.get(8));
		hand.add(t9);
		Tile t10= new Tile(a.get(9));
		hand.add(t10);
		Tile t11= new Tile(a.get(10));
		hand.add(t11);
		Tile t12= new Tile(a.get(11));
		
		hand.add(t12);
		Tile t13= new Tile(a.get(12));
		hand.add(t13);
		Tile t14= new Tile(a.get(13));
		ArrayList<Meld> result = ChowChecker.checkChow(hand,t14);
		assertEquals(2,result.size());
	}
	@Test
	public void UnitTestcheckChowv8() { //sorted list to test if can Chow as  A _  _  + _ A _
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,3,5,6,7,8,9,10,11,12,16,4 ));
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
		Tile t6= new Tile(a.get(5));
		hand.add(t6);
		Tile t7= new Tile(a.get(6));
		hand.add(t7);
		Tile t8= new Tile(a.get(7));
	    hand.add(t8);
		Tile t9= new Tile(a.get(8));
		hand.add(t9);
		Tile t10= new Tile(a.get(9));
		hand.add(t10);
		Tile t11= new Tile(a.get(10));
		hand.add(t11);
		Tile t12= new Tile(a.get(11));
		
		hand.add(t12);
		Tile t13= new Tile(a.get(12));
		hand.add(t13);
		Tile t14= new Tile(a.get(13));
		ArrayList<Meld> result = ChowChecker.checkChow(hand,t14);
		assertEquals(2,result.size());
	}
	@Test
	public void UnitTestcheckChowv9() { //sorted list to test if can Chow as    A _ _  + _ _ A + _ A _
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,3,4,5,6,7,9,10,11,12,16,8 ));
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
		Tile t6= new Tile(a.get(5));
		hand.add(t6);
		Tile t7= new Tile(a.get(6));
		hand.add(t7);
		Tile t8= new Tile(a.get(7));
	    hand.add(t8);
		Tile t9= new Tile(a.get(8));
		hand.add(t9);
		Tile t10= new Tile(a.get(9));
		hand.add(t10);
		Tile t11= new Tile(a.get(10));
		hand.add(t11);
		Tile t12= new Tile(a.get(11));
		
		hand.add(t12);
		Tile t13= new Tile(a.get(12));
		hand.add(t13);
		Tile t14= new Tile(a.get(13));
		ArrayList<Meld> result = ChowChecker.checkChow(hand,t14);
		assertEquals(3,result.size());
	}
	
	@Test
	public void UnitTestcheckChowv10() { //empty list, cover for loop
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0));
		Tile t14= new Tile(a.get(0));
		ArrayList<Meld> result = ChowChecker.checkChow(hand,t14);
		assertEquals(0,result.size());
	}
	@Test
	public void UnitTestcheckChowv11() { //1 in hand, cover for loop
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0));
		Tile t14= new Tile(a.get(0));
		hand.add(new Tile(1));
		ArrayList<Meld> result = ChowChecker.checkChow(hand,t14);
		assertEquals(0,result.size());
	}

}
