package main;

import org.junit.Test;



public class TestMain {
	@Test
	public void testMainAuto() {
		String[] args = new String[4];
		args[0] = "-ui";
		args[1] = "AI";
		args[2] = "-num";
		args[3] = "100";
		Main.main(args);
	}
	
	@Test
	public void testMainManual() {
		String[] args = new String[4];
		args[0] = "-ui";
		args[1] = "GUI";
		args[2] = "-num";
		args[3] = "3";
		Main.main(args);
	}
}

