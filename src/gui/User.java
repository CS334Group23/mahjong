package gui;

import java.util.ArrayList;

import utils.Tile;

public class User {
	private int userId;
	private boolean isRealUser;
	
	private Point handPoint;
	private Point meldPoint;
	private Point boardPoint;
	
	private ArrayList<Tile> hand;
	private ArrayList<Tile> meld;
	
	public User(int id, ArrayList<Tile> hand) {
		this.userId = id;
		this.hand = hand;
		this.meld = new ArrayList<>();
		this.meldPoint = new Point();
		this.isRealUser = false;
		
		// TODO: set coordinate of board point
		switch (id) {
			case 1 : // real user
				isRealUser = true;
				handPoint = new Point(90, 800);
				boardPoint = new Point();
				break;
			case 2 : 
				handPoint = new Point(900, 900);
				boardPoint = new Point();
				break;
			case 3 : 
				handPoint = new Point(250, 50);
				boardPoint = new Point();
				break;
			case 4 : 
				handPoint = new Point(30, 60);
				boardPoint = new Point();
		}
		
		if(hand == null) {
			this.hand = new ArrayList<>();
			for(int i = 0; i < 13; i++) {
				this.hand.add(new Tile(144));
			}
		}
	}

	public ArrayList<Tile> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Tile> hand) {
		this.hand = hand;
	}

	public ArrayList<Tile> getMeld() {
		return meld;
	}

	public void setMeld(ArrayList<Tile> meld) {
		this.meld = meld;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Point getHandPoint() {
		return handPoint;
	}

	public void setHandPoint(Point handPoint) {
		this.handPoint = handPoint;
	}

	public Point getMeldPoint() {
		return meldPoint;
	}

	public void setMeldPoint(Point meldPoint) {
		this.meldPoint = meldPoint;
	}

	public Point getBoardPoint() {
		return boardPoint;
	}

	public void setBoardPoint(Point boardPoint) {
		this.boardPoint = boardPoint;
	}

	public boolean isRealUser() {
		return isRealUser;
	}
	
	
	
}
