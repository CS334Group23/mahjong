/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: PongChecker.java </p> 
 * @author TeamCS3343 </a>
 */
package checker;

import java.util.ArrayList;

import utils.Meld;
import utils.Tile;

// TODO: Auto-generated Javadoc
/**
 * The Class PongChecker.
 */
public class PongChecker {
	
	/**
	 * Check pong.
	 *
	 * @param wall the wall
	 * @param another the another
	 * @return the meld
	 */
	public static Meld checkPong(ArrayList<Tile> wall, Tile another) {	
		int insertPosition = 0;
		for(; insertPosition<wall.size(); insertPosition++) {
			if(wall.get(insertPosition).getId()>another.getId()){
				break;
			}
		}
		ArrayList<Tile> context = new ArrayList<>();
		for(int i=(0<=insertPosition-2?insertPosition-2:0);i<=insertPosition+1&&i<wall.size();i++) {
			if(i==insertPosition) {
				context.add(another);
			}
			context.add(wall.get(i));
		}
		if(insertPosition == wall.size()) {
			context.add(another);
		}
		
		//check pong
		for(int i=0; i+2<context.size();i++) {
			if(context.get(i).getType() == context.get(i+1).getType() && context.get(i).getType() == context.get(i+2).getType()) {
				if(context.get(i).getRankIndex() == context.get(i+1).getRankIndex() && context.get(i).getRankIndex() == context.get(i+2).getRankIndex()) {
					return new Meld(context.get(i),context.get(i+1),context.get(i+2),null);
				}
			}
		}
		return null;
	}
	/*
	public Meld getPong(ArrayList<Tile> hand,int pos) {
		
		Meld pong;
		int first_pos=15;
		for(int i=0;i<hand.size();i++) {
			if(hand.get(i).getId()/4 == hand.get(pos).getId()/4) {
				first_pos=i;
				break;
			}
			
		} 
		if(first_pos+2<=hand.size()) {
			if(CheckPong(hand.get(first_pos),hand.get(first_pos+1),hand.get(first_pos+2))) {
				 pong=new Meld(hand.get(first_pos),hand.get(first_pos+1),hand.get(first_pos+2),null);
			}
			
		} 
		return null;
	}
	*/
}
