/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: KongChecker.java </p> 
 * @author TeamCS3343 </a>
 */
package checker;
import java.util.*;
import utils.*;
// TODO: Auto-generated Javadoc

/**
 * The Class KongChecker.
 */
public class KongChecker {
	
	/**
	 * Check kong.
	 *
	 * @param wall the wall
	 * @param another the another
	 * @return the meld
	 */
	public static Meld checkKong(ArrayList<Tile> wall, Tile another) {
		int insertPosition = 0;
		for(; insertPosition<wall.size(); insertPosition++) {
			if(wall.get(insertPosition).getId()>another.getId()){
				break;
			}
		}
		ArrayList<Tile> context = new ArrayList<>();
		for(int i=(0<=insertPosition-3?insertPosition-3:0);i<=insertPosition+2&&i<wall.size();i++) {
			if(i==insertPosition) {
				context.add(another);
			}
			context.add(wall.get(i));
		}
		if(insertPosition == wall.size()) {
			context.add(another);
		}
		
		//check kong
		for(int i=0; i+3<context.size();i++) {
			if(context.get(i).getType() == context.get(i+1).getType() && context.get(i).getType() == context.get(i+2).getType() && context.get(i).getType() == context.get(i+3).getType()) {
				if(context.get(i).getRankIndex() == context.get(i+1).getRankIndex() && context.get(i).getRankIndex() == context.get(i+2).getRankIndex() && context.get(i).getRankIndex() == context.get(i+3).getRankIndex()) {
					return new Meld(context.get(i),context.get(i+1),context.get(i+2),context.get(i+3));
				}
			}
		}
		return null;
	}
}
