package utils;

public class Meld {
	private Tile first;
	private Tile second;
	private Tile third;
	private Tile forth;
	private int comb_type; // just for temp
	private String combName;
	private String combChnName;
	private String meldName;
	private int meldLength;
	
	public Meld(Tile a,Tile b, Tile c, Tile d) {
		String str = "";
		if(c==null)
		{
			comb_type=0; // eye
			first=a;
			second=b;
			str = (a.getChnName()+" "+b.getChnName());
			meldLength=2;
		}else if (d==null) {
			if(c.getId()-a.getId()>3) {
				comb_type=1;
				
			}else
				comb_type=2; //pong or chow
			first=a;
			second=b;
			third=c;
			str = (a.getChnName()+" "+b.getChnName()+" "+c.getChnName());
			meldLength=3;
		}
		else {
			
			comb_type=3;//kong 
			first=a;
			second=b;
			third=c;
			forth=d;		
			str = (a.getChnName()+" "+b.getChnName()+" "+c.getChnName()+" "+d.getChnName());
			meldLength=4;
		}
		combName = toCombName(comb_type);
		combChnName = toChnCombName(comb_type);
		meldName = str;
	}
	public int compareTo(Meld meld) {

		return this.first.compareTo(meld.first);
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
	
	private String toCombName(int comb_type) {
		switch(comb_type) {
		case 0:
			return "eye";
		case 1:
			return "Chow";
		case 2:
			return "Pong";
		case 3:
			return "Kong";
		default:
			return null;
		}
	}
	
	private String toChnCombName(int comb_type) {
		switch(comb_type) {
		case 0:
			return "�";
		case 1:
			return "���";
		case 2:
			return "蝣�";
		case 3:
			return "���";
		default:
			return null;
		}
	}
	
	public String getName() {
		return combName;
	}
	
	public String getChnName() {
		return combChnName;
	}
	
	public String printMeld() {
		return meldName;
	}
	
	public int getMeldLength() {
		return meldLength;
	}
}
