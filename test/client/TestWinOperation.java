package client;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import network.WinMsg;
import server.Server;
import ui.textUi.TextUi;

class TestWinOperation {

	@Test
	void testInfoWin() throws Exception {
		setOutput();
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
		Client client = new Client(0,new Server(),"TEXT");
		WinOperation winOp = new WinOperation();
		winOp.operate(client, msg);
		assertEquals("client0 wins\n"
				+ "The hand of client 0 is 二条 /三条 /一万 /一万 /六万 /七万 /八万 /\n"
				+ "The hand of client 1 is 幺鸡 /二条 /五条 /八万 /四筒 /五筒 /红中 /白板 /北风 /北风 /\n"
				+ "The hand of client 2 is 七万 /八万 /三筒 /四筒 /五筒 /五筒 /六筒 /六筒 /红中 /北风 /\n"
				+ "The hand of client 3 is 二条 /二条 /五条 /一万 /一万 /七万 /七万 /九万 /三筒 /六筒 /红中 /红中 /白板 /\n",getOutput());
	}
	
	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;

	private void setOutput() throws Exception {
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
	}

	private String getOutput() { // throws Exception
		System.setOut(oldPrintStream);
		return bos.toString();
	}

}
