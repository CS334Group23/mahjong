package utils;

public class DrawMsg implements Message{
	private String opName;
	private int tileId;
	public DrawMsg(int id) {
		this.tileId = id;
		this.opName = "DrawOperation";
	}
	
	@Override
	public String getOperationName() {
		return opName;
	}

}
