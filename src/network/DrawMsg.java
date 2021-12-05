/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: DrawMsg.java </p> 
 * @author TeamCS3343 </a>
 */
package network;

/**
 * The Class DrawMsg.
 */
public class DrawMsg implements Message{
	
	/** The operation name. */
	private String opName;
	
	/** The drawn tile id. */
	private int tileId;
	
	/**
	 * Instantiates a new draw msg.
	 *
	 * @param id the drawn Tile id
	 */
	public DrawMsg(int id) {
		this.tileId = id;
		this.opName = "DrawOperation";
	}
	
	/**
	 * Gets the drawn tile id.
	 *
	 * @return the tile id
	 */
	public int getTileId() {
		return tileId;
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
