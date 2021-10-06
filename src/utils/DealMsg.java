package utils;

import java.util.ArrayList;

public class DealMsg implements Message{
	private ArrayList<Integer> initialcards;
	private String opName;
	
	public DealMsg(ArrayList<Integer> cards) {
		this.initialcards = cards;
		this.opName = "DealOperation";
	}
	
	@Override
	public String getOperationName() {
		return opName;
	}
	
}
