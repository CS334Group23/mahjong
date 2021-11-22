package main;

import server.Server;

public class Main {

	public static void main(String[] args) {
		Server server = new Server();
		server.formRoom();
		for(int i=0; i<4; i++) {// this number can be changed later
			server.init();
			server.startGame();
		}
	}

}
