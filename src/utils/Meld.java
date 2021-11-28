/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: Meld.java </p> 
 * @author TeamCS3343 </a>
 */
package utils;

// TODO: Auto-generated Javadoc
/**
 * The Class Meld.
 */
public class Meld {
	
	/** The first. */
	private Tile first;
	
	/** The second. */
	private Tile second;
	
	/** The third. */
	private Tile third;
	
	/** The forth. */
	private Tile forth;
	
	/** The comb type. */
	private int comb_type; // just for temp
	
	/** The comb name. */
	private String combName;
	
	/** The comb chn name. */
	private String combChnName;
	
	/** The meld name. */
	private String meldName;
	
	/** The meld length. */
	private int meldLength;
	
	/**
	 * Instantiates a new meld.
	 *
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 * @param d the d
	 */
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
	
	/**
	 * Compare to.
	 *
	 * @param meld the meld
	 * @return the int
	 */
	public int compareTo(Meld meld) {

		return this.first.compareTo(meld.first);
	}
	
	/**
	 * Gets the first.
	 *
	 * @return the first
	 */
	public Tile getFirst() {
		return first;
		
	}
	
	/**
	 * Gets the second.
	 *
	 * @return the second
	 */
	public Tile getSecond() {
		return second;
		
	}
	
	/**
	 * Gets the third.
	 *
	 * @return the third
	 */
	public Tile getThird() {
		return third;
		
	}
	
	/**
	 * Gets the forth.
	 *
	 * @return the forth
	 */
	public Tile getForth() {
		return forth;
		
	}
	
	/**
	 * Gets the comb type.
	 *
	 * @return the comb type
	 */
	public int getcomb_type() {
		return comb_type;
	}
	
	/**
	 * To comb name.
	 *
	 * @param comb_type the comb type
	 * @return the string
	 */
	private String toCombName(int comb_type) {
		switch(comb_type) {
		case 0:
			return "Eye";
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
	
	/**
	 * To chn comb name.
	 *
	 * @param comb_type the comb type
	 * @return the string
	 */
	private String toChnCombName(int comb_type) {
		switch(comb_type) {
		case 0:
			return "眼";
		case 1:
			return "吃";
		case 2:
			return "碰";
		case 3:
			return "槓";
		default:
			return null;
		}
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return combName;
	}
	
	/**
	 * Gets the chn name.
	 *
	 * @return the chn name
	 */
	public String getChnName() {
		return combChnName;
	}
	
	/**
	 * Prints the meld.
	 *
	 * @return the string
	 */
	public String printMeld() {
		return meldName;
	}
	
	/**
	 * Gets the meld length.
	 *
	 * @return the meld length
	 */
	public int getMeldLength() {
		return meldLength;
	}
}
