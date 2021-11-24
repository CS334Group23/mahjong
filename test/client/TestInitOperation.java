package client;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import network.InitMsg;
import server.Server;
import ui.textUi.TextUi;

class TestInitOperation {

	@Test
	void testInit() throws Exception {
		setOutput();
		Client client = new Client(0,new Server(),"TEXT");
		InitOperation initOp = new InitOperation();
		initOp.operate(client, new InitMsg());
		assertEquals("text ui init\n",getOutput());
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
