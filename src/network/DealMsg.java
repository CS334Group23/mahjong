/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: DealMsg.java </p> 
 * @author TeamCS3343 </a>
 */
package network;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DealMsg.
 */
public class DealMsg implements Message{
	
	/** The init cards. */
	private ArrayList<Integer> initCards;
	
	/** The op name. */
	private String opName;
	
	/**
	 * Instantiates a new deal msg.
	 *
	 * @param cards the cards
	 */
	public DealMsg(ArrayList<Integer> cards) {
		this.initCards = cards;
		this.opName = "DealOperation";
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
	 * Gets the inits the cards.
	 *
	 * @return the inits the cards
	 */
	public ArrayList<Integer> getInitCards(){
		return initCards;
	}
}
