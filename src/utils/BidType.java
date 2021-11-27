/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: BidType.java </p> 
 * @author TeamCS3343 </a>
 */
package utils;

// TODO: Auto-generated Javadoc
/**
 * The Enum BidType.
 */
public enum BidType {
	
	/** The empty. */
	EMPTY(0,"过"), 
 /** The chow. */
 CHOW(1,"吃"), 
 /** The pong. */
 PONG(2,"碰"), 
 /** The kong. */
 KONG(3,"杠"), 
 /** The win. */
 WIN(4,"胡");
	
	/** The bid id. */
	private final int bidId;
	
	/** The chn name. */
	private final String chnName;
	
	/**
	 * Instantiates a new bid type.
	 *
	 * @param bidId the bid id
	 * @param chnName the chn name
	 */
	private BidType(int bidId, String chnName) {
		this.bidId = bidId;
		this.chnName = chnName;
	}
	
	/**
	 * Gets the bid type.
	 *
	 * @return the bid type
	 */
	public int getBidType() {
		return bidId;
	}
	
	/**
	 * Gets the chn name.
	 *
	 * @return the chn name
	 */
	public String getChnName() {
		return chnName;
	}
}
