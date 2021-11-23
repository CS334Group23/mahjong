package checker;
import static org.junit.Assert.*;
import org.junit.Test;

import checker.Checker;
import checker.FacadeChecker;
import checker.GenerateWinningHand;
import checker.sequence.Sequence;
import utils.*;
import java.util.*;

// this is for testing , so please ignore it
public class Test_score{
	//@Test
	
	
	public void test() {
			
			ArrayList<Tile> hand = new ArrayList<>();
			GenerateWinningHand comb = new GenerateWinningHand();
			ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(1,0,2,4,5,6,8,9,10,13,14,15,16,17 ));
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

			Checker check= Checker.getInstance();
			ArrayList<Meld> showed_hand=new ArrayList<Meld>();
			ArrayList<Sequence> test_sequence=check.CheckScore(hand, showed_hand);
			int score=0;
			for(Sequence s: test_sequence){
				score+=s.getScore();
				
			}
			assertEquals(11, score);
		
	}
	
	
	
//@Test
	
	
	public void test2() {
			
			ArrayList<Tile> hand = new ArrayList<>();
			GenerateWinningHand comb = new GenerateWinningHand();
			ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(1,0,2,4,5,6,8,9,10,13,14,18,16,17 ));
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

			Checker check= Checker.getInstance();
			ArrayList<Meld> showed_hand=new ArrayList<Meld>();
			ArrayList<Sequence> test_sequence=check.CheckScore(hand, showed_hand);
			int score=0;
			for(Sequence s: test_sequence){
				score+=s.getScore();
				
			}
			assertEquals(11, score);
		
	}
	
//@Test


public void test3() {
		
		ArrayList<Tile> hand = new ArrayList<>();
		GenerateWinningHand comb = new GenerateWinningHand();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(1,2,3,41,42,43,61,62,63,108,109,81,82,83 ));
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
//		sorting.sortTile(hand);
		Collections.sort(hand);
		ArrayList<Meld> showed_hand=new ArrayList<>();
		FacadeChecker check= new FacadeChecker(hand, showed_hand, t14);
		
		ArrayList<Sequence> test_sequence=check.check_if_win();
		int score=0;
		for(Sequence s: test_sequence){
			score+=s.getScore();
			
		}
		assertEquals(1, score);
	
}

@Test


public void test4() {
		
		ArrayList<Tile> hand = new ArrayList<>();
		GenerateWinningHand comb = new GenerateWinningHand();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(1,2,3,4,5,6,8,9,10,16,17,18,121,122 ));
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
		//hand.add(t14);
		
		ArrayList<Meld> showed_hand=new ArrayList<>();
		FacadeChecker check= new FacadeChecker(hand, showed_hand, t14);
		
		ArrayList<Sequence> test_sequence=check.check_if_win();
		int score=0;
		for(Sequence s: test_sequence){
			score+=s.getScore();
			
		}
		System.out.println(score);
		assertEquals(4, score);
	
}
//@Test
public void testv5() {
	ArrayList<Tile> hand = new ArrayList<>();
	GenerateWinningHand comb = new GenerateWinningHand();
	ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(1,2,4,5,8,12,16,17,18,19,20,24,121 ));
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
	
	Tile t14=new Tile(0);
	
	ArrayList<Meld> showed_hand=new ArrayList<>();
	FacadeChecker check= new FacadeChecker(hand, showed_hand, t14);
	ArrayList<Meld> test=check.check_if_chow();
	test.add(check.check_if_pong());
	System.out.println(test.size());
}

}
