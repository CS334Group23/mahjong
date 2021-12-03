/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: FindTilePosition.java </p> 
 * @author TeamCS3343 </a>
 */
package utils;
import java.util.*;
// TODO: Auto-generated Javadoc

/**
 * The Class FindTilePosition.
 */
public class  FindTilePosition {
	
	/**
	 * Next different tile.
	 *
	 * @param hand the hand
	 * @param a the a
	 * @return the int
	 */
	public static int NextDifferentTile(ArrayList<Tile> hand, Tile a) {
		int pos=FindTilePosition.FindPosition(hand,a);
		for(int i=pos;i<hand.size();i++) {
			if(hand.get(pos).getRankIndex()!=  hand.get(i).getRankIndex()) {
				return i;
				
			}
			
		}
		return -1;
	}
	
	/**
	 * Previous different tile.
	 *
	 * @param hand the hand
	 * @param a the a
	 * @return the int
	 */
	public static int PreviousDifferentTile(ArrayList<Tile> hand, Tile a) {
		int pos=FindTilePosition.FindPosition(hand,a);
		for(int i=pos;i>=0;i--) {
			if(hand.get(pos).getRankIndex()!=  hand.get(i).getRankIndex()) {
				return i;
				
			}
			
		}
		return -1;
	}
	
	   /**
   	 * Find position.
   	 *
   	 * @param hand the hand
   	 * @param a the a
   	 * @return the int
   	 */
   	public static int FindPosition(ArrayList<Tile> hand, Tile a) {
	   int low=0;
	   int high=hand.size()-1;
	   while(high>=low) {
		   int mid=(low+high)/2;
		   if(a.getId()>hand.get(mid).getId()) {
			
			   low=mid+1;
			   
		   }else if(a.getId()<hand.get(mid).getId()) {
			   high=mid-1;
			   
		   }else return mid;
		   
	   }
	   return low;
	   
   }
	   
}



