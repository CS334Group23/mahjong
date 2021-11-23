package gui;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

import client.Client;
import network.DealMsg;
import server.Server;

public class TestGameController {
//	@Test
//	public void testGameControllerInit() {
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        PrintStream ps = new PrintStream(baos);
//        System.setOut(ps);
//		
//        Client client = new Client(0, new Server());
//        GameController gameController = GameController.getInstance();
//        gameController.init(client);
//        
//        //assertEquals("Get gameController instance", baos.toString());
//	}
	
	@Test
	public void testInfoDeal() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		
		// set up client for gamePanel
		Client client = new Client(0, new Server());
		ArrayList<Integer> tileIds = new ArrayList<>();
		for(int i = 0; i < 13; i++) {
			tileIds.add(1);
		}
		client.initWall(tileIds);
		
		GameController gameController = GameController.getInstance();
		gameController.init(client);
		
		
		DealMsg msg = new DealMsg(tileIds);
		gameController.infoDeal(msg);
		
		
//		synchronized(gameController) {
//			try {
//				gameController.wait();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		
//		assertEquals("GamePanel infoDeal", baos.toString());
	}	
	
	@Test
	public void testInfoDraw() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		
		// set up client for gamePanel
		Client client = new Client(0, new Server());
		ArrayList<Integer> tileIds = new ArrayList<>();
		for(int i = 0; i < 13; i++) {
			tileIds.add(1);
		}
		client.initWall(tileIds);
		
		GameController gameController = GameController.getInstance();
		gameController.init(client);
		
		
		DealMsg msg = new DealMsg(tileIds);
		gameController.infoDeal(msg);
	
//		assertEquals("GamePanel infoDraw", baos.toString());
	}	
	
	
}
