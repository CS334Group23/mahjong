package network;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class TestWinMsg {

	@Test
	void testOperationName() {
		ArrayList<ArrayList<Integer>> hands = new ArrayList<>();
		ArrayList<Integer> a1 = new ArrayList<Integer> (Arrays.asList(4,8,36,37,56,60,64));
		ArrayList<Integer> a2 = new ArrayList<Integer> (Arrays.asList(0,5,16,65,84,88,108,116,132,133));
		ArrayList<Integer> a3 = new ArrayList<Integer> (Arrays.asList(61,66,80,85,89,90,92,93,109,134));
		ArrayList<Integer> a4 = new ArrayList<Integer> (Arrays.asList(6,7,17,38,39,62,63,68,81,94,110,111,117));
		ArrayList<Integer> scores = new ArrayList<Integer> (Arrays.asList(1,-1,0,0));
		WinMsg msg = new WinMsg(0,0,null,scores,WinMsg.WINBYDISCARD);
		msg.addHand(0, a1);
		msg.addHand(1, a2);
		msg.addHand(2, a3);
		msg.addHand(3, a4);
		assertEquals("WinOperation",msg.getOperationName());
	}
	
	@Test
	void testGetHandsList() {
		ArrayList<ArrayList<Integer>> hands = new ArrayList<>();
		ArrayList<Integer> a1 = new ArrayList<Integer> (Arrays.asList(4,8,36,37,56,60,64));
		ArrayList<Integer> a2 = new ArrayList<Integer> (Arrays.asList(0,5,16,65,84,88,108,116,132,133));
		ArrayList<Integer> a3 = new ArrayList<Integer> (Arrays.asList(61,66,80,85,89,90,92,93,109,134));
		ArrayList<Integer> a4 = new ArrayList<Integer> (Arrays.asList(6,7,17,38,39,62,63,68,81,94,110,111,117));
		ArrayList<Integer> scores = new ArrayList<Integer> (Arrays.asList(1,-1,0,0));
		WinMsg msg = new WinMsg(0,0,null,scores,WinMsg.WINBYDISCARD);
		msg.addHand(0, a1);
		msg.addHand(1, a2);
		msg.addHand(2, a3);
		msg.addHand(3, a4);
		ArrayList<ArrayList<Integer>> trueHand = new ArrayList<>();
		for(int i=0; i<4; i++) {
			trueHand.add(null);
		}
		trueHand.set(0, a1);
		trueHand.set(1, a2);
		trueHand.set(2, a3);
		trueHand.set(3, a4);
		assertEquals(trueHand,msg.getHandsList());
	}

	@Test
	void testGetHandList() {
		ArrayList<ArrayList<Integer>> hands = new ArrayList<>();
		ArrayList<Integer> a1 = new ArrayList<Integer> (Arrays.asList(4,8,36,37,56,60,64));
		ArrayList<Integer> a2 = new ArrayList<Integer> (Arrays.asList(0,5,16,65,84,88,108,116,132,133));
		ArrayList<Integer> a3 = new ArrayList<Integer> (Arrays.asList(61,66,80,85,89,90,92,93,109,134));
		ArrayList<Integer> a4 = new ArrayList<Integer> (Arrays.asList(6,7,17,38,39,62,63,68,81,94,110,111,117));
		ArrayList<Integer> scores = new ArrayList<Integer> (Arrays.asList(1,-1,0,0));
		WinMsg msg = new WinMsg(0,0,a1,scores,WinMsg.WINBYDISCARD);
		msg.addHand(0, a1);
		msg.addHand(1, a2);
		msg.addHand(2, a3);
		msg.addHand(3, a4);
		ArrayList<ArrayList<Integer>> trueHand = new ArrayList<>();
		for(int i=0; i<4; i++) {
			trueHand.add(null);
		}
		trueHand.set(0, a1);
		trueHand.set(1, a2);
		trueHand.set(2, a3);
		trueHand.set(3, a4);
		assertEquals(a1,msg.getHandList());
	}
	
	@Test
	void testClientId() {
		ArrayList<ArrayList<Integer>> hands = new ArrayList<>();
		ArrayList<Integer> a1 = new ArrayList<Integer> (Arrays.asList(4,8,36,37,56,60,64));
		ArrayList<Integer> a2 = new ArrayList<Integer> (Arrays.asList(0,5,16,65,84,88,108,116,132,133));
		ArrayList<Integer> a3 = new ArrayList<Integer> (Arrays.asList(61,66,80,85,89,90,92,93,109,134));
		ArrayList<Integer> a4 = new ArrayList<Integer> (Arrays.asList(6,7,17,38,39,62,63,68,81,94,110,111,117));
		ArrayList<Integer> scores = new ArrayList<Integer> (Arrays.asList(1,-1,0,0));
		WinMsg msg = new WinMsg(0,0,null,scores,WinMsg.WINBYDISCARD);
		msg.addHand(0, a1);
		msg.addHand(1, a2);
		msg.addHand(2, a3);
		msg.addHand(3, a4);
		assertEquals(0,msg.getClientId());
	}
	
	@Test
	void testWinClientId() {
		ArrayList<ArrayList<Integer>> hands = new ArrayList<>();
		ArrayList<Integer> a1 = new ArrayList<Integer> (Arrays.asList(4,8,36,37,56,60,64));
		ArrayList<Integer> a2 = new ArrayList<Integer> (Arrays.asList(0,5,16,65,84,88,108,116,132,133));
		ArrayList<Integer> a3 = new ArrayList<Integer> (Arrays.asList(61,66,80,85,89,90,92,93,109,134));
		ArrayList<Integer> a4 = new ArrayList<Integer> (Arrays.asList(6,7,17,38,39,62,63,68,81,94,110,111,117));
		ArrayList<Integer> scores = new ArrayList<Integer> (Arrays.asList(1,-1,0,0));
		WinMsg msg = new WinMsg(0,0,null,scores,WinMsg.WINBYDISCARD);
		msg.addHand(0, a1);
		msg.addHand(1, a2);
		msg.addHand(2, a3);
		msg.addHand(3, a4);
		assertEquals(0,msg.getWinClientId());
	}
	
	@Test
	void testScores() {
		ArrayList<ArrayList<Integer>> hands = new ArrayList<>();
		ArrayList<Integer> a1 = new ArrayList<Integer> (Arrays.asList(4,8,36,37,56,60,64));
		ArrayList<Integer> a2 = new ArrayList<Integer> (Arrays.asList(0,5,16,65,84,88,108,116,132,133));
		ArrayList<Integer> a3 = new ArrayList<Integer> (Arrays.asList(61,66,80,85,89,90,92,93,109,134));
		ArrayList<Integer> a4 = new ArrayList<Integer> (Arrays.asList(6,7,17,38,39,62,63,68,81,94,110,111,117));
		ArrayList<Integer> defaultScores = new ArrayList<Integer> (Arrays.asList(0,0,0,0));
		ArrayList<Integer> scores = new ArrayList<Integer> (Arrays.asList(1,-1,0,0));
		WinMsg msg = new WinMsg(0,0,null,scores,WinMsg.WINBYDISCARD);
		msg.addHand(0, a1);
		msg.addHand(1, a2);
		msg.addHand(2, a3);
		msg.addHand(3, a4);
		msg.setScores(scores);
		assertEquals(Arrays.asList(1,-1,0,0),msg.getScores());
	}
	
	@Test
	void testWinType() {
		ArrayList<ArrayList<Integer>> hands = new ArrayList<>();
		ArrayList<Integer> a1 = new ArrayList<Integer> (Arrays.asList(4,8,36,37,56,60,64));
		ArrayList<Integer> a2 = new ArrayList<Integer> (Arrays.asList(0,5,16,65,84,88,108,116,132,133));
		ArrayList<Integer> a3 = new ArrayList<Integer> (Arrays.asList(61,66,80,85,89,90,92,93,109,134));
		ArrayList<Integer> a4 = new ArrayList<Integer> (Arrays.asList(6,7,17,38,39,62,63,68,81,94,110,111,117));
		ArrayList<Integer> scores = new ArrayList<Integer> (Arrays.asList(1,-1,0,0));
		WinMsg msg = new WinMsg(0,0,null,scores,WinMsg.TIE);
		msg.setWinType(WinMsg.WINBYDISCARD);
		msg.addHand(0, a1);
		msg.addHand(1, a2);
		msg.addHand(2, a3);
		msg.addHand(3, a4);
		assertEquals(1,msg.getWinType());
	}
	
}
