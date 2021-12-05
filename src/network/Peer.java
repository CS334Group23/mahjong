/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: Peer.java </p> 
 * @author TeamCS3343 </a>
 */
package network;

/**
 * The Interface Peer.
 */
public interface Peer {
	
	/**
	 * Send a message to a target Peer.
	 *
	 * @param target the target to send message 
	 * @param msg the message
	 */
	public void send(Peer target, Message msg);
	
	/**
	 * Deal with a receiving message.
	 *
	 * @param msg the received message
	 */
	public void onRecv(Message msg);
}	
