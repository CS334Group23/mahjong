package gui;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import org.junit.Test;

import utils.BidMsg;
import utils.DrawMsg;
import utils.Tile;
import utils.Type;

public class GameControllerTest {
//	@Test
//	public void testGameController1() {
//		GameController gameController = GameController.getInstance();
//		while(true) {
//			gameController.setVisible(true);
//		}
//	}
	
//	@Test
//	public void testGameController2() throws InterruptedException {
//		GameController gameController = GameController.getInstance();
//		
//		gameController.init(getHands());
//		gameController.setVisible(true);
//		
//		synchronized(this) {
//			this.wait();
//		}
//	}
	
	@Test
	public void testGameController3() throws InterruptedException {
		GameController gameController = GameController.getInstance();
		
		gameController.init(getHands());
		gameController.setVisible(true);
		
		// test add new tile
		gameController.infoDraw(new DrawMsg(50), new ArrayList<BidMsg>());
		
		// add event to new tile
		
		synchronized(this) {
			this.wait();
		}
	}
	
	public ArrayList<ArrayList<Tile>> getHands() {
		ArrayList<ArrayList<Tile>> hands = new ArrayList<>();
		
		Random rand = new Random();
		int randomNum;
		
		for(int i = 0; i < 4; i++) {
			ArrayList<Tile> hand = new ArrayList<>();
			for(int j = 0; j < 13; j++) {
				randomNum = rand.nextInt(120);
				hand.add(new Tile(randomNum));
			}
			hand.sort(new idComparator());
			hands.add(hand);
		}
		
		return hands;
	}
	
	class idComparator implements Comparator<Tile>{

		@Override
		public int compare(Tile o1, Tile o2) {
			int o1Id = o1.getId();
			int o2Id = o2.getId();
			
			if(o1Id == o2Id) return 0;
			
			return o1Id < o2Id ? -1 : 1;
		}
		
	}
}
