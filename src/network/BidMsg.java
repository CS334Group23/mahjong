/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: BidMsg.java </p> 
 * @author TeamCS3343 </a>
 */
package network;

import java.util.ArrayList;

import utils.BidType;
import utils.Meld;

/**
 * The Class BidMsg.
 */
public class BidMsg implements Message, Comparable<BidMsg>{
	
	/** The Constant BID_NUM represent the BidMsg Priority. */
	public static final int BID_NUM = 5;
	
	/** The client id who send the bid. */
	private int clientId;
	
	/** The previous client id who 哈市 been bided. */
	private int previousClientId;
	
	/** The operation name. */
	private String opName;
	
	/** The bid type. */
	private int bidType;
	
	/** The responser name. */
	private String responserName;
	
	/** The bided tile id. */
	private int tileId;
	
	/** The formed meld by this Bid. */
	private Meld meld;
	
	/** The bid name. */
	private String bidName;
	
	/** The win hand if is win. */
	private ArrayList<Integer> winHand;
	
	/** If the bid is self drawn. */
	private boolean selfDrawn;
	
	/**
	 * Instantiates a new bid msg.
	 *
	 * @param clientId the client id
	 * @param previous the previous client id
	 * @param bidType the bid type
	 * @param responserName the responser name
	 * @param tileId the bided tile id
	 * @param meld the formed meld
	 * @param winHand the win hand if win
	 * @param selfDrawn the selfDrawn flag
	 */
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
	
	/**
	 * Gets the operation name.
	 *
	 * @return the operation name
	 */
	@Override
	public String getOperationName() {
		return opName;
	}

	/**
	 * Compare to another bid message to get relative priority
	 *
	 * @param another the another BidMsg
	 * @return the relative priority
	 */
	@Override
	public int compareTo(BidMsg another) {
		return another.bidType-this.bidType;
	}
	
	/**
	 * Gets the responser name.
	 *
	 * @return the responser name
	 */
	public String getResponserName() {
		return responserName;
	}
	
	/**
	 * Gets the bid client id.
	 *
	 * @return the bid client id
	 */
	public int getBidClient() {
		return clientId;
	}
	
	/**
	 * Gets the formed bid meld.
	 *
	 * @return the meld
	 */
	public Meld getMeld() {
		return meld;
	}
	
	/**
	 * Gets the bid type.
	 *
	 * @return the bid type
	 */
	public int getBidType() {
		return bidType;
	}
	
	/**
	 * Gets the Chinese name of the bid.
	 *
	 * @return the Chinese name of the bid
	 */
	public String getChnName() {
		return bidName;
	}
	
	/**
	 * Gets the win hand.
	 *
	 * @return the win hand list
	 */
	public ArrayList<Integer> getWinHand(){
		return winHand;
	}
	
	/**
	 * Print the bid message list.
	 *
	 * @param a list of BidMsg
	 */
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
	
	/**
	 * Checks if is self drawn bid.
	 * 
	 * @return true, if is self drawn bid
	 */
	public boolean isSelfDrawn() {
		return selfDrawn;
	}
	
	/**
	 * Gets the bid tile id.
	 *
	 * @return the tile id
	 */
	public int getTileId() {
		return tileId;
	}
	
	/**
	 * Gets the previous client id.
	 *
	 * @return the previous client id
	 */
	public int getPreviousClient() {
		return previousClientId;
	}
}
