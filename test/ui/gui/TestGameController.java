/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: TestGameController.java </p> 
 * @author TeamCS3343 </a>
 */
package ui.gui;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

import client.Client;
import network.DealMsg;
import server.Server;
import ui.gui.GameController;

// TODO: Auto-generated Javadoc
/**
 * The Class TestGameController.
 */
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
	
	/**
 * Test info deal.
 */
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
	
	/**
	 * Test info draw.
	 */
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
