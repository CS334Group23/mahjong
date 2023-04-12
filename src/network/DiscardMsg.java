/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: DiscardMsg.java </p> 
 * @author TeamCS3343 </a>
 */
package network;

/**
 * The Class DiscardMsg.
 */
public class DiscardMsg implements Message{
	
	/** The operation name. */
	private String opName;
	
	/** The discarded tile id. */
	private int tileId;
	
	/** The sender id of this discard. */
	private int senderId;
	
	/**
	 * Instantiates a new discard msg.
	 *
	 * @param id the discarded Tile id
	 * @param clientId the sender client id
	 */
	public DiscardMsg(int id, int clientId) {
		this.tileId = id;
		this.opName = "DiscardOperation";
		this.senderId = clientId;
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
	 * Gets the sender id.
	 *
	 * @return the sender id
	 */
	public int getSenderId() {
		return senderId;
	}
	
	/**
	 * Gets the discarded tile id.
	 *
	 * @return the tile id
	 */
	public int getTileId() {
		return tileId;
	}

}
