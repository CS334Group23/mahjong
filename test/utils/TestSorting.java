/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: Testsorting.java </p> 
 * @author TeamCS3343 </a>
 */
package utils;
import static org.junit.Assert.*;
import org.junit.Test;

import checker.CheckWin;
import checker.GenerateWinningHand;
import utils.*;
import java.util.*;
// TODO: Auto-generated Javadoc

/**
 * The Class Testsorting.
 */
public class TestSorting {
//	@Test
//	public void UnitTestsortTilev1() { //test if can sort
//		ArrayList<Tile> hand = new ArrayList<>();
//		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(1,0,19,15,55,22,2,9,18,13,14,15,16,6 ));
//		Tile t1= new Tile(a.get(0));
//		hand.add(t1);
//		Tile t2= new Tile(a.get(1));
//		hand.add(t2);
//		Tile t3= new Tile(a.get(2));
//		hand.add(t3);
//		Tile t4= new Tile(a.get(3));
//		hand.add(t4);
//		Tile t5= new Tile(a.get(4));
//		hand.add(t5);
//		Tile t6= new Tile(a.get(5));
//		hand.add(t6);
//		Tile t7= new Tile(a.get(6));
//		hand.add(t7);
//		Tile t8= new Tile(a.get(7));
//        hand.add(t8);
//		Tile t9= new Tile(a.get(8));
//		hand.add(t9);
//		Tile t10= new Tile(a.get(9));
//		hand.add(t10);
//		Tile t11= new Tile(a.get(10));
//		hand.add(t11);
//		Tile t12= new Tile(a.get(11));
//		
//		hand.add(t12);
//		Tile t13= new Tile(a.get(12));
//		hand.add(t13);
//		Tile t14= new Tile(a.get(13));
//		hand.add(t14);
//		
////		sorting.sortTile(hand);
//		Collections.sort(hand);
//		boolean result=true;
//		for(int i=0;i<hand.size()-1;i++) {
//			if(hand.get(i).getId()>hand.get(i+1).getId()) {
//				result=false;
//			}
//			
//		}
//		assertEquals(true,result);
//		
//		
/**
 * Unit testsort meld.
 */
//	}
	@Test 
	public void UnitTestsort_Meld() {
		//0,4,8,12,16,20,24,28,32,36,40,44,6,5
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(99,95,45,44,41,20,19,12,10,9,8,5,4,1 ));
		CheckWin checkwin=new CheckWin();
		Tile t1= new Tile(a.get(0));
		Tile t2= new Tile(a.get(1));
		Tile t3= new Tile(a.get(2));
		Tile t4= new Tile(a.get(3));
		Tile t5= new Tile(a.get(4));
		Tile t6= new Tile(a.get(5));
		Tile t7= new Tile(a.get(6));
		Tile t8= new Tile(a.get(7));
		Tile t9= new Tile(a.get(8));
		Tile t10= new Tile(a.get(9));
		Tile t11= new Tile(a.get(10));
		Tile t12= new Tile(a.get(11));
		Tile t13= new Tile(a.get(12));
		Tile t14= new Tile(a.get(13));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t7,t8,t9,null));
		Sorting.sort_Meld(hand);
		boolean result=true;
		for(int i=0;i<hand.size()-1;i++) {
			if(hand.get(i).getFirst().getId()>hand.get(i+1).getFirst().getId()) {
				result=false;
			}
			
		}
		assertEquals(true,result);
		
	}
	
}
