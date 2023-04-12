/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: DrawNoticeMsg.java </p> 
 * @author TeamCS3343 </a>
 */
package network;

/**
 * The Class DrawNoticeMsg.
 */
public class DrawNoticeMsg implements Message{
	
	/** The operation name. */
	private String opName;
	
	/** The client id to send a draw in next round. */
	private int clientId;
	
	/**
	 * Instantiates a new draw notice msg.
	 *
	 * @param id The client id to send a draw in next round
	 */
	public DrawNoticeMsg(int id) {
		this.clientId = id;
		this.opName = "DrawNoticeOperation";
	}
	
	/**
	 * Gets The client id to send a draw in next round.
	 *
	 * @return the client id
	 */
	public int getClientId() {
		return clientId;
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
	
}
