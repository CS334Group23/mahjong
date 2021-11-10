package gui;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import org.junit.Test;

import utils.BidMsg;
import utils.BidType;
import utils.DiscardMsg;
import utils.DrawMsg;
import utils.Meld;
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
	
//	@Test
//	public void testGameController3() throws InterruptedException {
//		GameController gameController = GameController.getInstance();
//		
//		gameController.init(getHands());
//		gameController.setVisible(true);
//		
//		// test add new tile
//		ArrayList<BidMsg> possibleBid = new ArrayList<>();
//		
//		Meld kongMeld = new Meld(new Tile(50),new Tile(50),new Tile(50),new Tile(50));
//		BidMsg bidMsg = new BidMsg(User.USER_BOTTOM, BidType.KONG, "KongResponser", 0, kongMeld, new ArrayList<Integer>());
//		possibleBid.add(bidMsg);
//		
//		bidMsg = new BidMsg(User.USER_BOTTOM, BidType.EMPTY, "", 0, kongMeld, new ArrayList<Integer>());
//		possibleBid.add(bidMsg);
//
//		kongMeld = new Meld(new Tile(50),new Tile(50),new Tile(50),new Tile(50));
//		bidMsg = new BidMsg(User.USER_RIGHT, BidType.KONG, "KongResponser", 0, kongMeld, new ArrayList<Integer>());
//		possibleBid.add(bidMsg);
//		
//		kongMeld = new Meld(new Tile(50),new Tile(50),new Tile(50),new Tile(50));
//		bidMsg = new BidMsg(User.USER_TOP, BidType.KONG, "KongResponser", 0, kongMeld, new ArrayList<Integer>());
//		possibleBid.add(bidMsg);
//		
//		kongMeld = new Meld(new Tile(50),new Tile(50),new Tile(50),new Tile(50));
//		bidMsg = new BidMsg(User.USER_LEFT, BidType.KONG, "KongResponser", 0, kongMeld, new ArrayList<Integer>());
//		possibleBid.add(bidMsg);
//		
//		gameController.infoDraw(new DrawMsg(50), possibleBid);
//		
//		// add event to new tile
//		
//		synchronized(this) {
//			this.wait();
//		}
//	}
	
	@Test
	public void testGameController4() throws InterruptedException {
		GameController gameController = GameController.getInstance();
		
		gameController.init(getHands());
		gameController.setVisible(true);
		
		ArrayList<BidMsg> possibleBid = new ArrayList<>();
		
		Meld kongMeld = new Meld(new Tile(50),new Tile(50),new Tile(50),new Tile(50));
		BidMsg bidMsg = new BidMsg(User.USER_BOTTOM, BidType.KONG, "KongResponser", 0, kongMeld, new ArrayList<Integer>());
		possibleBid.add(bidMsg);
		
		bidMsg = new BidMsg(User.USER_BOTTOM, BidType.PONG, "", 0, kongMeld, new ArrayList<Integer>());
		possibleBid.add(bidMsg);
		
		bidMsg = new BidMsg(User.USER_BOTTOM, BidType.EMPTY, "", 0, kongMeld, new ArrayList<Integer>());
		possibleBid.add(bidMsg);
		
		DiscardMsg msg0 = new DiscardMsg(112, 0);
		DiscardMsg msg1 = new DiscardMsg(112, 1);
		DiscardMsg msg2 = new DiscardMsg(112, 2);
		DiscardMsg msg3 = new DiscardMsg(112, 3);
		
		for(int i = 0; i < 23; i++) {
			gameController.infoDiscard(msg0, null);
			gameController.infoDiscard(msg1, null);
			gameController.infoDiscard(msg2, null);
			gameController.infoDiscard(msg3, null);
		}
		
		gameController.infoDiscard(msg0, possibleBid);
		
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
			hand = Tile.sortTileList(hand);
			//hands.add(hand);
			
			// for testing kong
			if(i == 0) {
				hands.add(getDeisgnedHand());
			} else {
				hands.add(hand);
			}
		}
		
		return hands;
	}
	
	public ArrayList<Tile> getDeisgnedHand(){
		ArrayList<Tile> hand = new ArrayList<>();
		hand.add(new Tile(48));
		hand.add(new Tile(49));
		hand.add(new Tile(51));
		
		hand.add(new Tile(52));
		hand.add(new Tile(53));
		hand.add(new Tile(54));
		hand.add(new Tile(55));
		
		hand.add(new Tile(56));
		hand.add(new Tile(57));
		hand.add(new Tile(58));
		hand.add(new Tile(59));
		
		hand.add(new Tile(60));
		
		hand = Tile.sortTileList(hand);
		return hand;
	}
}
