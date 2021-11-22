package utils;

import java.util.ArrayList;

public class BidMsg implements Message, Comparable{
	public static final int BID_NUM = 5;
	
	private int clientId;
	private int previousClientId;
	private String opName;
	private int bidType;
	private String responserName;
	private int tileId;
	private Meld meld;
	private String bidName;
	private ArrayList<Integer> winHand;
	private boolean selfDrawn;
	
	public BidMsg(int clientId,int previous, BidType bidType, String responserName, int tileId, Meld meld, ArrayList<Integer> winHand, boolean selfDrawn) {
		this.clientId = clientId;
		this.previousClientId = previous;
		this.opName = "BidOperation";
		this.bidType = bidType.getBidType();
		this.responserName = responserName;
		this.tileId = tileId;
		this.meld = meld;
		this.bidName = bidType.getChnName();
		this.winHand = winHand;
		this.selfDrawn = selfDrawn;
	}
	
	public BidMsg() { //this may need to be deleted later
		
	}
	
	@Override
	public String getOperationName() {
		return opName;
	}

	@Override
	public int compareTo(Object another) {
		return ((BidMsg)another).bidType-this.bidType;
	}
	
	public String getResponserName() {
		return responserName;
	}
	
	public int getBidClient() {
		return clientId;
	}
	
	public Meld getMeld() {
		return meld;
	}
	
	public int getBidType() {
		return bidType;
	}
	
	public String getChnName() {
		return bidName;
	}
	
	public ArrayList<Integer> getWinHand(){
		return winHand;
	}
	
	public static void printBid(ArrayList<BidMsg> msgs) {
		String s = "";
		for(BidMsg msg:msgs) {
			if(msg.getBidType()==0 || msg.getBidType()==4) {
				s = s+(msg.getChnName()+" /");
			}
			else {
				s = s+(msg.getChnName()+" "+msg.getMeld().printMeld()+" /");
			}
		}
		System.out.println(s);
	}
	
	public boolean isSelfDrawn() {
		return selfDrawn;
	}
	
	public int getTileId() {
		return tileId;
	}
	
	public int getPreviousClient() {
		return previousClientId;
	}
}
