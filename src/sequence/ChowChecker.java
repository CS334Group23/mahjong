package sequence;

import java.util.*;

import utils.*;

public class ChowChecker {
	public static ArrayList<Meld> checkChow(ArrayList<Tile> wall, Tile another) {
		ArrayList<Meld> result = new ArrayList<>();
		if(another.getType()!=Type.BAMBOO && another.getType()!=Type.CHARACTER && another.getType()!=Type.DOT) {
			return result;
		}
		//check chow
		for(Tile a : wall) {
			if(a.getType() == another.getType() && a.getRankIndex() == another.getRankIndex()-1) {
				for(Tile b : wall){
					if(a.getType() == b.getType() && b.getRankIndex() == a.getRankIndex()-1) {
						result.add(new Meld(b, a, another, null));
						break;
					}
				}
				for (Tile b : wall) {
					if( a.getType() == b.getType() && b.getRankIndex() == another.getRankIndex()+1) {
						result.add(new Meld(a, another, b, null));
						break;
					}
				}
				break;
			}
		}
		for(Tile a : wall) {
			if(a.getType() == another.getType() && a.getRankIndex() == another.getRankIndex()+1) {
				for(Tile b : wall){
					if(a.getType() == b.getType() && b.getRankIndex() == a.getRankIndex()+1) {
						result.add(new Meld(another, a, b, null));
						break;
					}
				}
				break;
			}
		}
//		System.out.println(result.size());
//		System.out.println(result.get(0).getcomb_type());
//		System.out.println(result.get(0).getFirst().getChnName());
//		System.out.println(result.get(0).getSecond().getChnName());
//		System.out.println(result.get(0).getThird().getChnName());
//		System.out.println(result.get(0).getForth().getChnName());
		return result;
	}
	
	
	/*
	public static boolean CheckChow(Tile a, Tile b, Tile c) {

		if(a.getRankIndex() == b.getRankIndex()-1 && b.getRankIndex()== c.getRankIndex()-1 && a.getType().equals(c.getType()))
		{
			
			return true;
		}
		
		return false;
	}
	
	public ArrayList<Meld> getChow(ArrayList<Tile> hand, int pos){
		
		ArrayList<Meld> allchow=new ArrayList<>();
		int previous_tile_pos=BinarySearch.PreviousDifferentTile(hand,hand.get(pos));
		int pprevious_tile_pos=-1;
		if(previous_tile_pos!=-1)
			 pprevious_tile_pos=BinarySearch.PreviousDifferentTile(hand,hand.get(previous_tile_pos));
		int next_tile_pos=BinarySearch.NextDifferentTile(hand,hand.get(pos));
		int nnext_tile_pos=-1;
			if(next_tile_pos!=-1)
		 nnext_tile_pos=BinarySearch.NextDifferentTile(hand,hand.get(next_tile_pos));
		
		//now consider case  _ _ A
		if(previous_tile_pos !=-1 && pprevious_tile_pos!=-1)
			if(CheckChow(hand.get(pprevious_tile_pos),hand.get(previous_tile_pos),hand.get(pos))) {
				Meld meld=new Meld (hand.get(pprevious_tile_pos),hand.get(previous_tile_pos),hand.get(pos),null);
				allchow.add(meld);
				
			}
		
		//now consider case _ A _
		if(previous_tile_pos !=-1 && next_tile_pos!=-1)
			if(CheckChow(hand.get(previous_tile_pos),hand.get(pos),hand.get(next_tile_pos))) {
				Meld meld=new Meld (hand.get(previous_tile_pos),hand.get(pos),hand.get(next_tile_pos),null);
				allchow.add(meld);
				
			}
		
		//now consider case _ _ A  
		if(nnext_tile_pos !=-1 && next_tile_pos!=-1)
			if(CheckChow(hand.get(pos),hand.get(next_tile_pos),hand.get(nnext_tile_pos))) {
				Meld meld=new Meld (hand.get(pos),hand.get(next_tile_pos),hand.get(nnext_tile_pos),null);
				allchow.add(meld);
				
			}
		
		
		return allchow;
	}
	*/
	
	
}
