package sequence;
import static org.junit.Assert.*;
import org.junit.Test;

import sequence.CheckWin;
import sequence.Combination;
import utils.*;
import java.util.*;
public class TestPongChecker {
	@Test
	public void UnitTestcheckPongv1() {//sorted list to test if can't Pong
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
	Meld result = PongChecker.checkPong(hand,t14);
	assertEquals(null,result);
	}
	@Test
	public void UnitTestcheckPongv2() { //sorted list to test if can Pong
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
		Meld result = PongChecker.checkPong(hand,t14);
		boolean bresult=true;
		if(result==null) {
			bresult=false;
		}
		assertEquals(true,bresult);
		}

}