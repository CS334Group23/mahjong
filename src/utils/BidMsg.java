package utils;

public class BidMsg implements Message{
	private String opName;
	private int tileId;
	
	@Override
	public String getOperationName() {
		return opName;
	}
}
