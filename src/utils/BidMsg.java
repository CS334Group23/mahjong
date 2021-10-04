package utils;

public class BidMsg implements Message{
	private String name;
	private int tileId;
	
	@Override
	public String getName() {
		return name;
	}
}
