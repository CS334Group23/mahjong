package network;

public interface Peer {
	public void send(Peer target, Message msg);
	
	public void onRecv(Message msg);
}	
