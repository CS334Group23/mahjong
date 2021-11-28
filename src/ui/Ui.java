/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: Ui.java </p> 
 * @author TeamCS3343 </a>
 */
package ui;

import java.util.ArrayList;

import network.BidMsg;
import network.DealMsg;
import network.DiscardMsg;
import network.DrawMsg;
import network.DrawNoticeMsg;
import network.WinMsg;

// TODO: Auto-generated Javadoc
/**
 * The Interface Ui.
 */
public interface Ui {
	
	/**
	 * Info deal.
	 *
	 * @param dealMsg the deal msg
	 */
	public void infoDeal(DealMsg dealMsg); 
	
	/**
	 * Info draw.
	 *
	 * @param drawMsg the draw msg
	 * @param possibleBid the possible bid
	 */
	public void infoDraw(DrawMsg drawMsg, ArrayList<BidMsg> possibleBid);
	
	/**
	 * Gets the op index.
	 *
	 * @return the op index
	 */
	public int getOpIndex();
	
	/**
	 * Gets the discard.
	 *
	 * @return the discard
	 */
	public int getDiscard();
	
	/**
	 * Info discard.
	 *
	 * @param discardMsg the discard msg
	 * @param possibleBid the possible bid
	 */
	public void infoDiscard(DiscardMsg discardMsg, ArrayList<BidMsg> possibleBid);
	
	/**
	 * Info bid.
	 *
	 * @param bidMsg the bid msg
	 */
	public void infoBid(BidMsg bidMsg);
	
	/**
	 * Info win.
	 *
	 * @param winMsg the win msg
	 */
	public void infoWin(WinMsg winMsg);
	
	/**
	 * Info draw notice.
	 *
	 * @param drawNoticeMsg the draw notice msg
	 */
	public void infoDrawNotice(DrawNoticeMsg drawNoticeMsg);
	
	/**
	 * Inits the.
	 *
	 * @param client the client
	 */
	public void init(ClientInterface client);
}
