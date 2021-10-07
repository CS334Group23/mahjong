package utils;

import client.Client;

public class DiscardMsg implements Message{
	private String opName;
	private int tileId;
	private int senderId;
	
	public DiscardMsg(int id, int clientId) {
		this.tileId = id;
		this.opName = "DiscardOperation";
		this.senderId = clientId;
	}
	
	@Override
	public String getOperationName() {
		return opName;
	}
	
	public int getSenderId() {
		return senderId;
	}

}
