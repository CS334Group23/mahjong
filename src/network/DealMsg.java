package network;

import java.util.ArrayList;

public class DealMsg implements Message{
	private ArrayList<Integer> initCards;
	private String opName;
	
	public DealMsg(ArrayList<Integer> cards) {
		this.initCards = cards;
		this.opName = "DealOperation";
	}
	
	@Override
	public String getOperationName() {
		return opName;
	}
	
	public ArrayList<Integer> getInitCards(){
		return initCards;
	}
}
