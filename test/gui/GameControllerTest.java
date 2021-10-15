package gui;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import org.junit.Test;

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
	
	@Test
	public void testGameController2() {
		GameController gameController = GameController.getInstance();
		ArrayList<Tile> hand = new ArrayList<>();
		
		Random rand = new Random();
		int randomNum;
		
		for(int i = 0; i < 13; i++) {
			randomNum = rand.nextInt(120);
			hand.add(new Tile(randomNum));
		}
		
		hand.sort(new idComparator());
		gameController.init(hand);
		
		while(true) {
			gameController.setVisible(true);
		}
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
