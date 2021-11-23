package checker;
import static org.junit.Assert.*;
import org.junit.Test;

import checker.CheckWin;
import checker.GenerateWinningHand;
import utils.*;
import java.util.*;
public class TestCombination {
	@Test
	public void UnitTestCheckChowv1() {//test false
		Tile t1= new Tile(0);
		Tile t2= new Tile(8);
		Tile t3= new Tile(15);
		GenerateWinningHand testCombination=new GenerateWinningHand();
		boolean result = testCombination.CheckChow(t1, t2, t3);
		assertEquals(false,result);
	}
	@Test
	public void UnitTestCheckChowv2() {//test true
		Tile t1= new Tile(0);
		Tile t2= new Tile(4);
		Tile t3= new Tile(8);
		GenerateWinningHand testCombination=new GenerateWinningHand();
		boolean result = testCombination.CheckChow(t1, t2, t3);
		assertEquals(true,result);
		
		
	}
	@Test
	public void UnitTestCheckPongv1() {
		Tile t1= new Tile(0);
		Tile t2= new Tile(4);
		Tile t3= new Tile(8);
		GenerateWinningHand testCombination=new GenerateWinningHand();
		boolean result = testCombination.CheckPong(t1, t2, t3);
		assertEquals(false,result);
		
		
	}
	@Test
	public void UnitTestCheckPongv2() {
		Tile t1= new Tile(0);
		Tile t2= new Tile(1);
		Tile t3= new Tile(2);
		GenerateWinningHand testCombination=new GenerateWinningHand();
		boolean result = testCombination.CheckPong(t1, t2, t3);
		assertEquals(true,result);
		
		
	}
	
	@Test 
	public void UnitTestgetCombinationv1() { //testing  false
		ArrayList<Tile> hand = new ArrayList<>();
		GenerateWinningHand comb = new GenerateWinningHand();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,5,6,8,9,10,13,14,15,16,17 ));
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
		hand.add(t14);
		ArrayList<ArrayList<Meld>> result = comb.getCombination(hand);
		assertEquals(false,result.isEmpty());
		
		
	}
	@Test 
	public void UnitTestgetCombinationv2() { //testing  false
		ArrayList<Tile> hand = new ArrayList<>();
		GenerateWinningHand comb = new GenerateWinningHand();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,5,6,8,9,10,13,14,15,16,55 ));
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
		hand.add(t14);
		ArrayList<ArrayList<Meld>> result = comb.getCombination(hand);
		assertEquals(true,result.isEmpty());
		
		
	}
}
