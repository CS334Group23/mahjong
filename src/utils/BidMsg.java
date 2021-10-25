package utils;

public class BidMsg implements Message, Comparable{
	public static final int BID_NUM = 5;
	
	public static final int EMPTY = 0;
	public static final int CHOW = 1;
	public static final int PONG = 2;
	public static final int KONG = 3;
	public static final int WIN = 4;
	
	private int clientId;
	private String opName;
	private int bidType;
	private String responserName;
	private int tileId;
	private Meld meld;
	
	public BidMsg(int clientId, int bidType, String responserName, int tileId, Meld meld) {
		this.clientId = clientId;
		this.opName = "BidOperation";
		this.bidType = bidType;
		this.responserName = responserName;
		this.tileId = tileId;
		this.meld = meld;
	}
	
	@Override
	public String getOperationName() {
		return opName;
	}

	@Override
	public int compareTo(Object another) {
		return this.bidType-((BidMsg)another).bidType;
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
}
