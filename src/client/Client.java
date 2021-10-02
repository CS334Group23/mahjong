package client;

import java.util.HashMap;
import utils.*;
import checker.Checker;

public class Client {
	private HashMap<Integer, Type> hand; // ¤âµP
	private HashMap<Integer, Type> meld; // ¸I¤WºbªºµP
	
	public Client(HashMap<Integer, Type> cards) {
		this.hand = cards;
		this.meld = new HashMap<Integer, Type>();
	}
	
	public void draw(Tile tile) {
		hand.put(tile.getId(), tile.getType());
	}
	
	public Tile discard(Tile tile) {
		hand.remove(tile.getId());
		return tile;
	}
	
	public void update() {
		this.hand = CommonUtils.sort(hand);
	}
	
	private Object check() {
		Checker.check(hand, meld);
		return null;
	}
}
