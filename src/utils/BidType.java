/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: BidType.java </p> 
 * @author TeamCS3343 </a>
 */
package utils;

/**
 * The Enum BidType.
 * The enumerate type which represent the bid type 
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
	
	/** The Chinese name. */
	private final String chnName;
	
	/**
	 * Instantiates a new bid type.
	 *
	 * @param bidId the bid id
	 * @param chnName the Chinese name
	 */
	private BidType(int bidId, String chnName) {
		this.bidId = bidId;
		this.chnName = chnName;
	}
	
	/**
	 * Gets the bid id the bid type
	 *
	 * @return the bid type id
	 */
	public int getBidType() {
		return bidId;
	}
	
	/**
	 * Gets the Chinese name of the bid type.
	 *
	 * @return the Chinese name of the bid type
	 */
	public String getChnName() {
		return chnName;
	}
}
