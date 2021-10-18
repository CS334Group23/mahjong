package sequence;
import static org.junit.Assert.*;
import org.junit.Test;
import utils.*;
import java.util.*;

// this is for testing , so please ignore it
public class Test_score{
	@Test
	
	
	public void test() {
			
			ArrayList<Tile> hand = new ArrayList<>();
			Combination comb = new Combination();
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
			int score=check.CheckScore(hand, showed_hand);
			//System.out.println(score);
			assertEquals(11, score);
		
	}
	

}
