/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: TestDrawNoticeOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import network.DrawNoticeMsg;
import server.Server;
import ui.textUi.TextUi;

// TODO: Auto-generated Javadoc
/**
 * The Class TestDrawNoticeOperation.
 */
class TestDrawNoticeOperation {

	/**
	 * Test 1.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void test1() throws Exception {
		setOutput();
		Client client = new Client(0,new Server(),"TEXT");
		DrawNoticeMsg msg = new DrawNoticeMsg(2);
		DrawNoticeOperation op = new DrawNoticeOperation();
		op.operate(client, msg);
		assertEquals("server will send a draw to client: 2\n",getOutput());
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
