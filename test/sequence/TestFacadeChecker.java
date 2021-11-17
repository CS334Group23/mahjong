package sequence;
import static org.junit.Assert.*;
import org.junit.Test;
import utils.*;
import java.util.*;
public class TestFacadeChecker {
	@Test
	public void TestCheck_if_Scorev1() { //check if return empty
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,3,12,16,20,24,28,32,36,40,44,5,2 ));

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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		hand.add(t10);
		hand.add(t11);
		hand.add(t12);
		hand.add(t13);
		FacadeChecker check=new FacadeChecker(hand,showed_hand,t14);
		assertEquals(check.check_if_win().isEmpty(),true);
		
	}
	@Test
	public void TestCheck_if_Scorev2() { //check if return sequence
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,5,6,8,9,10,12,13,14,32,33 ));

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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		hand.add(t10);
		hand.add(t11);
		hand.add(t12);
		hand.add(t13);
		FacadeChecker check=new FacadeChecker(hand,showed_hand,t14);
		assertEquals(check.check_if_win().isEmpty(),false);
		
	}
	@Test 
	public void Testcheck_if_pongv1() { //test can pong
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,8,12,16,20,24,28,32,36,40,44,5,2 ));

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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		hand.add(t10);
		hand.add(t11);
		hand.add(t12);
		hand.add(t13);
		FacadeChecker check=new FacadeChecker(hand,showed_hand,t14);
		Meld result=check.check_if_pong();
		assertEquals(result.getcomb_type(),2);
		
	}
	@Test 
	public void Testcheck_if_pongv2() {
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,8,12,16,20,24,28,32,36,40,44,5,77 ));

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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		hand.add(t10);
		hand.add(t11);
		hand.add(t12);
		hand.add(t13);
		FacadeChecker check=new FacadeChecker(hand,showed_hand,t14);
		Meld result=check.check_if_pong();
		assertEquals(result,null);
		
	}
	
	@Test 
	public void Testcheck_if_chowv1() { //true,
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,4,8,12,16,20,24,28,32,36,40,44,5,9 ));

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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		hand.add(t10);
		hand.add(t11);
		hand.add(t12);
		hand.add(t13);
		FacadeChecker check=new FacadeChecker(hand,showed_hand,t14);
		ArrayList<Meld> result=check.check_if_chow();
		assertEquals(result.size(),3);
		
	}
	
	@Test 
	public void Testcheck_if_chowv2() { //false,
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,4,8,12,16,20,24,28,32,36,40,44,5,77 ));

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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		hand.add(t10);
		hand.add(t11);
		hand.add(t12);
		hand.add(t13);
		FacadeChecker check=new FacadeChecker(hand,showed_hand,t14);
		ArrayList<Meld> result=check.check_if_chow();
		assertEquals(result.size(),0);
		
	}
	@Test
	public void Testcheck_if_kongv1() { //true 
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,12,13,11 ));

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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		hand.add(t10);
		hand.add(t11);
		hand.add(t12);
		hand.add(t13);
		FacadeChecker check=new FacadeChecker(hand,showed_hand,t14);
		ArrayList<Meld> result=check.check_if_kong();
		assertEquals(result.size(),3);
		
	}
	
	@Test 
	public void Testcheck_if_kongv2() { //false
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,5,6,8,9,10,12,13,40,41,42 ));

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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		hand.add(t10);
		hand.add(t11);
		hand.add(t12);
		hand.add(t13);
		FacadeChecker check=new FacadeChecker(hand,showed_hand,t14);
		ArrayList<Meld> result=check.check_if_kong();
		assertEquals(result.size(),0);
		
	}
	
	
	@Test 
	public void TestUpdateHandv1() { //test if can update, using stub to create a get hand functino to know if hand is update inside checker
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,5,6,8,9,10,12,13,40,41,42 ));

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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		hand.add(t10);
		hand.add(t11);
		hand.add(t12);
		hand.add(t13);
		class stubchecker extends FacadeChecker{

			public stubchecker(ArrayList<Tile> hand, ArrayList<Meld> showed_hand, Tile a) {
				super(hand, showed_hand, a);
			}
			
			public ArrayList<Tile> getHand(){
				return this.hand;
				}
		}
		stubchecker check=new stubchecker(hand,showed_hand,t14);
		hand.remove(0);
		hand.add(t14);
		Tile t15=new Tile(51);
		check.UpdateHand(hand, showed_hand, t15);
		boolean result= check.getHand().contains(t15)&& !check.getHand().contains(t1);
		assertEquals(result,true);
		
	}
}

