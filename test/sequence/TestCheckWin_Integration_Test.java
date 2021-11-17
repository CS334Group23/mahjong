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
		public void IntegrationTestCheckWinv24() { //test if not  nine gate
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
		
		
	}
	
	
}
