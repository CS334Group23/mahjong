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
		String[] numArgs = clp.getArgumentValue("num");
		if(numArgs == null || numArgs.length != 1) {
			System.exit(1);
		}
		String ui = uiArgs[0];
		int gameNum = Integer.parseInt(numArgs[0]);
		if(gameNum > 0) {
			Server server = new Server();
			server.formRoom(ui);
			for(int i=0; i<gameNum; i++) {
				server.init();
				server.startGame();
			}
		}
	}

}
