package utils;
import java.util.ArrayList;
public class  BinarySearch {
	
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



