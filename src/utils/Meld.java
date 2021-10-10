package utils;

public class Meld {
	private Tile first;
	private Tile second;
	private Tile third;
	private Tile forth;
	private int type; // just for temp
	public Meld(Tile a,Tile b, Tile c, Tile d) {
		if(c==null)
		{
			type=0; // eye
			first=a;
			second=b;
			
		}else if (d==null) {
			
			type=1; //pong or chow
			first=a;
			second=b;
			third=c;
		}
		else {
			
			type=2;//kong 
			first=a;
			second=b;
			third=c;
			forth=d;
					
		}
		
		
	}
	public Tile getFirst() {
		return first;
		
	}
	public Tile getSecond() {
		return second;
		
	}
	public Tile getThird() {
		return third;
		
	}
	public Tile getForth() {
		return forth;
		
	}
}
