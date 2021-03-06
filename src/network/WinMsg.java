/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: WinMsg.java </p> 
 * @author TeamCS3343 </a>
 */
package network;

import java.util.ArrayList;

/**
 * The Class WinMsg.
 */
public class WinMsg implements Message{
	
	/** The operation name. */
	private String opName;
	
	/** The message sender client id. */
	private int clientId;
	
	/** The win client id. */
	private int winClientId;
	
	/** The hand of the send client. */
	private ArrayList<Integer> hand;
	
	/** The hands list of all the clients. */
	private ArrayList<ArrayList<Integer>> hands;
	
	/** The scores list of all the clients. */
	private ArrayList<Integer> scores;
	
	/** The win type. */
	private int winType;
	
	/** The Constant SELFDRAWN. */
	public static final int SELFDRAWN = 2;
	
	/** The Constant WINBYDISCARD. */
	public static final int WINBYDISCARD = 1;
	
	/** The Constant TIE. */
	public static final int TIE = 0;
	
	/**
	 * Instantiates a new win msg.
	 *
	 * @param clientId the sender client id
	 * @param winClientId the win client id
	 * @param hand the hand of the client
	 * @param scores the scores of all the client
	 * @param winType the win type
	 */
	public WinMsg(int clientId, int winClientId, ArrayList<Integer> hand, ArrayList<Integer> scores, int winType) {
		this.clientId = clientId;
		this.winClientId = winClientId;
		this.hand = hand;
		this.opName = "WinOperation";
		this.hands = new ArrayList<>();
		for(int i=0; i<4; i++) {
			hands.add(null);
		}
		this.scores = scores;
		this.winType = winType;
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
	 * Adds the hand of a client to the all client hands list.
	 *
	 * @param clientId the client id to be added
	 * @param hand the hand to be added
	 */
	public void addHand(int clientId, ArrayList<Integer> hand) {
		hands.set(clientId, hand);
	}
	
	/**
	 * Gets the hand list of the sender client.
	 *
	 * @return the hand list
	 */
	public ArrayList<Integer> getHandList() {
		return hand;
	}
	
	/**
	 * Gets the hands list of the clients.
	 *
	 * @return the hands list
	 */
	public ArrayList<ArrayList<Integer>> getHandsList(){
		return hands;
	}
	
	/**
	 * Gets the client id of the sender.
	 *
	 * @return the client id
	 */
	public int getClientId() {
		return clientId;
	}
	
	/**
	 * Gets the win client id.
	 *
	 * @return the win client id
	 */
	public int getWinClientId() {
		return winClientId;
	}
	
	/**
	 * Gets the scores of all the clients.
	 *
	 * @return the scores
	 */
	public ArrayList<Integer> getScores(){
		return scores;
	}
	
	/**
	 * Sets the scores of all the clients.
	 *
	 * @param scores the new scores
	 */
	public void setScores(ArrayList<Integer> scores) {
		this.scores = scores;
	}
	
	/**
	 * Gets the win type.
	 *
	 * @return the win type
	 */
	public int getWinType() {
		return winType;
	}
	
	/**
	 * Sets the win type.
	 *
	 * @param type the new win type
	 */
	public void setWinType(int type) {
		winType = type;
	}
}
