/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: DealMsg.java </p> 
 * @author TeamCS3343 </a>
 */
package network;

import java.util.ArrayList;

/**
 * The Class DealMsg.
 */
public class DealMsg implements Message{
	
	/** The initial cards id list. */
	private ArrayList<Integer> initCards;
	
	/** The operation name. */
	private String opName;
	
	/**
	 * Instantiates a new deal msg.
	 *
	 * @param cards the initial cards list
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
	 * Gets the initial the cards list.
	 *
	 * @return the initial the cards list
	 */
	public ArrayList<Integer> getInitCards(){
		return initCards;
	}
}
