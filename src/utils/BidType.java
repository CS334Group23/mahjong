package utils;

public enum BidType {
	EMPTY(0,"过"), CHOW(1,"吃"), PONG(2,"碰"), KONG(3,"杠"), WIN(4,"胡");
	
	private final int bidId;
	private final String chnName;
	
	private BidType(int bidId, String chnName) {
		this.bidId = bidId;
		this.chnName = chnName;
	}
	
	public int getBidType() {
		return bidId;
	}
	
	public String getChnName() {
		return chnName;
	}
}
