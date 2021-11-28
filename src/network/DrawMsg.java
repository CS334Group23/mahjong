/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: DrawMsg.java </p> 
 * @author TeamCS3343 </a>
 */
package network;

// TODO: Auto-generated Javadoc
/**
 * The Class DrawMsg.
 */
public class DrawMsg implements Message{
	
	/** The op name. */
	private String opName;
	
	/** The tile id. */
	private int tileId;
	
	/**
	 * Instantiates a new draw msg.
	 *
	 * @param id the id
	 */
	public DrawMsg(int id) {
		this.tileId = id;
		this.opName = "DrawOperation";
	}
	
	/**
	 * Gets the tile id.
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
