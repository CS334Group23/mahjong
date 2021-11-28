/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: BidMsg.java </p> 
 * @author TeamCS3343 </a>
 */
package network;

import java.util.ArrayList;

import utils.BidType;
import utils.Meld;

// TODO: Auto-generated Javadoc
/**
 * The Class BidMsg.
 */
public class BidMsg implements Message, Comparable{
	
	/** The Constant BID_NUM. */
	public static final int BID_NUM = 5;
	
	/** The client id. */
	private int clientId;
	
	/** The previous client id. */
	private int previousClientId;
	
	/** The op name. */
	private String opName;
	
	/** The bid type. */
	private int bidType;
	
	/** The responser name. */
	private String responserName;
	
	/** The tile id. */
	private int tileId;
	
	/** The meld. */
	private Meld meld;
	
	/** The bid name. */
	private String bidName;
	
	/** The win hand. */
	private ArrayList<Integer> winHand;
	
	/** The self drawn. */
	private boolean selfDrawn;
	
	/**
	 * Instantiates a new bid msg.
	 *
	 * @param clientId the client id
	 * @param previous the previous
	 * @param bidType the bid type
	 * @param responserName the responser name
	 * @param tileId the tile id
	 * @param meld the meld
	 * @param winHand the win hand
	 * @param selfDrawn the self drawn
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
	 * Instantiates a new bid msg.
	 */
	public BidMsg() { //this may need to be deleted later
		
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
	 * Compare to.
	 *
	 * @param another the another
	 * @return the int
	 */
	@Override
	public int compareTo(Object another) {
		return ((BidMsg)another).bidType-this.bidType;
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
	 * Gets the bid client.
	 *
	 * @return the bid client
	 */
	public int getBidClient() {
		return clientId;
	}
	
	/**
	 * Gets the meld.
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
	 * Gets the chn name.
	 *
	 * @return the chn name
	 */
	public String getChnName() {
		return bidName;
	}
	
	/**
	 * Gets the win hand.
	 *
	 * @return the win hand
	 */
	public ArrayList<Integer> getWinHand(){
		return winHand;
	}
	
	/**
	 * Prints the bid.
	 *
	 * @param msgs the msgs
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
	 * Checks if is self drawn.
	 *
	 * @return true, if is self drawn
	 */
	public boolean isSelfDrawn() {
		return selfDrawn;
	}
	
	/**
	 * Gets the tile id.
	 *
	 * @return the tile id
	 */
	public int getTileId() {
		return tileId;
	}
	
	/**
	 * Gets the previous client.
	 *
	 * @return the previous client
	 */
	public int getPreviousClient() {
		return previousClientId;
	}
}
