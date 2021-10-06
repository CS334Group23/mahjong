package utils;

public class PlayMsg implements Message{
	private String opName;
	private int tileId;
	public PlayMsg(int id) {
		this.tileId = id;
		this.opName = "PlayOperation";
	}
	
	@Override
	public String getOperationName() {
		return opName;
	}

}
