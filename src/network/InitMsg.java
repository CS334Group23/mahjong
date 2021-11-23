package network;


public class InitMsg implements Message{

	private String opName;
	
	public InitMsg() {
		this.opName = "InitOperation";
	}
	
	@Override
	public String getOperationName() {
		return opName;
	}
}
