/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: Main.java </p> 
 * @author TeamCS3343 </a>
 */
package main;

import server.Server;
import utils.CommandLineParser;

public class Main {

	/**
	 * The main method.
	 *
	 * @param args the command line arguments
	 */
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
