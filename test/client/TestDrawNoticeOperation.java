package client;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import network.DrawNoticeMsg;
import server.Server;
import ui.textUi.TextUi;

class TestDrawNoticeOperation {

	@Test
	void test1() throws Exception {
		setOutput();
		Client client = new Client(0,new Server(),"TEXT");
		DrawNoticeMsg msg = new DrawNoticeMsg(2);
		DrawNoticeOperation op = new DrawNoticeOperation();
		op.operate(client, msg);
		assertEquals("server will send a draw to client: 2\n",getOutput());
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
