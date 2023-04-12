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

/**
 * The Interface Ui.
 * The Ui interface which can be accessed by the Client
 */
public interface Ui {
	
	/**
	 * Inform the ui about deal message.
	 *
	 * @param dealMsg the deal message
	 */
	public void infoDeal(DealMsg dealMsg); 
	
	/**
	 * Info the ui about draw message.
	 *
	 * @param drawMsg the draw message
	 * @param possibleBid the possible bid represented as BidMsg list
	 */
	public void infoDraw(DrawMsg drawMsg, ArrayList<BidMsg> possibleBid);
	
	/**
	 * Gets the operation index of the user.
	 *
	 * @return the operation index
	 */
	public int getOpIndex();
	
	/**
	 * Gets the discard index of the user.
	 *
	 * @return the discard index
	 */
	public int getDiscard();
	
	/**
	 * Info the ui about discard message.
	 *
	 * @param discardMsg the discard message
	 * @param possibleBid the possible bid represented as BidMsg list
	 */
	public void infoDiscard(DiscardMsg discardMsg, ArrayList<BidMsg> possibleBid);
	
	/**
	 * Info the ui about bid message.
	 *
	 * @param bidMsg the bid message
	 */
	public void infoBid(BidMsg bidMsg);
	
	/**
	 * Info the ui about win message.
	 *
	 * @param winMsg the win message
	 */
	public void infoWin(WinMsg winMsg);
	
	/**
	 * Info the ui about draw notice message.
	 *
	 * @param drawNoticeMsg the draw notice message
	 */
	public void infoDrawNotice(DrawNoticeMsg drawNoticeMsg);
	
	/**
	 * Inits the ui.
	 *
	 * @param client the client
	 */
	public void init(ClientInterface client);
}
