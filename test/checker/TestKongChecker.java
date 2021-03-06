/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: TestKongChecker.java </p> 
 * @author TeamCS3343 </a>
 */
package checker;
import static org.junit.Assert.*;
import org.junit.Test;

import utils.*;
import java.util.*;
// TODO: Auto-generated Javadoc

/**
 * The Class TestKongChecker.
 */
public class TestKongChecker {
	
	/**
	 * Unit testcheck kongv 1.
	 */
	@Test
	public void UnitTestcheckKongv1() {//sorted list to test if can't kong
	ArrayList<Tile> hand = new ArrayList<>();
	ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,3,4,5,6,7,8,9,10,11,12,13,19 ));
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
	Meld result = KongChecker.checkKong(hand,t14);
	assertEquals(null,result);
	}
	
	/**
	 * Unit testcheck kongv 2.
	 */
	@Test
	public void UnitTestcheckKongv2() { //sorted list to test if can kong
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
		Meld result = KongChecker.checkKong(hand,t14);
		boolean bresult=true;
		if(result==null) {
			bresult=false;
		}
		assertEquals(true,bresult);
		}

	/**
	 * Test check kong 1.
	 */
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
	
		Meld result = KongChecker.checkKong(arr, new Tile(125));
		assertEquals(null, result);
	}
	
	/**
	 * Test check kong 2.
	 */
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
	
		Meld result = KongChecker.checkKong(arr, new Tile(5));
		assertEquals(null, result);
	}
	
	/**
	 * Test check kong 3.
	 */
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
	
		String result = KongChecker.checkKong(arr, new Tile(113)).getName();
		assertEquals("Kong", result);
	}
	
	/**
	 * Test check kong 4.
	 */
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
	
		Meld result = KongChecker.checkKong(arr, new Tile(29));
		assertEquals(null, result);
	}
}
