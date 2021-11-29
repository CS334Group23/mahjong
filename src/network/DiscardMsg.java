/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: DiscardMsg.java </p> 
 * @author TeamCS3343 </a>
 */
package network;

import client.Client;

// TODO: Auto-generated Javadoc
/**
 * The Class DiscardMsg.
 */
public class DiscardMsg implements Message{
	
	/** The op name. */
	private String opName;
	
	/** The tile id. */
	private int tileId;
	
	/** The sender id. */
	private int senderId;
	
	/**
	 * Instantiates a new discard msg.
	 *
	 * @param id the id
	 * @param clientId the client id
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
	 * Gets the tile id.
	 *
	 * @return the tile id
	 */
	public int getTileId() {
		return tileId;
	}

}
