/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: Peer.java </p> 
 * @author TeamCS3343 </a>
 */
package network;

// TODO: Auto-generated Javadoc
/**
 * The Interface Peer.
 */
public interface Peer {
	
	/**
	 * Send.
	 *
	 * @param target the target
	 * @param msg the msg
	 */
	public void send(Peer target, Message msg);
	
	/**
	 * On recv.
	 *
	 * @param msg the msg
	 */
	public void onRecv(Message msg);
}	
