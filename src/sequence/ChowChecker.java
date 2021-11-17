package sequence;
import java.util.*;
import utils.*;
public class ChowChecker {
	public static ArrayList<Meld> checkChow(ArrayList<Tile> wall, Tile another) {
		ArrayList<Meld> result = new ArrayList<>();
		if(another.getType()==Type.WIND || another.getType()==Type.DRAGON) {
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
		return result;
	}	
	
}
