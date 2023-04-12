/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: TestInitOperation.java </p> 
 * @author TeamCS3343 </a>
 */
package client;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import network.InitMsg;
import server.Server;
import ui.textUi.TextUi;

// TODO: Auto-generated Javadoc
/**
 * The Class TestInitOperation.
 */
class TestInitOperation {

	/**
	 * Test init.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testInit() throws Exception {
		setOutput();
		Client client = new Client(0,new Server(),"TEXT");
		InitOperation initOp = new InitOperation();
		initOp.operate(client, new InitMsg());
		assertEquals("text ui init\n"+
				 "Game Start!!\n",getOutput());
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
