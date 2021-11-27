/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: InitMsg.java </p> 
 * @author TeamCS3343 </a>
 */
package network;


// TODO: Auto-generated Javadoc
/**
 * The Class InitMsg.
 */
public class InitMsg implements Message{

	/** The op name. */
	private String opName;
	
	/**
	 * Instantiates a new inits the msg.
	 */
	public InitMsg() {
		this.opName = "InitOperation";
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
