package utils;

public class Meld {
	private Tile first;
	private Tile second;
	private Tile third;
	private Tile forth;
	private int comb_type; // just for temp
	public Meld(Tile a,Tile b, Tile c, Tile d) {
		if(c==null)
		{
			comb_type=0; // eye
			first=a;
			second=b;
			
		}else if (d==null) {
			if(c.getId()-a.getId()>3) {
				comb_type=1;
				
			}else
				comb_type=2; //pong or chow
			first=a;
			second=b;
			third=c;
		}
		else {
			
			comb_type=3;//kong 
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
	public int getcomb_type() {
		
		return comb_type;
	}
}
