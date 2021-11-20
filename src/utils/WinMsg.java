package utils;

import java.util.ArrayList;

public class WinMsg implements Message{
	private String opName;
	private int clientId;
	private int winClientId;
	private ArrayList<Integer> hand;
	private ArrayList<ArrayList<Integer>> hands;
	
	public WinMsg(int clientId, int winClientId, ArrayList<Integer> hand) {
		this.clientId = clientId;
		this.winClientId = winClientId;
		this.hand = hand;
		this.opName = "WinOperation";
		this.hands = new ArrayList<>();
		for(int i=0; i<4; i++) {//here is a hard code which needed to be removed later
			hands.add(null);
		}
	}
	
	
	@Override
	public String getOperationName() {
		return opName;
	}
	
	public void addHand(int clientId, ArrayList<Integer> hand) {
		hands.set(clientId, hand);
	}
	
	public ArrayList<Integer> getHandList() {
		return hand;
	}
	
	public ArrayList<ArrayList<Integer>> getHandsList(){
		return hands;
	}
	
	public int getClientId() {
		return clientId;
	}
	
	public int getWinClientId() {
		return winClientId;
	}
	
}
