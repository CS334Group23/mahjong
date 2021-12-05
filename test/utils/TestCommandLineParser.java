package utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCommandLineParser {

	@Test
	void test1() {
		String arguments[] = new String[] {"-GUI","-NUM","4"};
		CommandLineParser cmd = new CommandLineParser(arguments);
		assertEquals("4",cmd.getArgumentValue("NUM")[0].toString());
	}

	@Test
	void test2() {
		String arguments[] = new String[] {"-GUI"};
		CommandLineParser cmd = new CommandLineParser(arguments);
		assertEquals(null,cmd.getArgumentValue("GUI"));
	}
}
