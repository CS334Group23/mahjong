/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: FindTilePosition.java </p> 
 * @author TeamCS3343 </a>
 */
package utils;
import java.util.*;

/**
 * The Class FindTilePosition.
 * The Class which is used to find the relative Tile position in a Tile list.
 */
public class  FindTilePosition {
	
	/**
	 * Find the next different tile different from the input Tile in a Tile list.
	 *
	 * @param hand a list of Tile
	 * @param a the input Tile
	 * @return the position of the target Tile
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
	 * Find the previous different tile different from the input Tile in a Tile list.
	 *
	 * @param hand a list of Tile
	 * @param a the input Tile
	 * @return the position of the target Tile
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
   	 * Find position of a Tile in a Tile list.
   	 *
   	 * @param hand a list of Tile
   	 * @param a the input Tile
   	 * @return the position of the input Tile
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



