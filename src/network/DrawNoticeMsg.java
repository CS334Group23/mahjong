/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: DrawNoticeMsg.java </p> 
 * @author TeamCS3343 </a>
 */
package network;

// TODO: Auto-generated Javadoc
/**
 * The Class DrawNoticeMsg.
 */
public class DrawNoticeMsg implements Message{
	
	/** The op name. */
	private String opName;
	
	/** The client id. */
	private int clientId;
	
	/**
	 * Instantiates a new draw notice msg.
	 *
	 * @param id the id
	 */
	public DrawNoticeMsg(int id) {
		this.clientId = id;
		this.opName = "DrawNoticeOperation";
	}
	
	/**
	 * Gets the client id.
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
