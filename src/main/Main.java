package main;

import server.Server;
import utils.CommandLineParser;

public class Main {

	public static void main(String[] args) {
		// parse the command line argument
		CommandLineParser clp = new CommandLineParser(args);
		
		String[] uiArgs = clp.getArgumentValue("ui");
		if(uiArgs == null || uiArgs.length != 1) {
			System.exit(1);
		}
		Server server = new Server();
		server.formRoom(uiArgs[0]);
		for(int i=0; i<4; i++) {// this number can be changed later
			server.init();
			server.startGame();
		}
	}

}
