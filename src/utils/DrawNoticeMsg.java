package utils;

public class DrawNoticeMsg implements Message{
	private String opName;
	private int clientId;
	public DrawNoticeMsg(int id) {
		this.clientId = id;
		this.opName = "DrawNoticeOperation";
	}
	
	public int getClientId() {
		return clientId;
	}
	
	@Override
	public String getOperationName() {
		return opName;
	}
	
}
