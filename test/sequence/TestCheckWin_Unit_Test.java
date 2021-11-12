package sequence;
import static org.junit.Assert.*;
import org.junit.Test;
import utils.*;
import java.util.*;
public class TestCheckWin_Unit_Test {
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
		hand.add(new Meld(t1,t2,t3,t4));
		hand.add(new Meld(t5,t6,t7,t8));
		hand.add(new Meld(t9,t10,t11,t12));
		hand.add(new Meld(t13,t14,t15,t16));
		hand.add(new Meld(t17,t18,null,null));
		ArrayList<Meld> Showed_hand = new ArrayList<>();
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
	public void UnitTestMCv1() { ///All_One_suit test false
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
	public void UnitTestMCv2() { ///All_One_suit test false
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
	public void IntegrationTestCheckScore() {
		//will write once all scoring method are done ( some exception case need to handle)
		
		
	}
}
