package utils;

public class DiscardMsg implements Message{
	private String opName;
	private int tileId;
	public DiscardMsg(int id) {
		this.tileId = id;
		this.opName = "DiscardOperation";
	}
	
	@Override
	public String getOperationName() {
		return opName;
	}

}
