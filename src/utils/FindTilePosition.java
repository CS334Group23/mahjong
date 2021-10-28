package utils;
import java.util.*;
public class  FindTilePosition {
	public int NextDifferentTile(ArrayList<Tile> hand, Tile a) {
		int pos=FindTilePosition.FindPosition(hand,a);
		//System.out.println(a.getId()+" "+pos);
		for(int i=pos;i<hand.size();i++) {
			if(hand.get(pos).getRankIndex()!=  hand.get(i).getRankIndex()) {
				return i;
			}
			
		}
		return -1;
	}
	public int PreviousDifferentTile(ArrayList<Tile> hand, Tile a) {
		int pos=FindTilePosition.FindPosition(hand,a);
		//System.out.println(a.getId()+" "+pos);
		for(int i=0;i<pos;i++) {
			if(hand.get(pos).getRankIndex()!=  hand.get(i).getRankIndex()) {
				return i;
			}
			
		}
		return -1;
	}
	   public static int FindPosition(ArrayList<Tile> hand, Tile a) {

		   int low=0;
		   int high=hand.size();
		   while(high>=low) {
			   int mid=(low+high)/2;
			   //System.out.println(low+" l "+high+" h  "+ mid+ "   "+a.getId()+ "   "+hand.get(mid).getId());
			   if(a.getId()>hand.get(mid).getId()) {
				
				   low=mid+1;
				   
			   }else if(a.getId()<hand.get(mid).getId()) {
				   high=mid-1;
				   
			   }else return mid;
			   
		   }
		   return low;
		   
	   }
	   
}



