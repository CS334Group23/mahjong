package sequence;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import utils.Meld;
import utils.Tile;
public class TestCheckWin_Integration_Test {


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
		boolean res2 = checkwin.checkIsWin(hand, showed_hand);
		assertEquals(true,result);
		assertEquals(true,res2);
		
		
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
	public void IntegrationTestCheckWinv11() { //test if not mixed terminals
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
	
	@Test
	public void IntegrationTestCheckWinv12() { //test if  small Dragons
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,112,113,114,116,117,122,120,121,4,5,6));
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
			if(s.getClass()== (new Small_Dragons()).getClass())
				result= true;
			
		}
		assertEquals(true,result);
		
		
	}
	@Test
		public void IntegrationTestCheckWinv13() { //test if not small Dragons
			ArrayList<Tile> hand = new ArrayList<>();
			ArrayList<Meld> showed_hand=new ArrayList<>();
			ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,112,113,114,0,1,2,125,126,4,5,6));
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
				if(s.getClass()== (new Small_Dragons()).getClass())
					result= true;
				
			}
			assertEquals(false,result);
			
			
		}
		@Test
		public void IntegrationTestCheckWinv14() { //test if  small winds
			ArrayList<Tile> hand = new ArrayList<>();
			ArrayList<Meld> showed_hand=new ArrayList<>();
			ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(124,125,126,128,129,130,132,133,134,108,109,110,120,121));
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
				if(s.getClass()== (new Small_Winds()).getClass())
					result= true;
				
			}
			assertEquals(true,result);
			
			
		}
		
		@Test
		public void IntegrationTestCheckWinv15() { //test if not small winds
					ArrayList<Tile> hand = new ArrayList<>();
					ArrayList<Meld> showed_hand=new ArrayList<>();
					ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(124,125,126,128,129,130,132,133,134,108,109,110,112,113));
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
						if(s.getClass()== (new Small_Winds()).getClass())
							result= true;
						
					}
					assertEquals(false,result);
					
					
	}
		@Test
		public void IntegrationTestCheckWinv16() { //test if  all honours
			ArrayList<Tile> hand = new ArrayList<>();
			ArrayList<Meld> showed_hand=new ArrayList<>();
			ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(124,125,126,128,129,130,132,133,134,108,109,110,112,113));
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
				if(s.getClass()== (new All_Honours()).getClass())
					result= true;
				
			}
			assertEquals(true,result);
			
			
		}	

		@Test
		public void IntegrationTestCheckWinv17() { //test if  not all honours
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
				if(s.getClass()== (new All_Honours()).getClass())
					result= true;
				
			}
			assertEquals(false,result);
			
			
		}	
		
		@Test
		public void IntegrationTestCheckWinv18() { //test if  all terminals
			ArrayList<Tile> hand = new ArrayList<>();
			ArrayList<Meld> showed_hand=new ArrayList<>();
			ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,69,70,71,72,73));
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
				if(s.getClass()== (new All_Terminals()).getClass())
					result= true;
				
			}
			assertEquals(true,result);
			
			
		}	

		@Test
		public void IntegrationTestCheckWinv19() { //test if not all terminals
			ArrayList<Tile> hand = new ArrayList<>();
			ArrayList<Meld> showed_hand=new ArrayList<>();
			ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,69,70,74,75,76));
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
				if(s.getClass()== (new All_Terminals()).getClass())
					result= true;
				
			}
			assertEquals(false,result);
			
			
		}
		
		@Test
		public void IntegrationTestCheckWinv20() { //test if Great Dragons
			ArrayList<Tile> hand = new ArrayList<>();
			ArrayList<Meld> showed_hand=new ArrayList<>();
			ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,112,113,114,116,117,118,69,70,72,73,74));
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
				if(s.getClass()== (new Great_Dragons()).getClass())
					result= true;
				
			}
			assertEquals(true,result);
			
			
		}
		@Test
		public void IntegrationTestCheckWinv21() { //test if not Great Dragons
			ArrayList<Tile> hand = new ArrayList<>();
			ArrayList<Meld> showed_hand=new ArrayList<>();
			ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,112,113,114,124,125,126,69,70,72,73,74));
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
				if(s.getClass()== (new Great_Dragons()).getClass())
					result= true;
				
			}
			assertEquals(false,result);
			
			
		}
		@Test
		public void IntegrationTestCheckWinv22() { //test if Great Wind
			ArrayList<Tile> hand = new ArrayList<>();
			ArrayList<Meld> showed_hand=new ArrayList<>();
			ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(120,121,122,128,129,130,132,133,134,124,125,126,108,109));
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
				if(s.getClass()== (new Great_Winds()).getClass())
					result= true;
				
			}
			assertEquals(true,result);
			
			
		}	
		@Test
		public void IntegrationTestCheckWinv23() { //test if not  Great Wind
			ArrayList<Tile> hand = new ArrayList<>();
			ArrayList<Meld> showed_hand=new ArrayList<>();
			ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(124,125,126,128,129,130,132,133,1,2,3,110,108,109));
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
				if(s.getClass()== (new Great_Winds()).getClass())
					result= true;
				
			}
			assertEquals(false,result);
			
			
		}	
		@Test
		public void IntegrationTestCheckWinv24() { //test if   nine gate
			ArrayList<Tile> hand = new ArrayList<>();
			ArrayList<Meld> showed_hand=new ArrayList<>();
			ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,34,35));
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
				if(s.getClass()== (new Nine_Gates()).getClass())
					result= true;
				
			}
			assertEquals(true,result);
			
			
		}
		
		@Test
		public void IntegrationTestCheckWinv25() { //test if not  nine gate
			ArrayList<Tile> hand = new ArrayList<>();
			ArrayList<Meld> showed_hand=new ArrayList<>();
			ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,108,109,110));
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
				if(s.getClass()== (new Nine_Gates()).getClass())
					result= true;
				
			}
			assertEquals(false,result);
			
			
		}	
		
		@Test
		public void IntegrationTestCheckWinv26() { //test if thirteen orphans
			ArrayList<Tile> hand = new ArrayList<>();
			ArrayList<Meld> showed_hand=new ArrayList<>();
			ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,32,36,69,72,107,108,112,116,120,124,128,132,133));
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
				if(s.getClass()== (new Thirteen_Orphans()).getClass())
					result= true;
				
			}
			assertEquals(true,result);
			
			
		}	
		@Test
		public void IntegrationTestCheckWinv27() { //test if not thirteen orphans
			ArrayList<Tile> hand = new ArrayList<>();
			ArrayList<Meld> showed_hand=new ArrayList<>();
			ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,32,36,69,72,107,108,112,116,120,124,128,132,4));
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
				if(s.getClass()== (new Thirteen_Orphans()).getClass())
					result= true;
				
			}
			assertEquals(false,result);
			
			
		}	
		@Test
		public void IntegrationTestCheckWinv28() { //if it is four triplets
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
				if(s.getClass()== (new Four_Concealed_Triplets()).getClass())
					result= true;
				
			}
			assertEquals(true,result);
			
			
		}
		@Test
		public void IntegrationTestCheckWinv29() { //if it is four triplets
			ArrayList<Tile> hand = new ArrayList<>();
			ArrayList<Meld> showed_hand=new ArrayList<>();
			ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,4,8,32,33,34,36,37,38,108,109,110,5,6));
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
				if(s.getClass()== (new Four_Concealed_Triplets()).getClass())
					result= true;
				
			}
			assertEquals(false,result);
			
			
		}
	//test extra score
	@Test
	public void IntegrationTestCheckWinv30() { //test if  win from wall
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,4,8,32,33,34,36,37,38,108,109,110,4,5));
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
	public void IntegrationTestCheckWinv33() { //test if not Red Dragon
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
		boolean hasWin=false;
		boolean hasFour=false;
		for(Sequence s:seq) {
			if(s.getClass()== (new All_In_Triplet()).getClass())
				result= true;
			if(s.getClass()==(new Win_From_Wall().getClass()))
				hasWin = true;			
			if(s.getClass()==(new Four_Concealed_Triplets().getClass()))
				hasFour=true;	
			
		}
		assertEquals(false,result);
		assertEquals(false,hasWin);
		assertEquals(true,hasFour);
		
		
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
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17));
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
		boolean has_all_kongs=false;
		for(Sequence s:seq) {
			if(s.getClass().equals(new All_In_Triplet().getClass()))
				result= true;
			if(s.getClass()==(new All_Kongs().getClass()))
				has_all_kongs=true;
		}
		assertEquals(has_all_kongs,true);
		assertEquals(false,result);
		
		
	}
	
	/*

	@Test
	public void IntegrationTestCheckWinv41() { //if it is all one suit, cannot be mixed one suit
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,5,6,8,9,10,12,13,14,16,17));
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
	public void IntegrationTestCheckWinv42() { //if it is all terminals, cannot be mixed terminals
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,69,70,71,72,73));
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
	
	@Test
	public void IntegrationTestCheckWinv43() { //if it is Great Dragon, cannot be small dragon
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,112,113,114,117,118,119,69,70,71,72,73));
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
			if(s.getClass()== (new Small_Dragons()).getClass())
				result= true;
			
		}
		assertEquals(false,result);
		
		
	}
	
	@Test
	public void IntegrationTestCheckWinv44() { //if it is Great wind, cannot be small wind
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(120,121,122,124,125,126,128,129,130,132,133,134,72,73));
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
			if(s.getClass()== (new Small_Winds()).getClass())
				result= true;
			
		}
		assertEquals(false,result);
		
		
	}
	
	@Test
	public void IntegrationTestCheckWinv45() { //if it is nine gate, cannot be all one suit
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,34,35));
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
	*/
	@Test
	public void IntegrationTestCheckWinv46() { //if it is not winning hand, return empty
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Meld> showed_hand=new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,8,12,16,20,24,28,32,33,34,70));
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
		assertEquals(seq.isEmpty(),true);
		boolean res = checkwin.checkIsWin(hand, showed_hand);
		assertEquals(res,false);
		
		
	}
	
	
	//<---------------------------------------------------------------------------------->
	// Unit Test for function in class CheckWin
	@Test
	public void UnitTestPHv1() { //commonhand/ph test true
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,4,8,12,16,20,24,28,32,36,40,44,5,6 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckPH(hand);
		assertEquals(true,result);
		
	}
	@Test
	public void UnitTestPHv2() { //commonhand/ph test false
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,5,6,8,9,10,13,14,15,16,17 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckPH(hand);
		assertEquals(false,result);
		
	}
	@Test
	public void UnitTestPHHv1() { //All_Pongs/ Pong pong hu test true
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,5,6,8,9,10,13,14,15,16,17 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		ArrayList<Meld> Showed_hand = new ArrayList<>();
		Showed_hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckPPH(hand,Showed_hand);
		assertEquals(true,result);
		
	}
	@Test
	public void UnitTestPHHv2() { ///All_Pongs/ Pong pong hu test false
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,7,11,4,5,6,8,9,10,13,14,15,16,17 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		ArrayList<Meld> Showed_hand = new ArrayList<>();
		Showed_hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));;
		boolean result=checkwin.CheckPPH(hand,Showed_hand);
		assertEquals(false,result);
		
	}
	
	@Test
	public void UnitTestPHHv3() { ///All_Pongs/ Pong pong hu test false if all_honour with dragon
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,112,113,114,116,117,118,120,121,122,124,125  ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		ArrayList<Meld> Showed_hand = new ArrayList<>();
		Showed_hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));;
		boolean result=checkwin.CheckPPH(hand,Showed_hand);
		assertEquals(false,result);
		
		
	}
	@Test
	public void UnitTestPHHv4() { ///All_Pongs/ Pong pong hu test false if all_honour with wind at start
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(120,121,122,124,125,126,128,129,130,132,133,134,108,109  ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		ArrayList<Meld> Showed_hand = new ArrayList<>();
		Showed_hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));;
		boolean result=checkwin.CheckPPH(hand,Showed_hand);
		assertEquals(false,result);
		
	}
	@Test
	public void UnitTestPHHv5() { //All_Pongs/ Pong pong hu test false as mc
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,5,6,8,9,10,13,14,15,16,17 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		ArrayList<Meld> Showed_hand = new ArrayList<>();
		boolean result=checkwin.CheckPPH(hand,Showed_hand);
		assertEquals(false,result);
		
	}
	@Test
	public void UnitTestPHHv6() { //All_Pongs/ Pong pong hu test false as all_kongs
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,40,41 ));
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
		Tile t15= new Tile(a.get(14));
		Tile t16= new Tile(a.get(15));
		Tile t17= new Tile(a.get(16));
		Tile t18= new Tile(a.get(17));
	
		hand.add(new Meld(t17,t18,null,null));
		ArrayList<Meld> Showed_hand = new ArrayList<>();
		Showed_hand.add(new Meld(t1,t2,t3,t4));
		Showed_hand.add(new Meld(t5,t6,t7,t8));
		Showed_hand.add(new Meld(t9,t10,t11,t12));
		Showed_hand.add(new Meld(t13,t14,t15,t16));
		boolean result=checkwin.CheckPPH(hand,Showed_hand);
		assertEquals(false,result);
		
	}
	@Test
	public void UnitTestHYSv1() { ///Mixed_One_suit test false : if this is All_One_Suit return false
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,7,11,4,5,6,8,9,10,13,14,15,16,17 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckHYS(hand);
		assertEquals(false,result);
		
	}
	@Test
	public void UnitTestHYSv2() { ///Mixed_One_suit test false : if this is all honour return false
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,112,113,114,116,117,118,120,121,122,124,125 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckHYS(hand);
		assertEquals(false,result);
		
	}
	@Test
	public void UnitTestHYSv3() { ///Mixed_One_suit test true
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,7,11,4,5,6,8,9,10,112,113,114,109,110 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckHYS(hand);
		assertEquals(true,result);
		
	}
	@Test
	public void UnitTestHYSv4() { ///Mixed_One_suit test false if two type
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,7,11,4,5,6,8,9,10,36,37,38,109,110 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckHYS(hand);
		assertEquals(false,result);
		
	}
	@Test
	public void UnitTestQYSv1() { ///All_One_suit test true
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,7,11,4,5,6,8,9,10,13,14,15,16,17 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckQYS(hand);
		assertEquals(true,result);
		
	}
	@Test
	public void UnitTestQYSv2() { ///All_One_suit test true
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,7,11,4,5,6,8,9,10,13,14,15,16,17 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckQYS(hand);
		assertEquals(true,result);
		
	}
	@Test
	public void UnitTestQYSv3() { ///All_One_suit test false if all honour
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,112,113,114,116,117,118,120,121,122,124,125 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckQYS(hand);
		assertEquals(false,result);
		
	}
	@Test 
	public void UnitTestCheckHYJv1() { //test true
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,108,109,110,112,113 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckHYJ(hand);
		assertEquals(true,result);
		
	}
	@Test 
	public void UnitTestCheckHYJv2() { //test false
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,108,109,110,4,5 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckHYJ(hand);
		assertEquals(false,result);
		
	}
	@Test 
	public void UnitTestCheckHYJv3() { //test false if chow exist
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,4,8,32,33,34,36,37,38,108,109,110,4,5 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckHYJ(hand);
		assertEquals(false,result);
		
	}
	@Test 
	public void UnitTestCheckHYJv4() { //test false for all terminals 
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,69,70,71,72,73 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckHYJ(hand);
		assertEquals(false,result);
		
	}
	@Test 
	public void UnitTestCheckHYJv5() { //test false for no terminals 
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,112,113,114,116,117,118,120,121,122,124,125 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckHYJ(hand);
		assertEquals(false,result);
		
	}
	@Test
	public void UnitTestMCv1() { ///MC test false
		ArrayList<Meld> hand = new ArrayList<>();
		Tile t1= new Tile(0);
		Tile t2= new Tile(1);
		Tile t3= new Tile(2);
		hand.add(new Meld(t1,t2,t3,null));
		CheckWin checkwin=new CheckWin();
		boolean result=checkwin.CheckMC(hand);
		assertEquals(false,result);
		
	}
	@Test
	public void UnitTestMCv2() { ///MC test false
		ArrayList<Meld> hand = new ArrayList<>();
		CheckWin checkwin=new CheckWin();
		boolean result=checkwin.CheckMC(hand);
		assertEquals(true,result);
		
	}
	@Test
	public void UnitTestCheckSameTypev1() { //test false
		CheckWin checkwin=new CheckWin();
		checkwin.CheckSameType(new Tile(0), new Tile(1));
		
	}
	@Test
	public void UnitTestCheckSameTypev2() { //test true
		CheckWin checkwin=new CheckWin();
		checkwin.CheckSameType(new Tile(0), new Tile(36));
		
	}
	@Test
	public void UnitTestCheckRedDragonv1() { ///test false
		ArrayList<Meld> hand = new ArrayList<>();
		Tile t1= new Tile(0);
		Tile t2= new Tile(1);
		Tile t3= new Tile(2);
		hand.add(new Meld(t1,t2,t3,null));
		CheckWin checkwin=new CheckWin();
		boolean result=checkwin.CheckRedDragon(hand);
		assertEquals(false,result);
		
	}
	@Test
	public void UnitTestCheckRedDragonv2() { ///test true
		ArrayList<Meld> hand = new ArrayList<>();
		Tile t1= new Tile(108);
		Tile t2= new Tile(109);
		Tile t3= new Tile(110);
		hand.add(new Meld(t1,t2,t3,null));
		CheckWin checkwin=new CheckWin();
		boolean result=checkwin.CheckRedDragon(hand);
		assertEquals(true,result);
		
	}
	@Test
	public void UnitTestCheckGreenDragonv1() { ///test false
		ArrayList<Meld> hand = new ArrayList<>();
		Tile t1= new Tile(0);
		Tile t2= new Tile(1);
		Tile t3= new Tile(2);
		hand.add(new Meld(t1,t2,t3,null));
		CheckWin checkwin=new CheckWin();
		boolean result=checkwin.CheckGreenDragon(hand);
		assertEquals(false,result);
		
	}
	@Test
	public void UnitTestCheckGreenDragonv2() { ///test true
		ArrayList<Meld> hand = new ArrayList<>();
		Tile t1= new Tile(112);
		Tile t2= new Tile(113);
		Tile t3= new Tile(114);
		hand.add(new Meld(t1,t2,t3,null));
		CheckWin checkwin=new CheckWin();
		boolean result=checkwin.CheckGreenDragon(hand);
		assertEquals(true,result);
		
	}
	@Test
	public void UnitTestCheckWhiteDragonv1() { ///test false
		ArrayList<Meld> hand = new ArrayList<>();
		Tile t1= new Tile(0);
		Tile t2= new Tile(1);
		Tile t3= new Tile(2);
		hand.add(new Meld(t1,t2,t3,null));
		CheckWin checkwin=new CheckWin();
		boolean result=checkwin.CheckWhiteDragon(hand);
		assertEquals(false,result);
		
	}
	@Test
	public void UnitTestCheckWhiteDragonv2() { ///test true
		ArrayList<Meld> hand = new ArrayList<>();
		Tile t1= new Tile(116);
		Tile t2= new Tile(117);
		Tile t3= new Tile(118);
		hand.add(new Meld(t1,t2,t3,null));
		CheckWin checkwin=new CheckWin();
		boolean result=checkwin.CheckWhiteDragon(hand);
		assertEquals(true,result);
		
	}
	@Test
	public void IntegrationTestCheckKKHv1() { //check four concealed triplets if true
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,5,6,8,9,10,13,14,15,16,17 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		ArrayList<Meld> Showed_hand = new ArrayList<>();
		boolean result=checkwin.CheckKKH(hand,Showed_hand);
		assertEquals(true,result);
		
		
	}
	
	@Test
	public void UnitTestCheckKKHv1() { //check four concealed triplets if false
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,5,6,8,9,10,13,14,15,16,17 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		ArrayList<Meld> Showed_hand = new ArrayList<>();
		boolean result=checkwin.CheckKKH(hand,Showed_hand);
		assertEquals(true,result);
		
		
	}
	
	@Test
	public void UnitTestCheckKKHv2() { //check four concealed triplets if false
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,4,8,12,16,20,24,28,32,36,40,44,5,6 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
		hand.add(new Meld(t13,t14,null,null));
		ArrayList<Meld> Showed_hand = new ArrayList<>();
		boolean result=checkwin.CheckKKH(hand,Showed_hand);
		assertEquals(false,result);
		
		
	}
	@Test
	public void UnitTestCheckKKHv3() { //check four concealed triplets if false with not win from wall
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,5,6,8,9,10,13,14,15,16,17 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t13,t14,null,null));

		ArrayList<Meld> Showed_hand = new ArrayList<>();
		Showed_hand.add(new Meld(t10,t11,t12,null));
		boolean result=checkwin.CheckKKH(hand,Showed_hand);
		assertEquals(false,result);
		
		
	}
	
	@Test
	public void UnitTestCheckXSYv1() { //check small dragon if true
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,5,6,108,109,110,112,113,114,116,117 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckXSY(hand);
		assertEquals(true,result);
		
		
	}
	
	@Test
	public void UnitTestCheckXSYv2() { //check small dragon if false
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,4,5,6,108,109,110,112,113,114,120,121 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckXSY(hand);
		assertEquals(false,result);
		
		
	}
	
	@Test
	public void UnitTestCheckXSYv3() { //check small dragon if false as great dragons
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,112,113,114,116,117,118,0,1,2,4,5 ));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckXSY(hand);
		assertEquals(false,result);
		
		
	}
	
	@Test
	public void UnitTestCheckXSXv1() { //check small wind if true
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,121,122,123,124,125,126,128,129,130,132,133));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckXSX(hand);
		assertEquals(true,result);
		
		
	}
	
	@Test
	public void UnitTestCheckXSXv2() { //check small wind if false
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,121,122,123,124,125,126,128,129,130,112,113));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckXSX(hand);
		assertEquals(false,result);
		
		
	}
	@Test
	public void UnitTestCheckXSXv3() { //check small wind if false as great wind
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,121,122,123,124,125,126,128,129,130,112,113));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckXSX(hand);
		assertEquals(false,result);
		
		
	}
	
	@Test
	public void UnitTestCheckZYSv1() { //check all honour if true 
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,121,122,123,124,125,126,128,129,130,112,113));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckZYS(hand);
		assertEquals(true,result);
		
		
	}
	
	@Test
	public void UnitTestCheckZYSv2() { //check all honour if false 
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,121,122,123,124,125,126,128,129,130,0,1));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckZYS(hand);
		assertEquals(false,result);
		
		
	}
	
	@Test
	public void UnitTestCheckQYJv1() { //check all terminals if true
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,69,70,71,72,73));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckQYJ(hand);
		assertEquals(true,result);
		
		
	}
	
	@Test
	public void UnitTestCheckQYJv2() { //check all terminals if false
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,32,33,34,36,37,38,69,70,71,4,5));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckQYJ(hand);
		assertEquals(false,result);
		
		
	}
	
	@Test
	public void UnitTestCheckQYJv3() {// check all terminals if false with honour
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,32,33,34,36,37,38,69,70,71,4,5));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckQYJ(hand);
		assertEquals(false,result);
		
		
	}
	
	@Test
	public void UnitTestCheckDSYv1() {// check great dragon if true
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,112,113,114,116,117,118,69,70,71,4,5));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckDSY(hand);
		assertEquals(true,result);
		
		
	}
	
	@Test
	public void UnitTestCheckDSYv2() {// check great dragon if false
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(108,109,110,112,113,114,120,121,122,69,70,71,4,5));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckDSY(hand);
		assertEquals(false,result);
		
		
	}
	
	@Test
	public void UnitTestCheckDSXv1() {// check great wind if true
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(121,122,123,124,125,126,128,129,130,132,133,134,0,1));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckDSX(hand);
		assertEquals(true,result);
		
		
	}
	
	@Test
	public void UnitTestCheckDSXv2() {// check great wind if false
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,121,122,123,124,125,126,128,129,130,132,133));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckDSX(hand);
		assertEquals(false,result);
		
		
	}
	
	@Test
	public void UnitTestCheckJLBDv1() {// check nine gate if true
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(2,4,8,12,16,20,24,28,32,33,34,35,0,1));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckJLBD(hand);
		assertEquals(true,result);
		
		
	}
	
	@Test
	public void UnitTestCheckJLBDv2() {// check nine gate if false
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(2,4,8,12,16,20,24,28,32,33,34,35,5,6));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckJLBD(hand);
		assertEquals(false,result);
		
		
	}
	@Test
	public void UnitTestCheckJLBDv3() {// check nine gate if true with one of 2-8 has 2
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,8,12,16,20,24,28,32,33,34,5,6));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckJLBD(hand);
		assertEquals(true,result);
		
		
	}
	
	@Test
	public void UnitTestCheckJLBDv4() {// check nine gate if false with first exceed 4
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,3,4,5,20,24,28,32,33,34,6,7));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckJLBD(hand);
		assertEquals(false,result);
		
		
	}
	
	@Test
	public void UnitTestCheckJLBDv5() {// check nine gate if false with not same type
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,36,37,38,20,24,28,32,33,34,5,6));
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
		hand.add(new Meld(t1,t2,t3,null));
		hand.add(new Meld(t4,t5,t6,null));
		hand.add(new Meld(t7,t8,t9,null));
		hand.add(new Meld(t10,t11,t12,null));
	    hand.add(new Meld(t13,t14,null,null));
		boolean result=checkwin.CheckJLBD(hand);
		assertEquals(false,result);
		
		
	}

	
	@Test 
	public void UnitTestCheckSSYv1() {// check SSY if true
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,32,36,71,72,107,108,112,116,120,124,128,132,133));
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
		boolean result=checkwin.CheckSSY(hand);
		assertEquals(true,result);
		
		
	}
	
	@Test 
	public void UnitTestCheckSSYv2() {// check SSY if false if all also terminal tile except one
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,32,36,71,72,107,108,112,116,120,124,128,132,5));
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
		boolean result=checkwin.CheckSSY(hand);
		assertEquals(false,result);
		
		
	}
	@Test 
	public void UnitTestCheckSSYv3() {// check SSY if false 
		ArrayList<Tile> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,5,32,36,71,72,107,108,112,116,120,124,128));
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
		boolean result=checkwin.CheckSSY(hand);
		assertEquals(false,result);
		
		
	}
	@Test 
	public void UnitTestCheckAKSv1() {// check all kongs if true
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,40,41 ));
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
		Tile t15= new Tile(a.get(14));
		Tile t16= new Tile(a.get(15));
		Tile t17= new Tile(a.get(16));
		Tile t18= new Tile(a.get(17));
		hand.add(new Meld(t1,t2,t3,t4));
		hand.add(new Meld(t5,t6,t7,t8));
		hand.add(new Meld(t9,t10,t11,t12));
		hand.add(new Meld(t13,t14,t15,t16));
		hand.add(new Meld(t17,t18,null,null));
		boolean result=checkwin.CheckAKS(hand);
		assertEquals(true,result);
		
		
	}
	@Test 
	public void UnitTestCheckAKSv2() {// check all kongs if false
		ArrayList<Meld> hand = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,40,41 ));
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
		Tile t15= new Tile(a.get(14));
		Tile t16= new Tile(a.get(15));
		Tile t17= new Tile(a.get(16));
		Tile t18= new Tile(a.get(17));
		hand.add(new Meld(t1,t2,t3,t4));
		hand.add(new Meld(t5,t6,t7,t8));
		hand.add(new Meld(t9,t10,t11,null));
		hand.add(new Meld(t13,t14,t15,t16));
		hand.add(new Meld(t17,t18,null,null));
		boolean result=checkwin.CheckAKS(hand);
		assertEquals(false,result);
		
		
	}
	
}
