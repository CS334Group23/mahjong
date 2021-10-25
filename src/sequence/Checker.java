package sequence;

import java.util.*;

import utils.*;

public class Checker {
	private static Checker instance = new Checker();
	public static Checker getInstance() {
		
		return instance;
	}
	
public boolean CheckChow(Tile a, Tile b, Tile c) {

		if(a.getRankIndex() == b.getRankIndex()-1 && b.getRankIndex()== c.getRankIndex()-1 && a.getType().equals(c.getType()))
		{
			
			return true;
		}
		
		return false;
	}

	public boolean CheckPong(Tile a, Tile b, Tile c) {
		
		if(a.getRankIndex() == b.getRankIndex() && b.getRankIndex() == c.getRankIndex() && a.getType()==c.getType() &&b.getType()==c.getType())
		{
			//System.out.println(a.getId()+" "+b.getId()+" "+c.getId());
			return true;
		}
		
		return false;
	}
public boolean CheckKong(Tile a,Tile b, Tile c, Tile d) {
	if(a.getRankIndex() == b.getRankIndex() && b.getRankIndex() == c.getRankIndex() &&c.getRankIndex() == d.getRankIndex()&&b.getType()==c.getType())
	{
		//System.out.println(a.getId()+" "+b.getId()+" "+c.getId());
		return true;
	}
	return false;
}
	public ArrayList<Sequence> CheckScore(ArrayList<Tile> hand, ArrayList<Meld> showed_hand ) {
		int score=0;
		
		Combination comb=new Combination();
		ArrayList<ArrayList<Meld>> set=comb.getCombination(hand);
		ArrayList<Sequence> sequence =new ArrayList<>();
		for(ArrayList<Meld> winning_hand : set) {
			ArrayList<Sequence> temp_sequence =new ArrayList<>();
			//winning_hand.addAll(showed_hand);   use to merge the showed_hand into winning_hand
			//sort winning all by first of each meld, put eye at last
			int local_score=0;
			sorting.sort_Meld(winning_hand);
			if(CheckPH(winning_hand)) {
				Sequence common_hand=new Common_Hand();
				temp_sequence.add(common_hand);
			}
			if(CheckPPH(winning_hand)) {
				Sequence all_in_triplet=new All_In_Triplet();
				temp_sequence.add(all_in_triplet);
			}
			if(CheckHYS(winning_hand)) {
				Sequence mixed_one_suit=new Mixed_One_Suit();
				temp_sequence.add(mixed_one_suit);
			}
			if(CheckQYS(winning_hand) ) {
				Sequence all_one_suit=new All_One_Suit();
				temp_sequence.add(all_one_suit);
			}
			
			// other check will add later 
			
			//extra score eg 門前/風/花
			if(CheckMC(showed_hand)) {
				Sequence win_from_wall=new Win_From_Wall();
				temp_sequence.add(win_from_wall);
			}
			for(Sequence s: temp_sequence) {
				local_score+=s.getScore();
			}
	
			if(local_score>=score) {
				score=local_score;
				sequence=temp_sequence;
			}
			
		}
		return sequence;
		
		
	}
	public int NextDifferentTile(ArrayList<Tile> hand, Tile a) {
		int pos=BinarySearch.FindPosition(hand,a);
		//System.out.println(a.getId()+" "+pos);
		for(int i=pos;i<hand.size();i++) {
			if(hand.get(pos).getRankIndex()!=  hand.get(i).getRankIndex()) {
				return i;
			}
			
		}
		return -1;
	}
	public boolean CheckSameType(Tile a, Tile b) {
		//BAMBOO(0, 0), CHARACTER(1, 36), DOT(2, 72), DRAGON(3, 108), FLOWER(5, 136), WIND(4, 120);
		if( a.getType().equals(b.getType())
				) {return true;}
		
		return false;
		
	}
	public boolean CheckPH(ArrayList<Meld> hand) {//平燸
		for(int i=0;i<hand.size();i++){
			if(hand.get(i).getcomb_type() !=1 ||hand.get(i).getcomb_type() !=0) {
				return false;
			}
			
		}
		return true;
	}
	public boolean CheckPPH(ArrayList<Meld> hand) {//對對糊
		if(hand.get(0).getFirst().getType() == Type.DRAGON) {
			return false; // exception of 字一色
		}
		for(int i=0;i<hand.size();i++){
			if(hand.get(i).getcomb_type() !=2 &&hand.get(i).getcomb_type() !=0) {
				return false;
			}
			
		}
		return true;
	}
	public boolean CheckHYS(ArrayList<Meld> hand) {//添一色
	
		Tile first_hand= hand.get(0).getFirst(); //initial hand, use for check type , assume meld is sort.
		
		//BAMBOO(0, 0), CHARACTER(1, 36), DOT(2, 72),
		if(!(first_hand.getType()== Type.BAMBOO || first_hand.getType()== Type.CHARACTER ||first_hand.getType()== Type.DOT )) {
			
			return false; // it should be check for 字一色 , which is exception to HYS
		}
		Boolean hasDragon_or_wind=false;	
		for(int i=0;i<hand.size();i++) { //if all meld is same type with first tile, or if it is dragon, then return 3, else return 0
			if(!(CheckSameType(hand.get(i).getFirst(),first_hand))) {
				if(hand.get(i).getFirst().getType() == Type.DRAGON ||
						hand.get(i).getFirst().getType() == Type.WIND) {
					hasDragon_or_wind=true;
				}else return false;
			}

		}
		if(hasDragon_or_wind)
			return true;
		else
			return false; // exception on qys
	}
	
	public boolean CheckQYS(ArrayList<Meld> hand) {//清一色
		Tile first_hand= hand.get(0).getFirst(); //initial hand, use for check type , assume meld is sort.
		
		//BAMBOO(0, 0), CHARACTER(1, 36), DOT(2, 72),
		
			
		for(int i=0;i<hand.size();i++) {
			
			if(!CheckSameType(hand.get(i).getFirst(),first_hand) || 
					hand.get(i).getFirst().getType() == Type.DRAGON ||
					hand.get(i).getFirst().getType() == Type.WIND)
				return false;
		}
		return true;
	}
	public boolean CheckMC(ArrayList<Meld> hand) {
		if(hand.isEmpty())
			return true;
		return false;
	}
	
	
	public int CheckMF(ArrayList<Meld> hand) { //門風   will change later
	
	
		return 1;
	}
	public int CheckJF(ArrayList<Meld> hand) {//正花
		
		return 1;
	}
	



}
