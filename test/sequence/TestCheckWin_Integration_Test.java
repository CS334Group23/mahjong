package sequence;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import utils.Meld;
import utils.Tile;
public class TestCheckWin_Integration_Test {
	@Test
	public void IntegrationTestCheck_if_pong() {
		
		
		
	}
	
	//first test if showed hand + hand can form a winning hand
	@Test
	public void IntegrationTestCheckWinv1() { //test if can output score with meld
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,4,8,40,44,48,52,56,60,72,76,80,76,77 ));
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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		hand.add(t13);
		hand.add(t14);
		showed_hand.add(new Meld(t10,t11,t12,null));
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new Common_Hand()).getClass())
				result= true;
			
		}
		assertEquals(true,result);
		
		
	}
	
	
	// for score, first check all individual scoring method, all method should be true, false, and true with meld
	@Test
	public void IntegrationTestCheckWinv2() { //test if command hand  
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,4,8,40,44,48,52,56,60,72,76,80,76,77 ));
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
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new Common_Hand()).getClass())
				result= true;
			
		}
		assertEquals(true,result);
		
		
	}
	
	
	@Test
	public void IntegrationTestCheckWinv3() { //test if not command hand 
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,40,44,48,52,56,60,72,76,80,76,77 ));
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
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new Common_Hand()).getClass())
				result= true;
			
		}
		assertEquals(false,result);
		
		
	}
	@Test
	public void IntegrationTestCheckWinv4() { //test if all in triplet (must be with showed hand)
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,40,41,42,56,57,58,72,73,74,76,77 ));
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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		showed_hand.add(new Meld(t10,t11,t12,null));
		hand.add(t13);
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new All_In_Triplet()).getClass())
				result= true;
			
		}
		assertEquals(true,result);
		
		
	}
	@Test
	public void IntegrationTestCheckWinv5() { //test if not all in triplet
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,4,8,40,41,42,56,57,58,72,73,74,76,77 ));
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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		showed_hand.add(new Meld(t10,t11,t12,null));
		hand.add(t13);
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new All_In_Triplet()).getClass())
				result= true;
			
		}
		assertEquals(false,result);
		
		
	}
	@Test
	public void IntegrationTestCheckWinv6() { //test if all one suit
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,4,8,9,10,11,17,18,19,24,25,26,29,30 ));
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
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new All_One_Suit()).getClass())
				result= true;
			
		}
		assertEquals(true,result);
		
		
	}
	@Test
	public void IntegrationTestCheckWinv7() { //test if not all one suit
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,4,8,9,10,11,17,18,19,24,25,26,40,41 ));
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
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new All_One_Suit()).getClass())
				result= true;
			
		}
		assertEquals(false,result);
		
		
	}
	
	@Test
	public void IntegrationTestCheckWinv8() { //test if mixed one suit
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,4,8,9,10,11,17,18,19,24,25,26,108,109 ));
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
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new Mixed_One_Suit()).getClass())
				result= true;
			
		}
		assertEquals(true,result);
		
		
	}
	
	@Test
	public void IntegrationTestCheckWinv9() { //test if not mixed one suit
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,4,8,9,10,11,17,18,19,40,41,42,108,109 ));
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
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new Mixed_One_Suit()).getClass())
				result= true;
			
		}
		assertEquals(false,result);
		
		
	}
	
	@Test
	public void IntegrationTestCheckWinv10() { //test if  mixed terminals
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,69,70,71,108,109 ));
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
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new Mixed_Terminals()).getClass())
				result= true;
			
		}
		assertEquals(true,result);
		
		
	}
	@Test
	public void IntegrationTestCheckWinv11() { //test if  mixed terminals
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,108,109,110,4,5));
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
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new Mixed_Terminals()).getClass())
				result= true;
			
		}
		assertEquals(false,result);
		
		
	}
	
	
	
	
	//test extra score
	@Test
	public void IntegrationTestCheckWinv30() { //test if  win from wall
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,108,109,110,4,5));
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
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new Win_From_Wall()).getClass())
				result= true;
			
		}
		assertEquals(true,result);
		
		
	}
	@Test
	public void IntegrationTestCheckWinv31() { //test if not win from wall
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,108,109,110,4,5));
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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		showed_hand.add(new Meld(t10,t11,t12,null));
		hand.add(t13);
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new Win_From_Wall()).getClass())
				result= true;
			
		}
		assertEquals(false,result);
		
		
	}
	
	@Test
	public void IntegrationTestCheckWinv32() { //test if Red Dragon
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,108,109,110,4,5));
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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		showed_hand.add(new Meld(t10,t11,t12,null));
		hand.add(t13);
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new Red_Dragon()).getClass())
				result= true;
			
		}
		assertEquals(true,result);
		
		
	}
	
	@Test
	public void IntegrationTestCheckWinv33() { //test if Red Dragon
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,112,113,114,4,5));
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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		showed_hand.add(new Meld(t10,t11,t12,null));
		hand.add(t13);
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new Red_Dragon()).getClass())
				result= true;
			
		}
		assertEquals(false,result);
		
		
	}
	
	@Test
	public void IntegrationTestCheckWinv34() { //test if Green Dragon
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,112,113,114,4,5));
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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		showed_hand.add(new Meld(t10,t11,t12,null));
		hand.add(t13);
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new Green_Dragon()).getClass())
				result= true;
			
		}
		assertEquals(true,result);
		
		
	}
	
	@Test
	public void IntegrationTestCheckWinv35() { //test if not green Dragon
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,108,109,110,4,5));
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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		showed_hand.add(new Meld(t10,t11,t12,null));
		hand.add(t13);
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new Green_Dragon()).getClass())
				result= true;
			
		}
		assertEquals(false,result);
		
		
	}
	
	@Test
	public void IntegrationTestCheckWinv36() { //test if White Dragon
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,116,117,118,4,5));
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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		showed_hand.add(new Meld(t10,t11,t12,null));
		hand.add(t13);
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new White_Dragon()).getClass())
				result= true;
			
		}
		assertEquals(true,result);
		
		
	}
	
	@Test
	public void IntegrationTestCheckWinv37() { //test if not white Dragon
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,112,113,114,4,5));
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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		showed_hand.add(new Meld(t10,t11,t12,null));
		hand.add(t13);
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new White_Dragon()).getClass())
				result= true;
			
		}
		assertEquals(false,result);
		
		
	}
	
	//Test exception list now
	
	
	//Test with all in triplets
	@Test
	

	public void IntegrationTestCheckWinv38() { //if it is win from wall, cannot be all in triplets
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,108,109,110,4,5));
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
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new All_In_Triplet()).getClass())
				result= true;
			
		}
		assertEquals(false,result);
		
		
	}
	@Test
	public void IntegrationTestCheckWinv39() { //if it is all honours, cannot be all in triplets
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,112,113,114,120,121,122,124,125,126,128,129));
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
		hand.add(t1); 
		hand.add(t2);
		hand.add(t3);
		hand.add(t4);
		hand.add(t5);
		hand.add(t6);
		hand.add(t7);
		hand.add(t8);
		hand.add(t9);
		showed_hand.add(new Meld(t10,t11,t12,null));;
		hand.add(t13);
		hand.add(t14);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new All_In_Triplet()).getClass())
				result= true;
			
		}
		assertEquals(false,result);
		
		
	}
	@Test
	public void IntegrationTestCheckWinv40() { //if it is all kongs, cannot be all in triplets
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18));
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
		Tile t15= new Tile(a.get(13));
		Tile t16= new Tile(a.get(13));
		Tile t17= new Tile(a.get(13));
		Tile t18= new Tile(a.get(13));
		showed_hand.add(new Meld(t1,t2,t3,t4));
		showed_hand.add(new Meld(t5,t6,t7,t8));
		showed_hand.add(new Meld(t9,t10,t11,t12));
		showed_hand.add(new Meld(t13,t14,t15,t16));
		hand.add(t17);
		hand.add(t18);
		ArrayList<Sequence> seq=checkwin.CheckScore(hand,showed_hand);
		boolean result=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new All_In_Triplet()).getClass())
				result= true;
			
		}
		assertEquals(false,result);
		
		
	}

	
}
