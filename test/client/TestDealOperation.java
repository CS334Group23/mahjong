/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: TestDealOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import network.DealMsg;
import server.Server;
import ui.textUi.TextUi;

// TODO: Auto-generated Javadoc
/**
 * The Class TestDealOperation.
 */
class TestDealOperation {

	/**
	 * Test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void test() throws Exception {
		setOutput();
		Client client = new Client(0,new Server(),"TEXT");
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(20,28,36,37,38,44,56,57,68,69,72,76,84));
		DealOperation dealOp = new DealOperation();
		dealOp.operate(client, new DealMsg(a));
		assertEquals("Client0 has cards: 六条 /八条 /一万 /一万 /一万 /三万 /六万 /六万 /九万 /九万 /一筒 /二筒 /四筒 /\n",getOutput());
	}
	
	/** The old print stream. */
	PrintStream oldPrintStream;
	
	/** The bos. */
	ByteArrayOutputStream bos;

	/**
	 * Sets the output.
	 *
	 * @throws Exception the exception
	 */
	private void setOutput() throws Exception {
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
	}

	/**
	 * Gets the output.
	 *
	 * @return the output
	 */
	private String getOutput() { // throws Exception
		System.setOut(oldPrintStream);
		return bos.toString();
	}

}
