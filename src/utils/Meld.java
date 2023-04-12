/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: Meld.java </p> 
 * @author TeamCS3343 </a>
 */
package utils;

/**
 * The Class Meld.
 * The Class which represent a Meld in the whole System.
 */
public class Meld {
	
	/** The first Tile of the Meld. */
	private Tile first;
	
	/** The second Tile of the Meld. */
	private Tile second;
	
	/** The third Tile of the Meld. */
	private Tile third;
	
	/** The forth Tile of the Meld. */
	private Tile forth;
	
	/** The combination type of the Meld. */
	private int comb_type; // just for temp
	
	/** The combination name of the Meld. */
	private String combName;
	
	/** The Chinese combination name of the Meld. */
	private String combChnName;
	
	/** The name of the Meld. */
	private String meldName;
	
	/** The lenght of the Meld. */
	private int meldLength;
	
	/**
	 * Instantiates a new meld.
	 *
	 * @param a the first Tile
	 * @param b the second Tile
	 * @param c the third Tile
	 * @param d the fourth Tile
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
	 * Compare the relative priority of two Meld.
	 *
	 * @param meld another Meld to compare with.
	 * @return the integer represent the relative priority of two Meld
	 */
	public int compareTo(Meld meld) {

		return this.first.compareTo(meld.first);
	}
	
	/**
	 * Gets the first Tile of the Meld.
	 *
	 * @return the first Tile of the Meld
	 */
	public Tile getFirst() {
		return first;
		
	}
	
	/**
	 * Gets the second Tile of the Meld.
	 *
	 * @return the second Tile of the Meld
	 */
	public Tile getSecond() {
		return second;
		
	}
	
	/**
	 * Gets the third Tile of the Meld.
	 *
	 * @return the third Tile of the Meld
	 */
	public Tile getThird() {
		return third;
		
	}
	
	/**
	 * Gets the forth Tile of the Meld.
	 *
	 * @return the forth Tile of the Meld
	 */
	public Tile getForth() {
		return forth;
		
	}
	
	/**
	 * Gets the combination type of the Meld.
	 *
	 * @return the combination type of the Meld
	 */
	public int getcomb_type() {
		return comb_type;
	}
	
	/**
	 * Transfer the combination type to its English name.
	 *
	 * @param comb_type the combination type of a Meld
	 * @return the string of the English name of the Combination type
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
	 * Transfer the combination type to its Chinese name.
	 *
	 * @param comb_type the combination type of a Meld
	 * @return the string of the Chinese name of the Combination type
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
	 * Gets the English name of the combination of the Meld.
	 *
	 * @return the English name
	 */
	public String getName() {
		return combName;
	}
	
	/**
	 * Gets the Chinese name of the combination of the Meld.
	 *
	 * @return the Chinese name
	 */
	public String getChnName() {
		return combChnName;
	}
	
	/**
	 * Get a String of the Meld name
	 *
	 * @return the string of the Meld name
	 */
	public String printMeld() {
		return meldName;
	}
	
	/**
	 * Gets the length of the Meld.
	 *
	 * @return the length of the Meld
	 */
	public int getMeldLength() {
		return meldLength;
	}
}
